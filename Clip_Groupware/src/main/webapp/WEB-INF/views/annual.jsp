<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>연차관리</title>
<%@ include file="./header.jsp" %>
</head>
<body>
	<main id="main" class="main">
		<div class="card">
		<div class="card-body">
		<section class="section dashboard">
				<div style="margin-left: 560px; margin-top: 20px;">
					검색 : <input style=" width: 250px; display: unset;" id="searchInput"
						class="form-control" type="text" placeholder="검색할 유저 아이디를 입력하세요">
					<button class="btn btn-primary rounded-pill" id="annualSearch">검색</button>
					<button class="btn btn-warning rounded-pill" id="resetSearch">검색 초기화</button>
				</div>
				<table class="table table-hover" style="margin-top: 10px;">
							<thead>
								<tr>								   
									<th>이름</th>
									<th>전체 연차</th>
									<th>사용 연차</th>
									<th>남은 연차</th>
								</tr>
							</thead>
							<tbody id="annualTableBody">
								<c:forEach var="alist" items="${anlist}" varStatus="vs">
									<tr class="an-lists">
										<td>${alist.user_name}</td>
										<td>${alist.annual_ct}</td>
										<td>${alist.annual_use}</td>
										<td>${alist.annual_leov}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
			<a href="./gianInsert.do"><button
					class="btn btn-primary rounded-pill">양식추가</button></a>
		</section>
		</div>
	</div>
	</main>
</body>
</html>