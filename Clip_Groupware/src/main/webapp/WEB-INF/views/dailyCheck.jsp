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
<script type="text/javascript" src="./js/dailyCheck.js"></script>t
</head>
<body>
 <div class="modal fade" id="dailyCheckModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">


							<div class="form-group">
								<form action="./myReservationInsert.do" method="post"
									id="dailyCheckForm">

									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">수정 사유를 입력하세요.</h5>
									</div>
									<div class="modal-body">									
										<textarea class="form-control mt-2" id="re_content"
											name="re_content" rows="5" placeholder="수정사유을 입력해주세요."></textarea>
									</div>
								</form>
								<div class="modal-footer">
									<input class="btn btn-secondary" type="button" value="수정완료"
										id="addDailyCheck"> <input class="btn btn-secondary"
										type="button" value="뒤로가기" id="addDailyCheckCancel">
								</div>
							</div>

						</div>
					</div>
				</div>
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
     <!-- $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 여기를 기준으로 위 아래가 같이 호환이 안됩니다 혹시 이유 아시는분 ?????? $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ -->
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
					<c:forEach var="list" items="${lists}">
						<tr>
							<th scope="row">${list.user_id}</th>
							<td>${list.user_name}</td>
							<td>${list.positions_name}</td>
							<td>${list.ranks_name}</td>
							<td>${list.dept_name}</td>
							<td>${list.daily_intime}</td>
							<td>${list.daily_outtime}</td>
							<td>${list.daily_status}</td>
							<td>${list.daily_modify} <button class="open-modal-btn">수정</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="datatable-bottom paging">
			    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">‹</button></li><li class="datatable-pagination-list-item datatable-active"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">1</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">2</button></li><li class="datatable-pagination-list-item"><button data-page="3" class="datatable-pagination-list-item-link" aria-label="Page 3">3</button></li><li class="datatable-pagination-list-item"><button data-page="4" class="datatable-pagination-list-item-link" aria-label="Page 4">4</button></li><li class="datatable-pagination-list-item"><button data-page="5" class="datatable-pagination-list-item-link" aria-label="Page 5">5</button></li><li class="datatable-pagination-list-item"><button data-page="6" class="datatable-pagination-list-item-link" aria-label="Page 6">6</button></li><li class="datatable-pagination-list-item"><button data-page="7" class="datatable-pagination-list-item-link" aria-label="Page 7">7</button></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><button class="datatable-pagination-list-item-link">…</button></li><li class="datatable-pagination-list-item"><button data-page="10" class="datatable-pagination-list-item-link" aria-label="Page 10">10</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">›</button></li></ul></nav>
			</div>
	</main>
</body>
</html>
