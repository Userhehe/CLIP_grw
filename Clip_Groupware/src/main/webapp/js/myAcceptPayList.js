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