<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>CLIP GROUPWARE</title>
<%@ include file="./header.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
<script type="text/javascript" src="./js/mainPage.js"></script>
<style>
.mainContent {
	border: 1px dotted gray; /* 크기 표시용 나중에 지울거 */
	height: 250px;
	width: 100%; /* 기본 너비 100%로 설정 */
	max-width: 1200px; /* 최대 너비 1200px로 설정 */
}
.mainSideContent {
	border: 1px dotted gray; /* 크기 표시용 나중에 지울거 */
	height: 710px;
/* 	width: 100%; /* 기본 너비 100%로 설정 */ */
	max-width: 500px; /* 최대 너비 500px로 설정 */
}

/* 미디어 쿼리를 사용하여 화면 너비에 따라 스타일 조정 */

	.mainContent {
		max-width: 100%; /* 화면이 1200px 이하일 때 최대 너비를 100%로 설정 */
	}
	
@media screen and (max-width: 768px) {
	.mainSideContent {
		max-width: 100%; /* 화면이 768px 이하일 때 최대 너비를 100%로 설정 */
	}
}


</style>
</head>
<body>
<!-- ======= 모달 구간 ======= -->
<!--memodetail modal (상세모달) -->
	<div class="modal fade" id="calendarModalDetail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">상세 내용 입니다.</h5>
				</div>
				
				<div class="modal-body">
					<input type="text" style="display: none" id="dtSeq">
					<div class="form-group">
					<label for="dtTitle" class="col-form-label">일정 제목</label>
					<div class="form-group">
						<div class="form-control" id="dtTitle"></div>
					</div>
					<label for="dtContent" class="col-form-label">일정 내용</label>
					<div class="form-control" id="dtContent"></div>
					<label for="dtStart" class="col-form-label">시작 날짜</label>
					<div class="form-control" id="dtStart"></div>
					<label for="dtEnd" class="col-form-label">종료 날짜</label>
					<div class="form-control" id="dtEnd"></div>
					</div>
				</div>
				<div class="modal-footer">
					<div class="btn-group" role="group aria-label="Basic outlined example" id="dtButtons">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--memodetail modal (상세모달) 끝 -->
<!-- ======= 모달 구간 끝 ======= -->
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
				<!-- ======= row 시작 ======= -->
				<div class="col-lg-6">
					<div class="row">
						<!-- ======= 위에 건들지 마세요. ======= -->
						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">
										<a href="./nctBoard.do">알람목록 <span>| Alarm</span></a>
										<a href="./webSocketTest.do">웹소켓이동</a>
									</h5>
									<!-- <div class="mainSideContent"> -->
									<div class="mainContent">
										<table class="table table-hover" style="margin-top: 10px;">
											<thead>
												<tr>
													<th>제목</th>
													<th>내용</th>
													<th>시간</th>
												</tr>
											</thead>
											<tbody id="alarmTableBody">
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">
										<a href="./schedule.do">나의일정 <span>| schedule</span></a>
									</h5>
									<div class="mainContent">
										<table class="table table-hover" style="margin-top: 10px;">
											<thead>
												<tr>
													<th>제목</th>
													<th>시작일시</th>
													<th>종료일시</th>
												</tr>
											</thead>
											<tbody id="scheduleTableBody">
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- ======= 위로 일정, 공지 ## 아래로 전자, 프젝 ======= -->
				<div class="col-lg-6">
					<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">
										전자결재 <span>| E-work</span>
									</h5>
									<div class="mainContent">
									<br>
										<p><a href="./myAcceptPayList.do" style="color: blue; font-weight: bold;">&nbsp;${loginVo.user_name}님</a> 결재 승인하실문서입니다. </p>
										<table class="table table-hover" style="margin-top: 10px;">
											<thead>
												<tr>
													<th>결재코드</th>
													<th>결재제목</th>
													<th>결재요청일</th>
												</tr>
											</thead>
											<tbody>
												<c:choose>
													<c:when test="${not empty lists}">
														<c:forEach var="vo" items="${lists}" varStatus="vs">
															<tr>
																<td>${vo.app_seq}</td>
																<td>${vo.app_title}</td>
																<td>${vo.app_createdate}</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<tr  onclick="event.preventDefault(); event.stopImmediatePropagation();">
												           <td colspan="5" style="color: red; text-align: center;">승인해야되는 결재가 없습니다.</td>
												        </tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>	
					
					<div class="col-12">
						<div class="card recent-sales overflow-auto">
							<div class="card-body">
								<h5 class="card-title">
									<a href="./nctBoard.do">공지사항 <span>| Notice</span></a>
								</h5>
								<!-- <div class="mainSideContent"> -->
								<div class="mainContent">
									<table class="table table-hover" style="margin-top: 10px;">
										<thead>
											<tr>
												<th>제목</th>
												<th>시작일시</th>
												<th>종료일시</th>
											</tr>
										</thead>
										<tbody id="ntcScheduleTableBody">
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- ======= row 끝 ======= -->
			</div>
		</section>
	</main>
</body>
</html>