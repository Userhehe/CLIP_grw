<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<%@ include file="./header.jsp"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/nctBoard.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div class="card">
			<div class="card-body">
			
			
				<h5 class="card-title">공지 사항</h5>
				<table class="table table-hover" style="margin-top: 10px;" id="ntcBoard">
					<thead>
						<tr>
							<th>제목</th>
							<th>작성일</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${selectNtcBoard}" varStatus="vs">
							<tr class="ntcBoard" data-seq="${vo.ntc_seq}">
								<td>${vo.ntc_title}</td>
								<td>${vo.ntc_create}</td>
								<td>${vo.user_id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				
			</div>
		</div>
	</main>
</body>
</html>