<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 결재조회</title>
<%@ include file="./header.jsp"%>
<style type="text/css">
	.hohover:hover{
/* 		background-color: black; */
		opacity: .5; 
		border: dotted 5px grey;
	}
	
	.row {
    	margin-top: 100px;
   		margin-bottom: 100px;
	}
</style>
</head>
<body>

	<main id="main">
		<div class="row">
			<div class="col-xl-3">
			</div>
			
			<div class="col-xl-3">
				<div class="card hohover">
					<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
						<a href="./myPayList.do" style="color: black; display: inline-block; text-align: center;">
							<img src="./images/requestPayImg.png" alt="requestPay" style="width: 60%; ">
							<hr/>
							<h2 style="white-space: nowrap;">내 요청 결재</h2>
						</a>
					</div>
				</div>
			</div>

			<div class="col-xl-3 ">
				<div class="card hohover">
					<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
						<a href="./myTempPayList.do" style="color: black; display: inline-block; text-align: center;">
							<img src="./images/tempPayImg.png" alt="tempPay" style="width: 60%;">
							<hr/>
							<h2 style="white-space: nowrap;">임시저장 결재</h2>
						</a>
					</div>
				</div>
			</div>

			<div class="col-xl-3">
			</div>
			
			<div class="col-xl-3">
			</div>
			<div class="col-xl-3 ">
				<div class="card hohover">
					<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
						<a href="./myAcceptPayList.do" style="color: black; display: inline-block; text-align: center;">
							<img src="./images/stampPayImg.png" alt="stampPay" style="width: 60%;">
							<hr/>
							<h2 style="white-space: nowrap;">내 승인대기 결재</h2>
						</a>
					</div>
				</div>
			</div>

			<div class="col-xl-3 ">
				<div class="card hohover">
					<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
						<a href="./myReferPayList.do" style="color: black; display: inline-block; text-align: center;">
							<img src="./images/referPayImg.png" alt="referPay" style="width: 60%;">
							<hr/>
							<h2 style="white-space: nowrap;">참조된 결재</h2>
						</a>
					</div>
				</div>
			</div>
			<div class="col-xl-3">
			</div>
			
		</div>
	</main>
</body>
</html>