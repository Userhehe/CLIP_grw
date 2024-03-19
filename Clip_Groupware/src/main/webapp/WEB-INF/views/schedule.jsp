<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>일정 조회</title>
<%@ include file="./header.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->   <!-- 모달창 사용시 css 충돌때문에 막아둠 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<style type="text/css">
	.row{
		flex-wrap: nowrap;
	}
</style>
</head>
<body>

 <!--memo modal 추가 -->
 	<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">       
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                </div>
                
                <div class="modal-body">
               <div class="form-group">
                     <form action="./addmemo.do" method="post" id="memoform">
                     <div class="form-group">
	                     <label for="title" class="col-form-label">일정 제목</label>
	                     <input type="text" class="form-control" id="title" name="title">
                     </div>
	                 <label for="content" class="col-form-label">일정 내용</label>
	                 	<textarea class="form-control" rows="5" id="content" name="content"></textarea>
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
                    </form> 
               </div>
            </div>
                
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" id="addCalendar" >추가</button>
                    <button type="button" class="btn btn-warning" data-dismiss="modal" id="modalclose">취소</button>
                </div>
    
            </div>   
        </div>   
    </div>
    
<!--memodetail modal 추가 -->    
    <div class="modal fade" id="memodetail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">       
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">상세메모</h5>
                </div>
                <div class="modal-body">
               <div class="form-group">
                     <form action="./memodetail.do" method="post" id="memoform">
                     <div class="form-group">
	                     <label for="title" class="col-form-label">일정 제목</label>
	                     <div id="dttitle" nam></div>
	                     <div type="text" class="form-control" id="dttitle" name="title"></div>
                     </div>
	                 <label for="content" class="col-form-label">일정 내용</label>
	                 	<textarea class="form-control" rows="5" id="dtcontent" name="content"></textarea>
	                 <label for="startDate" class="col-form-label">시작 날짜</label>
                     <div class="input-group">
                        <input type="text" class="form-control" name="start" id="dtstart" readonly="readonly" ondblclick="return false" id="startDate">
                        <span class="input-group-addon" id="imagebutton"><i class="glyphicon glyphicon-calendar"></i></span>
                     </div>
                     <label for="endDate" class="col-form-label">종료 날짜</label>
                     <div class="input-group">
                        <input type="text" class="form-control" name="end" id="dtend" readonly="readonly">
                        <span class="input-group-addon" id="imagebutton2"><i class="glyphicon glyphicon-calendar"></i></span>
                     </div>
                    </form> 
               </div>
            </div>
                
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" id="addCalendar" >추가</button>
                    <button type="button" class="btn btn-warning" data-dismiss="modal" id="modalclose" onclick="location.href='.schedule.do'">취소</button>
                </div>
    
            </div>   
        </div>   
    </div>
    	
    	
    	
    	
    	


<main id="main" class="main">
	<section class="section dashboard">
	<div class="row">
		<div class="col-lg-2">
			<div class="card-body" >
			<h2 class="card-title">조회 목록</h2>
				<form>
					<table>
						<tr>
							<td>
								<input type="checkbox"> 전사일정
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox"> 휴가일정
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox"> 회의실 예약
							</td>
						</tr>
					</table>
				</form>	
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