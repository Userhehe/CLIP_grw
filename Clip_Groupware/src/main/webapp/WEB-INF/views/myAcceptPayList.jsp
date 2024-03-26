<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 승인대기 결재</title>
<%@ include file="./header.jsp"%>
<script type="text/javascript" src="./js/myAcceptPayList.js"></script>
</head>
<body>
	<main id="main" class="main">
	<div class="card">
		<div class="card-body">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="tab1" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">전체 조회</button>
                </li>
                <li class="nav-item"	 role="presentation">
                  <button class="nav-link" id="tab2" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false" tabindex="-1">승인할 결재문서조회</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="tab3" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false" tabindex="-1">결재취소한 결재조회 </button>
                </li>
              </ul>
              <div class="tab-content pt-2" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
					<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 님 승인대기중인 전체 문서를 조회하였습니다.</h4>
					<table  class="table table-hover" style="margin-top: 10px;">
					<thead>
						<tr>
							<th>결재코드</th>
							<th>제목</th>
							<th>양식 종류</th>
							<th>작성일</th>
							<th>결재현황</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${lists}" varStatus="vs">
							<tr>
								<td>${vo.app_seq}</td>
								<td>${vo.app_title}</td>
								<td>${vo.gian_seq}</td>
								<td>${vo.app_createdate}</td>
								<td>${vo.app_draft}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 페이징 -->
				<div style="margin-left: 450px;">
				<nav aria-label="Page navigation example">
			            <ul class="pagination">
			              <li class="page-item">
			                <a class="page-link" href="#" aria-label="Previous">
			                  <span aria-hidden="true">«</span>
			                </a>
			              </li>
			              <li class="page-item"><a class="page-link" href="#">1</a></li>
			              <li class="page-item"><a class="page-link" href="#">2</a></li>
			              <li class="page-item"><a class="page-link" href="#">3</a></li>
			              <li class="page-item">
			                <a class="page-link" href="#" aria-label="Next">
			                  <span aria-hidden="true">»</span>
			                </a>
			              </li>
			            </ul>
			          </nav>
				</div>
				<!-- 페이징 끝 -->
                <!-- 모달 시작 -->
				<div class="modal fade" id="detailModal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="modalLabel">상세 정보</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<p id="modalContent"></p>
								</div>
								<div class="modal-footer">
									  <a href="#"><img alt="PDF.img" src="./images/pdfImg.png"></a>
				                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
				                      <button type="button" class="btn btn-secondary">결재 수정</button>					        			 
				                      <button type="button" class="btn btn-light">결재 취소</button>
								</div>
							</div>
						</div>
					</div>
                </div>
				<!-- 모달 끝 -->
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
					<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 님이 승인해야 되는 문서를 조회하였습니다.</h4>
                	<table  class="table table-hover" style="margin-top: 10px;">
					<thead>
						<tr>
							<th>결재코드</th>
							<th>제목</th>
							<th>양식 종류</th>
							<th>작성일</th>
							<th>결재현황</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${lists2}" varStatus="vs">
							<tr>
								<td>${vo.app_seq}</td>
								<td>${vo.app_title}</td>
								<td>${vo.gian_seq}</td>
								<td>${vo.app_createdate}</td>
								<td>${vo.app_draft}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 페이징 -->
				<div style="margin-left: 450px;">
				<nav aria-label="Page navigation example">
			            <ul class="pagination">
			              <li class="page-item">
			                <a class="page-link" href="#" aria-label="Previous">
			                  <span aria-hidden="true">«</span>
			                </a>
			              </li>
			              <li class="page-item"><a class="page-link" href="#">1</a></li>
			              <li class="page-item"><a class="page-link" href="#">2</a></li>
			              <li class="page-item"><a class="page-link" href="#">3</a></li>
			              <li class="page-item">
			                <a class="page-link" href="#" aria-label="Next">
			                  <span aria-hidden="true">»</span>
			                </a>
			              </li>
			            </ul>
			          </nav>
				</div>
				<!-- 페이징 끝 -->
				<!-- 모달 시작 -->
				<div class="modal fade" id="detailModal2" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="modalLabel">상세 정보</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									 <p id="modalContent"></p>
								</div>
								<div class="modal-footer">
									  <a href="#"><img alt="PDF.img" src="./images/pdfImg.png"></a>
				                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
				                      	<button type="button" class="btn btn-secondary">결재 수정</button>					        			 
				                      	<button type="button" class="btn btn-light">결재 취소</button>
								</div>
							</div>
						</div>
					</div>
                </div>
                <!-- 모달 끝 -->
                </div>
                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
					<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 님이 승인 보류처리하신 문서를 조회하였습니다.</h4>
                	<table  class="table table-hover" style="margin-top: 10px;">
					<thead>
						<tr>
							<th>결재코드</th>
							<th>제목</th>
							<th>양식 종류</th>
							<th>작성일</th>
							<th>결재현황</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${lists3}" varStatus="vs">
							<tr>
								<td>${vo.app_seq}</td>
								<td>${vo.app_title}</td>
								<td>${vo.gian_seq}</td>
								<td>${vo.app_createdate}</td>
								<td>${vo.app_draft}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 페이징 -->
				<div style="margin-left: 450px;">
				<nav aria-label="Page navigation example">
			            <ul class="pagination">
			              <li class="page-item">
			                <a class="page-link" href="#" aria-label="Previous">
			                  <span aria-hidden="true">«</span>
			                </a>
			              </li>
			              <li class="page-item"><a class="page-link" href="#">1</a></li>
			              <li class="page-item"><a class="page-link" href="#">2</a></li>
			              <li class="page-item"><a class="page-link" href="#">3</a></li>
			              <li class="page-item">
			                <a class="page-link" href="#" aria-label="Next">
			                  <span aria-hidden="true">»</span>
			                </a>
			              </li>
			            </ul>
			          </nav>
				</div>
				<!-- 페이징 끝 -->
				<!-- 모달 시작 -->
				<div class="modal fade" id="detailModal3" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="modalLabel">상세 정보</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									 <p id="modalContent"></p>
								</div>
								<div class="modal-footer">
									  <a href="#"><img alt="PDF.img" src="./images/pdfImg.png"></a>
				                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
								</div>
							</div>
						</div>
					</div>
                </div>
                <!-- 모달 끝 -->
                </div>
              </div>
		</div>
	</div>
	</main>
</body>
</html>