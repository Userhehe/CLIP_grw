<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 저장한 결재파일</title>
<%@ include file="./header.jsp"%>
</head>
<body>
	<main id="main" class="main">
<%-- 		${lists} --%>
<%-- 		${loginVo} --%>
		<div class="card">
		<div class="card-body">
			
			<div >
				<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 의 임시저장 결재파일</h4>
              <!-- Table with stripped rows -->
              <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns col-sm-12">
              <div class="datatable-top">
				    <div class="datatable-dropdown col-sm-6">
				            <label>
				                <select class="datatable-selector"><option value="5">5</option><option value="10" selected="">10</option><option value="15">15</option><option value="-1">All</option></select> entries per page
				            </label>
				        </div>
				        
				    <div class="col-sm-2">
				    	  <button type="submit" style="color: white;" class="col-sm-6 btn btn-warning rounded-pill">검색</button>
                    </div>
				    	  
				      <div class="datatable-search col-sm-2">
				            <input class="datatable-input" placeholder="Search..." type="search" title="Search within table">
				        </div>
				    	  
				    <div class="col-sm-2">	  
				    	<div class="col-sm-10">	  
		                    <select class="form-select " aria-label="Default select example">
		                      <option selected="selected" >양식별 조회</option>
		                      <option value="1">PAY</option>
		                      <option value="2">VA</option>
		                      <option value="3">ETC</option>
		                    </select>
			            </div>        
		            </div>        
				        
				  
				</div>
				<div class="datatable-container"><table class="table datatable datatable-table">
				<thead>
				<tr>
					<th data-sortable="true" style="width: 9.181636726546905%;" aria-sort="descending" class="datatable-descending">
						<button class="datatable-sorter">
						Num
	                    </button>
                    </th>
                    <th data-sortable="true" style="width: 26.813040585495674%;">
                    	<button class="datatable-sorter">제목</button>
                   	</th>
                   	<th data-sortable="true" style="width: 28.542914171656687%;">
                   		<button class="datatable-sorter">양식 종류</button>
               		</th>
               		<th data-format="YYYY/DD/MM" data-sortable="true" data-type="date" style="width: 16.899534264803727%;">
               			<button class="datatable-sorter">생성일</button>
             		</th>
             		<th data-sortable="true" class="red" style="width: 18.562874251497004%;">
             			<input type="checkbox" id="checkAll">
             		</th>
            	</tr>
            	</thead>
            	<tbody>
            	<tr data-index="0">
            	<td>1</td>
            	<td>
					<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#disablebackdrop">
	            			${lists[0].app_title}
	            	</button>
            	</td>
            	<td>${lists[0].gian_seq}</td>
            	<td>${lists[0].app_createdate}</td>
            	<td class="green">
            		<input type="checkbox" class="checkDel">
           		</td>
           		</tr><tr data-index="1"><td>Zachery Morgan</td><td>6730</td><td>Collines-de-l'Outaouais</td><td>2006/04/09</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="2"><td>Yoko Freeman</td><td>4077</td><td>Lidköping</td><td>2002/27/12</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="3"><td>Wyatt Riley</td><td>5694</td><td>Cavaion Veronese</td><td>2012/19/02</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="4"><td>Wyatt Mccarthy</td><td>3547</td><td>Patan</td><td>2014/23/06</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="5"><td>Willow Gilliam</td><td>3497</td><td>Amqui</td><td>2009/29/11</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="6"><td>Walker Nixon</td><td>6901</td><td>Metz</td><td>2011/12/11</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="7"><td>Vivien Dominguez</td><td>5653</td><td>Bargagli</td><td>2001/09/01</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="8"><td>Vielka Olsen</td><td>3745</td><td>Vrasene</td><td>2016/08/01</td><td class="green"><input type="checkbox" class="checkDel"></td></tr><tr data-index="9"><td>Ursula Reynolds</td><td>7544</td><td>Southampton</td><td>1999/16/12</td><td class="green"><input type="checkbox" class="checkDel"></td></tr>
           		</tbody></table></div>
				<div class="datatable-bottom">
				    <div class="datatable-info">Showing 1 to 10 of 100 entries</div>
				    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">‹</button></li><li class="datatable-pagination-list-item datatable-active"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">1</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">2</button></li><li class="datatable-pagination-list-item"><button data-page="3" class="datatable-pagination-list-item-link" aria-label="Page 3">3</button></li><li class="datatable-pagination-list-item"><button data-page="4" class="datatable-pagination-list-item-link" aria-label="Page 4">4</button></li><li class="datatable-pagination-list-item"><button data-page="5" class="datatable-pagination-list-item-link" aria-label="Page 5">5</button></li><li class="datatable-pagination-list-item"><button data-page="6" class="datatable-pagination-list-item-link" aria-label="Page 6">6</button></li><li class="datatable-pagination-list-item"><button data-page="7" class="datatable-pagination-list-item-link" aria-label="Page 7">7</button></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><button class="datatable-pagination-list-item-link">…</button></li><li class="datatable-pagination-list-item"><button data-page="10" class="datatable-pagination-list-item-link" aria-label="Page 10">10</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">›</button></li></ul></nav>
					<button class="btn btn-secondary">다중 삭제</button>
				</div>
				</div>
              <!-- End Table with stripped rows -->

            </div>
            
            
            <div class="modal fade" id="disablebackdrop" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
            
            	<div class="modal-dialog modal-xl">
            	
            		<div class="modal-content">
		            	<div class="modal-header">
			                <h4 class="modal-title">${lists[0].app_title}</h4>
			                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			               
		                </div>
		                
		                <div class="modal-body">
		                	<h5>요청일자 : ${lists[0].app_createdate}</h5>
		                	<hr>
	                    	${lists[0].app_content}
	                    </div>
	                    
	                    <div class="modal-footer">
	                 	   <a href="#">PDF 저장<img alt="PDF.img" src="./images/pdfImg.png"></a>
		                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
		                      <button type="button" class="btn btn-secondary">작성</button>
		                      <button type="button" class="btn btn-light">삭제</button>
	                    </div>
                    </div>
                    
            	</div>
            
            </div>
            
			
		</div>
	</div>
		
		
	</main>
</body>
</html>