<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>CLIP LOG IN</title>
<meta name="robots" content="noindex, nofollow">
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<!-- Template Main CSS File -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/css/loginForm.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="./js/loginForm.js"></script>

</head>
<body>
	<!-- 아이디 찾기 모달 -->
	<form action="" id="idFindForm" method="post">
		<div class="modal fade show" id="idFindModal" tabindex="-1" style="display: block;" aria-modal="true" role="dialog">
    		<div class="modal-dialog modal-dialog-centered">
		        <div class="modal-content">
		        	<div class="modal-header">
		            	<h5 class="modal-title">아이디 찾기</h5>
		            	<button type="button" class="btn-close" onclick="closeIdModal()" data-bs-dismiss="modal" aria-label="Close"></button>
		        	</div>
			        <div class="modal-body">
					  	<div class="form-group">
							<input type="text" class="form-control" id="email" name="email" placeholder="가입하신 이메일주소를 입력해주세요" required="required">
						</div>
						<div class="fc_blue font12">&nbsp;&nbsp;* 발송버튼을 누르면 가입하신 이메일 주소로 아이디값이 발송됩니다.</div>
		        	</div>
	            	<div class="modal-footer">
		            	<button type="button" class="btn btn-secondary" onclick="closeIdModal()" data-bs-dismiss="modal">닫기</button>
			            <button type="submit" class="btn btn-primary orange_bg">발송</button>
		        	</div>
		        </div>
	    	</div>
	    </div>
    </form>
    
    <!-- 비밀번호 재설정 모달 -->
	<div class="modal fade show" id="replacePwModal" tabindex="-1" style="display: block;" aria-modal="true" role="dialog">
   		<div class="modal-dialog modal-dialog-centered">
	        <div class="modal-content">
        		<div class="modal-header">
             		<h5 class="modal-title">비밀번호 재설정</h5>
             		<button type="button" class="btn-close" onclick="closePwModal()" data-bs-dismiss="modal" aria-label="Close"></button>
        		</div>
        		<div class="modal-body">
        			<form action="" id="sendCertnumForm" method="post">
						<div class="form-group">
							<input type="text" class="form-control replace_pw_input" id="id" name="id" placeholder="가입하신 아이디를 입력해주세요" required="required">
							<button type="submit" id="sendCertnumBtn" class="btn btn-primary orange_bg">발송</button>
						</div>
						<div class="fc_blue font12">&nbsp;&nbsp;* 발송버튼을 누르면 입력하신 해당 아이디의 이메일주소로 인증번호가 발송됩니다.</div>
					</form>

					<form action="" id="checkCertnumForm" method="post">			        
				        <div class="mg_top10">
				        	<div class="flex_end">
					        	<div>인증번호 입력시간 : &nbsp;</div>
					        	<div id="timer" class="flex_end" name="timer">00:00</div>
				        	</div>
							<div class="form-group">
								<input type="number" class="form-control replace_pw_input" id="certnum" name="certnum" placeholder="인증번호를 입력해주세요" required="required">
								<button type="submit" id="checkCertnumBtn" class="btn btn-primary orange_bg">확인</button>
							</div>
							<div class="fc_blue font12">&nbsp;&nbsp;* 가입하신 이메일 주소로 발송된 인증번호를 입력해주세요.</div>
				        </div>
			        </form>
			        
			        <form action="" id="updatePasswordForm" method="post">
				        <div>
							<div class="form-group">
								<input type="password" class="form-control replace_pw_input mg_top30" id="replacePassword" name="replacePassword" placeholder="새로운 비밀번호를 입력해주세요" required="required">
								<input type="password" class="form-control replace_pw_input mg_top10" id="checkPassword" name="checkPassword" placeholder="비밀번호를 한번 더 입력해주세요" required="required">
								<div class="fc_blue font12">&nbsp;&nbsp;* 비밀번호는 영문&숫자를 포함한 8~16자리로 이루어져야합니다.</div>
								<button type="submit" id="replacePasswordBtn" class="btn btn-primary flex_end fr orange_bg">비밀번호 재설정</button>
							</div>
				        </div>
			        </form>
           		</div>
	        	<div class="modal-footer">
        			<button type="submit" class="btn btn-secondary white_bg" onclick="certnumRequest()" data-bs-dismiss="modal">인증번호재요청</button>
	            	<button type="button" class="btn btn-secondary" onclick="closePwModal()" data-bs-dismiss="modal">Close</button>
	        	</div>
        	</div>
    	</div>
    </div>
	
	<div class="container">
		<img src="assets/img/loginlogo.png" class="additional-image" alt="loginlogo">
<!-- 		<form action="./login" method="post"> -->
		<form action="./loginForms.do" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="input-field">
				<input type="text" id="username" name="username" class="input-field" placeholder="아이디를 입력해주세요" required="required">
			</div>
			<div class="input-field">
				<input type="password" id="password" name="password" class="input-field" placeholder="비밀번호를 입력해주세요" required="required">
			</div>
			<input type="submit" id="login_btn" class="button" value="Login"/>
			
			<div class="form-check" style="display: flex;">
				<input type="checkbox" id="remember" class="form-check-input" name="remember-me">							
				<label for="remember" class="form-check-label">자동 로그인</label>
			</div>
		</form>
		
		<div class="links">
			<a href="#" onclick="openIdModal()">아이디 찾기</a>
			|&nbsp;
			<a href="#" onclick="openPwModal()">비밀번호 재설정</a>
		</div>
	</div>
</body>
</html>
