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
		                    <input type="date" id="startDate" name="startDate" class="form-control w133px">
		                  </div>
		                </div>
		                <div class="col-md-2 w140px">
		                  <!-- <label for="lastDate" class="col-sm-2 col-form-label">종료일</label> -->
		                  <div class="col-sm-10">
		                    <input type="date" id="endDate" name="endDate" class="form-control w133px">
		                  </div>
		                </div>
		                &nbsp;&nbsp;
		                <div class="col-md-2 pd1px">
		                  <select id="searchDepts" name="searchDepts" class="form-select" aria-label="Default select example">
		                    <option value="">부서선택</option>
		                    <c:forEach var="deptLists" items="${deptLists}" varStatus="vs">
								<option value="${deptLists.dept_name}">${deptLists.dept_name}</option>
							</c:forEach>
		                  </select>
		                </div>
		                <div class="col-md-2 pd1px">
		                  <select id="searchPositions" name="searchPositions" class="form-select" aria-label="Default select example">
		                    <option value="">직급선택</option>
		                    <c:forEach var="positLists" items="${positionsLists}" varStatus="vs">
								<option value="${positLists.positions_name}">${positLists.positions_name}</option>
							</c:forEach>
		                  </select>
		                </div>
		                <div class="col-md-2 pd1px">
		                  <select  id="searchRanks" name="searchRanks" class="form-select" aria-label="Default select example">
		                    <option value="">직책선택</option>
		                    <c:forEach var="ranksLists" items="${ranksLists}" varStatus="vs">
								<option value="${ranksLists.ranks_name}">${ranksLists.ranks_name}</option>
							</c:forEach>
		                  </select>
		                </div>
		                <div class="col-md-2 pd1px">
		                  <select  id="searchStatus" name="searchStatus" class="form-select" aria-label="Default select example">
		                    <option value="">재직여부</option>
								<option value="Y">Y</option>
								<option value="N">N</option>
		                  </select>
		                </div>
		                <div class="col-md-2 w140px pd1px">
		                  <div class="col-sm-10">
		                    <input type="text" id="searchName" name="searchName" class="form-control w133px" placeholder="이름 입력">
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
			    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">‹</button></li><li class="datatable-pagination-list-item datatable-active"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">1</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">2</button></li><li class="datatable-pagination-list-item"><button data-page="3" class="datatable-pagination-list-item-link" aria-label="Page 3">3</button></li><li class="datatable-pagination-list-item"><button data-page="4" class="datatable-pagination-list-item-link" aria-label="Page 4">4</button></li><li class="datatable-pagination-list-item"><button data-page="5" class="datatable-pagination-list-item-link" aria-label="Page 5">5</button></li><li class="datatable-pagination-list-item"><button data-page="6" class="datatable-pagination-list-item-link" aria-label="Page 6">6</button></li><li class="datatable-pagination-list-item"><button data-page="7" class="datatable-pagination-list-item-link" aria-label="Page 7">7</button></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><button class="datatable-pagination-list-item-link">…</button></li><li class="datatable-pagination-list-item"><button data-page="10" class="datatable-pagination-list-item-link" aria-label="Page 10">10</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">›</button></li></ul></nav>
			</div>
			<button class="btn btn-secondary right_button" onclick="window.location.href='./signUp.do'">사원등록</button>
		</div>
    </main>
</body>
</html>