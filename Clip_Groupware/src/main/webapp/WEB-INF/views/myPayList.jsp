<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 요청 결재 리스트</title>
<%@ include file="./header.jsp"%>
</head>
<body>
	<main id="main" class="main">
<%-- 	${lists} --%>
	
	<div class="card">
		<div class="card-body">
<%-- 			<h4 class="card-title"><span style="color: skyblue;">${loginVo.user_name}</span> 의 요청 결재 리스트</h4> --%>
<!-- 			<form action="post"> -->
<!-- 				<div class="col-lg-12" > -->
<!-- 					<div class="row mb-5"> -->
<!-- 	                  <label class="col-sm-1 col-form-label badge rounded-pill bg-light text-dark" style="text-align: center; font-size: large;">제목</label> -->
<!-- 	                  <div class="col-sm-4"> -->
<!-- 	                    <input type="text" class="form-control"> -->
<!-- 	                  </div> -->
<!-- 	                  <button type="submit" style="color: white;" class="col-sm-1 btn btn-warning rounded-pill">검색</button> -->
	                  
<!-- 	                  <div class="col-sm-6"> -->
<!-- 	                  	<div class="col-sm-3"> -->
<!-- 		                    <select class="form-select" aria-label="Default select example"> -->
<!-- 		                      <option selected="selected" >진행도별 조회</option> -->
<!-- 		                      <option value="1">결재대기</option> -->
<!-- 		                      <option value="2">임시저장</option> -->
<!-- 		                      <option value="3">결재반려</option> -->
<!-- 		                      <option value="4">결재완료</option> -->
<!-- 		                    </select> -->
<!-- 	                    </div> -->
<!-- 	               	 </div> -->
	                  
<!--                   	</div> -->
<!--                 </div> -->
                
                
<!-- 			</form> -->
<!-- 			<div class="card-body"> -->
<!--               <h5 class="card-title">Default Table</h5> -->

