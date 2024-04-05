<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 신청</title>
<%@ include file="./header.jsp"%>



<script type="text/javascript" src="./js/paylineModal.js"></script>
<style type="text/css">
.form-control,.form-select{
	width:15%;
	display: inline;
}

.select_payline_area, .select_payline_area{
	border: solid #ECB53B 2px;
	border-radius: 5px;
	padding: 10px; 
}

.vakata-context{
 	z-index: 1060; 
}

.bi-file-x-fill{
	margin-left: 10px;
}

/* .btn-warning, .btn-warning:hover{ */
/* 	color:#fff; */
/* } */




</style>
<script type="text/javascript" src="./js/payTemplateSelect.js"></script>

<!-- SmartEditor2 라이브러리  -->
<script type="text/javascript" src="se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<!-- Drag & Zone 라이브러리 -->
<link rel="stylesheet"
	href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">
<script src="https://rawgit.com/enyo/dropzone/master/dist/dropzone.js"></script>



<link rel="stylesheet" href="./css/jstree.css" />
</head>
<body>
	<main id="main" class="main">
		<div class="container">
		<section class="section dashboard">
			<div style="display: none">
				<input type="text" disabled="disabled" id="session_user_name" value="${loginVo.user_name}">
				<input type="text" disabled="disabled" id="session_dept_name" value="${loginVo.dept_name}">
				<input type="text" disabled="disabled" id="session_ranks_name" value="${loginVo.ranks_name}">
				<input type="text" disabled="disabled" id="session_user_id" name="user_id" value="${loginVo.user_id}">
				
			</div>
			<h5 class="card-title">${user_name}님 결재신청하실 기안서를 선택해주세요.</h5>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home" type="button" role="tab"
						aria-controls="home" aria-selected="true" >연차 신청서</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link " id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile" type="button" role="tab"
						aria-controls="profile" aria-selected="true">지출 결의서</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
						data-bs-target="#contact" type="button" role="tab"
						aria-controls="contact" aria-selected="false" tabindex="-1">출장
						보고서</button>
				</li>
				
			</ul>
			
			
			
			<div class="tab-content pt-2" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<!--  연차신청서탭 시작 -->
					<div class="container" >
					
					<div class="form-group" style="margin-top:20px;">
						<label for="app_title">결재 제목</label>
						<input type="text" id="app_title" class="form-control" name="app_title" placeholder="제목을 입력하세요." style="width:90%">			
					</div>
				
					<div class="form-group" style="margin-top:10px;">
					    <label for="vaSel">연차 종류</label> 
					    <select class="form-select" aria-label="Default select example" id="vaSel" style="width:37%;" onchange="half(this)">
					        <option value="">--사용하실 연차종류를 선택하세요.--</option>
					        <option value="day">연차</option>
					        <option value="halfDay">반차</option>
					        <option value="gongGa">병가/공가</option>
					        <!-- <option value="halfHalfDay">반반차</option> -->                          
					    </select>
					</div>
					<div class="form-group" style="margin-top:10px;">
					    <label for="startDate">기간</label> 
					    <input type="date" style="margin-left: 30px;" class="form-control" id="startDate" name="startDate">
					    <input type="time" class="form-control" id="startTime" style="display: none;">
					    ~
					    <input type="date" class="form-control" id="endDate" name="endDate">
					    <input type="time" class="form-control" id="endTime" style="display: none;">
					    
					    <hr/>
					    
						<a id="payModalBtn" class="btn btn-warning" data-toggle="modal" data-target="#paylinemodal">
							결재라인 지정
		            	</a>
		            	<div id="selectedPayLine">
		            		
		            		
		            	</div>	
		            	
		            	<!-- 결재라인 모달 영역 -->
						<div class="modal fade" id="paylinemodal" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
				            
				            	<div class="modal-dialog modal-lg">
				            	
				            		<div class="modal-content">
						            	<div class="modal-header">
							                <h4 class="modal-title">결재라인 지정</h4>
							                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							               
						                </div>
						                <div class="modal-body row">
							                <div class="col-lg-6">
							                	<div class="select_payline_area col-lg-12">
							                		<div id="search_box">
														<input id="search_input" type="text" placeholder="사원 검색">
													</div>
													<hr/>
													
													<div id="payLine_box"></div>
							                	</div>
							                </div>
							                
							                <div class="col-lg-6">
							                	<div class="select_payline_area col-lg-12" style="height: 100%">
							                		<div id="pickLine_box">
							                		<h4>지정된 결재인</h4>
							                		<hr/>
							                		</div>
							                	</div>
						                	</div>
						                	
						                	<hr>
					                    </div>
					                    <div class=modal-footer>
					                      <button type="button" class="btn btn-warning" id="applyPayLine">결재라인 지정확인</button>
					                      <input type="button" class="btn btn-danger" value="초기화" onclick="clean()">
					                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
					                    </div>
				                    </div>
				                    
				            	</div>
				            
				            </div>
		            	
		            	<hr/>
		            	
		            	
		            	
		            	<!-- 참조인 지정 영역 -->
		            	<a id="refModalBtn" class="btn btn-warning" data-toggle="modal" data-target="#selectedRefermodal">
							참조인 지정
		            	</a>
		            	
		            	
