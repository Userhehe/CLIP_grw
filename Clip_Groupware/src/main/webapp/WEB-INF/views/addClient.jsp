<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta charset="utf-8">
<title>Add Client</title>
<%@ include file="./header.jsp"%>
<script type="text/javascript" src="./js/addClient.js"></script>

</head>
<body>
	<main id="main" class="main" style="background-color: #f2f2f2;">
		<section class="section dashboard">
			<div>

				<div class="card"
					style="width: 1000px; margin: 30px auto; margin-top: 150px;">
					<div class="card-body">
						<h5 class="title"
							style="margin-top: 30px; margin-bottom: 30px; text-align: center; font-weight: bolder; font-size: x-large;">새
							클라이언트 추가</h5>
						<form id="newClient" style="width: 100%; text-align: center;">
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">고객사
									이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="cliNm">
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">고객사
									연락처</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="cliNumber">
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">고객사
									주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="cliAd">
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">고객사
									담당자</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="cliMn">
								</div>
							</div>
							<div class="row mb-3">
								<label for="inputText" class="col-sm-2 col-form-label">담당자
									부서</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="cliMnDept">
								</div>
							</div>
							<div class="row">
								<div class="col-sm-2"></div>
								<!-- 비어 있는 2 column을 추가하여 버튼을 오른쪽으로 옮깁니다. -->
								<div class="col-sm-8 d-flex justify-content-center">
									<!-- 버튼을 수직 가운데로 정렬하는 부분 -->
									<button class="btn btn-warning" type="button"
										style="width: 300px; margin: 20px;" id="cliInsertBtn">추가</button>
								</div>
								<div class="col-sm-2"></div>
								<!-- 오른쪽 여백을 유지하기 위해 추가 -->
							</div>
						</form>
					</div>
				</div>

			</div>
		</section>
	</main>
</body>
</html>