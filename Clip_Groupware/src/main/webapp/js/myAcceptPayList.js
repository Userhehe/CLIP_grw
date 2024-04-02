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
			url: "./myAcceptPayList.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				
				if(data.app_draft === "결재반려"){
					$("#modalContent1").html("결재내용: " + data.app_content);
				}else{
					$("#modalContent1").html("결재내용: " + data.app_content);				
				}
				
				if(data.app_draft === "결재대기" || data.app_draft === "결재승인" ){
					$("#editBtn").show();
					$("#rejectBtn").show();
				}else{
					$("#editBtn").hide();
					$("#rejectBtn").hide();
				}
				var modal = new bootstrap.Modal($("#detailModal1"));	
				modal.show();
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
		
			$('#detailModal1').on('hidden.bs.modal', function (e) {
				  location.reload();
			});
		
		  $("#rejectBtn").on("click", function() {
		    var appSeq = $(this).attr("data-appseq");
     		window.location.href = "./rejectionPay.do?app_seq=" + appSeq; 
		  });
		   $("#editBtn").on("click", function() {
		    var app_seq = $(this).attr("data-appseq");
		   //window.location.href = "./okPay.do?app_seq=" + app_seq; 
		  });
		  
		  $.ajax({
			url: "./myAcceptPayListPause.do?app_seq=" + requestData.app_seq,
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(requestData),
			success: function(data) {
				console.log(data);
				
				if(data.app_draft === "결재반려"){
					$("#modalContent2").html("결재내용: " + data.app_content);
				}else{
					$("#modalContent2").html("결재내용: " + data.app_content);				
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
					$("#modalContent3").html("결재내용: " + data.app_content);
				}else{
					$("#modalContent3").html("결재내용: " + data.app_content);				
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