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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/gianList.js"></script>
<%@ include file="./header.jsp"%>
</head>
<body>
	<main id="main" class="main">
	<div class="card">
		<div class="card-body">
		<section class="section dashboard">
			<div class="row">
				<div style=" margin-top: 20px; margin-left: 56%;">
					검색 : <input style=" width: 250px; display: unset;" id="searchInput"
						class="form-control" type="text" placeholder="기안서명을 입력해주세요.">
					<button class="btn btn-warning" id="templateSearch">검색</button>
					<button class="btn btn-secondary" id="resetSearch">검색 초기화</button>
				</div>
				<form action="./templateDelete.do" method="post"
					onsubmit="return chsSubmit()">
					<table class="table table-hover" style="margin-top: 10px;">
						<thead>
							<tr>
								<th>기안서코드</th>
								<th>기안서명</th>
								<th>등록일</th>
							</tr>
						</thead>
						<tbody id="templateTableBody">
							<c:choose>
								<c:when test="${not empty lists2}">
									<c:forEach var="vo" items="${lists2}" varStatus="vs">
										<tr>
											<td>${lists.gian_seq}</td>
											<td><a href="./gianDetail.do?gian_seq=${vo.gian_seq}">${vo.gian_name}</a></td>
											<td><fmt:parseDate var="patternDate"
													value="${vo.gian_regdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
												<fmt:formatDate value="${patternDate}" pattern="yyyy년MM월dd일" /></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="vo" items="${lists}" varStatus="vs">
										<tr>
											<td>${vo.gian_seq}</td>
											<td><a href="./gianDetail.do?gian_seq=${vo.gian_seq}">${vo.gian_name}</a></td>
											<td><fmt:parseDate var="patternDate"
													value="${vo.gian_regdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
												<fmt:formatDate value="${patternDate}" pattern="yyyy년MM월dd일" /></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
						<tfoot>
							<tr>
								<td></td>
								<td><div id="noDataMessage" style="color: red; text-align: center;"></div></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
			<a href="./gianInsert.do"><button
					class="btn btn-warning" style="width: 100%;">양식추가</button></a>
		</section>
		</div>
	</div>
	</main>
	<script type="text/javascript">
	$(document).ready(function() {
	    $("#templateSearch").click(function() {
	        var searchText = $("#searchInput").val().toLowerCase(); // 입력된 검색어를 소문자로 변환
	        var found = false; // 검색 결과가 있는지 여부를 나타내는 플래그
	        // 제목에 검색어가 포함된 행을 보여줌
	        $("tbody tr").each(function() {
	            var titleText = $(this).find('td:nth-child(2)').text().toLowerCase(); // 제목 텍스트 추출 후 소문자로 변환
	            if (titleText.includes(searchText)) { // 검색어가 제목에 포함되어 있는지 확인
	                $(this).show(); // 행을 보여줌
	                found = true; // 검색 결과가 있다고 표시
	        	}else {
	                $(this).hide(); // 검색어가 없으면 행을 숨김
	            }
	        });
	        if (!found) {
	            $("#noDataMessage").text("검색하신 단어는 없는 제목입니다. 다시 입력해주세요.");
	        } else {
	            $("#noDataMessage").text("");
	        }
	    });
	    
	    $("#resetSearch").click(function(){
	    	$("#searchInput").val("");
	    	$("tbody tr").show();
	    	$("#noDataMessage").text("");
	    });
	});
	</script>
</body>
</html>