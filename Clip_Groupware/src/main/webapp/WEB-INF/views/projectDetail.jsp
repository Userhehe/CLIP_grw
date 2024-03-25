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
						style="margin-top: 1100px; background-color: white; height: 215px; border-radius: 20px;">
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

				<div class="col-md-1"
					style="display: flex; align-items: center; margin-left:1250px; margin-top: 180px; height: 10px; width: 300px;">
					<div class="select_payline_area col-lg-12" style="background-color:white; padding: 20px; border-radius: 20px;">
						<div id="search_box">
							<input id="search_input" type="text" placeholder="사원 검색">
						</div>
						<hr>

						<div id="payLine_box" class="jstree jstree-1 jstree-default"
							role="tree" aria-multiselectable="true" tabindex="0"
							aria-activedescendant="USER_031" aria-busy="false">
							<ul
								class="jstree-container-ul jstree-children jstree-contextmenu"
								role="presentation">
								<li role="none" id="DEPT_001" class="jstree-node  jstree-open"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" aria-expanded="true"
									id="DEPT_001_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>디자인</a>
									<ul role="group" class="jstree-children">
										<li role="none" id="USER_004" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_004_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>신정원
												대표이사</a></li>
										<li role="none" id="USER_031"
											class="jstree-node  jstree-leaf jstree-last"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_031_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>박준옥
												차장</a></li>
									</ul></li>
								<li role="none" id="DEPT_002" class="jstree-node  jstree-open"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" aria-expanded="true"
									id="DEPT_002_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>설계</a>
									<ul role="group" class="jstree-children">
										<li role="none" id="USER_030" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_030_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>박길동
												부장</a></li>
										<li role="none" id="USER_049" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_049_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>암호화된피카츄
												대리</a></li>
										<li role="none" id="USER_045" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_045_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>피카츄
												대리</a></li>
										<li role="none" id="USER_053" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_053_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>신정원
												대리</a></li>
										<li role="none" id="USER_057" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_057_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김동인
												대리</a></li>
										<li role="none" id="USER_051" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_051_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>서종우
												대리</a></li>
										<li role="none" id="USER_037" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_037_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>전민균
												대리</a></li>
										<li role="none" id="USER_001" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_001_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김동인
												대리</a></li>
										<li role="none" id="USER_059" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_059_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김동휘
												대리</a></li>
										<li role="none" id="USER_033" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_033_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김종우
												주임</a></li>
										<li role="none" id="USER_012"
											class="jstree-node  jstree-leaf jstree-last"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_012_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>홍길동
												사원</a></li>
									</ul></li>
								<li role="none" id="DEPT_003" class="jstree-node  jstree-open"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" aria-expanded="true"
									id="DEPT_003_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>공무</a>
									<ul role="group" class="jstree-children">
										<li role="none" id="USER_002"
											class="jstree-node  jstree-leaf jstree-last"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_002_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>신윤상
												과장</a></li>
									</ul></li>
								<li role="none" id="DEPT_004" class="jstree-node  jstree-leaf"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" id="DEPT_004_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>시공</a></li>
								<li role="none" id="DEPT_005" class="jstree-node  jstree-open"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" aria-expanded="true"
									id="DEPT_005_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>영업</a>
									<ul role="group" class="jstree-children">
										<li role="none" id="USER_034"
											class="jstree-node  jstree-leaf jstree-last"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_034_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김구라
												사원</a></li>
									</ul></li>
								<li role="none" id="DEPT_006" class="jstree-node  jstree-open"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" aria-expanded="true"
									id="DEPT_006_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>관리</a>
									<ul role="group" class="jstree-children">
										<li role="none" id="USER_005" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_005_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>박경민
												차장</a></li>
										<li role="none" id="USER_003"
											class="jstree-node  jstree-leaf jstree-last"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_003_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김태영
												대리</a></li>
									</ul></li>
								<li role="none" id="DEPT_007"
									class="jstree-node  jstree-open jstree-last"><i
									class="jstree-icon jstree-ocl" role="presentation"></i><a
									class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
									aria-selected="false" aria-level="1" aria-expanded="true"
									id="DEPT_007_anchor"><i
										class="jstree-icon jstree-themeicon" role="presentation"></i>인사</a>
									<ul role="group" class="jstree-children">
										<li role="none" id="USER_006" class="jstree-node  jstree-leaf"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_006_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>김동휘
												과장</a></li>
										<li role="none" id="USER_011"
											class="jstree-node  jstree-leaf jstree-last"><i
											class="jstree-icon jstree-ocl" role="presentation"></i><a
											class="jstree-anchor" href="#" tabindex="-1" role="treeitem"
											aria-selected="false" aria-level="2" id="USER_011_anchor"><i
												class="jstree-icon jstree-themeicon" role="presentation"></i>서종우
												대리</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="select_payline_area col-lg-12">
						<div id="pickLine_box"></div>
					</div>
				</div>
			</div>
	</main>
</body>
</html>