<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstree PayLine Test</title>
<%@ include file="./header.jsp"%>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/jstree.min.js"></script>
<!-- <link rel="stylesheet" -->
<!-- 	href="//static.jstree.com/3.3.15/assets/bootstrap/css/bootstrap.min.css" /> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.3.15/themes/default/style.min.css" />
<link rel="stylesheet" href="./css/jstree.css" />


<script type="text/javascript" src="./js/paylineTest.js"></script>
<style type="text/css">
.select_payline_area, .select_payline_area{
	border: solid #ECB53B 2px;
	border-radius: 5px;
	padding: 10px; 
}


</style>
</head>
<body>

	<main id="main" class="main">
		
		<div class="card">
			<div class="card-body">
				<button class="btn btn-warning rounded-pill" data-toggle="modal" data-target="#paylinemodal" onclick="openModal()">
					결재라인 지정
            	</button>
			</div>
			
			
			
			
			
			
			
		</div>
		
		  <div class="modal fade" id="paylinemodal" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
            
            	<div class="modal-dialog modal-xl">
            	
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
									
			                	</div>
			                </div>
			                
			                <div class="col-lg-6">
			                	<div class="select_payline_area col-lg-12">
			                		<div id="search_box">
									</div>
			                	</div>
		                	</div>
		                	
		                	<hr>
	                    </div>
	                    <div class=modal-footer>
	                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">결재라인 지정확인</button>
	                      <button type="button" class="btn btn-secondary">취소</button>
	                    </div>
                    </div>
                    
            	</div>
            
            </div>
		
	
	
	</main>

</body>
</html>