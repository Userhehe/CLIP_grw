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
		<img src="assets/img/loginlogo.png" class="additional-image" alt="loginlogo">
		<form action="./login.do" method="post">
			<!-- 아이디 입력 -->
			<div class="input-field">
				<input type="text" id="user_id" name="user_id" class="input-field" placeholder="아이디를 입력해주세요">
			</div>
			<!-- 비밀번호 입력 -->
			<div class="input-field">
				<%-- <input type="password" id="user_password" name="${_csrf.user_password}" class="input-field" placeholder="비밀번호를 입력해주세요" value="${_csrf.token}"> --%>
				<input type="password" id="user_password" name="user_password" class="input-field" placeholder="비밀번호를 입력해주세요">
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