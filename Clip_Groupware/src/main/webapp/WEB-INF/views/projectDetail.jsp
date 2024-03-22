<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Projects</title>
<%@ include file="./header.jsp"%>
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
	<main id="main" class="main">
		<div>
			<div class="row" style="width: 100%; flex-wrap: nowrap;">
				<div class="col-md-1"
					style="display: flex; align-items: center; margin-top: 15px; margin-bottom: 15px; height: 10px; width: 800px;">
					<a
						style="font-style: normal; font-size: 20pt; margin-left: 30px; width: 1200px;">[서울시청]인지건강
						운동시설 디자인제안</a>
					<div class="progress mt-3" style="width: 500px; margin-left: auto;">
						<div
							class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
							role="progressbar" style="width: 15%;" aria-valuenow="75"
							aria-valuemin="0" aria-valuemax="100"></div>
					</div>
				</div>
			</div>
			<div class="col-md-1"
				style="margin-left: 20px; height: 80px; width: 800px;">
				<div class="card-body"
					style="margin-top: 20px; background-color: white; height: 530px; width: 1200px; border-radius: 20px;">
					<ul class="nav nav-tabs" id="myTab" role="tablist"
						style="margin-top: 10px;">
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link active" id="home-tab"
								data-bs-toggle="tab" data-bs-target="#home" type="button"
								role="tab" aria-controls="home" aria-selected="true">영업팀</button>
						</li>
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link " id="profile-tab" data-bs-toggle="tab"
								data-bs-target="#profile" type="button" role="tab"
								aria-controls="profile" aria-selected="false" tabindex="-1">디자인팀</button>
						</li>
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
								data-bs-target="#contact" type="button" role="tab"
								aria-controls="contact" aria-selected="false" tabindex="-1">설계팀</button>
						</li>
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
								data-bs-target="#contact" type="button" role="tab"
								aria-controls="contact" aria-selected="false" tabindex="-1">공무팀</button>
						</li>
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
								data-bs-target="#contact" type="button" role="tab"
								aria-controls="contact" aria-selected="false" tabindex="-1">시공팀</button>
						</li>
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
								data-bs-target="#contact" type="button" role="tab"
								aria-controls="contact" aria-selected="false" tabindex="-1">관리팀</button>
						</li>
					</ul>
					<div class="form-group">
						<textarea name="gian_html" id="smartEditor1"
							style="width: 100%; height: 600px; display: none;">

					</textarea>
						<iframe frameborder="0" scrolling="no"
							style="width: 100%; height: 600px;"
							src="se2/SmartEditor2Skin.html"></iframe>
					</div>
				</div>
			</div>
			<div class="row" style="width: 100%; flex-wrap: nowrap;">
				<div class="col-md-1"
					style="display: flex; align-items: center; margin-top: 10px; margin-bottom: 15px; height: 20px; width: 1225px; margin-left: 20px;">
					<div class="card-body"
						style="margin-top: 1100px;  background-color: white; height: 215px; border-radius: 20px;">
						<table class="table table-hover" style="margin-top: 10px;">
							<thead>
								<tr>
									<th scope="col">순번</th>
									<th scope="col">내용</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td>Brandon Jacob</td>
									<td>28</td>
									<td>2016-05-25</td>
								</tr>
								<tr>
									<th scope="row">2</th>
									<td>Bridie Kessler</td>
									<td>35</td>
									<td>2014-12-05</td>
								</tr>
								<tr>
									<th scope="row">3</th>
									<td>Ashleigh Langosh</td>
									<td>45</td>
									<td>2011-08-12</td>
								</tr>
								<tr>
									<th scope="row">4</th>
									<td>Angus Grady</td>
									<td>34</td>
									<td>2012-06-11</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>