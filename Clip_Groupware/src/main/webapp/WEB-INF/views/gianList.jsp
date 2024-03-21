<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>CLIP GROUPWARE</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/gianList.js"></script>
<%@ include file="./header.jsp"%>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
				<div style="margin-left: 560px;">
					<select style="width: 10%; display: unset;" class="form-select"
						name="gian_search">
						<option value="">구분</option>
						<option value="gian_name">기안서명</option>
						<option value="gian_modifier">작성자</option>
					</select> <input style="width: 250px; display: unset;" id="gian_name"
						class="form-control" type="text" placeholder="검색어를 입력해주세요.">
					<button class="btn btn-primary rounded-pill" id="templateSearch">검색</button>
				</div>
				<form action="./templateDelete.do" method="post"
					onsubmit="return chsSubmit()">
					<table class="table table-hover" style="margin-top: 10px;">
						<thead>
							<tr>
								<th><input type="checkbox" class="allCheckBox" id="chCheck"
									onclick="checkAll(this.checked)"></th>
								<th>기안서코드</th>
								<th>기안서명</th>
								<th>등록일</th>
							</tr>
						</thead>
						<tbody id="templateTableBody">
							<c:choose>
								<c:when test="${not empty lists2}">
									<c:forEach var="vo" items="${lists2}" varStatus="vs">
										<tr>
											<td><input type="checkbox" name="ch" class="ch"
												value="${lists.gian_seq}"></td>
											<td>${lists.gian_seq}</td>
											<td><a href="./gianDetail.do?gian_seq=${vo.gian_seq}">${vo.gian_name}</a></td>
											<td><fmt:parseDate var="patternDate"
													value="${vo.gian_regdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
												<fmt:formatDate value="${patternDate}" pattern="yyyy년MM월dd일" /></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vo" items="${lists}" varStatus="vs">
										<tr>
											<td><input type="checkbox" name="ch" class="ch"
												value="${vo.gian_seq}"></td>
											<td>${vo.gian_seq}</td>
											<td><a href="./gianDetail.do?gian_seq=${vo.gian_seq}">${vo.gian_name}</a></td>
											<td><fmt:parseDate var="patternDate"
													value="${vo.gian_regdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
												<fmt:formatDate value="${patternDate}" pattern="yyyy년MM월dd일" /></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</form>
			</div>
			<a href="./gianInsert.do"><button
					class="btn btn-primary rounded-pill">양식추가</button></a>
			<button class="btn btn-danger rounded-pill" onclick="templateDel()">양식삭제</button>
		</section>
	</main>
	<script type="text/javascript">
	document.getElementById('templateSearch').addEventListener('click', function() {
	    var searchKeyword = document.getElementById('gian_name').value;
	    fetch('./templateReasearch.do?gian_name=' + searchKeyword)
	        .then(function(response) {
	            if (!response.ok) {
	                throw new Error('서버 응답 실패');
	            }
	            return response.text();
	        })
	       .then(function(responseText) {
			    document.getElementById('templateTableBody').innerHTML = responseText;
			})
	        .catch(function(error) {
	            console.error('처리가 실패되었습니다.', error);
	        });
	});
	</script>
</body>
</html>