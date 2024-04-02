<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회의실 예약</title>
<%@ include file="./header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- fullcalendar -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->
<!-- 모달창 사용시 css 충돌때문에 막아둠 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>


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
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/themes/default/style.min.css" />
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script type="text/javascript" src="./js/recalendar.js"></script>
<script type="text/javascript" src="./js/reservation.js"></script>



<style type="text/css">
ul.jstree-container-ul>li>a>i.jstree-checkbox {
	display: none;
}

#attadd{
	display: flex;
}


#reservationModalButton{
	background-color: orange !important; 
}
#reservationModalButton:hover {
    background-color: darkorange !important;
}
.vakata-context{
 	z-index: 1060; 
}

</style>
</head>
<body>

	<!-- 예약 추가 모달 -->
	<div class="modal fade" id="reservationModal" tabindex="-1"	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="form-group">
					<form action="./myReservationInsert.do" method="post" id="reservationForm">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">예약 내용을 입력하세요.</h5>
						</div>
						<div class="modal-body">
							<label for="me_room" class="col-form-label">회의실을 선택해주세요.</label> 
								<select class="form-control" name="me_room" id="me_room">
									<c:forEach var="vo" items="${meeTingRoomVo}">
										<option value="${vo.me_room}">${vo.me_room}번회의실</option>
									</c:forEach>
								</select> 
							<label for="re_start" class="col-form-label">예약일을 선택해주세요.</label>
							<div class="input-group">
								<span class="input-group-addon"> 
								<input type="text"	class="form-control" readonly="readonly" ondblclick="return false" id="re_start" name="re_start" placeholder="날짜선택">
								</span> 
								<span class="input-group-btn" style="margin-left: 20px;">
									<button class="btn btn-secondary" type="button" onclick="selPDate()">날짜 선택 완료</button>
								</span>
							</div>

							<div id="nawarayo" style="display: none">
								<label for="re_start_time" class="col-form-label">예약 시간을 선택해주세요.(회의 종료시간 = 시작 시간 + 1시간)</label>
								<div class="input-group">
									<span class="input-group-addon"> 
										<input type="text" class="form-control" readonly="readonly" ondblclick="return false" id="re_start_time">
									</span> 
									<span class="input-group-btn" style="margin-left: 20px;">
										<input class="btn btn-secondary" type="button" value="예약 시간 선택 완료" onclick="reservationTime()">
									</span>
								</div>
							</div>

							<input class="form-control mt-2" type="text" id="re_title" name="re_title" placeholder="회의 제목을 입력해주세요.">
							<textarea class="form-control mt-2" id="re_content"	name="re_content" rows="5" placeholder="회의 내용을 입력해주세요."></textarea>
					</form>
				</div> 
			</div> 
		
								<div class="modal-footer">
									<input class="btn btn-secondary" type="button" value="예약 확인" id="addReservation"> 
									<input class="btn btn-secondary" type="button" value="취소" id="addReservationCancel" onclick="redetailclose()">
								</div>
									
							</div>

						</div>
					</div> 

				
		<!-- 회의 참여인원 설정 모달 -->
		<div class="modal fade" id="reattmodal" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
            
            	<div class="modal-dialog modal-lg">
            	
            		<div class="modal-content">
		            	<div class="modal-header">
		            	 <div id="hiddenValue" style="display: none;">
		            	 </div>
			                <h4 class="modal-title">회의 참석자 선택</h4>
			                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			               
		                </div>
		                <div class="modal-body row">
			                <div class="col-lg-6">
			                	<div class="select_payline_area col-lg-12">
			                		<div id="empChoice">
										<h5>사원 선택</h5>
									</div>
									<hr/>
										<input id="search_input" type="text" placeholder="사원 검색">						
									<div id="emp_box"></div>
			                	</div>
			                </div>
			                
			                <div class="col-lg-6">
			                	<div class="select_payline_area col-lg-12" style="height: 100%">
			                		<div id="pickatt_box">
			                		<h5>지정된 참석자</h5>
			                		<hr/>
			                		</div>
			                	</div>
		                	</div>
		                	
		                	<hr>
	                    </div>
	                    <div class=modal-footer>
	                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	                      <input type="button" class="btn btn-light" value="초기화" onclick="clean()">
	                      <button type="button" class="btn btn-warning" id="attconfirm" onclick="attconfirm()">참석자 등록</button>
	                    </div>
                    </div>
                    
            	</div>
            
            </div>				
				
				
				
		
	<main id="main" class="main">
		<div class="container">
			<div class="row">
				<button class="btn btn-secondary" id="reservationModalButton" onclick="reservationModal()" > 예약하기 </button>
				<div class="card-body">
					<div id="recalendar"></div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>