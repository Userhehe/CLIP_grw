<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projects</title>
<%@ include file="./header.jsp"%>
<script type="text/javascript" src="./js/projects.js"></script>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
				<!-- inner header start -->
				<div style="border-bottom: .5px solid #2F3438;">
					<div style="display: flex; align-items: center;">
						<ul class="nav nav-tabs nav-tabs-bordered" id="borderTab"
							role="tablist">
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="progress-tab" data-bs-toggle="tab"
									data-bs-target="bordered-progress" type="button" role="tab"
									aria-controls="progress" aria-relected="true"
									onclick="location.href='projectsProgress.do' ">진행도별
									프로젝트</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link active" id="period-tab"
									data-bs-toggle="tab" data-bs-target="bordered-period"
									type="button" role="tab" aria-controls="period"
									aria-relected="true"
									onclick="location.href='projectsPeriod.do' ">시간대별 프로젝트</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="client-tab" data-bs-toggle="tab"
									data-bs-target="bordered-client" type="button" role="tab"
									aria-controls="client" aria-relected="true"
									onclick="location.href='projectClient.do' ">발주처별 프로젝트</button>
							</li>
						</ul>
						
				<!-- 검색버튼 시작 -->
						<div style="margin-left: auto; margin-right: 5px; height: 42px">
							<ul style="list-style-type: none; padding: 0; display: flex;">
								<li><input type="date" class="form-control" id="prjStartDate"
									name="startDate"></li>
								<li>~</li>
								<li><input type="date" class="form-control" id="prjEndDate"
									name="endDate"></li>
								<li><button type="button" id="periodSrchBtn" class="btn btn-warning">검색</button></li>
							</ul>
						</div>
				<!-- 검색버튼 끝 -->
					</div>
				</div>
				<!-- inner header End -->				
				<!-- 프로젝트 생성버튼 시작 -->
				<div class="d-grid gap-2 mt-3">
					<button class="btn btn-warning" type="button"
						data-bs-toggle="modal" data-bs-target="#verticalycentered"
						style="margin-top: 0px;">프로젝트 생성</button>
				</div>
				<!-- 프로젝트 생성버튼 끝 -->
				<!-- 프로젝트 생성 모달창 시작 -->
				<div class="modal fade" id="verticalycentered" tabindex="-1"
					style="display: none;" aria-hidden="true">
					<div class="modal-dialog modal-lg modal-dialog-centered"
						style="width: 1200px;">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">새 프로젝트 생성</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<div class="card-body">
									<form id="newProject">
										<div class="row mb-3">
											<label for="inputText" class="col-sm-2 col-form-label">프로젝트
												명</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="projectNm">
											</div>
										</div>
										<div class="row mb-3">
											<label for="inputEmail" class="col-sm-2 col-form-label">발주처</label>
											<div class="col-sm-10">
												<select class="form-select"
													aria-label="Default select example" name="cliNm">
													<c:forEach var="client" items="${clientList}">
														<option value="${client.CLI_NAME}">${client.CLI_NAME}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="row mb-3">
											<label for="inputPassword" class="col-sm-2 col-form-label">현장명</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="workSite">
											</div>
										</div>
										<div class="row mb-3">
											<label for="inputDate" class="col-sm-2 col-form-label">시작일자</label>
											<div class="col-sm-10">
												<input type="date" class="form-control" name="prjSdate">
											</div>
										</div>
										<div class="row mb-3">
											<label for="inputDate" class="col-sm-2 col-form-label">마감기한</label>
											<div class="col-sm-10">
												<input type="date" class="form-control" name="prjEdate">
											</div>
										</div>
										<div class="row mb-3">
											<label for="inputPassword" class="col-sm-2 col-form-label">비고</label>
											<div class="col-sm-10">
												<textarea class="form-control" style="height: 100px" name="prjNote"></textarea>
											</div>
										</div>
										<ul class="col-sm-10">
											<h5>필요 제출목록</h5>
											<li class="form-check"><input class="form-check-input"
												type="checkbox" id="gridCheck1"> <label
												class="form-check-label" for="gridCheck1"> 최종이미지 </label></li>
											<li class="form-check"><input class="form-check-input"
												type="checkbox" id="gridCheck2" checked=""> <label
												class="form-check-label" for="gridCheck2"> 견적서 </label></li>
											<li class="form-check"><input class="form-check-input"
												type="checkbox" id="gridCheck2" checked=""> <label
												class="form-check-label" for="gridCheck2"> 제안서 </label></li>
											<li class="form-check"><input class="form-check-input"
												type="checkbox" id="gridCheck2" checked=""> <label
												class="form-check-label" for="gridCheck2"> 도면 </label></li>

										</ul>
									</form>
									<!-- End General Form Elements -->
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">닫기</button>
								<button type="button" id="prjInsertBtn" class="btn btn-warning">등록</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 프로젝트 생성 모달창 끝 -->

				<div class="container" style="margin-left: 5px;">
					<div class="row" style="width: 119%; flex-wrap: wrap;">
						<c:forEach var="projects" items="${lists}" varStatus="vs">
							<div class="col-md-4" style="width: 20%; flex: 0 0 20%;">
								<div class="card-body"
									style="margin-top: 30px; background-color: white; height: 230px; width: 100%; border-radius: 20px;">
									<div>
										<div class="card-title">
											<span style="font-weight: bold; font-size: 17px;">[${projects.cli_name}]</span><br>
											<div style="margin-top: 5px;">${projects.prj_name}</div>
										</div>
									</div>
									<div>
										<h5>참여자 : [${lists2[vs.index].user_name}]</h5>
									</div>
									<div style="text-align: right; margin-top: 20px;">
										<button type="button" class="btn btn-secondary"
											onclick="location.href='projectDetail.do?project_id=${project.PRJ_ID}'"
											style="margin-right: 15px;">상세보기</button>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

		</section>
	</main>
</body>
</html>