<!--               Default Table -->
<!--               <table class="table"> -->
<!--                 <thead> -->
<!--                   <tr> -->
<!--                     <th scope="col">Num</th> -->
<!--                     <th scope="col">제목</th> -->
<!--                     <th scope="col">기안서 양식</th> -->
<!--                     <th scope="col">작성일자</th> -->
<!--                     <th scope="col">진행현황</th> -->
<!--                   </tr> -->
<!--                 </thead> -->
<!--                 <tbody> -->
<!--                   <tr> -->
<!--                     <th scope="row">1</th> -->
<!--                     <td>Brandon Jacob</td> -->
<!--                     <td>Designer</td> -->
<!--                     <td>28</td> -->
<!--                     <td>2016-05-25</td> -->
<!--                   </tr> -->
<!--                   <tr> -->
<!--                     <th scope="row">2</th> -->
<!--                     <td>Bridie Kessler</td> -->
<!--                     <td>Developer</td> -->
<!--                     <td>35</td> -->
<!--                     <td>2014-12-05</td> -->
<!--                   </tr> -->
<!--                   <tr> -->
<!--                     <th scope="row">3</th> -->
<!--                     <td>Ashleigh Langosh</td> -->
<!--                     <td>Finance</td> -->
<!--                     <td>45</td> -->
<!--                     <td>2011-08-12</td> -->
<!--                   </tr> -->
<!--                   <tr> -->
<!--                     <th scope="row">4</th> -->
<!--                     <td>Angus Grady</td> -->
<!--                     <td>HR</td> -->
<!--                     <td>34</td> -->
<!--                     <td>2012-06-11</td> -->
<!--                   </tr> -->
<!--                   <tr> -->
<!--                     <th scope="row">5</th> -->
<!--                     <td>Raheem Lehner</td> -->
<!--                     <td>Dynamic Division Officer</td> -->
<!--                     <td>47</td> -->
<!--                     <td>2011-04-19</td> -->
<!--                   </tr> -->
<!--                 </tbody> -->
<!--               </table> -->
<!--               End Default Table Example -->
<!--             </div> -->
			
			
			<div >
				<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 의 요청 결재 리스트</h4>
              <!-- Table with stripped rows -->
              <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns"><div class="datatable-top">
				    <div class="datatable-dropdown">
				            <label>
				                <select class="datatable-selector"><option value="5">5</option><option value="10" selected="">10</option><option value="15">15</option><option value="-1">All</option></select> entries per page
				            </label>
				        </div>
				        
				    <div>
		                    <select class="form-select" aria-label="Default select example">
		                      <option selected="selected" >진행도별 조회</option>
		                      <option value="1">결재대기</option>
		                      <option value="2">임시저장</option>
		                      <option value="3">결재반려</option>
		                      <option value="4">결재완료</option>
		                    </select>
                    </div>
				        
				    <div class="datatable-search">
				            <input class="datatable-input" placeholder="Search..." type="search" title="Search within table">
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
               			<button class="datatable-sorter">작성일</button>
             		</th>
             		<th data-sortable="true" class="red" style="width: 18.562874251497004%;">
             			<button class="datatable-sorter">결재 현황</button>
             		</th>
            	</tr>
            	</thead>
            	<tbody><tr data-index="0"><td>Zelenia Roman</td><td>
											            		<span name="onModal" value="${lists[0].app_seq}">${lists[0].app_title}</span>
											            	</td><td>Redwater</td><td>2012/03/03</td><td class="green">31%</td></tr><tr data-index="1"><td>Zachery Morgan</td><td>6730</td><td>Collines-de-l'Outaouais</td><td>2006/04/09</td><td class="green">51%</td></tr><tr data-index="2"><td>Yoko Freeman</td><td>4077</td><td>Lidköping</td><td>2002/27/12</td><td class="green">48%</td></tr><tr data-index="3"><td>Wyatt Riley</td><td>5694</td><td>Cavaion Veronese</td><td>2012/19/02</td><td class="green">67%</td></tr><tr data-index="4"><td>Wyatt Mccarthy</td><td>3547</td><td>Patan</td><td>2014/23/06</td><td class="green">9%</td></tr><tr data-index="5"><td>Willow Gilliam</td><td>3497</td><td>Amqui</td><td>2009/29/11</td><td class="green">30%</td></tr><tr data-index="6"><td>Walker Nixon</td><td>6901</td><td>Metz</td><td>2011/12/11</td><td class="green">41%</td></tr><tr data-index="7"><td>Vivien Dominguez</td><td>5653</td><td>Bargagli</td><td>2001/09/01</td><td class="green">86%</td></tr><tr data-index="8"><td>Vielka Olsen</td><td>3745</td><td>Vrasene</td><td>2016/08/01</td><td class="green">70%</td></tr><tr data-index="9"><td>Ursula Reynolds</td><td>7544</td><td>Southampton</td><td>1999/16/12</td><td class="green">61%</td></tr></tbody></table></div>
				<div class="datatable-bottom">
				    <div class="datatable-info">Showing 1 to 10 of 100 entries</div>
				    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">‹</button></li><li class="datatable-pagination-list-item datatable-active"><button data-page="1" class="datatable-pagination-list-item-link" aria-label="Page 1">1</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">2</button></li><li class="datatable-pagination-list-item"><button data-page="3" class="datatable-pagination-list-item-link" aria-label="Page 3">3</button></li><li class="datatable-pagination-list-item"><button data-page="4" class="datatable-pagination-list-item-link" aria-label="Page 4">4</button></li><li class="datatable-pagination-list-item"><button data-page="5" class="datatable-pagination-list-item-link" aria-label="Page 5">5</button></li><li class="datatable-pagination-list-item"><button data-page="6" class="datatable-pagination-list-item-link" aria-label="Page 6">6</button></li><li class="datatable-pagination-list-item"><button data-page="7" class="datatable-pagination-list-item-link" aria-label="Page 7">7</button></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><button class="datatable-pagination-list-item-link">…</button></li><li class="datatable-pagination-list-item"><button data-page="10" class="datatable-pagination-list-item-link" aria-label="Page 10">10</button></li><li class="datatable-pagination-list-item"><button data-page="2" class="datatable-pagination-list-item-link" aria-label="Page 2">›</button></li></ul></nav>
				</div>
				</div>
              <!-- End Table with stripped rows -->

            </div>
            
            <div class="">
            	<div></div>
            
            
            </div>
            
			
		</div>
	</div>
	
	
	
	
	<div class="card-body">
              <h5 class="card-title">Disabled Backdrop</h5>
              <p>You can disable the backdrop by adding <code>data-bs-backdrop="false"</code> to <code>.modal-dialog</code></p>

              <!-- Disabled Backdrop Modal -->
              <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#disablebackdrop">
                Launch Modal
              </button>
              
              
              <div class="modal fade" id="disablebackdrop" tabindex="-1" data-bs-backdrop="false" style="display: none;" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title">Disabled Backdrop</h5>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                      Non omnis incidunt qui sed occaecati magni asperiores est mollitia. Soluta at et reprehenderit. Placeat autem numquam et fuga numquam. Tempora in facere consequatur sit dolor ipsum. Consequatur nemo amet incidunt est facilis. Dolorem neque recusandae quo sit molestias sint dignissimos.
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                  </div>
                </div>
              </div><!-- End Disabled Backdrop Modal-->

            </div>
            
	
	</main>
</body>
</html>