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
						<div style="margin-left: auto; margin-right: 30px; height: 42px">
							<ul style="list-style-type: none; padding: 0; display: flex;">
								<li><input type="date" class="form-control" id="startDate" name="startDate"></li>
								<li> ~ </li>
								<li><input type="date" class="form-control" id="endDate" name="endDate"></li>
								<li><button type="button" class="btn btn-warning">검색</button></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
</body>
</html>