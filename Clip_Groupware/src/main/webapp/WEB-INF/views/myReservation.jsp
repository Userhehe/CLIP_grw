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

<style type="text/css">
ul.jstree-container-ul>li>a>i.jstree-checkbox {
	display: none;
}

.re_title:hover{
	cursor: pointer;
	color: orange;
}

.attre_title:hover{
	cursor: pointer;
	color: orange;
}

.vakata-context{
 	z-index: 1060; 
}
#home{
	text-align: center;
}
#profile{
	text-align: center;
}


</style>

</head>
<body>

<!-- 예약 상세보기 모달 & 수정 -->
<div class="modal fade" id="redetail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">       
    	<div class="modal-content">
    		<form id="Revmodify">
                <div class="modal-header">
                	<div class="detailhidden" style="display: block;">
                    	<h5 class="modal-title">회의실 예약 상세조회</h5>
                    </div>
                    <div class="modifyhidden" style="display: none;">
                   		<h5 class="modal-title">회의실 예약 수정</h5>
                    </div>
                </div>
                <div class="modal-body">
                <!--seq 값을 저장할 input -->
                <div class="form-group">
					<div id="hiddenDiv" style="display: none;">
						<input type="text" id="hiddenValue" name="re_seq">
					</div>	        
		        </div>
               <div class="form-group">
	                     <label for="title" class="col-form-label">회의실 번호</label>
	                     <div class="detailhidden" style="display: block;">
	                     	<input type="text" class="form-control" id="deroomNum"  readonly="readonly" >
	                     </div>
	                     <div class="modifyhidden" style="display: none;">
	                     	<select class="form-control" name="me_room" id="me_room">
									<option value="1">1번</option>
									<option value="2">2번</option>
									<option value="3">3번</option>
									<option value="4">4번</option>
									<option value="5">5번</option>
							</select> 
	                     </div>
	                     
                     
                     
                     <label for="startDate" class="col-form-label">시작 날짜</label>
                     <div class="detailhidden" style="display: block;">
	                     <div class="input-group">
	                        <input type="text" class="form-control"  id="destart" readonly="readonly">
	                     </div>
                    </div>
                    
                    <div class="modifyhidden" style="display: none;">
	                    <div class="input-group">
							<span class="input-group-addon"> 
								<input type="text"	class="form-control" readonly="readonly" ondblclick="return false" id="re_start" name="re_start">
							</span> 
							<span class="input-group-btn" style="margin-left: 20px;">
								<button class="btn btn-secondary" type="button" onclick="selPDate()">날짜 선택 완료</button>
							</span>
						</div>
                    </div>
                    <!-- 종료날짜 -->
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
                    <!-- 종료날짜 끝 -->
                    
                     
                     <div class="form-group">
	                    <label for="title" class="col-form-label">회의 제목</label>
	                     <div class="detailhidden" style="display: block;">
	                    	<input type="text" class="form-control" id="detitle" readonly="readonly">
                     	</div>
	                    <div class="modifyhidden" style="display: none;">
	                    	<input type="text" class="form-control" id="re_title" name="re_title">
                     	</div>
	                   
                     </div>
                     
	                 <label for="content" class="col-form-label">회의 내용</label>
	                 	<div class="detailhidden" style="display: block;">
	                 		<textarea class="form-control" rows="5" id="decontent" readonly="readonly"></textarea>
	                 	</div>
	                 	<div class="modifyhidden" style="display: none;">
	                 		<textarea class="form-control" rows="5" id="re_content" name="re_content"></textarea>
	                 	</div>
	                 
	                 <div class="detailhidden" style="display: block;">
	                 	<label for="attend" class="col-form-label">참석자 명단</label>
	                 	<textarea class="form-control" rows="5" id="deattlist" readonly="readonly"></textarea>
	                 </div>	
               </div>
            </div>
           </form>

            
            
            
             <div class="modal-footer">
             	<div class="detailhidden" style="display: block;">	
             		<button type="button" class="btn btn-warning" onclick="modifyRev()"> 수정 </button>
		            <button type="button" class="btn btn-danger" id="delRev" onclick="delRev()"> 삭제 </button>
		            <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="redetailclose()">취소</button>
            	</div>
            	<div class="modifyhidden" style="display: none;">
            		<button type="button" class="btn btn-info" onclick="modifycon()" id="modifycon"> 확인 </button>
	            	<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="redetailclose()">취소</button>
            	</div>
             </div>   
        </div>            
    </div>
