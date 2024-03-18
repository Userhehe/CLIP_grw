<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>일정 조회</title>
<%@ include file="./header.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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

 <!-- modal 추가 -->
 	<div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">       
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                </div>
                
                <div class="modal-body">
               <div class="form-group">
                     <form action="./insert.do" method="post" id="form">
                     <div class="form-group">
                       <label for="sel1" class="col-form-label">구분</label>
                       <select class="form-control" id="groupid" name="groupid">
                         <option value="개인일정">개인일정</option>
                         <option value="회의">회의</option>
                         <option value="외근">외근</option>
                       </select>
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
                    <button type="button" class="btn btn-warning" id="addCalendar">추가</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" id="sprintSettingModalClose">취소</button>
                </div>
    
            </div>   
        </div>   
    </div>
    	
    	
    	<div class="modal fade" id="detailModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">       
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                
                <div class="modal-body">
               <div class="form-group">
                     <form action="./delete.do" method="post">
                     <div class="form-group">
                       <label for="sel1" class="col-form-label">구분</label>
                       <div class="form-control" id="groupid1"></div>
                     <label for="title" class="col-form-label">일정 제목</label>
                     <div class="form-control" id="title1"></div>
                     </div>
                       <label for="content" class="col-form-label">일정 내용</label>
                       <div class="form-control" id="content1"></div>
                     <label for="startDate" class="col-form-label">시작 날짜</label>
                     <div class="form-control" id="start1"></div>
                     <label for="endDate" class="col-form-label">종료 날짜</label>
                     <div class="form-control" id="end1"></div>
                    </form> 
               </div>
            </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" onclick="modify(${vo.seq})">수정</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" id="sprintSettingModalClose">취소</button>
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
		
			<div class="container">
				<div id="calendar"></div>
			</div>
			
	</div>		
	</section>
</main>	
</body>
</html>