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
</head>
<body>
	<main id="main" class="main">
		<div class="card-body">
			<h5 class="card-title">근태 정보 조회</h5>
			<div class="search-form">
    <form action="./searchDailyCheckList.do" method="get" class="form-inline">
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
                <label for="userId" class="mr-2">아이디</label>
                <input type="text" class="form-control" id="userId" name="userId">
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
        <button type="submit" class="btn btn-primary mt-2">검색</button>
    </form>
</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">직책</th>
						<th scope="col">직급</th>
						<th scope="col">부서</th>
						<th scope="col">출근시간</th>
						<th scope="col">퇴근시간</th>
						<th scope="col">출퇴근여부</th>
						<th scope="col">수정사유</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lists" items="${lists}">
						<tr>
							<th scope="row">${lists.user_id}</th>
							<td>${lists.user_name}</td>
							<td>${lists.positions_name}</td>
							<td>${lists.ranks_name}</td>
							<td>${lists.dept_name}</td>
							<td>${lists.daily_intime}</td>
							<td>${lists.daily_outtime}</td>
							<td>${lists.daily_status}</td>
							<td>${lists.daily_modify}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>
