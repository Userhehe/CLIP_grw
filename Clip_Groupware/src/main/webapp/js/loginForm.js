// 페이지가 캐시된 상태인지 확인하는 함수
//function isPageCached() {
//    return window.performance.getEntriesByType("navigation")[0].type === "back_forward";
//}

// 메시지 수신 시 처리하는 함수
//function handleMessage(message) {
//    if (!isPageCached()) {
//        // 페이지가 캐시된 상태가 아니면 메시지 처리
//        console.log("Received message:", message);
//    } else {
//        // 페이지가 캐시된 상태이면 경고 메시지 표시
//        console.warn("Message received while page is cached. Ignoring message.");
//    }
//}

var urlParams = new URLSearchParams(window.location.search);
var message = urlParams.get('message');
if (message) {
    alert(message);
}

// 아이디 찾기 모달창 숨기기, 인증번호와 비밀번호 재설정 입력방지
document.addEventListener('DOMContentLoaded', function(){
	var modal = document.getElementById("idFindModal");
	modal.style.display = "none";
	
	document.getElementById('certnum').disabled = true;
	document.getElementById('certnum').value = "";
	document.getElementById('checkCertnumBtn').disabled = true;
	document.getElementById('checkCertnumBtn').style.backgroundColor = 'lightgrey';
	
	document.getElementById('replacePassword').disabled = true;
	document.getElementById('replacePassword').value = "";
	document.getElementById('checkPassword').disabled = true;
	document.getElementById('checkPassword').value = "";
	document.getElementById('replacePasswordBtn').disabled = true;
	document.getElementById('replacePasswordBtn').style.backgroundColor = 'lightgrey';
});

// 아이디 찾기 모달창 활성화
function openIdModal() {
	var modal = document.getElementById("idFindModal");
	modal.style.display = "block";
}

// 아이디 찾기 모달창 비활성화
function closeIdModal() {
	var modal = document.getElementById("idFindModal");
	modal.style.display = "none";
}

// 비밀번호 재설정 모달창 숨기기
document.addEventListener('DOMContentLoaded', function(){
	var modal = document.getElementById("replacePwModal");
	modal.style.display = "none";
});

// 비밀번호 재설정 모달창 활성화
function openPwModal() {
	var modal = document.getElementById("replacePwModal");
	modal.style.display = "block";
}

// 비밀번호 재설정 모달창 비활성화
function closePwModal() {
	var modal = document.getElementById("replacePwModal");
	certnumReload();
	modal.style.display = "none";
}

// 비밀번호 재설정 - 비밀번호 입력란 활성화
function passwordUpdateInputActive() {
	document.getElementById('replacePassword').disabled = false;
	document.getElementById('checkPassword').disabled = false;
	document.getElementById('replacePasswordBtn').disabled = false;
	document.getElementById('replacePasswordBtn').style.backgroundColor = '#ECB53B';
}

// 인증번호 입력란 비활성화
function certnumInputDisabled() {
	stopTimer();
	document.getElementById('certnum').disabled = true;
	document.getElementById('checkCertnumBtn').disabled = true;
	document.getElementById('checkCertnumBtn').style.backgroundColor = 'lightgrey';
}

// 비밀번호 재설정 - 비밀번호 입력란 비활성화
function passwordUpdateDisabled() {
	document.getElementById('replacePassword').disabled = true;
	document.getElementById('replacePassword').value = "";
	document.getElementById('checkPassword').disabled = true;
	document.getElementById('checkPassword').value = "";
	document.getElementById('replacePasswordBtn').disabled = true;
	document.getElementById('replacePasswordBtn').style.backgroundColor = 'lightgrey';
}

// 비밀번호 재설정 - 아이디 입력란 비활성화
function sendCertnumFromIdDisabled() {
	document.getElementById('id').disabled = true;
	document.getElementById('sendCertnumBtn').disabled = true;
	document.getElementById('sendCertnumBtn').style.backgroundColor = 'lightgrey';
}

// 비밀번호 재설정 - 인증번호 비교란 활성화
function checkCertnumActive() {
	document.getElementById('certnum').disabled = false;
	document.getElementById('checkCertnumBtn').disabled = false;
	document.getElementById('checkCertnumBtn').style.backgroundColor = '#ECB53B';
}

var timerInterval;
var timeLeft = 0;

// 인증번호 타이머설정
function startTimer() {
	timeLeft = 60;
    timerInterval = setInterval(function() {
        var minutes = Math.floor(timeLeft / 60);
        var seconds = timeLeft % 60;

        document.getElementById('timer').textContent = (minutes < 10 ? '0' : '') + minutes + ':' + (seconds < 10 ? '0' : '') + seconds;

        timeLeft--; // 시간 1초단위로 감소

        // 타이머가 0이 되면 타이머 리셋
        if (timeLeft < 0) {
            clearInterval(timerInterval);
		    document.getElementById('timer').textContent = '00:00';
		    document.getElementById('certnum').disabled = true;
		    document.getElementById('checkCertnumBtn').disabled = true;
			document.getElementById('checkCertnumBtn').style.backgroundColor = 'lightgrey';
            alert('인증번호가 만료되었습니다. 인증번호를 다시 발급해주세요.');
        }
    }, 1000); // 1초마다 실행
    return timerInterval;
}

function stopTimer() {
	clearInterval(timerInterval);
}

