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
<meta content="" name="description">
<meta content="" name="keywords">
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
<!-- ======= START HEADER ======= -->
	<header id="header" class="header fixed-top d-flex align-items-center">
		<nav class="header-nav ms-auto">
			<ul class="d-flex align-items-center">
<!-- ======= START ALERT ======= -->
				<li class="nav-item dropdown"><a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
				<i class="bi bi-bell"></i>
				<span class="badge bg-warning badge-number">4</span></a>
					<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
						<li class="dropdown-header">읽지않은 4개의 알림이 있습니다
						<a href="#"><span class="badge rounded-pill bg-warning p-2 ms-2">View all</span></a>
						</li>
						<li><hr class="dropdown-divider"></li>
						<li class="notification-item"><i
							class="bi bi-info-circle text-primary"></i>
							<div><h4>알림창 쓸사람 쓰세요</h4>  -<p>예시로 안지웠음</p></div>
						</li>
						<li><hr class="dropdown-divider"></li>		
					</ul>
				</li>
<!-- ======= END ALERT ======= -->

<!-- ======= START MYPAGE ======= -->
				<li class="nav-item dropdown pe-3">
				<a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown"> <img
						src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
						<span class="d-none d-md-block dropdown-toggle ps-2">신정원 과장</span>
				</a>
					<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
						<li class="dropdown-header">
							<h6>신정원 과장</h6> <span>디자인팀(팀장)</span>
						</li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item d-flex align-items-center" href="users-profile.html">
						<i class="bi bi-person"></i>
						<span>프로필</span>
						</a>
						</li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item d-flex align-items-center" href="users-profile.html">
						<i class="bi bi-gear"></i>
						<span>개인정보 수정</span></a>
						</li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item d-flex align-items-center" href="#">
						<i class="bi bi-box-arrow-right"></i>
						<span>Log Out</span>
						</a>
						</li>
					</ul>
				</li>
<!-- ======= END MYPAGE ======= -->
			</ul>
		</nav>
	</header>
<!-- ======= END HEADER ======= -->
	
<!-- ======= START SIDEBAR ======= -->
	<aside id="sidebar" class="sidebar">
		<ul class="sidebar-nav" id="sidebar-nav">
			<li class="mainlogo">
				<a href="./main.do" class="logo d-flex align-items-center"> <img src="assets/img/logo.png" alt=""></a>
			</li>
<!-- ======= START humanresource-nav ======= -->
				<li class="nav-item" style="margin-top: 200px">
				<a class="nav-link collapsed" data-bs-target="#humanresource-nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-file-earmark-person"></i><span>인사관리</span><i class="bi bi-chevron-down ms-auto"></i>
				</a>
					<ul id="humanresource-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
						<li><a href="components-buttons.html"><i class="bi bi-circle"></i><span>인사 정보</span></a></li>
						<li><a href="components-badges.html"><i class="bi bi-circle"></i><span>근태관리</span></a></li>
						<li><a href="components-buttons.html"><i class="bi bi-circle"></i><span>연차관리</span></a></li>
						<li><a href="components-breadcrumbs.html"><i class="bi bi-circle"></i><span>조직도</span></a></li>
						<li><a href="./empty.do"><i class="bi bi-circle"></i><span>직급관리</span></a></li>
						<li><a href="components-accordion.html"><i class="bi bi-circle"></i><span>직책관리</span></a></li>
						<li><a href="components-accordion.html"><i class="bi bi-circle"></i><span>부서관리</span></a></li>
						<li><a href="components-buttons.html"><i class="bi bi-circle"></i><span>사용자 접속로그</span></a></li>
					</ul>
				</li>
<!-- ======= END humanresource-nav ======= -->

<!-- ======= START ework-nav ======= -->
			<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#ework-nav" data-bs-toggle="collapse" href="#">
					<i class="bx bx-select-multiple"></i><span>전자결재</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="ework-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="forms-elements.html"> <i class="bi bi-circle"></i><span>결재신청</span></a></li>
					<li><a href="forms-layouts.html"> <i class="bi bi-circle"></i><span>결재조회</span></a></li>
					<li><a href="./paytemplate.do"> <i class="bi bi-circle"></i><span>결재양식서 관리</span></a></li>
				</ul>
			</li>
<!-- ======= END ework-nav ======= -->
			
<!-- ======= START project-nav ======= -->
			<li class="nav-item"><a class="nav-link collapsed" data-bs-target="#project-Nav" data-bs-toggle="collapse" href="#">
					<i class="bx bx-bar-chart-square"></i><span>프로젝트 관리</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="project-Nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="tables-general.html"> <i class="bi bi-circle"></i><span>프로젝트 조회</span></a></li>
					<li><a href="tables-data.html"> <i class="bi bi-circle"></i><span>프로젝트 관리</span></a></li>
				</ul>
			</li>
<!-- ======= END project-nav ======= -->

<!-- ======= START schedule-Nav ======= -->
			<li class="nav-item"><a class="nav-link collapsed" data-bs-target="#schedule-Nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-calendar-week"></i><span>일정관리</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="schedule-Nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="tables-general.html"> <i class="bi bi-circle"></i><span>일정 조회</span></a></li>
					<li><a href="tables-data.html"> <i class="bi bi-circle"></i><span>회의실 예약</span></a></li>
					<li><a href="tables-data.html"> <i class="bi bi-circle"></i><span>회의실 예약 수정</span></a></li>
				</ul>			
			</li>
<!-- ======= END schedule-Nav ======= -->
		</ul>
	</aside>
	
	<!-- ======= 화면 작업구역 시작 ======= -->
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
				기안서 코드:<input type="text" class="form-control" value="${vo.gian_seq}" readonly="readonly"><br>
				기안서 구분 :<input type="text" class="form-control" value="${vo.gian_gubun}" readonly="readonly"><br>
				작성자 :<input type="text" class="form-control" value="${vo.gian_modifier}" readonly="readonly"><br>
				등록일 :<input type="text" class="form-control" value="${vo.gian_regdate}" readonly="readonly"><br>
				기안서 내용 :<textarea rows="10" readonly="readonly">${vo.gian_html}</textarea>
			</div>
			<a href="./templateMod.do?gian_seq=${vo.gian_seq}"><button class="btn btn-primary rounded-pill">양식수정</button></a>
			<a href="./paytemplate.do"><button class="btn btn-danger rounded-pill">목록으로</button></a>
		</section>
	</main>
	
	<!-- ======= 화면 작업구역 끝 ======= -->
	
	
<!-- ======= END SIDEBAR ======= -->
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>
	<!-- Vendor JS Files -->
	<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/chart.js/chart.umd.js"></script>
	<script src="assets/vendor/echarts/echarts.min.js"></script>
	<script src="assets/vendor/quill/quill.min.js"></script>
	<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
</body>
</html>