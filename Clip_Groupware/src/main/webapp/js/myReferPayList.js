function pdfPrint() {

	// 현재 document.body의 html을 A4 크기에 맞춰 PDF로 변환
	html2canvas(document.getElementById("saveZone"), {
		onrendered: function(canvas) {
			console.log("작동");
			
			// (그리거나 캡쳐한)캔버스를 지정한포멧에 따라 이미지로 변환후 데이터URL로 반환하는 함수
			var imgData = canvas.toDataURL('image/png');
	

			var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준 210
			var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
			var imgHeight = canvas.height * imgWidth / canvas.width;//이미지의 세로길이
			var heightLeft = imgHeight; //출력해야할 이미지의 높이

			var doc = new jsPDF('p', 'mm');	//PDF를 생성하고 조작하기 위한 객체 생성
			//매개변수는 PDF의 생성되는 방향과 단위를 의미한다 ,'p'는 세로'l'은 가로방향 'mm'단위로 페이지의 크기 단위
			
			var position = 0;

			// 첫 페이지 출력
			//			저장할이미지, 저장타입, 시작x좌표, 시작y좌표, PDF의 크기(가로,세로)	
			doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
			heightLeft -= pageHeight;
			//전체 이미지의 높이에서 PDF 한페이지의 높이를 -

			// 한 페이지 이상일 경우 루프 돌면서 출력
			while (heightLeft >= 20) {
				position = heightLeft - imgHeight;
				doc.addPage();
				doc.addImage(imgData, 'PNG', 0, position, imgWidth, imgHeight);
				heightLeft -= pageHeight;
			}

			// 파일 저장
			doc.save('참조된 기안문서.pdf');


//			이미지로 표현
//			document.write('<img src="'+imgData+'" />');
		}

	});

}

window.onload = function(){
	var saveBtn = document.querySelector("#savePdf");
	saveBtn.addEventListener("click",function(){
		console.log("작동");
		pdfPrint();
	});
}

$(document).ready(function() {
	$("tbody tr").click(function() {
		const appSeq = $(this).find('td:first-child').text();
		console.log('appseq값:', appSeq);
		const requestData = {
			app_seq: appSeq
		};
		console.log('요청데이터:', requestData);
		$.ajax({
			url: "./myPayList.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				$("#modalContent").html("문서번호 : "+data.app_seq + data.app_content);
				$("#tempDel").attr("data-appseq",appSeq);
				var modal = new bootstrap.Modal($("#detailModal"));
				modal.show();
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
	  
	});
	//검색기능	
	 $("#templateSearch").click(function() {
	        var searchText = $("#searchInput").val().toLowerCase(); // 입력된 검색어를 소문자로 변환
	        var found = false; // 검색 결과가 있는지 여부를 나타내는 플래그
	        // 제목에 검색어가 포함된 행을 보여줌
	        $("tbody tr").each(function() {
	            var titleText = $(this).find('td:nth-child(3)').text().toLowerCase(); // 제목 텍스트 추출 후 소문자로 변환
	            if (titleText.includes(searchText)) { // 검색어가 제목에 포함되어 있는지 확인
	                $(this).show(); // 행을 보여줌
	                found = true; // 검색 결과가 있다고 표시
	        	}else {
	                $(this).hide(); // 검색어가 없으면 행을 숨김
	            }
	        });
	        if (!found) {
	            $("#noDataMessage").text("검색하신 단어는 없는 양식입니다. 다시 입력해주세요.");
	        } else {
	            $("#noDataMessage").text("");
	        }
	    });
	    
	    $("#resetSearch").click(function(){
	    	$("#searchInput").val("");
	    	$("tbody tr").show();
	    	$("#noDataMessage").text("");
	    });
});
