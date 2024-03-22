<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 예약 정보 확인</title>
<%@ include file="./header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩 CSS 파일 로드 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->

<!-- JavaScript 라이브러리 로드 -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/jstree.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>

<!-- 부트스트랩 테마 CSS 파일 및 기타 CSS 파일 로드 -->
<!-- <link rel="stylesheet" href="//static.jstree.com/3.3.15/assets/bootstrap/css/bootstrap.min.css" /> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/themes/default/style.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script type="text/javascript" src="./js/reservation.js"></script>

<style type="text/css">
ul.jstree-container-ul>li>a>i.jstree-checkbox {
	display: none;
}
</style>
</head>
<body>
<!-- 값을 받기위한 hidden -->
<input type="text" id="user_auth" value="${vo.re_title}" style="display: none">


<!-- redetail 모달 -->
<div class="modal fade" id="redetailmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">       
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">회의실 예약 상세조회</h5>
                </div>
                
                <div class="modal-body">
               <div class="form-group">
                     <form action="./addmemo.do" method="post" id="memoform">
                     <div class="form-group">
	                     <label for="title" class="col-form-label">회의실 번호</label>
	                     <input type="text" class="form-control" id="title" name="title">
                     </div>
                     <label for="startDate" class="col-form-label">시작 날짜</label>
                     <div class="input-group">
                        <input type="text" class="form-control" name="start" id="start" readonly="readonly" ondblclick="return false" id="startDate">
                        <span class="input-group-addon" id="imagebutton"><i class="glyphicon glyphicon-calendar"></i></span>
                     </div>
                     <label for="endDate" class="col-form-label">종료 날짜</label>
                     <div class="input-group">
                        <input type="text" class="form-control" name="end" id="end" readonly="readonly">
                        <span class="input-group-addon" id="imagebutton2"><i class="glyphicon glyphicon-calendar"></i></span>
                     </div>
                     <div class="form-group">
	                     <label for="title" class="col-form-label">회의 제목</label>
	                     <input type="text" class="form-control" id="title" name="title">
                     </div>
	                 <label for="content" class="col-form-label">일정 내용</label>
	                 	<textarea class="form-control" rows="5" id="content" name="content"></textarea>
	                 <div class="form-group">
	                     <label for="title" class="col-form-label">참석자</label>
	                     <input type="text" class="form-control" id="title" name="title">
                     </div>
                    </form> 
               </div>
            </div>
                
                <div class="modal-footer">
                    <button type="submit" class="btn btn-secondary" id="addCalendar" >삭제</button>
                    <button type="submit" class="btn btn-secondary" id="addCalendar" >수정</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">취소</button>
                </div>
    
            </div>   
        </div>   
    </div>

	<main id="main" class="main">
		<section class="section dashboard">
		
		<!-- 상단 탭구분 -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">나의 회의실 예약 현황</button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false" tabindex="-1">내가 참석한 회의실 예약 현황</button>
                </li>
        </ul>
		
			<div class="tab-content pt-2" id="myTabContent">
				<!-- 예약한 회의실 현황 리스트 -->	
	            <div class="tab-pane fade active show" id="home" role="tabpanel" aria-labelledby="home-tab">
	            <div class="row">
					<div style="margin-left: 560px;">
						<select style="width: 10%; display: unset;" class="form-select" name="gian_search">
							<option value="">구분</option>
							<option value="gian_name">회의 제목</option>
							<option value="gian_modifier">회의실 번호</option>
						</select> <input style="width: 250px; display: unset;" id="gian_name" class="form-control" type="text" placeholder="검색어를 입력해주세요.">
						<button class="btn btn-primary rounded-pill" id="templateSearch">검색</button>
					</div>
					
						<table class="table table-hover" style="margin-top: 10px;">
							<thead>
								<tr>
									<th><input type="checkbox" class="allCheckBox" id="chCheck" onclick="checkAll(this.checked)"></th>
									<th>회의실 번호</th>
									<th>회의 제목</th>
									<th>예약일</th>
								</tr>
							</thead>
							<tbody id="templateTableBody">
								<c:forEach var="vo" items="${myReservationList}" varStatus="vs">
									<tr>
										<td>${vo.re_seq}</td>
										<td>${vo.me_room}</td>
										<td>
											<a id="redetail" href="./reDetail.do?seq=${vo.re_seq}">${vo.re_title}</a>
										</td>
										<td>${vo.re_create}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				</div>
				</div>
				
				<!-- 내가 참석자에 포함된 예약 리스트 -->
				<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
	            <div class="row">
					<div style="margin-left: 560px;">
						<select style="width: 10%; display: unset;" class="form-select" name="gian_search">
							<option value="">구분</option>
							<option value="gian_name">회의 제목</option>
							<option value="gian_modifier">회의실 번호</option>
						</select> <input style="width: 250px; display: unset;" id="gian_name" class="form-control" type="text" placeholder="검색어를 입력해주세요.">
						<button class="btn btn-primary rounded-pill" id="templateSearch">검색</button>
					</div>
					
						<table class="table table-hover" style="margin-top: 10px;">
							<thead>
								<tr>
									<th><input type="checkbox" class="allCheckBox" id="chCheck" onclick="checkAll(this.checked)"></th>
									<th>회의실 번호</th>
									<th>회의 제목</th>
									<th>예약일</th>
								</tr>
							</thead>
							<tbody id="templateTableBody">
								<c:forEach var="vo" items="${myReservationList}" varStatus="vs">
									<tr>
										<td>${vo.re_seq}</td>
										<td>${vo.me_room}</td>
										<td>
											<a>${vo.re_title}</a>
										</td>
										<td>${vo.re_create}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				</div>
				</div>		
			</div>
		</section>
	</main>
</body>
</html>