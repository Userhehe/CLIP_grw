<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 저장한 결재파일</title>
<%@ include file="./header.jsp"%>
<script type="text/javascript" src="./js/myTempPayList.js"></script>
</head>
<body>
	<main id="main" class="main">
	<%--${lists} ${loginVo} --%>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 님 임시 저장한 결재리스트</h4>
			<!-- 검색시작 -->
			<div style="margin-left: 560px;">
					<select  style="width: 35%; display: unset;" class="form-select " aria-label="Default select example">
		                      <option selected="selected" >제목별 검색</option>
		                      <option value="1">양식종류별 검색</option>
		             </select>
					<input style="width: 200px; display: unset;" id="gian_name"class="form-control" type="text" placeholder="Search...">
					<button class="btn btn-warning rounded-pill" id="templateSearch">검색</button>
				</div>
				<!-- 검색끝 -->
				<table  class="table table-hover" style="margin-top: 10px;">
					<thead>
						<tr>
							<th>결재코드</th>
							<th>제목</th>
							<th>양식 종류</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${lists}" varStatus="vs">
							<tr>
								<td>${vo.app_seq}</td>
								<td>${vo.app_title}</td>
								<td>${vo.gian_seq}</td>
								<td>${vo.app_createdate}</td>
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
			                      <button type="button" class="btn btn-primary">결재 작성</button>
			                      <button type="button" id="tempDel" data-appseq="" class="btn btn-warning">삭제</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 모달 끝 -->
		</div>
	</div>
	</main>
</body>
</html>