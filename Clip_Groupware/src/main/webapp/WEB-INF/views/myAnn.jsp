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
<title>나의 연차정보</title>
<%@ include file="./header.jsp" %>
<link href="./assets/css/userBoard.css" rel="stylesheet">
</head>
<body>
<%
UserinfoVo loginUserVo = (UserinfoVo)session.getAttribute("loginVo");
%>
	<main id="main" class="main">
		<div class="card">
            <div class="card-body">
            	
            	<h5 class="card-title">나의 연차정보</h5>

	            <table class="table table-hover">
	              <thead>
	                <tr>
	                  <th scope="col">구분</th>
	                  <th scope="col">정보</th>
	                </tr>
	              </thead>
	              
	              <tbody>
	              <c:forEach var="myDetail" items="${myDetailList}" varStatus="vs">
				    <tr>
				        <td style="background-color: grey; color: white;">아이디</td>
				        <td>${myDetail.user_id}</td>
				    </tr> 
				    <tr>
				        <td style="background-color: grey; color: white;">이름</td>
				        <td>${myDetail.user_name}</td>
				    </tr>
				    <tr>
				        <td style="background-color: grey; color: white;">사용 가능 연차</td>
				        <td>${myDetail.ann_leov}</td>
				    </tr>
				    <tr>
				        <td style="background-color: grey; color: white;">사용한 연차</td>
				        <td>${myDetail.ann_useday}</td>
				    </tr>
				</c:forEach>

	          	</tbody>
              </table>
        	</div>
    	</div>
	</main>
</body>
</html>