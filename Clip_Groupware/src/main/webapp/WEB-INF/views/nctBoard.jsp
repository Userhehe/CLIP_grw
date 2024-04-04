<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<%@ include file="./header.jsp"%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/nctBoard.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div class="card">
			<div class="card-body">
			
				<h5 class="card-title">공지 사항</h5>
				<table class="table table-hover" style="margin-top: 10px;" id="ntcBoard">
					<thead>
						<tr>
							<th>제목</th>
							<th>작성일</th>
							<th>작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${lists}" varStatus="vs">
							<tr class="ntcBoard" data-seq="${vo.ntc_seq}">
								<td>${vo.ntc_title}</td>
								<td>${vo.ntc_create}</td>
								<td>${vo.user_id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
    
    			<!-- 페이지 링크 표시 -->
<div class="datatable-bottom paging">
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <!-- 첫 페이지로 이동 버튼 -->
            <li class="page-item <c:if test="${page.page == 1}">disabled</c:if>">
                <a class="page-link" href="${pageContext.request.contextPath}/nctBoard.do?page=1" aria-label="First">
                    <span aria-hidden="true">&lt;&lt;</span>
                </a>
            </li>

            <!-- 이전 페이지로 이동 버튼 -->
            <li class="page-item <c:if test="${page.page <= 5}">disabled</c:if>">
                <a class="page-link" href="${pageContext.request.contextPath}/nctBoard.do?page=${page.stagePage - 1}" aria-label="Previous">
                    <span aria-hidden="true">&lt;</span>
                </a>
            </li>

            <!-- 페이지 번호 링크 -->
            <c:forEach begin="${page.stagePage}" end="${page.endPage}" var="i">
                <li class="page-item <c:if test="${i == page.page}">active</c:if>">
                    <a class="page-link" href="${pageContext.request.contextPath}/nctBoard.do?page=${i}">${i}</a>
                </li>
            </c:forEach>

            <!-- 다음 페이지로 이동 버튼 -->
            <li class="page-item <c:if test="${page.stagePage+4 >= page.totalPage}">disabled</c:if>">
                <a class="page-link" href="${pageContext.request.contextPath}/nctBoard.do?page=${page.endPage + 1}" aria-label="Next">
                    <span aria-hidden="true">&gt;</span>
                </a>
            </li>

            <!-- 마지막 페이지로 이동 버튼 -->
            <li class="page-item <c:if test="${page.page == page.totalPage}">disabled</c:if>">
                <a class="page-link" href="${pageContext.request.contextPath}/nctBoard.do?page=${page.totalPage}" aria-label="Last">
                    <span aria-hidden="true">&gt;&gt;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
    			
				
				
			</div>
		</div>
	</main>
</body>
</html>