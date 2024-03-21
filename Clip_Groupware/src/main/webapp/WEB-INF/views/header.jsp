<%@page import="com.clip.gwr.vo.UserinfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>header</title>
<!-- <script type="text/javascript" src="./js/calendar.js"></script> -->
<meta content="" name="description">
<meta content="" name="keywords">
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
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- <script type="text/javascript" src="./js/calendar.js"></script> -->

</head>

<body>
<%
UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
%>

<!-- ======= START HEADER ======= -->
	<header id="header" class="header fixed-top d-flex align-items-center">
		<nav class="header-nav ms-auto">
			<ul class="d-flex align-items-center">
<!-- ======= START ALERT ======= 
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
 ======= END ALERT ======= -->

<!-- ======= START MYPAGE ======= -->
				<li class="nav-item dropdown pe-3">
				<a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown"> <img
						src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
						<span class="d-none d-md-block dropdown-toggle ps-2">${loginVo.user_name} ${loginVo.ranks_name}</span>
				</a>
					<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
						<li class="dropdown-header">
							<h6>${loginVo.user_name}</h6> <span> ${loginVo.dept_name}팀 (${loginVo.ranks_name})</span>
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
						<li><a class="dropdown-item d-flex align-items-center" href="./logout.do">
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
						<li><a href="./userInfo.do"><i class="bi bi-circle"></i><span>인사 정보</span></a></li>
						<li><a href="./dailyCheck.do"><i class="bi bi-circle"></i><span>근태관리</span></a></li>
						<li><a href="./annual.do"><i class="bi bi-circle"></i><span>연차관리</span></a></li>
						<li><a href="./organization.do"><i class="bi bi-circle"></i><span>조직도</span></a></li>
						<li><a href="./empty.do"><i class="bi bi-circle"></i><span>직급관리</span></a></li>
						<li><a href="./position.do"><i class="bi bi-circle"></i><span>직책관리</span></a></li>
						<li><a href="./deptAll.do"><i class="bi bi-circle"></i><span>부서관리</span></a></li>
						<li><a href="./access.do"><i class="bi bi-circle"></i><span>사용자 접속로그</span></a></li>
					</ul>
				</li>
<!-- ======= END humanresource-nav ======= -->

<!-- ======= START ework-nav ======= -->
			<li class="nav-item">
			<a class="nav-link collapsed" data-bs-target="#ework-nav" data-bs-toggle="collapse" href="#">
					<i class="bx bx-select-multiple"></i><span>전자결재</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="ework-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="./payRegister.do"> <i class="bi bi-circle"></i><span>결재신청</span></a></li>
					<li><a href="./myPaySelect.do"> <i class="bi bi-circle"></i><span>결재조회</span></a></li>
					<c:if test="${loginVo.user_auth == 'ROLE_ADMIN'}">
						<li><a href="./paytemplate.do"> <i class="bi bi-circle"></i><span>결재양식서 관리</span></a></li>					
					</c:if>
				</ul>
			</li>
<!-- ======= END ework-nav ======= -->
			
<!-- ======= START project-nav ======= -->
			<li class="nav-item"><a class="nav-link collapsed" data-bs-target="#project-Nav" data-bs-toggle="collapse" href="#">
					<i class="bx bx-bar-chart-square"></i><span>프로젝트 관리</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="project-Nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="./projectsProgress.do"> <i class="bi bi-circle"></i><span>프로젝트 조회</span></a></li>
					<li><a href="tables-data.html"> <i class="bi bi-circle"></i><span>프로젝트 관리</span></a></li>
				</ul>
			</li>
<!-- ======= END project-nav ======= -->

<!-- ======= START schedule-Nav ======= -->
			<li class="nav-item"><a class="nav-link collapsed" data-bs-target="#schedule-Nav" data-bs-toggle="collapse" href="#">
					<i class="bi bi-calendar-week"></i><span>일정관리</span><i class="bi bi-chevron-down ms-auto"></i>
			</a>
				<ul id="schedule-Nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
					<li><a href="./schedule.do"> <i class="bi bi-circle"></i><span>일정 조회</span></a></li>
					<li><a href="./reservation.do"> <i class="bi bi-circle"></i><span>회의실 예약</span></a></li>
					<li><a href="./myReservation.do"> <i class="bi bi-circle"></i><span>회의실 예약 수정</span></a></li>
				</ul>			
			</li>
<!-- ======= END schedule-Nav ======= -->
		</ul>
	</aside>
<!-- ======= END SIDEBAR ======= -->
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
