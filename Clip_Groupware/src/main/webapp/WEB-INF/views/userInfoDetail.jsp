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
<title>사용자 상세정보</title>
<%@ include file="./header.jsp" %>
</head>
<body>
	<main id="main" class="main">
		<div class="card">
            <div class="card-body">
            	
            	<h5 class="card-title">사용자 상세정보</h5>

	            <!-- Table with hoverable rows -->
	            <table class="table table-hover">
	              <thead>
	                <tr>
	                  <th scope="col">구분</th>
	                  <th scope="col">정보</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach var='userDetailList' items="${userDetailList}" varStatus="vs">
		                <tr>
			                <td>아이디</td>
			                <td>${userDetailList.user_id}</td>
		                </tr>
		                <tr>
		                	<td>주민등록번호</td>
			                <td>${userDetailList.user_registnum}</td>
		                </tr>
		                <tr>
		                	<td>이메일</td>
			                <td>${userDetailList.user_email}</td>
		                </tr>
		                <tr>
		                	<td>생년월일</td>
			                <td>${userDetailList.user_birthday}</td>
		                </tr>
		                <tr>
		                	<td>연락처</td>
			                <td>${userDetailList.user_phonenum}</td>
		                </tr>
		                <tr>
		                	<td>주소</td>
			                <td>${userDetailList.user_address}</td>
		                </tr>
		                <tr>
		                	<td>부서</td>
			                <td>${userDetailList.dept_name}</td>
		                </tr>
		                <tr>
		                	<td>직급</td>
			                <td>${userDetailList.ranks_name}</td>
		                </tr>
		                <tr>
		                	<td>직책</td>
			                <td>${userDetailList.positions_name}</td>
		                </tr>
		                <tr>
		                	<td>입사일</td>
			                <td>${userDetailList.user_regdate}</td>
		                </tr>
	                </c:forEach>
	              </tbody>
              </table>
              <!-- End Table with hoverable rows -->
            </div>
          </div>
	</main>
</body>
</html>