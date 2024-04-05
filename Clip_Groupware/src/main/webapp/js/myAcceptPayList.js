function pdfPrint() {

	// 현재 document.body의 html을 A4 크기에 맞춰 PDF로 변환
	html2canvas(document.getElementById("saveZone"), {
		onrendered: function(canvas) {
			console.log("작동");
			
			// (그리거나 캡쳐한)캔버스를 지정한포멧에 따라 이미지로 변환후 데이터URL로 반환하는 함수
			var imgData = canvas.toDataURL('image/png');
	

			var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
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
			doc.save('승인 결재문서.pdf');


//			이미지로 표현
//			document.write('<img src="'+imgData+'" />');
		}

	});
	
	html2canvas(document.getElementById("saveZone3"), {
		onrendered: function(canvas) {
			console.log("작동");
			
			// (그리거나 캡쳐한)캔버스를 지정한포멧에 따라 이미지로 변환후 데이터URL로 반환하는 함수
			var imgData = canvas.toDataURL('image/png');
	

			var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
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
			doc.save('승인한 결재문서.pdf');


//			이미지로 표현
//			document.write('<img src="'+imgData+'" />');
		}

	});
	
		html2canvas(document.getElementById("saveZone2"), {
		onrendered: function(canvas) {
			console.log("작동");
			
			// (그리거나 캡쳐한)캔버스를 지정한포멧에 따라 이미지로 변환후 데이터URL로 반환하는 함수
			var imgData = canvas.toDataURL('image/png');
	

			var imgWidth = 210; // 이미지 가로 길이(mm) A4 기준
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
			doc.save('반려한 결재문서.pdf');


//			이미지로 표현
//			document.write('<img src="'+imgData+'" />');
		}

	});
	
	
}



window.onload = function(){
	var saveBtn = document.querySelector("#savePdf");
	var saveBtn2 = document.querySelector("#savePdf2");
	var saveBtn3 = document.querySelector("#savePdf3");
	saveBtn.addEventListener("click",function(){
		console.log("작동");
		pdfPrint();
	});
	saveBtn2.addEventListener("click",function(){
		console.log("작동");
		pdfPrint();
	});
	saveBtn3.addEventListener("click",function(){
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
		
		$("#rejectBtn").attr("data-appseq", appSeq); 
		$("#rejectFinalBtn").attr("data-appseq", appSeq); 
		$("#editBtn").attr("data-appseq", appSeq); 
		
		
		var app_seq = $(this).attr("data-appseq");
	
	    
	    
		
		$.ajax({
			url: "./myAcceptPayList.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				
				if(data.app_draft === "결재반려"){
					$("#modalContent1").html(data.app_content);
					
				}else{
					$("#modalContent1").html(data.app_content);				
				}
				
				if(data.app_draft === "결재진행" || data.app_draft === "결재대기" ){
					$("#editBtn").show();
					$("#rejectBtn").show();
				}else{
					$("#editBtn").hide();
					$("#rejectBtn").hide();
				}
				var modal = new bootstrap.Modal($("#detailModal1"));	
				modal.show();
				
		    var gian = document.getElementById("modalContent1").parentNode;
	    	console.log(gian);
	    	console.log(gian.querySelector('.table-bordered'));
				
				
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
		
		document.getElementById("rejectBtn").addEventListener("click", function() {
    		document.getElementById("cancelContent").style.display = "inline-block";
    		document.getElementById("rejectFinalBtn").style.display = "inline-block";
		});
		
		$("#rejectFinalBtn").on("click", function() {
		    var app_seq = $(this).attr("data-appseq");
		    var cancelContent = $("#cancelContent").val();
		    if(cancelContent.trim() === ""){
				alert('반려시에는 반려사유를 반드시 입력하셔야됩니다.');
			}else{
	     		$.ajax({
		            url: "./rejectionPay.do",
		            method: "POST",
		            data: { app_seq: app_seq,
		            		pay_rejectreason: cancelContent },
		            success: function(data) {
		                console.log("성공!! 결재코드:"+app_seq+",내용:"+cancelContent);
		                alert("반려처리가 정상적으로 처리되었습니다.");
		                location.reload();
		            },
		            error: function(error) {
		                 alert("서버오류로 인하여 실패하였습니다.");  
		            }
		        }); 
		    }
		});
		
		  $('#detailModal1').on('hidden.bs.modal', function (e) {
			location.reload();
		  });
		
		
		
		
		  $("#editBtn").on("click", function() {
			    
			    console.log("결재코드:",app_seq);
			    $.ajax({
			        url: "./okPay.do?app_seq="+ app_seq,
			        type: "POST",
			        contentType: "application/json",
					data: JSON.stringify({app_seq:app_seq}),
			        success: function(data) {
			            alert('결재가 정상적으로 승인되었습니다.');
			            location.reload();
			        },
			        error: function(error) {
			            alert("결재 승인에 실패하였습니다.");
			        }
			    });
			});



		  
		  $.ajax({
			url: "./myAcceptPayListPause.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				
				if(data.app_draft === "결재반려"){
					$("#modalContent2").html("문서번호 : "+data.app_seq+ data.app_content);
				}else{
					$("#modalContent2").html("문서번호 : "+data.app_seq+ data.app_content);				
				}
				
				if(data.app_draft === "결재대기" || data.app_draft === "결재승인" ){
					$("#editBtn").show();
					$("#rejectBtn").show();
				}else{
					$("#editBtn").hide();
					$("#rejectBtn").hide();
				}
				var modal = new bootstrap.Modal($("#detailModal2"));	
				modal.show();
				
				
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
		
		$('#detailModal2').on('hidden.bs.modal', function (e) {
			location.reload();
		});
		
		 $.ajax({
			url: "./myAcceptPayListChecked.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				
				if(data.app_draft === "결재반려"){
					$("#modalContent3").html("문서번호 : "+data.app_seq+ data.app_content);
				}else{
					$("#modalContent3").html("문서번호 : "+data.app_seq+ data.app_content);				
				}
				
				if(data.app_draft === "결재대기" || data.app_draft === "결재승인" ){
					$("#editBtn").show();
					$("#rejectBtn").show();
				}else{
					$("#editBtn").hide();
					$("#rejectBtn").hide();
				}
				var modal = new bootstrap.Modal($("#detailModal3"));	
				modal.show();
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
		
		$('#detailModal3').on('hidden.bs.modal', function (e) {
			location.reload();
		});
	});	
});