<!-- 		            	참조인 모달 영역 -->
						<div class="modal fade" id="selectedRefermodal" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
				            	<div class="modal-dialog modal-lg">
				            	
				            		<div class="modal-content">
						            	<div class="modal-header">
							                <h4 class="modal-title">참조인 지정</h4>
							                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							               
						                </div>
						                <div class="modal-body row">
							                <div class="col-lg-6">
							                	<div class="select_payline_area col-lg-12">
							                		<div id="search_box">
														<input id="referSearch_input" type="text" placeholder="사원 검색">
													</div>
													<hr/>
													
													<div id="reference_box"></div>
							                	</div>
							                </div>
							                
							                <div class="col-lg-6">
							                	<div class="select_payline_area col-lg-12" style="height: 100%">
							                		<div id="pickReference_box">
							                		<h4>지정된 참조인</h4>
							                		<hr/>
							                		</div>
							                	</div>
						                	</div>
						                	
						                	<hr>
					                    </div>
					                    <div class=modal-footer>
					                      <button type="button" class="btn btn-warning" id="applyReference">참조인 지정확인</button>
					                      <input type="button" class="btn btn-light" value="초기화" onclick="clean()">
					                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
					                    </div>
				                    </div>
				            	</div>
				            </div>
					</div>
					
					<!-- gian_1 신청 모달-->
					
		            	<div class="modal fade" id="previewGian" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
			                <div class="modal-dialog modal-xl" id="req_preview1">
			                  <div class="modal-content">
			                    <div class="modal-header">
			                      <h5 class="modal-title">기안서 양식</h5>
			                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			                    </div>
			                    <div class="modal-body">
									${vo1.gian_html}
			                    </div>
			                    <div class="modal-footer">
			                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			                      <button type="button" class="btn btn-warning" id="pushReq">결재 요청</button>
			                      <button type= "button" id="tempSave" class="btn btn-secondary" onclick="saveApproval()">임시저장</button>
			                    </div>
			                  </div>
			                </div>
			              </div>
					
					
					
					
					<div class="form-group" style="margin-top:10px;">
						<label for="reason">신청 사유</label>
						<textarea name="gian_html" id="approvalContent"
							style="width: 100%; height: 400px;"></textarea>
							
							
						<br> <br> <br>
					</div>
					<div style="text-align: center;">
<!-- 						<button id="sunbmitReq" class="btn btn-primary rounded-pill" data-toggle="modal" data-target="#reqPayment">미리보기/결재요청</button> -->
<!-- 						<button type= "button" id="tempSave" class="btn btn-secondary rounded-pill">임시저장</button> -->
						<button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#previewGian" onclick="gatheringInfo()">
              				미리보기/결재요청
		              	</button>
					</div>
				</div>
				<!--  연차신청서탭 끝 -->
				</div>
			</div>
			
			
			
			
			
			<!--  지출결의서탭 시작 -->
			<div class="tab-content pt-2" id="myTabContent">
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="container" >
					<form id="payTemplate" action="./" method="post">
						<div class="form-group">
							<label for="applicantName">신청자 이름</label> <input type="text"
								class="form-control" id="applicantName" value="${user_name}"
								name="applicantName" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="department">부서</label> <input type="text"
								id="department" class="form-control" value="${dept_name}"
								name="department" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="position">직책</label> <input type="text" id="position"
								class="form-control" value="${ranks_name}" name="position"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="position">총 지출금액:</label> <input type="number"
								id="spendPay" class="form-control" name="position">
						</div>
						<div class="form-group">
							<label for="position">제목 :</label> <input type="text"
								id="payTitle" class="form-control" name="position">
						</div>
						<div class="form-group">
							<label for="position">지출 증빙자료:</label>
							<div class="dropzone" id="fileDropzone"></div>
						</div>
						<div class="form-group">
							<label for="position">문서내용 :</label>
							<textarea name="payGian_html" id="smartEditor2"
								style="width: 100%; height: 412px;">${vo2.gian_html}</textarea>
							<div>
<%-- 							${vo2.gian_html} --%>
							</div>
							<br>
							<br>
							<br>
						</div>
						<div style="text-align: center;">
							<button type="submit" class="btn btn-primary rounded-pill">결재요청</button>
							<button type="submit" id="tempSave"
								class="btn btn-secondary rounded-pill">임시저장</button>
						</div>
					</form>
					
					</div>	
				</div>
			</div>
			<!-- 출장 보고서 탭 시작 -->
			<div class="tab-content pt-2" id="myTabContent">
				<div class="tab-pane fade" id="contact" role="tabpanel"
					aria-labelledby="contact-tab">
					<div class="container" >
					<form>
						<div class="form-group">
							<label for="position">문서내용 :</label>
							<textarea name="outerGian_html" id="smartEditor3"
								style="width: 100%; height: 412px;">${vo3.gian_html}</textarea>
<%-- 							<div>${vo3.gian_html}</div> --%>
							<br>
							<br>
							<br>
						</div>
						<div style="text-align: center;">
							<button type="submit" class="btn btn-primary rounded-pill">결재요청</button>
							<button type="submit" id="tempSave" class="btn btn-secondary rounded-pill">임시저장</button>
						</div>
					</form>
					</div>
				</div>
			</div>
		</section>
		
		
            
            
            
         
			
		</div>
	</main>
</body>
</html>
<!-- editor.js는  html 젤 아래에 넣어야 충돌이 발생 안됨. -->
<script type="text/javascript" src="./js/payGian.js"></script> 
<script type="text/javascript" src="./js/dragAndDrop.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/jstree.min.js"></script>
<!-- <link rel="stylesheet"
	href="//static.jstree.com/3.3.15/assets/bootstrap/css/bootstrap.min.css" /> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/themes/default/style.min.css" />
<link rel="stylesheet" href="./css/jstree.css" />
