<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ include file="./header.jsp" %>
</head>
<body>
<div class="container">
<div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성날자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lists" items="${lists}" varStatus="vr">
					<tr>
						<td>${vr.count}</td>
						<td>${lists.}</td>
						<td><a href="./selectOneSign.do?s_seq=${lists.getS_seq()}">${lists.getS_title()}</a></td>
						<td>${lists.getS_indate()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<button class="btn btn-info" type="button" onclick="location.href='./insertSign.do'">서명생성</button>
	</div>	
</div>

</body>
</html>