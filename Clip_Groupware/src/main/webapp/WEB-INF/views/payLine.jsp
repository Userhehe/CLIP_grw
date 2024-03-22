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
			                <h4 class="modal-title">제목</h4>
			                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			               
		                </div>
		                <div class="modal-body">
		                	<h5>요청일자</h5>
		                	<hr>
	                    </div>
	                    <div class=>
	                     <a href="#">PDF 저장<img alt="PDF.img" src="./images/pdfImg.png"></a>
	                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
	                      <button type="button" class="btn btn-secondary">결재 수정</button>
	                      <button type="button" class="btn btn-light">결재 취소</button>
	                    </div>
                    </div>
                    
            	</div>
            
            </div>
		
	
	
	</main>

</body>
</html>