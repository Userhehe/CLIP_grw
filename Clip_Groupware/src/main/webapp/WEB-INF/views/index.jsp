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
<link href="./assets/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
			<!-- 추가 이미지 -->
			<img src="assets/img/loginlogo.png" class="additional-image"
				alt="loginlogo">
			<!-- 아이디 입력 -->
			<div class="input-field">
				<input type="text" id="username" class="input-field"
					placeholder="ID">
			</div>
			<!-- 비밀번호 입력 -->
			<div class="input-field">
				<input type="text" id="password" class="input-field"
					placeholder="PASSWORD">
			</div>
			<!-- 로그인 버튼 (기능구현시 a tag 삭제 할것!!!!) -->
			<a href='./main.do'><button id="loginBtn" class="button" >Login</button></a>
			
			<div class="links">
				<a href="아이디찾기_URL">아이디 찾기</a>
				<a>|</a>
				<a href="비밀번호재설정_URL">비밀번호 재설정</a>
			</div>
		</div>
</body>
</html>