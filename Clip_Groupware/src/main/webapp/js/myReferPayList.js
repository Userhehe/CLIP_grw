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
