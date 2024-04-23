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
					window.location.href = "./login/loginForm.do";
				} else {
					console.log('로그아웃 실패');
					window.location.href = "./accessError.do";
				}
			}, 
			error: function(error) {
				console.error('로그아웃 실패', error);
				window.location.href="./accessError.do";
			}
		});
	});
	chktime();
});
function chktime(){
	$.ajax({
		url:'./chktime.do',
		method: 'GET',
		success: function(response) {
			if(response=='1'){
				$('#checkOutButton').css('display', 'block');
				$('#checkInButton').css('display', 'none');
			}else{
				$('#checkInButton').css('display', 'block');
				$('#checkOutButton').css('display', 'none');
			}
		}
	})
	$('#checkOutButton').click(function() {
    $('#checkInButton').css('display', 'block');
    $('#checkOutButton').css('display', 'none');
});

}

"./insertDailyCheckIntime.do" 



