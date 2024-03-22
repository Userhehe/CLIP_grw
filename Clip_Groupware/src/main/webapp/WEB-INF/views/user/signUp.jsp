<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ include file="./header.jsp"%>
<link href="./assets/css/signUp.css" rel="stylesheet">
</head>
<body>
	<main id="main" class="main">
		<div class="container" style="background-color: #F2F2F2; width: 70vh;">
			<div class="card-body w65vh">
				<h5 class="card-title font20">회원정보 등록</h5>
				<form action="./signUp.do" method="post">
					<div class="row mb-3">
						<label for="inputText" class="col-sm-2 col-form-label font12">성명</label>
						<div class="col-sm-10">
							<input type="text" id="user_name" name="user_name"
								class="form-control" required="required">
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputEmail" class="col-sm-2 col-form-label font12">주민등록번호</label>
						<div class="col-sm-10">
							<input type="text" id="user_start_registnum" name="user_start_registnum" class="form-control w24_7vh ib" placeholder="주민등록번호 앞자리" required="required"> 
							<span class="ib">-</span> 
							<input type="password" id="user_last_registnum" name="user_last_registnum" class="form-control w24_7vh ib" placeholder="주민등록번호 뒷자리" required="required">
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputEmail" class="col-sm-2 col-form-label font12">Email</label>
						<div class="col-sm-10">
							<input type="text" id="user_email" name="user_email" class="form-control w33_5vh ib" required="required"> 
							<span class="ib">@</span> 
							<select name="email" class="form-select w15_2vh ib">
								<option value="gmail.com">gmail.com</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.com">hanmail.com</option>
								<option value="input_email">직접 입력</option>
							</select>
						</div>
					</div>
					<div class="row mb-3">
						<label for="user_birthday" class="col-sm-2 col-form-label font12">생년월일</label>
						<div class="col-sm-10">
							<input type="number" id="user_birthday" name="user_birthday" class="form-control" maxlength="8" placeholder="생년월일8자리 ex)19980423" required="required">
						</div>
					</div>

					<div class="row mb-3">
						<label for="inputEmail" class="col-sm-2 col-form-label font12">연락처</label>
						<div class="col-sm-10">
							<select name="phone_firstnum" class="form-select w15vh ib">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="input_phone">직접 입력</option>
							</select> 
							<span class="ib">-</span> 
							<input type="number" id="phone_secondnum" name="phone_secondnum" class="form-control w16_72vh ib" placeholder="연락처 앞자리" required="required"> 
							<span class="ib">-</span> 
							<input type="number" id="phone_lastnum" name="phone_lastnum" class="form-control w16_72vh ib" placeholder="연락처 뒷자리" required="required">
						</div>
					</div>

					<div class="row mb-3">
						<label for="user_address" class="col-sm-2 col-form-label font12">주소</label>
						<div class="col-sm-10">
							<input type="text" id="user_address" name="user_address" class="form-control" required="required">
						</div>
					</div>

					<div class="row mb-3">
						<label for="dept_name" class="col-sm-2 col-form-label font12">부서선택</label>
						<div class="col-sm-10">
							<select name="dept_name" class="form-select">
								<option value="">부서선택</option>
								<c:forEach var="deptLists" items="${deptLists}" varStatus="vs">
									<option value="${deptLists.dept_name}">${deptLists.dept_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mb-3">
						<label for="ranks_name" class="col-sm-2 col-form-label font12">직급선택</label>
						<div class="col-sm-10">
							<select name="ranks_name" class="form-select">
								<option value="">직급선택</option>
								<c:forEach var="positLists" items="${positionsLists}" varStatus="vs">
									<option value="${positLists.positions_name}">${positLists.positions_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row mb-3">
						<label for="positions_name" class="col-sm-2 col-form-label font12">직책선택</label>
						<div class="col-sm-10">
							<select name="positions_name" class="form-select">
								<option value="">직책선택</option>
								<c:forEach var="ranksLists" items="${ranksLists}" varStatus="vs">
									<option value="${ranksLists.ranks_name}">${ranksLists.ranks_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row mb-3">
						<label for="user_auth" class="col-sm-2 col-form-label font12">관리자여부</label>
						<div class="col-sm-10">
							<select name="user_auth" class="form-select">
								<option value="ROLE_USER">N</option>
								<option value="ROLE_ADMIN">Y</option>
							</select>
						</div>
					</div>

					<br />
					<div class="row mb-3">
						<div>
							<button type="submit" class="btn btn-secondary button">사원정보등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</main>
</body>
</html>