</div>
<!-- 예약 상세보기&수정 모달 끝  -->


<!-- 참석자로 등록된 예약 상세보기 모달 -->
<div class="modal fade" id="attredetail" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">       
    	<div class="modal-content">
                <div class="modal-header">
                	<div class="detailhidden" style="display: block;">
                    	<h5 class="modal-title">회의실 예약 상세조회</h5>
                    </div>
                </div>
                <div class="modal-body">
                <!--seq 값을 저장할 input -->
                <div class="form-group">
					<div id="hiddenDiv" style="display: none;">
						<input type="text" id="atthiddenValue" name="re_seq">
					</div>	        
		        </div>
		        
               <div class="form-group">
	                     <label for="title" class="col-form-label">회의실 번호</label>
	                     <div class="detailhidden" style="display: block;">
	                     	<input type="text" class="form-control" id="attderoomNum"  readonly="readonly" >
	                     </div>
	                     
                     
                     
                     <label for="startDate" class="col-form-label">시작 날짜</label>
                     <div class="detailhidden" style="display: block;">
	                     <div class="input-group">
	                        <input type="text" class="form-control"  id="attdestart" readonly="readonly" >
	                     </div>
                    </div>
                    
                    <!-- 종료날짜 -->
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
                    <!-- 종료날짜 끝 -->
                    
                     
                     <div class="form-group">
	                    <label for="title" class="col-form-label">회의 제목</label>
	                     <div class="detailhidden" style="display: block;">
	                    	<input type="text" class="form-control" id="attdetitle" readonly="readonly">
                     	</div>
	                   
                     </div>
                     
	                 <label for="content" class="col-form-label">회의 내용</label>
	                 	<div class="detailhidden" style="display: block;">
	                 		<textarea class="form-control" rows="5" id="attdecontent" readonly="readonly"></textarea>
	                 	</div>
	                 	
	                 <label for="attend" class="col-form-label">참석자 명단</label>
	                 	<textarea class="form-control" rows="5" id="attdeattlist" readonly="readonly"></textarea>	
               </div>
            </div>

            
            
            
             <div class="modal-footer">
	            	<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="attredetailclose()">취소</button>
             </div>   
        </div>            
    </div>
</div>
<!-- 참석자로 등록된 예약 상세보기 모달 끝 -->


<!-- 회의 참여인원 설정 모달 -->
		<div class="modal fade" id="reattmodalmodify" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
            
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
	                      <button type="button" class="btn btn-warning" id="attconfirm" onclick="attmodify()">참석자 등록</button>
	                    </div>
                    </div>
                    
            	</div>
            
            </div>
            <!-- 회의 참여인원 설정 모달 끝-->
 
 
 
 
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
									<th>예약번호</th>
									<th>회의실 번호</th>
									<th>회의 제목</th>
									<th>예약 시간</th>
									<th>예약일</th>
								</tr>
							</thead>
							<tbody id="templateTableBody">
								<c:forEach var="vo" items="${myReservationList}" varStatus="vs">
									<tr class="re-lists">
										<td class="re_seq">${vo.re_seq}</td>
										<td>${vo.me_room}</td>
										<td class="re_title">${vo.re_title}</td>
										<td class="re_start">${vo.re_start } ~ ${vo.re_end }</td>
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
									<th>예약번호</th>
									<th>회의실 번호</th>
									<th>회의 제목</th>
									<th>예약 시간</th>
									<th>예약일</th>
								</tr>
							</thead>
							<tbody id="templateTableBody">
								<c:forEach var="vo" items="${myAttReservationAll}" varStatus="vs">
									<tr>
										<td class="attre_seq">${vo.re_seq}</td>
										<td>${vo.me_room}</td>
										<td class="attre_title">${vo.re_title}</td>
										<td>${vo.re_start }</td>
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
<script type="text/javascript" src="./js/reservation.js"></script>
</html>