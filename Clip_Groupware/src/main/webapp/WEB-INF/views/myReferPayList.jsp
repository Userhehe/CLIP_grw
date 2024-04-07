<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 참조된 결재 리스트</title>
<!-- pdf다운로드를 위한 라이브러리 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.js"></script>
<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
<%@ include file="./header.jsp"%>
<script type="text/javascript" src="./js/myReferPayList.js"></script>
</head>
<body>
	<main id="main" class="main">
	<div class="card">
		<div class="card-body">
			<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 님의 참조된 결재 리스트</h4>
			<div style="margin-left: 560px; margin-top: 20px;">
				검색 : <input style=" width: 250px; display: unset;" id="searchInput"
					class="form-control" type="text" placeholder="양식종류를 입력해주세요.">
				<button class="btn btn-warning " id="templateSearch">검색</button>
				<button class="btn btn-secondary " id="resetSearch">검색 초기화</button>
			</div>
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
					<c:choose>
						<c:when test="${not empty lists}">
							<c:forEach var="vo" items="${lists}" varStatus="vs">
								<tr>
									<td>${vo.app_seq}</td>
									<td>${vo.app_title}</td>
									<td>${vo.gian_seq}</td>
									<td>${vo.app_createdate}</td>
									<td>${vo.app_draft}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
					       <tr onclick="event.preventDefault(); event.stopImmediatePropagation();">
					          <td colspan="5" style="color: red; text-align: center;">참조된 결재가 없습니다.</td>
					       </tr>
					    </c:otherwise>
					</c:choose>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td><div id="noDataMessage" style="color: red; text-align: center;"></div></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tfoot>
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
					<div class="modal-dialog modal-xl">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modalLabel">상세 정보</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body" id="saveZone">
								 <p id="modalContent"></p>
							</div>
							<div class="modal-footer">
								  <a id="savePdf"><img alt="PDF.img" src="./images/pdfImg.png"></a>
			                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
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