<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 신청</title>
<%@ include file="./header.jsp" %>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
				<table class="table table-striped" style="margin-top: 10px;">
					<thead>
						<tr>
							<th><input type="checkbox" class="allCheckBox" id="chCheck" onclick="checkAll(this.checked)"></th>
							<th>기안서코드</th>
							<th>기안서명</th>
							<th>등록일</th>
							<th>즐겨찾기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${lists}" varStatus="vs">
							<tr>
								<td><input type="checkbox" name="ch" class="ch" value="${vo.gian_seq}"></td>
								<td>${vo.gian_seq}</td>
								<td><a href="./gianDetail.do?gian_seq=${vo.gian_seq}">${vo.gian_name}</a></td>
								<td><fmt:parseDate var="patternDate" value="${vo.gian_regdate}"
								pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate> <fmt:formatDate
								value="${patternDate}" pattern="yyyy년MM월dd일" /></td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</main>
</body>
</html>