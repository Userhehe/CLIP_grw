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
<title>Projects</title>
<%@ include file="./header.jsp"%>
<script type="text/javascript" src="./js/projectBoard.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
	<main id="main" class="main">
		<div>
			<div>
				<div class="row" style="width: 50%; flex-wrap: nowrap;">
					<div class="col-md-1"
						style="display: flex; align-items: center; margin-left: 25px; margin-top: 50px; margin-bottom: 15px; height: 10px; width: 800px;">
						<div class="title">


							<div
								style="display: flex; flex-direction: row; align-items: center; margin-top: 5px; font-size: xx-large; font-weight: 800;">
								<div>[${result[0].cli_name}] ${result[0].prj_name}</div>
								<div
									style="margin-left: 10px; display: flex; align-items: center;">
									<button type="button" class="btn btn-outline-warning"
										style="width: 35px; height: 35px; display: flex; align-items: center; justify-content: center;">
										<i class="bi bi-pen"></i>
									</button>
									<button type="button" class="btn btn-outline-danger" id="deletePrjTopBtn"
										style="width: 35px; height: 35px; margin-left: 5px; display: flex; align-items: center; justify-content: center;">
										<i class="bi bi-trash"></i>
									</button>
								</div>
							</div>


							<div
								style="margin-top: 10px; font-size: large; font-weight: 300;">현장주소
								: ${result[0].work_site}</div>
							<div style="margin-top: 5px; font-size: large; font-weight: 200;">프로젝트
								기간 : ${result[0].prj_sdate}~${result[0].prj_ddate}</div>
						</div>
					</div>

					<div style="display: flex; justify-content: flex-end;">
						<div
							style="width: calc(550px - 50px); margin-bottom: 20px; margin-top: 5px; margin-right: 20px;">
							<!-- 수정 -->
							<div class="progress mt-3"
								style="width: calc(100% + 50px - 50px); margin-bottom: 25px;">
								<!-- 수정 -->
								<div
									class="progress-bar progress-bar-striped bg-warning progress-bar-animated"
									role="progressbar" style="width: 15%;" aria-valuenow="75"
									aria-valuemin="0" aria-valuemax="100"></div>
							</div>
							<div
								style="display: flex; justify-content: space-between; align-items: center;">
								<div style="font-size: medium; font-weight: 100;">
									프로젝트 매니저 : ${result[0].prj_manager}<br> 프로젝트 참여자 :
									<c:forEach var="project" items="${result}" varStatus="vs"> 
                    				${result[vs.index].user_name}${not vs.last ? ', ' : ''}
                				</c:forEach>
								</div>
								<button type="button" class="btn btn-secondary"
									style="height: 50px; width: 50px;">
									<!-- 수정하지 않음 -->
									<i class="bi bi bi-person"></i>
								</button>
							</div>
						</div>
					</div>

				</div>
			</div>

			<div class="col-md-1"
				style="margin-left: 20px; margin-top: 10px; margin-bottom: 9px; width: calc(100% - 40px); max-width: 1520px;">
				<div class="card-body"
					style="margin-top: 5px; background-color: white; height: 660px; border-radius: 20px;">
					<ul class="nav nav-tabs" id="teamTabs" role="tablist"
						style="margin-top: 10px;">
						<li class="nav-item" role="presentation" style="margin-top: 10px;">
							<button class="nav-link active" id="sales-tab"
								data-bs-toggle="tab" data-bs-target="#sales" type="button"
								role="tab" aria-controls="sales" aria-selected="true">영업팀</button>
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

					<form id="insertProjectBoard"
						style="width: 100%; text-align: center;">
						<input type="hidden" name="prjId" id="prjId" value = "${result[0].prj_id}">
						<input type="hidden" name="prjManager" id="prjManager" value = "${result[0].prj_manager_id}">	
						<input type="hidden" name="loginUserId" id="loginUserId" value = "${loginVo.user_id}">													
						<div>
							<input type="text" name="pboTitle" class="form-control"
								style="width: 1480px; max-width: 100%; margin-top: 15px; text-align: center; margin: 15px auto; display: block;"
								placeholder="제목을 입력하세요">
						</div>
						<div>
							<textarea class="form-control" name="pboContent"
								style="height: 250px; margin-top: 5px; text-align: center;"
								placeholder="내용을 입력하세요"></textarea>
						</div>

						<div class="d-grid gap-2 mt-3">
							<button class="btn btn-warning" type="button" id="pboInsertBtn">등록</button>
						</div>
					</form>
					<div>
						<table class="table table-hover" style="margin-top: 25px;">
							<thead>
								<tr>
									<th scope="col" style="width: 100px; text-align: center;">순번</th>
									<th scope="col" style="width: 200px; text-align: center;">작성자</th>
									<th scope="col" style="text-align: center; width: 300px;">제목</th>
									<th scope="col" style="text-align: center;">내용</th>
									<th scope="col" style="width: 150px; text-align: center;">등록일</th>
									<th scope="col" style="text-align: center; width: 60px;">수정</th>
									<th scope="col" style="text-align: center; width: 60px;">삭제</th>
									<!-- 새로운 열 추가 -->
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row" style="width: 100px; text-align: center;">${project_board.PBO_SEQ}</th>
									<td style="width: 200px; text-align: center;">${project_board.USER_ID}</td>
									<td style="text-align: center; width: 300px;">${project_board.PBO_TITLE}</td>
									<td style="text-align: center;">${project_board.PBO_CONTENT}</td>
									<td style="width: 150px; text-align: center;">${project_board.PBO_REGDATE}</td>
									<td style="text-align: center; width: 60px;">
										<button type="button" class="btn btn-outline-warning">
											<i class="bi bi-pen"></i>
										</button>
									</td>
									<td style="text-align: center; width: 60px;">
										<button type="button" class="btn btn-outline-danger">
											<i class="bi bi-trash"></i>
										</button>
									</td>
									<!-- 버튼 열 추가 -->
								</tr>
								<!-- 다른 행들도 동일하게 추가 -->
							</tbody>
						</table>
					</div>



				</div>
			</div>

		</div>
	</main>
</body>
</html>