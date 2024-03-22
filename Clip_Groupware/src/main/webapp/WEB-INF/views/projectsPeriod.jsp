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
						<div style="margin-left: auto; margin-right: 5px; height: 42px">
							<ul style="list-style-type: none; padding: 0; display: flex;">
								<li><input type="date" class="form-control" id="startDate"
									name="startDate"></li>
								<li>~</li>
								<li><input type="date" class="form-control" id="endDate"
									name="endDate"></li>
								<li><button type="button" class="btn btn-warning">검색</button></li>
								<li style="width: 160px; height: 38px;">
									<!-- 프로젝트 생성 버튼을 감싸는 새로운 div 추가 -->
									<button type="button" class="btn btn-warning"
										style="width: 190px; margin-top: 0px;">프로젝트 생성</button>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="container" style="margin-left: 0px;">
					<div class="row" style="width: 100%; flex-wrap: nowrap;">
						<div class="col-md-3">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[서울시청]인지건강 운동시설 디자인제안</h5>
									<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
								</div>
								<div class="progress mt-3">
									<div
										class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
										role="progressbar" style="width: 25%" aria-valuenow="15"
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<div style="text-align: right;">
									<button type="button" class="btn btn-secondary"
										onclick="location.href='projectDetail.do' "
										style="margin-top: 20px; margin-right: 10px;">상세보기</button>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[현대산업개발]고척 아이파크 휴게시설 디자인 공모</h5>
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
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[중구청]광화문광장 휴게시설 디자인 제안</h5>
									<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
								</div>
								<div class="progress mt-3">
									<div
										class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
										role="progressbar" style="width: 45%" aria-valuenow="75"
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
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[금천구청]가산 디지털단지 역사 앞 힐링광장 조성 사업</h5>
									<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
								</div>
								<div class="progress mt-3">
									<div
										class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
										role="progressbar" style="width: 85%" aria-valuenow="75"
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
					<!-- 여기까지 1번째 행 -->
					<!-- 아래로 2번째 행, 3번째 행 작성 -->
					<div class="row">
						<div class="col-md-3" style="width: 324px;">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[양천구청]용왕산 근린공원 등산로 벤치 설치 사업</h5>
									<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
								</div>
								<div class="progress mt-3">
									<div
										class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
										role="progressbar" style="width: 15%" aria-valuenow="25"
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<div style="text-align: right;">
									<button type="button" class="btn btn-secondary"
										style="margin-top: 20px; margin-right: 10px;">상세보기</button>
								</div>
							</div>
						</div>
						<div class="col-md-3" style="width: 324px;">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[롯데건설]광명 9구역 롯데캐슬 시그니처 운동시설 공모</h5>
									<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
								</div>
								<div class="progress mt-3">
									<div
										class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
										role="progressbar" style="width: 95%" aria-valuenow="75"
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<div style="text-align: right;">
									<button type="button" class="btn btn-secondary"
										style="margin-top: 20px; margin-right: 10px;">상세보기</button>
								</div>
							</div>
						</div>
						<div class="col-md-3" style="width: 324px;">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[대우건설]파주 운정 14BL 푸르지오 파크라인 휴게시설 공모</h5>
									<p class="card-text">참여자 : 박경민 부장, 신정원 과장, 신윤상 대리, 김동인 사원</p>
								</div>
								<div class="progress mt-3">
									<div
										class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
										role="progressbar" style="width: 35%" aria-valuenow="75"
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
								<div style="text-align: right;">
									<button type="button" class="btn btn-secondary"
										style="margin-top: 20px; margin-right: 10px;">상세보기</button>
								</div>
							</div>
						</div>
						<div class="col-md-3" style="width: 324px;">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[삼성물산]반포 레미안 조경시설 조성 사업</h5>
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
						<div class="col-md-3" style="width: 324px;">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[gs건설]반포자이 놀이시설 리모델링</h5>
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
						<div class="col-md-3" style="width: 324px;">
							<div class="card-body"
								style="margin-top: 30px; background-color: white; height: 230px; border-radius: 20px;">
								<div>
									<h5 class="card-title">[서울시청]인지건강 운동시설 디자인제안</h5>
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