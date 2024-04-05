<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>일정 조회</title>
<%@ include file="./header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- 모달창 사용시 css 충돌때문에 막아둠 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<style type="text/css">
	.row {
		flex-wrap: nowrap;
	}
	
	/* 일정별 색상 */
	.memo_event > *{
     	background-color: #39CEFA;
    }
	.nct_event > *{
     	background-color: orange;
    }
    .reser_event > *{
     	background-color: #70DB8A;
    }
    .annual_event > *{
     	background-color: #9368DC;
    }
    
    
    .fc-event-title{
    	color : white;
    }
    
	/* 요일별 날짜 색상 */
	.fc-day-sun a {
	  color: red;
	}
	.fc-day-sat a {
	  color: blue;
	}
	.fc-day-mon a, .fc-day-tue a, .fc-day-wed a, .fc-day-thu a, .fc-day-fri a {
	  color: black;
	}
	
	
	.square {
		margin-left : 10px;
        width: 100px;
        height: 15px;
    }
</style>
</head>
<body>

	<!--memo modal 추가(등록 모달) -->
	<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			
				<div class="modal-header">
					<h5 class="modal-title">일정을 입력하세요.</h5>
				</div>

				<div class="modal-body">
					<div class="form-group">
						<form id="addForm">
							<div class="form-group">
								<label for="title" class="col-form-label">일정 제목</label> 
								<input type="text" class="form-control" id="title">
							</div>
							<label for="content" class="col-form-label">일정 내용</label>
							<textarea class="form-control" rows="5" id="content"></textarea>
							<label for="start" class="col-form-label">시작 날짜</label>
							<div class="input-group">
								<input type="text" class="form-control" readonly="readonly" ondblclick="return false" id="start">
							</div>
							<label for="end" class="col-form-label">종료 날짜</label>
							<div class="input-group">
								<input type="text" class="form-control" readonly="readonly" ondblclick="return false" id="end">
							</div>
						</form>
					</div>
				</div>

				<div class="modal-footer">
					<button type="submit" class="btn btn-secondary" id="addCalendar">추가</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">취소</button>
				</div>

			</div>
		</div>
	</div>
	<!--memo modal 추가(등록 모달) -->

	<!--memodetail modal (상세모달) -->
	<div class="modal fade" id="calendarModalDetail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">상세 내용</h5>
				</div>
				
				<div class="modal-body">
					<input type="text" style="display: none" id="dtSeq">
					
					<div id="meRoomDiv" style="display: none;">
						<label for="meRoom" class="col-form-label">회의실 번호</label>
						<div class="form-group">
							<div class="form-control" id="meRoom"></div>
						</div>
					</div>
					
					<div class="form-group">
					<label for="dtTitle" class="col-form-label">일정 제목</label>
					<div class="form-group">
						<div class="form-control" id="dtTitle"></div>
					</div>
					
					
					<label for="dtContent" class="col-form-label">일정 내용</label>
					<textarea rows="5" class="form-control" id="dtContent" readonly="readonly"></textarea>
					<label for="dtStart" class="col-form-label">시작 날짜</label>
					<div class="form-control" id="dtStart"></div>
					<label for="dtEnd" class="col-form-label">종료 날짜</label>
					<div class="form-control" id="dtEnd"></div>
					</div>
					
					<div id="attendDiv" style="display: none;">
						<label for="attends" class="col-form-label">참석자 명단</label>
						<textarea rows="5" class="form-control" id="attends" readonly="readonly"></textarea>
					</div>
				</div>

				<div class="modal-footer">
					<div class="btn-group" role="group aria-label="Basic outlined example" id="dtButtons">
					</div>
					
				</div>

			</div>
		</div>
	</div>
	<!--memodetail modal (상세모달) 끝 -->

	<!--memo modal (수정 모달) -->
	<div class="modal fade" id="calendarModalUpdate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			
				<div class="modal-header">
					<h5 class="modal-title">일정을 입력하세요.</h5>
				</div>

				<div class="modal-body">
					<div class="form-group">
						<form id="upForm">
							<input type="text" style="display: none" id="upSeq">
							<div class="form-group">
								<label for="upTitle" class="col-form-label">일정 제목</label> 
								<input type="text" class="form-control" id="upTitle">
							</div>
							<label for="upContent" class="col-form-label">일정 내용</label>
							<textarea class="form-control" rows="5" id="upContent"></textarea>
							<label for="upStart" class="col-form-label">시작 날짜</label>
							<div class="input-group">
								<input type="text" class="form-control" readonly="readonly" ondblclick="return false" id="upStart">
							</div>
							<label for="upEnd" class="col-form-label">종료 날짜</label>
							<div class="input-group">
								<input type="text" class="form-control" readonly="readonly" ondblclick="return false" id="upEnd">
							</div>
						</form>
					</div>
				</div>

				<div class="modal-footer">
					<button type="submit" class="btn btn-secondary" id="updateCalendar">수정 완료</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">취소</button>
				</div>

			</div>
		</div>
	</div>
	<!--memo modal (수정 모달)끝 -->
	
	
	
	
	
	
	<main id="main" class="main">
		<section class="section dashboard">
			<div class="row">
				<div class="col-lg-2"
					style="background-color: #f2f2f2; height: 300px">
					<div class="card-body">
						<h2 class="card-title">조회 목록</h2>
							<table>
								<tr>
									<td><input type="checkbox" id="showAllEvent" checked> 전체일정</td>
								</tr>
								<tr>
									<td><input type="checkbox" id="showPrs" checked> 개인일정</td>
									<td><div class="square" style="background-color: #39CEFA;"></div></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="showNct" checked> 전사일정</td>
									<td><div class="square" style="background-color: orange;"></div></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="showRe" checked> 예약일정</td>
									<td><div class="square" style="background-color: #70DB8A;"></div></td>
								</tr>
								<tr>
									<td><input type="checkbox" id="showAn" checked> 휴가일정</td>
									<td><div class="square" style="background-color: #9368DC;"></div></td>
								</tr>
								<tr style="display: none">
									<td><input type="text" id="user_auth" value="${loginVo.user_auth}"></td>
								</tr>
								<tr style="display: none">
									<td><input type="text" id="user_id" value="${loginVo.user_id}"></td>
								</tr>
							</table>
					</div>
				</div>

				<div class="card-body">
					<div id="calendar"></div>
				</div>

			</div>
		</section>
	</main>
</body>
</html>

