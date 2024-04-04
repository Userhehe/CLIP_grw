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
	height: 500px
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


						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">
										<a href="./nctBoard.do">공지사항 <span>| Notice</span></a>
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
											<tbody id="ntcScheduleTableBody">
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

						<!-- ======= 아래 건들지 마세요. ======= -->
					</div>
				</div>

				<!-- ======= 위로 일정, 공지 ## 아래로 전자, 프젝 ======= -->
				<div class="col-lg-6">
					<div class="row">
						<!-- ======= 위에 건들지 마세요. ======= -->

						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">
										전자결재 <span>| E-work</span>
									</h5>
									<div class="mainContent">메인콘텐츠 작업 영역 @크기설정금지@</div>
								</div>
							</div>
						</div>


						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">
										프로젝트 <span>| Project</span>
									</h5>
									<div class="mainContent">메인콘텐츠 작업 영역 @크기설정금지@</div>
								</div>
							</div>
						</div>

						<!-- ======= 아래 건들지 마세요. ======= -->
					</div>
				</div>

				<!-- ======= row 끝 ======= -->
			</div>
		</section>
	</main>
</body>
</html>