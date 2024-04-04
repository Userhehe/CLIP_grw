//$(document).ready(function() {
//    $.ajax({
//        url: '/header.do',
//        method: 'GET', 
//        dataType: 'json',
//        success: function(response) {
//			log.info("!!!!!!!!!response : ",response);
//            var fileStorename = response;
//            var imageUrl = './images/userprofile/' + fileStorename;
//            $('#fileImage').attr('src', imageUrl);
//        },
//        error: function() {
//            console.log('실패..');
//        }
//    });
//});

$(document).ready(function() {
	$('#logout').click(function(event) {
		event.preventDefault();
		
		$.ajax({
			url: './logout.do',
			method: 'GET',
			dataType: 'json',
			success: function(response) {
				if(response == 1) {
					alert('로그아웃 되었습니다.');
					window.location.href = "./loginForm.do";
				} else {
					console.log('로그아웃 실패');
					window.location.href = "./accessError.do";
				}
			},
			error: function(xhr, status, error) {
				console.error('로그아웃 실패', xhr, status, error);
				window.location.href="./accessError.do";
			}
		});
	});
});