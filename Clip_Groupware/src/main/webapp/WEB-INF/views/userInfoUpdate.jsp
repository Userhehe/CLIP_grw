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
<title>사용자 정보 수정</title>
<%@ include file="./header.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="./assets/css/userInfoUpdate.css" rel="stylesheet">
<script type="text/javascript" src="./js/userInfoUpdate.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div class="container" style="margin: 0;">
			<div class="card-body w661_5px">
				<h5 class="card-title font20">회원정보 수정</h5>
				<div class="fc_red font12">&nbsp;&nbsp;* 값은 필수값입니다</div>
				<form action="./userInfoUpdateData.do" method="post">
					<input type="hidden" name="userId" value="${param.user_seq}"/>
					<c:forEach var='userDetailList' items="${userDetailList}" varStatus="vs">
						<div class="row mb-3">
							<label for="userName" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>성명</label>
							<div class="col-sm-10">
								<input type="text" id="userName" name="userName" class="form-control" value="${userDetailList.user_name}" required="required">
							</div>
						</div>
						<div class="row mb-3">
							<label for=inputRegistnum class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>주민등록번호</label>
							<div class="col-sm-10">
								<input type="text" id="userStartRegistnum" name="userStartRegistnum" class="form-control w249_8px ib" value="${fn:substringBefore(userDetailList.user_registnum, '-')}" placeholder="주민등록번호 앞자리" required="required"> 
								<span class="ib">-</span> 
								<input type="text" id="userLastRegistnum" name="userLastRegistnum" class="form-control w249_8px ib" value="${fn:substringAfter(userDetailList.user_registnum, '-')}" placeholder="주민등록번호 뒷자리" required="required">
							</div>
						</div>
						<div class="row mb-3">
							<label for="inputEmail" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>Email</label>
							<div class="col-sm-10">
								<c:set var="emailSplit" value="${fn:split(userDetailList.user_email, '@')}"/>
								<input type="text" id="userEmail" name="userEmail" class="form-control w345px ib" value="${emailSplit[0]}" required="required"> 
								<span class="ib">@</span>
								<input type="text" id="emailDomain" name="emailDomain" class="form-control w143_7px ib" value="${emailSplit[1]}">
 							</div>
						</div>
						<div id="mailCheck">
							<button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#verticalycentered">이메일 중복체크</button>
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
								<input type="number" id="userBirthday" name="userBirthday" class="form-control" maxlength="8" value="${fn:replace(userDetailList.user_birthday, '-', '')}" placeholder="생년월일8자리 ex)19980423" required="required">
							</div>
						</div>
						<div class="row mb-3">
							<label for="inputEmail" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>연락처</label>
							<div class="col-sm-10">
								<c:set var="phonenumSplit" value="${fn:split(userDetailList.user_phonenum, '-')}"/>
								<select id="phoneFirstnum" name="phoneFirstnum" class="form-select w120px ib">
									<option value="010" <c:if test="${phonenumSplit[0] eq 010}">selected</c:if>>010</option>
									<option value="011" <c:if test="${phonenumSplit[0] eq 011}">selected</c:if>>011</option>
									<c:choose>
										<c:when test="${phonenumSplit[0] ne 010 and phonenumSplit[0] ne 011}">
											<option value="inputPhone" <c:if test="${phonenumSplit[0] ne 010 and phonenumSplit[0] ne 011}">selected</c:if>>${phonenumSplit[0]}</option>
											<option value="inputPhone" <c:if test="${phonenumSplit[0] ne 010 and phonenumSplit[0] ne 011}"></c:if>>직접 입력</option>
										</c:when>
										<c:otherwise>
											<option value="inputPhone">직접 입력</option>
										</c:otherwise>
									</c:choose>
								</select> 
								<span class="ib">-</span> 
								<input type="number" id="phoneSecondnum" name="phoneSecondnum" class="form-control w182_7px ib" placeholder="연락처 앞자리" value="${phonenumSplit[1]}" required="required"> 
								<span class="ib">-</span>
								<input type="number" id="phoneLastnum" name="phoneLastnum" class="form-control w182_7px ib" placeholder="연락처 뒷자리" value="${phonenumSplit[2]}" required="required">
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
								<input type="text" id="userAddress" name="userAddress" class="form-control" value="${userDetailList.user_address}" required="required">
							</div>
						</div>
	
						<div class="row mb-3">
							<label for="deptName" class="col-sm-2 col-form-label font12">&nbsp;&nbsp;부서선택</label>
							<div class="col-sm-10">
								<select name="deptName" class="form-select">
									<option value="">부서선택</option>
									<c:forEach var="deptLists" items="${deptLists}" varStatus="vs">
										<c:choose>
											<c:when test="${deptLists.dept_name eq userDetailList.dept_name}">
												<option value="${deptLists.dept_name}" selected>${deptLists.dept_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${deptLists.dept_name}">${deptLists.dept_name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row mb-3">
							<label for="ranksName" class="col-sm-2 col-form-label font12">&nbsp;&nbsp;직급선택</label>
							<div class="col-sm-10">
								<select name="ranksName" class="form-select">
									<option value="">직급선택</option>
									<c:forEach var="ranks" items="${ranksLists}" varStatus="vs">
										<c:choose>
											<c:when test="${ranks.ranks_name eq userDetailList.ranks_name}">
												<option value="${ranks.ranks_name}" selected>${ranks.ranks_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${ranks.ranks_name}">${ranks.ranks_name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
	
						<div class="row mb-3">
							<label for="positionsName" class="col-sm-2 col-form-label font12">&nbsp;&nbsp;직책선택</label>
							<div class="col-sm-10">
								<select name="positionsName" class="form-select">
									<option value="">직책선택</option>
									<c:forEach var="positions" items="${positionsLists}" varStatus="vs">
										<c:choose>
											<c:when test="${positions.positions_name eq userDetailList.positions_name}">
												<option value="${positions.positions_name}" selected>${positions.positions_name}</option>
											</c:when>
											<c:otherwise>
												<option value="${positions.positions_name}">${positions.positions_name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
						</div>
	
						<div class="row mb-3">
							<label for="userAuth" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>관리자여부</label>
							<div class="col-sm-10">
								<select name="userAuth" class="form-select">
									<option value="ROLE_USER" <c:if test="${userDetailList.user_auth eq 'ROLE_USER'}">selected</c:if>>N</option>
									<option value="ROLE_ADMIN" <c:if test="${userDetailList.user_auth eq 'ROLE_ADMIN'}">selected</c:if>>Y</option>
								</select>
							</div>
						</div>
						
						<div class="row mb-3">
							<label for="userStatus" class="col-sm-2 col-form-label font12"><span class="fc_red">*&nbsp;</span>재직여부</label>
							<div class="col-sm-10">
								<select name="userStatus" class="form-select">
									<option value="Y" <c:if test="${userDetailList.user_status eq 'Y'}">selected</c:if>>Y</option>
									<option value="N" <c:if test="${userDetailList.user_status eq 'N'}">selected</c:if>>N</option>
								</select>
							</div>
						</div>
						<br>
						<div class="row mb-3">
							<div>
								<button type="submit" id="userInfoUpdateBtn" class="btn btn-secondary button">사원정보수정</button>
							</div>
						</div>
					</c:forEach>
				</form>
			</div>
		</div>
	</main>
</body>
</html>