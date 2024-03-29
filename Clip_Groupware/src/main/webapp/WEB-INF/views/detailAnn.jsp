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
<title>연차 상세정보</title>
<%@ include file="./header.jsp" %>
<link href="./assets/css/userBoard.css" rel="stylesheet">
</head>
<body>
	<main id="main" class="main">
		<div class="card">
            <div class="card-body">
            	
            	<h5 class="card-title">연차 상세정보</h5>

	            <table class="table table-hover">
	              <thead>
	                <tr>
	                  <th scope="col">구분</th>
	                  <th scope="col">정보</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach var='anDetailList' items="${anDetailList}" varStatus="vs">
		                <tr>
			                <td style="background-color: grey; color: white;">아이디</td>
			                <td>${anDetailList.user_id}
			                	
			                </td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">이름</td>
			                <td>${anDetailList.user_name}</td>
		                </tr>
<!-- 		                <tr> -->
<!-- 		                	<td style="background-color: grey; color: white;">부서</td> -->
<%-- 			                <td>${anDetailList.dept_name}</td> --%>
<!-- 		                </tr> -->
<!-- 		                <tr> -->
<!-- 		                	<td style="background-color: grey; color: white;">직급</td> -->
<%-- 			                <td>${anDetailList.ranks_name}</td> --%>
<!-- 		                </tr> -->
<!-- 		                <tr> -->
<!-- 		                	<td style="background-color: grey; color: white;">직책</td> -->
<%-- 			                <td>${anDetailList.positions_name}</td> --%>
<!-- 		                </tr> -->
		                  <tr>
		                	<td style="background-color: grey; color: white;">발생 연차</td>
			                <td>${anDetailList.annual_ct}</td>
		                </tr>
		                  <tr>
		                	<td style="background-color: grey; color: white;">사용 연차</td>
			                <td>${anDetailList.annual_use}</td>
		                </tr>
		                <tr>
		                	<td style="background-color: grey; color: white;">잔여 연차</td>
			                <td>${anDetailList.annual_leov}</td>
		                </tr>
		                
	            	</c:forEach>
	          	</tbody>
              </table>
              	<div class="flex_end">
	            	<button class="btn btn-secondary" onclick="window.location.href='./selAnnual.do'">목록</button>
	            	<button class="btn btn-secondary ml_10" onclick="window.location.href='./userInfoUpdate.do?user_seq=${param.user_seq}'">사원정보수정</button>
           		</div>
        	</div>
    	</div>
	</main>
</body>
</html>