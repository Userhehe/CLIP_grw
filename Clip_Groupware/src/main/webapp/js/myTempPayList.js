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
				$("#modalContent").html("결재코드:"+data.app_seq+"<br>결재요청일자: " + data.app_createdate + "<br>결재내용: " + data.app_content);
				var modal = new bootstrap.Modal($("#detailModal"));
				modal.show();
			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
	});
	
});

function cancel() {
    console.log("취소버튼 클릭");
    const appSeq = $(this).find('td:first-child').text();
    const confirmed = confirm("해당 결재를 결재취소 하시겠습니까?");
    const requestData = {
        app_seq: appSeq
    };
	console.log("요청데이터:",requestData);
    if (confirmed) {
        $.ajax({
            url: './cancelPay.do', 
            type: 'POST', 
            contentType: 'application/json', 
            data: JSON.stringify(requestData), 
            success: function(data) {
                alert("결재가 취소되었습니다. " + JSON.stringify(data));
            },
            error: function(error) { 
                console.log("app_seq:====> ", appSeq);
                console.log('에러는 싫으니까 고쳐줘');
            }
        });
    }
}