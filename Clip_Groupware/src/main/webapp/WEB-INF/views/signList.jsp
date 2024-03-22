<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>사인 리스트 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ include file="./header.jsp" %>
</head>
<body>
<div id="container" style=" margin-top: 200px; ">
<div style="text-align: center;">
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>이름</th>
					<th>제목</th>
					<th>작성날자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lists" items="${lists}" varStatus="vr">
					<tr>
						<td>${vr.count}</td>
 						<td>${lists.signs_seq}</td>
						<td>${lists.user_id}</td>
						<td>${lists.user_name}</td> 
						<%-- <td>${lists.signs_image}</td> --%>
						
 						<%-- <td><a href="./selectPad.do?user_id=${lists.user_id}">${lists.signs_name}</a></td>  --%>
 						<td><a href="./selectPad.do?signs_seq=${lists.signs_seq}">${lists.signs_name}</a></td> 
						<td>${lists.signs_regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
 		</table> 
	</div>
	<div>
		<button class="btn btn-info" type="button" onclick="location.href='./insertPad.do'">서명생성</button>
		<button class="btn btn-danger" type="button" onclick="location.href='./delPad.do'">서명삭제</button>
		
 	</div>	 
 </div> 

</body>
</html>