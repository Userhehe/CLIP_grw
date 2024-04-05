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

function handleButtonClick(buttonType) {
    var checkInButton = document.getElementById("checkInButton");
    var checkOutButton = document.getElementById("checkOutButton");

    if (buttonType === 'checkIn') {
        // 출근 버튼 클릭 시 처리
        checkInButton.style.display = 'none';
        checkOutButton.style.display = 'block';
    } else if (buttonType === 'checkOut') {
        // 퇴근 버튼 클릭 시 처리
        checkOutButton.style.display = 'none';
        checkInButton.style.display = 'block';
    }
}



