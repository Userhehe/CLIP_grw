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
<link href="./assets/css/userBoard.css" rel="stylesheet">
</head>
<body>
	<main id="main" class="main flexCenter">
		<div id="card" class="card">
            <div id="userCardBody" class="card-body">
            	<h5 id="userCardTitle" class="card-title">사용자 상세정보</h5>

	            <table class="table">
	              <thead>
	                <tr>
	                  <th scope="col">구분</th>
	                  <th scope="col">정보</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach var='userDetailList' items="${userDetailList}" varStatus="vs">
		                <tr>
			                <td style="background-color: grey; color: white;">아이디</td>
			                <td>${userDetailList.user_id}</td>
		                </tr>
		                <tr>
			                <td style="background-color: grey; color: white;">아이디</td>
			                <td>${userDetailList.user_name}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">주민등록번호</td>
			                <td>${userDetailList.user_registnum}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">이메일</td>
			                <td>${userDetailList.user_email}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">생년월일</td>
			                <td>${userDetailList.user_birthday}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">연락처</td>
			                <td>${userDetailList.user_phonenum}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">주소</td>
			                <td>${userDetailList.user_address}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">부서</td>
			                <td>${userDetailList.dept_name}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">직급</td>
			                <td>${userDetailList.ranks_name}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">직책</td>
			                <td>${userDetailList.positions_name}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">입사일</td>
			                <td>${userDetailList.user_regdate}</td>
		            	</tr>
	            	</c:forEach>
	          	</tbody>
              </table>
              	<div class="flex_end">
	            	<button class="btn btn-secondary" onclick="window.location.href='./userInfo.do'">목록</button>
	            	<button class="btn btn-secondary ml_10" onclick="window.location.href='./userInfoUpdate.do?user_seq=${param.user_seq}'">사용자정보수정</button>
           		</div>
        	</div>
    	</div>
	</main>
</body>
</html>