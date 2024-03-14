<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 신청</title>
<%@ include file="./header.jsp" %>
<script type="text/javascript" src="./js/payTemplateSelect.js"></script>
</head>
<body>
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
			<div  style="margin-left:560px;">
					<select style="width:10%;display:unset;" class="form-select" name="gian_search">
						<option value="">구분</option>
						<option value="gian_name">기안서명</option>
						<option value="gian_modifier">작성자</option>
					</select>
					<input style="width:250px; display: unset;" class="form-control" type="text" placeholder="검색어를 입력해주세요.">								
					<button class="btn btn-primary rounded-pill">검색</button>
					<button class="btn btn-primary rounded-pill" onclick="modify()">자주쓰는 양식</button>
				</div>
				<table class="table table-striped" style="margin-top: 10px;">
			    <thead>
			        <tr>
			            <th>기안서코드</th>
			            <th>기안서명</th>
			            <th>등록일</th>
			            <th>즐겨찾기</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach var="vo" items="${lists2}" varStatus="vs">
			                <tr>
			                    <td>${vo.gian_seq}</td>
			                    <td><a href="">${vo.gian_name}</a></td>
			                    <td>
			                        <fmt:parseDate var="patternDate" value="${vo.gian_regdate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
			                        <fmt:formatDate value="${patternDate}" pattern="yyyy년MM월dd일" />
			                    </td>
			                    <td>
			                        <c:choose>
			                            <c:when test="${vo.gm_seq == null}">
			                               <a>☆</a>  
			                            </c:when>
			                            <c:otherwise>
			                                <a>★</a> 
			                            </c:otherwise>
			                        </c:choose>
			                    </td>
			                </tr>
			        </c:forEach>
			    </tbody>
			</table>
			<div>
		<!-- 모달시작 -->
		<div class="modal fade" id="modify" role="dialog">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">글 수정</h4>
					</div>
					<div class="modal-body">
						<form method="post" id="frmModify">
							<input>
						</form>
					</div>
					
				</div>

			</div>
		</div>
		<!-- 모달끝 -->
			</div>
		</section>
	</main>
</body>
</html>