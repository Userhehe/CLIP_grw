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
	              	<c:forEach var='anDetail' items="${anDetailList}" varStatus="vs">
				    <tr>
				        <td style="background-color: grey; color: white;">아이디</td>
				        <td>${anDetail.user_id}</td>
				    </tr> 
				    <tr>
				        <td style="background-color: grey; color: white;">이름</td>
				        <td>${anDetail.user_name}</td>
				    </tr>
				    <tr> 
				        <td style="background-color: grey; color: white;">부서</td> 
				        <td>${anDetail.dept_name}</td> 
				    </tr> 
				    <tr> 
				        <td style="background-color: grey; color: white;">직급</td> 
				        <td>${anDetail.ranks_name}</td> 
				    </tr> 
				    <tr> 
				        <td style="background-color: grey; color: white;">직책</td> 
				        <td>${anDetail.positions_name}</td> 
				    </tr> 
				    <tr>
				        <td style="background-color: grey; color: white;">사용 가능 연차</td>
				        <td>${anDetail.ann_leov - anDetail.ann_useday}</td>
				    </tr>
				</c:forEach>

	          	</tbody>
              </table>
              	<div class="flex_end">
	            	<button class="btn btn-secondary" onclick="window.location.href='./annAll.do'">목록</button>
	            	<button class="btn btn-secondary ml_10" onclick="window.location.href='./updateAnn.do?user_id=${param.user_id}'">연차수정</button>
           		</div>
        	</div>
    	</div>
	</main>
</body>
</html>