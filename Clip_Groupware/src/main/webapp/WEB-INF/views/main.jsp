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
<%@ include file="./header.jsp" %>
</head>
<body>
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
</body>
</html>