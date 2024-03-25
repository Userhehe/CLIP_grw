// 페이지가 캐시된 상태인지 확인하는 함수
function isPageCached() {
    return window.performance.getEntriesByType("navigation")[0].type === "back_forward";
}

// 메시지 수신 시 처리하는 함수
function handleMessage(message) {
    if (!isPageCached()) {
        // 페이지가 캐시된 상태가 아니면 메시지 처리
        console.log("Received message:", message);
    } else {
        // 페이지가 캐시된 상태이면 경고 메시지 표시
        console.warn("Message received while page is cached. Ignoring message.");
    }
}


// 아이디 찾기 모달창 숨기기
document.addEventListener('DOMContentLoaded', function(){
	var modal = document.getElementById("idFindModal");
	modal.style.display = "none";
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
	modal.style.display = "none";
}






$(document).ready(function() {
    $('#idFindForm').submit(function(event) {
        event.preventDefault(); // 기본 제출 방지
        
        // 이메일 값을 가져오기
        var email = $('#email').val();
        console.log('이메일주소는??', email);

        $.ajax({
            url: './findId.do',
            method: 'POST',
            data: { email: email }, // 이메일 값을 데이터로 전달
            dataType: 'html',
            success: function(response) {
                console.log('아디찾기성공!!!!');
		        // alert 창에 메시지 표시
		        alert(response);
            },
            error: function(xhr, status, error) {
                console.error('아디찾기요청실패...', status, error);
            }
        });
    });
    
    $('#sendCertNumForm').submit(function(event) {
		event.preventDefault();
		
		var id = $('#id').val();
		console.log('아이디는????', id);
		
		$.ajax({
			url: './sendCertNum.do',
			method: 'POST',
			data: { id: id },
			dataType: 'html',
			success: function(response) {
				console.log('인증번호발송성공!!!!');
				alert(response);
			},
			error: function(xhr, status, error) {
				console.error('인증번호발송실패...', status, error)
			}
		})
	});
	
	$('#comparisonCertNumForm').submit(function(event) {
		event.preventDefault();
		
		var id = $('#id').val();
		var certnum = $('#certnum').val();
		console.log('인증번호값은 ????',certnum);
		console.log('아이디값은 ????', id);
		
		$.ajax({
			url: './comparisonCertNumForm.do',
			method: 'POST',
			data: { id: id, certnum: certnum },
			dataType: 'text',
			success: function(response) {
				console.log("인증번호비교!!!!");
				alert(response);
			},
			error: function(xhr, status, error) {
				console.error('인증번호비교실패....', status, error)
			}
		})
	});
});