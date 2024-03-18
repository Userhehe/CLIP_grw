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
<link href="./assets/css/loginForm.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<img src="assets/img/loginlogo.png" class="additional-image" alt="loginlogo">
		<form action="./loginForm.do" method="post">
			<div class="input-field">
				<input type="text" id="username" name="username" class="input-field" placeholder="아이디를 입력해주세요" required="required">
			</div>
			<div class="input-field">
				<input type="password" id="password" name="password" class="input-field" placeholder="비밀번호를 입력해주세요" required="required">
			</div>
			<div>
				<label for="remember">자동 로그인</label>
				<input type="checkbox" id="remember" name="remember-me">							
			</div>
			<input type="submit" id="login_btn" class="button" value="Login"/>
		</form>
		<div class="links">
			<a href="아이디찾기_URL">아이디 찾기</a>
			|&nbsp;
			<a href="비밀번호재설정_URL">비밀번호 재설정</a>
		</div>
	</div>
</body>
</html>