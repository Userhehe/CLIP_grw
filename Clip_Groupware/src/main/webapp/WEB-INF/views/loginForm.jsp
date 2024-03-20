<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>CLIP LOG IN</title>
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<!-- Template Main CSS File -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./assets/css/loginForm.css" rel="stylesheet">
<script type="text/javascript" src="./js/loginForm.js"></script>
</head>
<body>
	<div class="container">
		<img src="assets/img/loginlogo.png" class="additional-image" alt="loginlogo">
		<form action="./loginForms.do" method="post">
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
			<div id="idFindModal" class="modal fade">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<span class="close" onclick="closeIdModal()">&times;</span>
						<p>아이디 찾기</p>
					</div>
				</div>
			</div>
			|&nbsp;
			<a href="/editPassword.do">비밀번호 재설정</a>
		</div>
	</div>
</body>
</html>
