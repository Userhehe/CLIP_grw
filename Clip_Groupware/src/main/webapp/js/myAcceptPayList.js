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
				$("#modalContent").html("결재요청일자: " + data.app_createdate +"<br>결재상태:"+data.app_draft +"<br>결재내용: " + data.app_content );
				var modal = new bootstrap.Modal($("#detailModal"));	
				modal.show();
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
	});	
});