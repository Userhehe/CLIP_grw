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
<title>회원정보등록</title>
<%@ include file="./header.jsp"%>
<link href="./assets/css/signUp.css" rel="stylesheet">
<script type="text/javascript" src="./js/signUp.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div class="container" style="margin: 0;">
			<div class="card-body w661_5px">
				<h5 class="card-title font20">회원정보 등록</h5>
				<div class="fc_red font12">&nbsp;&nbsp;* 값은 필수값입니다</div>
				<form action="./signUp.do" method="post">
					<div class="row mb-3">
						<label for="userName" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>성명</label>
						<div class="col-sm-10">
							<input type="text" id="userName" name="userName" class="form-control" required="required">
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputRegistnum" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>주민등록번호</label>
						<div class="col-sm-10">
							<input type="text" id="userStartRegistnum" name="userStartRegistnum" class="form-control w249_8px ib" placeholder="주민등록번호 앞자리" required="required"> 
							<span class="ib">-</span> 
							<input type="password" id="userLastRegistnum" name="userLastRegistnum" class="form-control w249_8px ib" placeholder="주민등록번호 뒷자리" required="required">
						</div>
					</div>
					<div class="row mb-3">
						<label for="inputEmail" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>Email</label>
						<div class="col-sm-10">
							<input type="text" id="userEmail" name="userEmail" class="form-control w345px ib" data-bs-toggle="modal" data-bs-target="#verticalycentered" required="required"> 
							<span class="ib">@</span> 
							<input type="text" id="emailDomain" name="emailDomain" class="form-control w143_7px ib" data-bs-toggle="modal" data-bs-target="#verticalycentered">
						</div>
					</div>
					<!-- 이메일 중복체크 모달창 -->
					<div class="modal fade" id="verticalycentered" tabindex="-1">
				  		<div class="modal-dialog modal-dialog-centered">
						    <div class="modal-content">
						        <div class="modal-header">
						            <h5 class="modal-title">이메일 중복체크</h5>
						            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				        	  	</div>
							    <div class="modal-body">
								<c:set var="emailSplit" value="${fn:split(userDetailList.user_email, '@')}"/>
								<input type="text" id="frontEmail" name="frontEmail" class="form-control w297px ib" value="${emailSplit[0]}" required="required"> 
								<span class="ib">@</span>
								<select id="backEmail" name="backEmail" class="form-select w143_7px ib">
									<option value="gmail.com" <c:if test="${emailSplit[1] eq 'gmail.com'}">selected</c:if>>gmail.com</option>
									<option value="naver.com" <c:if test="${emailSplit[1] eq 'naver.com'}">selected</c:if>>naver.com</option>
									<option value="hanmail.com" <c:if test="${emailSplit[1] eq 'hanmail.com'}">selected</c:if>>hanmail.com</option>
									<option value="openInputEmail" <c:if test="${emailSplit[1] ne 'gmail.com' and emailSplit[1] ne 'naver.com' and emailSplit[1] ne 'hanmail.com'}">selected</c:if>>직접 입력</option>
								</select>
								<div id="mailDomainInput">
									직접입력 : &nbsp;
									<input type="text" id="inputEmail" class="form-control w143_7px" name="backEmail"
										<c:choose>
											<c:when test="${emailSplit[1] ne 'gmail.com' and emailSplit[1] ne 'naver.com' and emailSplit[1] ne 'hanmail.com'}">
												value="${emailSplit[1]}"
											</c:when>
											<c:otherwise>
												value=""
											</c:otherwise>
										</c:choose>
									>
								</div>
									<div id="emailUnAvailable">이미 존재하는 아이디입니다.</div>
									<div id="emailAvailable">사용가능한 아이디입니다.</div>
									<button type="button" id="emailCheckBtn" class="btn btn-primary btn-sm">이메일 중복체크</button>
							    </div>
							    <div class="modal-footer">
							      	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
							        <button type="button" id="emailInsertBtn" class="btn btn-primary" data-bs-dismiss="modal">이메일 등록</button>
							    </div>
						    </div>
				  		</div>
					</div>
					<div class="row mb-3">
						<label for="userBirthday" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>생년월일</label>
						<div class="col-sm-10">
							<input type="number" id="userBirthday" name="userBirthday" class="form-control" maxlength="8" placeholder="생년월일8자리 ex)19980423" required="required">
						</div>
					</div>

					<div class="row mb-3">
						<label for="inputEmail" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>연락처</label>
						<div class="col-sm-10">
							<select id="phoneFirstnum" name="phoneFirstnum" class="form-select w120px ib">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="inputPhone">직접 입력</option>
							</select> 
							<span class="ib">-</span> 
							<input type="number" id="phoneSecondnum" name="phoneSecondnum" class="form-control w182_7px ib" placeholder="연락처 앞자리" required="required"> 
							<span class="ib">-</span> 
							<input type="number" id="phoneLastnum" name="phoneLastnum" class="form-control w182_7px ib" placeholder="연락처 뒷자리" required="required">
						</div>
					</div>
					
					<div id="phonenumFrontInputCt" class="row mb-3">
						<label for="phonenumFrontInput" class="col-sm-2 col-form-label font12"><span class="fc_red">&nbsp;&nbsp;</span></label>
						<div id="phonenumFrontInput" class="col-sm-10">
							<input type="number" id="inputPhoneFirstnum" name="inputPhoneFirstnum" class="form-control w120px ib" value="" placeholder="직접입력">
						</div>
					</div>

					<div class="row mb-3">
						<label for="userAddress" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>주소</label>
						<div class="col-sm-10">
							<input type="text" id="userAddress" name="userAddress" class="form-control" required="required">
						</div>
					</div>

					<div class="row mb-3">
						<label for="deptName" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>부서선택</label>
						<div class="col-sm-10">
							<select id="deptName" name="deptName" class="form-select">
								<option value="">부서선택</option>
								<c:forEach var="deptLists" items="${deptLists}" varStatus="vs">
									<option value="${deptLists.dept_name}">${deptLists.dept_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mb-3">
						<label for="ranksName" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>직급선택</label>
						<div class="col-sm-10">
							<select id="ranksName" name="ranksName" class="form-select">
								<option value="">직급선택</option>
								<c:forEach var="ranksLists" items="${ranksLists}" varStatus="vs">
									<option value="${ranksLists.ranks_name}">${ranksLists.ranks_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row mb-3">
						<label for="positionsName" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>직책선택</label>
						<div class="col-sm-10">
							<select id="positionsName" name="positionsName" class="form-select">
								<option value="">직책선택</option>
								<c:forEach var="positionsLists" items="${positionsLists}" varStatus="vs">
									<option value="${positionsLists.positions_name}">${positionsLists.positions_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row mb-3">
						<label for="userAuth" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>관리자여부</label>
						<div class="col-sm-10">
							<select name="userAuth" class="form-select">
								<option value="ROLE_USER">N</option>
								<option value="ROLE_ADMIN">Y</option>
							</select>
						</div>
					</div>
					
					<div class="row mb-3">
						<label for="userRegdate" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>입사일</label>
						<div class="col-sm-10">
							<input type="date" id="userRegdate" name="userRegdate" class="form-control" required="required">
						</div>
					</div>
					<br>
					<div class="row mb-3">
						<div class="flex_end">
							<button class="btn btn-secondary" onclick="window.location.href='./userInfo.do'">목록</button>&nbsp;
							<button type="submit" id="userInfoInsertBtn" class="btn btn-secondary">사원정보등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>