// 초기화
function certnumReload() {
	stopTimer();
	document.getElementById('id').disabled = false;
	document.getElementById('id').value = "";
	document.getElementById('sendCertnumBtn').disabled = false;
	document.getElementById('sendCertnumBtn').style.backgroundColor = '#ECB53B';
	
	document.getElementById('certnum').disabled = true;
	document.getElementById('certnum').value = "";
	document.getElementById('checkCertnumBtn').disabled = true;
//	$('#checkCertnumBtn').prop('disabled', true);
	document.getElementById('checkCertnumBtn').style.backgroundColor = 'lightgrey';
//	$('#checkCertnumBtn').css('backgroundColor', 'lightgrey');
	
	document.getElementById('replacePassword').disabled = true;
	document.getElementById('replacePassword').value = "";
	document.getElementById('checkPassword').disabled = true;
	document.getElementById('checkPassword').value = "";
	document.getElementById('replacePasswordBtn').disabled = true;
	document.getElementById('replacePasswordBtn').style.backgroundColor = 'lightgrey';
}

function certnumRequest() {
	stopTimer();
	$('#sendCertnumForm').submit(); 
}

$(document).ready(function() {
	$('#loginForm').submit(function(event) {
		event.preventDefault();
		var username = $('#username').val();
		var password = $('#password').val();
		
		$.ajax({
			url: './loginForms.do',
			method: 'POST',
			dataType: 'json',
			data: { username:username, password:password},
			success: function(response) {
				console.log('로그인 성공!');
				if(response === 1) {
					alert('로그인 되었습니다.');
					window.location.href="./main.do";
				} else if(response === 2) {
					alert('아이디 또는 비밀번호를 확인해주세요.');
					window.location.href="./login/loginForm.do";
				} else {
					console.log('로그인 실패');
					window.location.href="./accessError.do";
				}
			}, 
			error: function(error) {
				console.error('로그인 실패', error);
				window.location.href="./accessError.do";
			}
		});
	});
	
	// 아이디 찾기
    $('#idFindForm').submit(function(event) {
	    event.preventDefault();
	    var email = $('#email').val();
	
	    $.ajax({
	        url: './findId.do',
	        method: 'POST',
	        dataType: 'json',
	        data: { email:email },
	        success: function(response) {
				console.log('아이디찾기요청성공');
				if(response === 1) {
					alert('입력하신 이메일로 아이디값이 전송되었습니다.');
				} else {
					alert('해당 이메일정보를 가진 아이디가 존재하지 않습니다.\n다시 확인해주세요.');
				}
	        },
	        error: function(error) {
	            console.error('아이디찾기요청실패', error);
	        }
	    });
	});

	// 비밀번호 재설정 - 인증번호 발송
	$('#sendCertnumForm').submit(function(event) {
		event.preventDefault();
		var id = $('#id').val();
		
		$.ajax({
			url: './sendCertnum.do',
			method: 'POST',
			dataType: 'json',
			data: { id: id },
			success: function(response) {
				if (response === 1) {
					console.log('아이디 있음');
					sendCertnumFromIdDisabled();
					checkCertnumActive();
					alert('인증번호가 입력된 아이디의 이메일주소로 발송되었습니다.');
					startTimer();
				} else {
					console.log('아이디 없음');
					alert('입력하신 아이디에 대한 이메일이 존재하지 않습니다.');
				}
			},
			error: function(error) {
				console.error('인증번호발송실패', error)
			}
		});
	});

	// 비밀번호 재설정 - 인증번호 일치여부 확인
	$('#checkCertnumForm').submit(function(event) {
		event.preventDefault();
		var id = $('#id').val();
		var certnum = $('#certnum').val();
		
		$.ajax({
			url: './checkCertnum.do',
			method: 'POST',
			dataType: 'json',
			data: { id:id, certnum:certnum },
			success: function(response) {
				if(response === 1) {
					console.log("인증번호 일치");
					passwordUpdateInputActive();
					certnumInputDisabled();
					stopTimer();
					alert('인증번호가 일치합니다.');
				} else {
					console.log("인증번호 불일치")
					passwordUpdateDisabled();
					alert('인증번호가 일치하지 않습니다.');
				}
			},
			error: function(error) {
				console.error('인증번호비교실패', error)
			}
		});
	});

	// 비밀번호 재설정 - 비밀번호 재설정
	$('#updatePasswordForm').submit(function(event) {
		event.preventDefault();
		var id = $('#id').val();
		var password = $('#replacePassword').val();
		var passwordCheck = $('#checkPassword').val();
		var passwordRole = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z0-9]{8,16}$/; // 8~16자리 영문과 숫자조합 정규식
		
		if(!passwordRole.test(password)){
			alert('비밀번호는 8~16자리의 영문 숫자 조합이어야합니다.');
			return;
		}
		if(password != passwordCheck){
			alert('두 비밀번호의 값이 일치하지 않습니다.\n다시 확인해주세요.');
			return;
		}
		
		$.ajax({
			url: './updatePasswordForm.do',
			method: 'POST',
			dataType: 'json',
			data: { id:id, password:password },
			success: function(response) {
				console.log("비밀번호업데이트");
				alert(response.message);
				location.href='./login/loginForm.do'; 
			},
			error: function(error) {
				console.error('비밀번호업데이트실패', error);
			}
		});
	});
});