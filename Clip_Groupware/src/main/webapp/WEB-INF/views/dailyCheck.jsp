<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>근태관리</title>
<%@ include file="./header.jsp"%>
<link href="./assets/css/dailyCheck.css" rel="stylesheet">
<script type="text/javascript" src="./js/dailyCheck.js"></script>
</head>
<body>
	<div class="modal fade" id="dailyCheckModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">


				<div class="form-group">
						<div class="modal-header">
							<input type="text" id="daily_seq" style="display: none;">
							<h5 class="modal-title" id="exampleModalLabel">수정 사유를 입력하세요.</h5>
						</div>						
						<div class="modal-body">
							<textarea class="form-control mt-2" id="daily_reasonmodify" name="re_content" rows="5" placeholder="수정사유을 입력해주세요."></textarea>
						
	                    	<select class="form-control mt-2" id="daily_status">
									<option value="정상근무">정상근무</option>
									<option value="결근">결근</option>
							</select> 
						</div>
						<div class="modal-footer">
							<input class="btn btn-secondary" type="submit" value="수정완료" id="addDailyCheck"> 
							<input class="btn btn-secondary" type="button" value="뒤로가기" id="addDailyCheckCancel">
						</div>
				</div>
			</div>
		</div>
	</div>
	<main id="main" class="main">
		<div class="card-body">
			<h5 class="card-title">근태 정보 조회</h5>
			<br>
			<div class="search-form">
    <form action="./searchDailyCheckList.do" method="GET" class="form-inline" id="searchForm">
        <div class="row">
            <div class="col-md-2">
                <label for="startDate" class="mr-2">검색 시작일</label> 
                <input type="date" class="form-control" id="startDate" name="startDate">
            </div>
            <div class="col-md-2">
                <label for="lastDate" class="mr-2">검색 종료일</label> 
                <input type="date" class="form-control" id="lastDate" name="lastDate">
            </div>
            <div class="col-md-2">
                <label for="userName" class="mr-2">이름</label> 
                <input type="text" class="form-control" id="userName" name="userName">
            </div>
            <div class="col-md-2">
                <label for="positions" class="mr-2">직책</label> 
                <select class="form-control" id="positions" name="positions">
                    <option value="">선택</option>
                    <c:forEach var="position" items="${positionsList}">
                        <option value="${position.positions_name}">${position.positions_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-2">
                <label for="ranks" class="mr-2">직급</label> 
                <select class="form-control" id="ranks" name="ranks">
                    <option value="">선택</option>
                    <c:forEach var="rank" items="${ranksList}">
                        <option value="${rank.ranks_name}">${rank.ranks_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-2">
                <label for="dept" class="mr-2">부서</label> 
                <select class="form-control" id="dept" name="dept">
                    <option value="">선택</option>
                    <c:forEach var="dept" items="${deptList}">
                        <option value="${dept.dept_name}">${dept.dept_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-md-12 text-right">
                <button type="submit" class="btn btn-info" id="searchButton">검색</button>
            </div>
        </div>
        <br>
    </form>
</div>

			<table class="table table-hover" id="dailyCheckTable">
    		<thead>
        <tr>
            <th scope="col">번호</th>                
            <th scope="col">이름</th>
            <th scope="col">직책</th>
            <th scope="col">직급</th>
            <th scope="col">부서</th>
            <th scope="col">출근시간</th>
            <th scope="col">퇴근시간</th>
            <th scope="col">출퇴근여부</th>
            <th scope="col">수정여부</th>
            <th scope="col">수정사유</th>
            <th scope="col">수정내용</th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="list" items="${lists}">
            <tr>
                <td class="daily_seq">${list.daily_seq}</td>             
                <td>${list.user_name}</td>
                <td>${list.positions_name}</td>
                <td>${list.ranks_name}</td>
                <td>${list.dept_name}</td>
                <td>${list.daily_intime}</td>
                <td>${list.daily_outtime}</td>
                <td>${list.daily_status}</td>
                <td class="daily_modify">${list.daily_modify}</td>      
                <td class="daily_reasonmodify">${list.daily_reasonmodify}</td> 
                <td>
                    <button class="open-modal-btn btn btn-warning rounded-pill">수정</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
		</div>
	</main>
</body>
</html>
