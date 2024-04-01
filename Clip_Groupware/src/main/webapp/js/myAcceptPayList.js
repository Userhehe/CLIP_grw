$(document).ready(function() {
	$("tbody tr").click(function() {
		const appSeq = $(this).find('td:first-child').text();
		console.log('appseq값:', appSeq);
		const requestData = {
			app_seq: appSeq
		};
		console.log('요청데이터:', requestData);
		
		$("#rejectBtn").attr("data-appseq", appSeq); 
		$("#editBtn").attr("data-appseq", appSeq); 
		
		$.ajax({
			url: "./myPayList.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				
				if(data.app_draft === "결재반려"){
					$("#modalContent").html("결재요청일자: " + data.app_createdate +"<br>결재상태:"+data.app_draft +  "<br>결재 반려사유 : " + data.pay_rejectreason  +"<br>결재내용: " + data.app_content );
				}else{
					$("#modalContent").html("결재요청일자: " + data.app_createdate +"<br>결재상태:"+data.app_draft +"<br>결재내용: " + data.app_content );					
				}
				
				if(data.app_draft === "결재대기" || data.app_draft === "결재승인" ){
					$("#editBtn").show();
					$("#rejectBtn").show();
				}else{
					$("#editBtn").hide();
					$("#rejectBtn").hide();
				}
				var modal = new bootstrap.Modal($("#detailModal"));	
				modal.show();
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
		
		  $("#rejectBtn").on("click", function() {
		    var appSeq = $(this).attr("data-appseq");
		    window.location.href = "./rejectionPay.do?app_seq=" + appSeq; 
		  });
		   $("#editBtn").on("click", function() {
		    var appSeq = $(this).attr("data-appseq");
		    window.location.href = "./okPay.do?app_seq=" + appSeq; 
		  });
	});	
});