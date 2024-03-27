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
	<div class="card">
		<div class="card-body">
			<div>
				<h4 class="card-title"><span class="card-title" style="color: skyblue;">${loginVo.user_name}</span> 님 요청 결재리스트</h4>
				<div style="margin-left: 560px;">
					<select  id="statusSelect"  style="width: 35%; display: unset;" class="form-select " aria-label="Default select example">
		                      <option value="all" selected="selected" >전체 검색</option>
		                      <option value="결재대기">결재대기</option>
		                      <option value="결재반려">결재반려</option>
		                      <option value="결재취소">결재취소</option>
		                      <option value="결재완료">결재완료</option>
		             </select>
					<input style="width: 200px; display: unset;" id="searchInput"class="form-control" type="text" placeholder="제목을 입력해주세요.">
					<button class="btn btn-warning rounded-pill" id="templateSearch">검색</button>
				</div>
				<table  class="table table-hover" style="margin-top: 10px;">
						<thead>
							<tr>
								<th>결재코드</th>
								<th>제목</th>
								<th>양식 종류</th>
								<th>작성일</th>
								<th>결재현황</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo" items="${lists}" varStatus="vs">
								<tr>
									<td>${vo.app_seq}</td>
									<td>${vo.app_title}</td>
									<td>${vo.gian_seq}</td>
									<td>${vo.app_createdate}</td>
									<td>${vo.app_draft}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td></td>
								<td><div id="noDataMessage" style="color: red; text-align: center;"></div></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
					<!-- 페이징 -->
					<div style="margin-left: 450px;">
					<nav aria-label="Page navigation example">
		                <ul class="pagination">
		                  <li class="page-item">
		                    <a class="page-link" href="#" aria-label="Previous">
		                      <span aria-hidden="true">«</span>
		                    </a>
		                  </li>
		                  <li class="page-item"><a class="page-link" href="#">1</a></li>
		                  <li class="page-item"><a class="page-link" href="#">2</a></li>
		                  <li class="page-item"><a class="page-link" href="#">3</a></li>
		                  <li class="page-item">
		                    <a class="page-link" href="#" aria-label="Next">
		                      <span aria-hidden="true">»</span>
		                    </a>
		                  </li>
		                </ul>
		              </nav>
					</div>
					<div class="modal fade" id="detailModal" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="modalLabel">상세 정보</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									 <p id="modalContent"></p>
								</div>
								<div class="modal-footer">
									  <a href="#"><img alt="PDF.img" src="./images/pdfImg.png"></a>
				                      <button type="button" class="btn btn-warning" data-bs-dismiss="modal">확인</button>
				                      <button type="button" id="editPayButton" class="btn btn-secondary">결재 수정</button>
				                     <button type="button" id="cancelPayButton" class="btn btn-light" data-appseq="">결재 취소</button>
								</div>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>		
	</main>
		<script type="text/javascript">
		$(document).ready(function() {
			  $("tbody tr").click(function() {
			    const appSeq = $(this).find('td:first-child').text();
			    console.log('appseq값:',appSeq);
			    const requestData = {
			      app_seq : appSeq
			    };
			    console.log('요청데이터:',requestData);
				
			    // 여기에 모달을 업데이트하는 코드 추가
			    $("#cancelPayButton").attr("data-appseq", appSeq); // 버튼에 app_seq 값을 저장
			    
			    $.ajax({
			      url: "./myPayList.do?app_seq="+requestData.app_seq,
			      type: "POST",
			      contentType: "application/json",
			      data: JSON.stringify(requestData),
			      success: function(data) {
			    	console.log(data);
			    	$("#modalContent").html("결재요청일자: " + data.app_createdate + "<br>결재내용: " + data.app_content);
			    	$("#cancelPayButton").attr("data-appseq", appSeq); // 버튼에 app_seq 값을 저장

                    // 결재 상태에 따라 결재 수정 및 취소 버튼 숨김 처리
                    if (data.app_draft === "결재취소") {
                        $("#editPayButton").hide();
                        $("#cancelPayButton").hide();
                    } else {
                        $("#editPayButton").show();
                        $("#cancelPayButton").show();
                    }
			    	
			    	
			        var modal = new bootstrap.Modal($("#detailModal"));
			        modal.show();
			      },
			      error: function(error) {
			        console.log('에러시러요');
			      }
			    });
			  });
			  //결재취소 버튼 클릭 이벤트
			  $("#cancelPayButton").on("click", function() {
			    var appSeq = $(this).attr("data-appseq");
			    window.location.href = "./cancelPay.do?app_seq=" + appSeq; 
			  });
			});
		//검색기능
		$(document).ready(function() {
		    $("#templateSearch").click(function() {
		        var searchText = $("#searchInput").val().toLowerCase(); // 입력된 검색어를 소문자로 변환
		        var searchOption = $("#statusSelect").val(); //선택된 옵션 가져옴.
		        var found = false; // 검색 결과가 있는지 여부를 나타내는 플래그
		        // 제목에 검색어가 포함된 행을 보여줌
		        $("tbody tr").each(function() {
		            var titleText = $(this).find('td:nth-child(2)').text().toLowerCase(); // 제목 텍스트 추출 후 소문자로 변환
		            if (searchOption === 'all' && (titleText.includes(searchText))) { // 검색어가 제목에 포함되어 있는지 확인
		                $(this).show(); // 행을 보여줌
		                found = true; // 검색 결과가 있다고 표시
		            }else if(searchOption !== 'all' && titleText.includes(searchText)){ 
		            	 $(this).show(); // 행을 보여줌
		                 found = true; 
		        	}else {
		                $(this).hide(); // 검색어가 없으면 행을 숨김
		            }
		        });
		        if (!found) {
		            $("#noDataMessage").text("검색하신 단어는 없는 제목입니다. 다시 입력해주세요.");
		        } else {
		            $("#noDataMessage").text("");
		        }
		    });
		});
		</script>
</body>
</html>