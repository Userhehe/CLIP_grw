<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./assets/css/signUp.css" rel="stylesheet">
<%@ include file="./header.jsp" %>
</head>
<body>
	<div class="container">
		<!-- 추가 이미지 -->
		<form action="./signUp.do" method="post">
			<!-- 아이디 입력 -->
			<div class="mg_top15">
				<input type="text" id="user_name" name="user_name" class="input-field" placeholder="성명">
			</div>
			<!-- 비밀번호 입력 -->
			<div>
				<input type="text" id="user_front_registnum" name="user_password" class="input-field" maxlength="6" placeholder="주민등록번호 앞자리">
				-
				<input type="password" id="user_password" name="user_password" class="input-field" maxlength="7" placeholder="주민등록번호 뒷자리">
			</div>
			<div>
				<input type="text" id="user_email" name="user_email" class="input-field">
				@
				<label for="email"></label>
				<select name="email">
					<option value="gmail.com">gmail.com</option>
					<option value="naver.com">naver.com</option>
					<option value="hanmail.com">hanmail.com</option>
					<option value="input_email">직접 입력</option>
				</select>
			</div>
			
			<input type="text" maxlength="8" placeholder="생년월일8자리 ex)19980423">
			
			<div>
				<select name="phone_firstnum">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="input_phone_firstnum">직접 입력</option>
				</select>
				-
				<input type="text" id="phone_secondnum" placeholder="전화번호 앞자리">
				-
				<input type="text" id="phone_lastnum" placeholder="전화번호 뒷자리">
				
				<input type="text" id="user_address" placeholder="주소">
				
				<div>
					<label for="dept">부서선택</label>
					<select name="dept">
						<option value="010"></option>
						<option value="011">011</option>
						<option value="input_dept">직접 입력</option>
					</select>
					<label for="ranks">직급선택</label>
					<select name="ranks">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="input_dept">직접 입력</option>
					</select>
					<label for="positions">직책선택</label>
					<select name="positions">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="input_dept">직접 입력</option>
					</select>
					<label for="positions">관리자여부</label>
					<select name="positions">
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
					
				</div>
			</div>
			
			
			
			<input type="submit" id="login_btn" class="button mg_top15" value="사원정보 등록"/>
			
			
		</form>
	</div>
</body>
</html>