<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projects</title>
<%@ include file="./header.jsp"%>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
			<div>
				<div style="border-bottom: .5px solid #2F3438;">
					<div style="display: flex; align-items: center;">
						<ul class="nav nav-tabs nav-tabs-bordered" id="borderTab"
							role="tablist">
							<li class="nav-item" role="presentation">
								<button class="nav-link active" id="progress-tab"
									data-bs-toggle="tab" data-bs-target="bordered-progress"
									type="button" role="tab" aria-controls="progress"
									aria-relected="true"
									onclick="location.href='projectsProgress.do' ">진행도별
									프로젝트</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="period-tab" data-bs-toggle="tab"
									data-bs-target="bordered-period" type="button" role="tab"
									aria-controls="period" aria-relected="true"
									onclick="location.href='projectsPeriod.do' ">시간대별 프로젝트</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="client-tab" data-bs-toggle="tab"
									data-bs-target="bordered-client" type="button" role="tab"
									aria-controls="client" aria-relected="true"
									onclick="location.href='projectClient.do' ">발주처별 프로젝트</button>
							</li>
						</ul>
						<div style="margin-left: auto; margin-right: 30px;">
							<ul style="list-style-type: none; padding: 0; display: flex;">
								<li style="margin-right: 10px;"><input
									class="form-check-input" type="radio" name="gridRadios"
									id="gridRadios1" value="option1" checked=""> <label
									class="form-check-label" for="gridRadios1">진행중</label></li>
								<li><input class="form-check-input" type="radio"
									name="gridRadios" id="gridRadios2" value="option2"> <label
									class="form-check-label" for="gridRadios2">완료</label></li>
							</ul>
						</div>
					</div>
				</div>
				<div>
					<div class="container" style="margin-left: 0px;">
						<div class="row">
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
										<div class="col-md-3">
											<!-- 여기에 버튼 추가 -->
											<div class="card-body" style="text-align: right;">
												<button type="button" class="btn btn-warning">프로젝트 생성</button>
											</div>
										</div>
							<!-- 여기서부터 각각의 카드를 복사해서 붙여넣기 -->
							<!-- col-md-3 단위로 복사해서 4열까지 만들어줍니다 -->
						</div>
						<!-- 여기까지 1번째 행 -->
						<!-- 아래로 2번째 행, 3번째 행 작성 -->
						<div class="row">
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<!-- 여기서부터 각각의 카드를 복사해서 붙여넣기 -->
							<!-- col-md-3 단위로 복사해서 4열까지 만들어줍니다 -->
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card-body"
									style="margin-top: 30px; background-color: #F2F2F2; height: 220px;">
									<div>
										<h5 class="card-title">[서울시청]인지건강 디자인제안</h5>
										<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
									</div>
									<div class="progress mt-3">
										<div
											class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
											role="progressbar" style="width: 75%" aria-valuenow="75"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div style="text-align: right;">
										<button type="button" class="btn btn-secondary"
											style="margin-top: 20px; margin-right: 10px;">상세보기</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</section>
	</main>
</body>
</html>