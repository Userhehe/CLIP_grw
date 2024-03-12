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
<%@ include file="./header.jsp" %>
<!-- ======= START MAIN ======= -->
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
<!-- ======= START LEFTSIDE SECTION ======= -->
				<div class="col-lg-8">
					<div class="row">
<!-- ======= START EWORK CARD ======= -->
						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">전자결재 <span>| E-work</span></h5>
										</div>
									</div>
								</div>
<!-- ======= END EWORK CARD ======= -->
<!-- ======= START NOTICE CARD ======= -->
						<div class="col-12">
							<div class="card recent-sales overflow-auto">
								<div class="card-body">
									<h5 class="card-title">공지사항 <span>| Notice</span></h5>
								</div>
							</div>
						</div>
<!-- ======= END NOTICE CARD ======= -->
					</div>
				</div>
<!-- ======= END LEFTSIDE SECTION ======= -->
<!-- ======= START RIGHTSIDE SECTION ======= -->
				<div class="col-lg-4">
<!-- ======= START schedule CARD ======= -->
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">일정관리 <span>| schedule</span></h5>
							<div class="activity">
								<div class="activity-item d-flex">
								</div>
							</div>
						</div>
					</div>
<!-- ======= END schedule CARD ======= -->
<!-- ======= START PROJECT CARD ======= -->
					<div class="card">
						<div class="card-body pb-0">
							<h5 class="card-title">프로젝트 <span>| Project</span></h5>
						</div>
					</div>
<!-- ======= END PROJECT CARD ======= -->
				</div>
<!-- ======= END RIGHTSIDE SECTION ======= -->
			</div>
		</section>
	</main>
<!-- ======= END MAIN ======= -->
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