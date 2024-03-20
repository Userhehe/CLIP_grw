<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 예약 정보 확인</title>
<%@ include file="./header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 CSS 파일 로드 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->

<!-- JavaScript 라이브러리 로드 -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/jstree.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>

<!-- 부트스트랩 테마 CSS 파일 및 기타 CSS 파일 로드 -->
<!-- <link rel="stylesheet" href="//static.jstree.com/3.3.15/assets/bootstrap/css/bootstrap.min.css" /> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/themes/default/style.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script type="text/javascript" src="./js/reservation.js"></script>

<style type="text/css">
ul.jstree-container-ul>li>a>i.jstree-checkbox {
	display: none;
}
</style>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
				<div style="margin-left: 560px;">
					<select style="width: 10%; display: unset;" class="form-select" name="gian_search">
						<option value="">구분</option>
						<option value="gian_name">회의제목</option>
						<option value="gian_modifier">예약자</option>
					</select> <input style="width: 250px; display: unset;" id="gian_name" class="form-control" type="text" placeholder="검색어를 입력해주세요.">
					<button class="btn btn-primary rounded-pill" id="templateSearch">검색</button>
				</div>

				<table class="table table-striped" style="margin-top: 10px;">
					<thead>
						<tr>
							<th><input type="checkbox" class="allCheckBox" id="chCheck"
								onclick="checkAll(this.checked)"></th>
							<th>회의실</th>
							<th>예약제목</th>
							<th>예약일</th>
							<th>예약자</th>
						</tr>
					</thead>
					<tbody id="templateTableBody">
						<c:forEach var="vo" items="${myReservationList}" varStatus="vs">
							<tr>
								<td>${vo.re_seq}</td>
								<td>${vo.me_room}</td>
								<td>${vo.re_title}</td>
								<td>${vo.re_create}</td>
								<td>${vo.user_id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		
			</div>
		</section>
	</main>
</body>
</html>