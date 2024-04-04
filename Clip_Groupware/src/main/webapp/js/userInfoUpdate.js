$(document).ready(function(){
	$('#emailUnAvailable').hide(); // 중복체크 여부 문구 숨기기
	$('#emailAvailable').hide(); // 중복체크 여부 문구 숨기기
	$('#userEmail').attr('readonly',true); // 이메일 입력란 비활성화
	$('#emailDomain').attr('readonly',true); // 이메일 도메인 입력란 비활성화
	$('#inputEmail').prop('disabled',true); // 이메일 중복체크 직접입력란 비활성화
	$('#emailInsertBtn').prop('disabled',true); // 이메일 중복체크 완료 후 이메일 입력 버튼 비활성화
	$('#phonenumFrontInputCt').hide(); // 연락처 지역번호 직접입력란 숨기기
	$('#inputPhoneFirstnum').attr('disabled',true); // 연락처 지역번호 직접입력란 비활성화
	
	// 새로고침으로 submit 되지 않도록
	var userInfoInsertBtn = document.getElementById("userInfoUpdateBtn");
		userInfoInsertBtn.addEventListener("submit", function(event) {
		event.preventDefault();
	});
	
	// 카카오 주소찾기
	window.onload = function() {
		document.getElementById("userAddress").addEventListener("click",function(){
			new daum.Postcode({
				oncomplete: function(data) {
					document.getElementById("userAddress").value = data.address;
					document.querySelector("input[name=userAddress]").focus();
				}
			}).open();
		});
	}
	
	// 이메일 키보드 입력시 이메일 등록버튼 비활성화
	var frontEmail = document.getElementById('frontEmail');
	frontEmail.addEventListener('keyup', function(event) {
		$('#emailAvailable').hide();
		$('#emailUnAvailable').hide();
		$('#emailInsertBtn').prop('disabled',true);
	});
	
	// 이메일 도메인 키보드 입력시 이메일 등록버튼 비활성화
	var inputEmail = document.getElementById('inputEmail');
	inputEmail.addEventListener('keyup', function(event) {
		$('#emailAvailable').hide();
		$('#emailUnAvailable').hide();
		$('#emailInsertBtn').prop('disabled',true);
	});
	
	// 이메일 중복체크
	$('#emailCheckBtn').click(function(){
		var frontEmail = $('#frontEmail').val();
		var backEmail = $('#backEmail').val();
		if(frontEmail == null || frontEmail == "") {
			alert('이메일 입력란을 반드시 채워주세요');
			return;
		}
		if ($('#backEmail option[value="openInputEmail"]').prop('selected') && ($('#inputEmail').val() == null || $('#inputEmail').val() == "")) {
			alert('이메일 도메인을 반드시 채워주세요');
			return;
		}
		console.log('frontEmail : ', frontEmail);
		console.log('backEmail : ', backEmail); 
		
		$.ajax({
			url: './emailCheck.do',
			method: 'POST',
			dataType: 'json',
			data: { frontEmail:frontEmail, backEmail:backEmail },
			success: function(response) {
				console.log('이메일중복체크성공');
				console.log('responseType', typeof response);
				console.log('response.emailCheck',response.emailCheck);
				console.log('response.emailCheckType', typeof response.emailCheck);
				if(response.emailCheck >= 1) {
					alert('입력하신 이메일로 가입된 아이디가 존재합니다.\n다른 이메일을 입력해주세요.');
					$('#emailUnAvailable').show();
					$('#emailAvailable').hide();
					$('#emailInsertBtn').prop('disabled',true);
				} else {
					alert('입력하신 이메일은 사용가능합니다.');
					$('#emailAvailable').show();
					$('#emailUnAvailable').hide();
					$('#emailInsertBtn').prop('disabled',false);
				}
			},
			error: function(xhr, status, error) {
				console.error('이메일중복체크실패', xhr, status, error);
			}
		});
	});

	// 이메일 중복체크 도메인 selectbox 직접입력선택시 직접입력 input태그 활성화 & 비활성화
	$('#backEmail').change(function(){
	    var selectVal = $(this).val();
	    if(selectVal === 'openInputEmail') {
	        $('#inputEmail').prop('disabled', false);
	    } else {
	        $('#inputEmail').prop('disabled', true).val('');
	    }
	});
	
	// 이메일 중복체크 완료 후 이메일 입력 버튼
	$('#emailInsertBtn').click(function(){
		var userEmail = $('#frontEmail').val();
		var emailDomain = $('#backEmail').val();
		var inputEmail = $('#inputEmail').val();
		
		$('#userEmail').val(userEmail);
		if(inputEmail != null && inputEmail != "") {
			$('#emailDomain').val(inputEmail);
		} else {
			$('#emailDomain').val(emailDomain);
		}
	});
	
	// 직접입력란 활성화 & 비활성화
	$('#phoneFirstnum').change(function(){
	    var selectVal = $(this).val();
	    if(selectVal === 'inputPhone') {
			$('#phonenumFrontInputCt').show();
	        $('#inputPhoneFirstnum').prop('disabled', false);
	    } else {
	        $('#inputPhoneFirstnum').prop('disabled', true).val('');
	        $('#phonenumFrontInputCt').hide();
	    }
	});
	
	// 필수입력란 미입력시 return
	$('#userInfoUpdateBtn').click(function(event){
		if ($('#phoneFirstnum option[value="inputPhone"]').prop('selected') && ($('#inputPhoneFirstnum').val() === '')) {
			alert('연락처 지역번호를 입력해주세요');
			event.preventDefault(); // 폼 제출을 취소합니다.
			return;
		}
		if($('#deptName').val() === '') {
			alert('부서를 선택해주세요');
			event.preventDefault(); // 폼 제출을 취소합니다.
			return;			
		}
		if($('#ranksName').val() === '') {
			alert('직급을 선택해주세요');
			event.preventDefault(); // 폼 제출을 취소합니다.
			return;			
		}
		if($('#positionsName').val() === '') {
			alert('직책을 선택해주세요');
			event.preventDefault(); // 폼 제출을 취소합니다.
			return;			
		}
	});
});
