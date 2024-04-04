<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>사원목록</title>
<%@ include file="./header.jsp" %>
<link href="./assets/css/userBoard.css" rel="stylesheet">
<script type="text/javascript" src="./js/userInfo.js"></script>
</head>
<body>
	<main id="main" class="main">
		<div class="card">
			<div class="card-body">
		        <h5 class="card-title">사원 목록</h5>
		        
		        <!-- Table with hoverable rows -->
		        <form action="./searchUserList.do" id="searchUserList" class="form-inline" method="GET">
		        	<div id="flex_center" class="row">
			        	<div class="col-md-2 w140px">
		                  <!-- <label for="startDate" class="col-sm-2 col-form-label">시작일</label> -->
		                  <div class="col-sm-10">
		                  	<c:choose>
		                  		<c:when test="${startDate eq null}">
				                    <input type="date" id="startDate" name="startDate" class="form-control w133px">
		                  		</c:when>
		                  		<c:otherwise>
		                  			<input type="date" id="startDate" name="startDate" value="${startDate}" class="form-control w133px">
		                  		</c:otherwise>
		                  	</c:choose>
		                  </div>
		                </div>
		                <div class="col-md-2 w140px">
		                  <!-- <label for="lastDate" class="col-sm-2 col-form-label">종료일</label> -->
		                  <div class="col-sm-10">
		                  	<c:choose>
		                  		<c:when test="${endDate eq null}">
				                    <input type="date" id="endDate" name="endDate" class="form-control w133px">
		                  		</c:when>
		                  		<c:otherwise>
		                  			<input type="date" id="endDate" name="endDate" value="${endDate}" class="form-control w133px">
		                  		</c:otherwise>
		                  	</c:choose>
		                  </div>
		                </div>
		                &nbsp;&nbsp;
		                <div class="col-md-2 pd1px">
		                  <select id="searchDepts" name="searchDepts" class="form-select" aria-label="Default select example">
		                  	<c:choose>
		                  		<c:when test="${searchDepts eq null}">
			                  		<option value="">부서선택</option>
		                  		</c:when>
		                  		<c:otherwise>
		                  			<option value="${searchDepts}">${searchDepts}</option>
		                  		</c:otherwise>
		                  	</c:choose>
		                    <c:forEach var="deptLists" items="${deptLists}" varStatus="vs">
								<option value="${deptLists.dept_name}">${deptLists.dept_name}</option>
							</c:forEach>
		                  </select>
		                </div>
		                <div class="col-md-2 pd1px">
		                  <select id="searchPositions" name="searchPositions" class="form-select" aria-label="Default select example">
		                    <c:choose>
		                  		<c:when test="${searchPositions eq null}">
			                  		<option value="">직책선택</option>
		                  		</c:when>
		                  		<c:otherwise>
		                  			<option value="${searchPositions}">${searchPositions}</option>
		                  		</c:otherwise>
		                  	</c:choose>
		                    <c:forEach var="positLists" items="${positionsLists}" varStatus="vs">
								<option value="${positLists.positions_name}">${positLists.positions_name}</option>
							</c:forEach>
		                  </select>
		                </div>
		                <div class="col-md-2 pd1px">
		                  <select  id="searchRanks" name="searchRanks" class="form-select" aria-label="Default select example">
		                    <c:choose>
		                  		<c:when test="${searchRanks eq null}">
			                  		<option value="">직급선택</option>
		                  		</c:when>
		                  		<c:otherwise>
		                  			<option value="${searchRanks}">${searchRanks}</option>
		                  		</c:otherwise>
		                  	</c:choose>
		                    <c:forEach var="ranksLists" items="${ranksLists}" varStatus="vs">
								<option value="${ranksLists.ranks_name}">${ranksLists.ranks_name}</option>
							</c:forEach>
		                  </select>
		                </div>
		                <div class="col-md-2 pd1px">
		                  <select  id="searchStatus" name="searchStatus" class="form-select" aria-label="Default select example">
		                    <option value="">재직여부</option>
		                    <c:choose>
		                  		<c:when test="${searchStatus eq null}">
			                  		<option value="Y">Y</option>
									<option value="N">N</option>
		                  		</c:when>
		                  		<c:when test="${searchStatus eq Y}">
			                  		<option value="Y">Y</option>
									<option value="N">N</option>
		                  		</c:when>
		                  		<c:otherwise>
									<option value="N">N</option>
		                  			<option value="Y">Y</option>
		                  		</c:otherwise>
		                  	</c:choose>
		                  </select>
		                </div>
		                <div class="col-md-2 w140px pd1px">
		                  <div class="col-sm-10">
		                  	<c:choose>
		                  		<c:when test="${searchName eq null}">
				                    <input type="text" id="searchName" name="searchName" class="form-control w133px" placeholder="이름 입력">
		                  		</c:when>
		                  		<c:otherwise>
		                  			<input type="text" id="searchName" name="searchName" class="form-control w133px" value="${searchName}" placeholder="이름 입력">
		                  		</c:otherwise>
		                  	</c:choose>
		                  </div>
		                </div>
			       		<button type="submit" id="searchBtn" class="ri-search-line"></button>
		        	</div>
		      	</form>
		        <table class="table table-hover">
		          <thead>
		            <tr>
		              <th scope="col">아이디</th>
		              <th scope="col">인사명</th>
		              <th scope="col">직급</th>
		              <th scope="col">직책</th>
		              <th scope="col">부서</th>
		              <th scope="col">관리자 여부</th>
		              <th scope="col">입사일</th>
		            </tr>
		          </thead>
		          <tbody>
		          	
		          	<c:forEach var="userList" items="${userList}" varStatus="vs">
			            <tr style="cursor: pointer;" onclick="location.href='./userInfoDetail.do?user_seq=${userList.user_id}'">
			              <td>${userList.user_id}</td>
			              <td>${userList.user_name}</td>
			              <td>${userList.ranks_name}</td>
			              <td>${userList.positions_name}</td>
			              <td>${userList.dept_name}</td>
			              <c:if test="${userList.user_auth eq 'ROLE_USER'}">
			              	<td>N</td>
			              </c:if>
			              <c:if test="${userList.user_auth eq 'ROLE_ADMIN'}">
			              	<td>Y</td>
			              </c:if>
			              <td>${userList.user_regdate}</td>
			            </tr>
		            </c:forEach>
		            
		          </tbody>
		        </table>
	    	</div>
			<div class="datatable-bottom paging">
			    <nav aria-label="Page navigation">
			        <ul class="pagination justify-content-center">
			            <!-- 첫 페이지로 이동 버튼 -->
			            <li class="page-item <c:if test="${page.page == 1}">disabled</c:if>">
			                <a class="page-link" href="${pageContext.request.contextPath}/userInfo.do?page=1" aria-label="First">
			                    <span aria-hidden="true">&lt;&lt;</span>
			                </a>
			            </li>
			
			            <!-- 이전 페이지로 이동 버튼 -->
			            <li class="page-item <c:if test="${page.page <= 5}">disabled</c:if>">
			                <a class="page-link" href="${pageContext.request.contextPath}/userInfo.do?page=${page.stagePage - 1}" aria-label="Previous">
			                    <span aria-hidden="true">&lt;</span>
			                </a>
			            </li>
			
			            <!-- 페이지 번호 링크 -->
			            <c:forEach begin="${page.stagePage}" end="${page.endPage}" var="i">
			                <li class="page-item <c:if test="${i == page.page}">active</c:if>">
			                    <a class="page-link" href="${pageContext.request.contextPath}/userInfo.do?page=${i}">${i}</a>
			                </li>
			            </c:forEach>
			
			            <!-- 다음 페이지로 이동 버튼 -->
			            <li class="page-item <c:if test="${page.stagePage+4 >= page.totalPage}">disabled</c:if>">
			                <a class="page-link" href="${pageContext.request.contextPath}/userInfo.do?page=${page.endPage + 1}" aria-label="Next">
			                    <span aria-hidden="true">&gt;</span>
			                </a>
			            </li>
			
			            <!-- 마지막 페이지로 이동 버튼 -->
			            <li class="page-item <c:if test="${page.page == page.totalPage}">disabled</c:if>">
			                <a class="page-link" href="${pageContext.request.contextPath}/userInfo.do?page=${page.totalPage}" aria-label="Last">
			                    <span aria-hidden="true">&gt;&gt;</span>
			                </a>
			            </li>
			        </ul>
			    </nav>
			</div>
			<button class="btn btn-secondary right_button" onclick="window.location.href='./signUp.do'">사원등록</button>
		</div>
    </main>
</body>
</html>