<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>마이페이지</title>
<%@ include file="./header.jsp" %>
<link href="./assets/css/myPage.css" rel="stylesheet">
<body>
	<main id="main" class="main" style="padding: 3.85% 9% 3.85% 9%;">
		<c:forEach var="userDetailList" items="${userDetailList}" varStatus="vs">
			<div class="pagetitle">
		    	<nav>
		        <ol id="title" class="breadcrumb">
		        	<li class="breadcrumb-item active">마이페이지</li>
		        </ol>
		     	</nav>
		    </div>
			<section class="section profile">
		      	<div class="row">
		        	<div class="col-xl-4">
		          		<div id="profileCt" class="card">
		            		<div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
				            	<img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
				            	<h2>${userDetailList.user_name}</h2>
				            	<br>
				            	<h3>${userDetailList.dept_name}팀 ${userDetailList.positions_name}</h3>
				           	</div>
				        </div>
				        
				        <form action="./photoUpload.do" method="post" enctype="multipart/form-data">
					        <div class="card bgcolorTrans">
					        	<input type="file" name="uploadImage">
					        	<button type="submit" id="profilePhotoUploadBtn" class="btn btn-dark">프로필 사진 등록</button>
					        </div>
				        </form>
				        
				        <div class="card bgcolorTrans">
	                   		<button type="button" id="profilePhotoUpdateBtn" class="btn btn-warning">프로필사진 수정</button>
	                   		<button type="button" id="profilePhotoDelBtn" class="btn btn-danger">프로필사진 삭제</button>
				        </div>
				        
				        <div class="card bgcolorTrans">
	                   		<button type="button" class="btn btn-dark" onclick="window.location.href = './certiOfImpl.do'">재직증명서 다운로드</button>
				        </div>
				        
				        <div class="card bgcolorTrans">
	                   		<button type="button" class="btn btn-dark">서명등록</button>
				        </div>
		        	</div>
		        	<div class="col-xl-8">
			        	<div id="userInfoDetailCt" class="card">
				            <div id="userInfoDetail" class="card-body pt-3">
			              		<div class="tab-content pt-2">
			                		<div class="tab-pane fade profile-overview active show" id="profile-overview" role="tabpanel">
			                			<h5 class="card-title label">나의 상세정보</h5>
			                  			<div class="row mgTop30px">
			                    			<div class="col-lg-3 col-md-4 label ">아이디</div>
			                    			<div class="col-lg-9 col-md-8">${userDetailList.user_id}</div>
			                  			</div>
					
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">주민등록번호</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.user_registnum}</div>
					                  	</div>
					
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">이메일</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.user_email}</div>
					                  	</div>
					
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">생년월일</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.user_birthday}</div>
					                  	</div>
					
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">연락처</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.user_phonenum}</div>
					                  	</div>
					
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">주소</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.user_address}</div>
					                  	</div>
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">부서</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.dept_name}</div>
					                  	</div>
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">직급</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.positions_name}</div>
					                  	</div>
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">직책</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.ranks_name}</div>
					                  	</div>
					                  	<div class="row mgTop30px">
					                    	<div class="col-lg-3 col-md-4 label">입사일</div>
					                    	<div class="col-lg-9 col-md-8">${userDetailList.user_regdate}</div>
					                  	</div>
				               		</div>
			       				</div>
			            	</div>
			      		</div>
		       		</div>
				</div>
	    	</section>
    	</c:forEach>
	</main>
</body>
</html>