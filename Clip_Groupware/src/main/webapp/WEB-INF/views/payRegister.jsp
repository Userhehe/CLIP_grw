<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재 신청</title>
<%@ include file="./header.jsp"%>



<script type="text/javascript" src="./js/paylineTest.js"></script>
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

.btn-warning, .btn-warning:hover{
	color:#fff;
}




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
		<section class="section dashboard">
			<h5 class="card-title">${user_name}님 결재신청하실 기안서를 선택해주세요.</h5>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home" type="button" role="tab"
						aria-controls="home" aria-selected="true">연차 신청서</button>
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
					<form id="insertForm" action="./myPayInsert.do" method="post">
					</div>
					<div class="form-group" style="margin-top:20px;">
					    <label for="vaSel">연차 종류</label> 
					    <select class="form-select" aria-label="Default select example" id="vaSel" style="width:37%;" onchange="half(this.value)">
					        <option value="">--사용하실 연차종류를 선택하세요.--</option>
					        <option value="day">연차</option>
					        <option value="halfDay">반차</option>
					        <option value="gongGa">병가/공가</option>
					        <option value="halfHalfDay">반반차</option>                          
					    </select>
					</div>
					<div class="form-group" style="margin-top:10px;">
					    <label for="startDate">기간</label> 
					    <input type="date" style="margin-left: 30px;" class="form-control" id="startDate" name="startDate">
					    <input type="time" class="form-control" id="startTime" style="display: none;">
					    ~
					    <input type="date" class="form-control" id="endDate" name="endDate">
					    <input type="time" class="form-control" id="endTime" style="display: none;">
					    
						<a id="payModalBtn" class="btn btn-warning rounded-pill" data-toggle="modal" data-target="#paylinemodal">
							결재라인 지정
		            	</a>
		            	<div class="selectedPayLine">
		            		<label class="badge bg-warning" >결재라인</label>
		            		<table class="table table-bordered" style="display: inline-block; vertical-align: middle;">
		            			<tr>
		            				<th>1차 결재자</th>
		            				<th>2차 결재자</th>
		            				<th>3차 결재자</th>
		            			</tr>
		            			<tr>
		            				<td></td>
		            				<td></td>
		            				<td></td>
		            			</tr>
		            		</table>
		            	</div>					    

					</div>
					<div class="form-group" style="margin-top:10px;">
						<label for="reason">신청 내용</label>
						<textarea name="gian_html" id="smartEditor1"
							style="width: 100%; height: 600px;">${vo1.gian_html}</textarea>
						<br> <br> <br>
					</div>
					<div style="text-align: center;">
						<button type="submit" class="btn btn-primary rounded-pill">미리보기/결재요청</button>
						<button type="submit" id="tempSave"
							class="btn btn-secondary rounded-pill">임시저장</button>
					</div>
					</form>
				</div>
				<!--  연차신청서탭 끝 -->
			</div>
			<!--  지출결의서탭 시작 -->
			<div class="tab-content pt-2" id="myTabContent">
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
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
			<!-- 출장 보고서 탭 시작 -->
			<div class="tab-content pt-2" id="myTabContent">
				<div class="tab-pane fade" id="contact" role="tabpanel"
					aria-labelledby="contact-tab">
					<form>
						<div class="form-group">
							<label for="position">문서내용 :</label>
							<textarea name="outerGian_html" id="smartEditor3"
								style="width: 100%; height: 412px;">${vo3.gian_html}</textarea>
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
		</section>
		
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
			                	<div class="select_payline_area col-lg-12">
			                		<div id="pickLine_box"></div>
			                	</div>
		                	</div>
		                	
		                	<hr>
	                    </div>
	                    <div class=modal-footer>
	                      <button type="button" class="btn btn-warning" id="applyPayLine">결재라인 지정확인</button>
	                      <input type="button" class="btn btn-light" value="초기화" onclick="clean()">
	                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
	                    </div>
                    </div>
                    
            	</div>
            
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
