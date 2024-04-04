$(document).ready(function() {
			  $("tbody tr").click(function() {
			    const appSeq = $(this).find('td:first-child').text();
			    console.log('appseq값:',appSeq);
			    const requestData = {
			      app_seq : appSeq
			    };
			    console.log('요청데이터:',requestData);
				
			    $("#cancelPayButton").attr("data-appseq", appSeq); // 버튼에 app_seq 값을 저장
			    
			    $.ajax({
			      url: "./myPayList.do?app_seq="+requestData.app_seq,
			      type: "POST",
			      contentType: "application/json",
			      data: JSON.stringify(requestData),
			      success: function(data) {
			    	console.log(data);
			    	$("#modalContent").html(appSeq + data.app_content );
			    	$("#cancelPayButton").attr("data-appseq", appSeq); // 버튼에 app_seq 값을 저장

                    // 결재 상태에 따라 결재 수정 및 취소 버튼 숨김 처리
                  	if (data.app_draft === "결재대기") {
	                	$("#editPayButton").show();
					    $("#cancelPayButton").show();
 					} else {
					 $("#editPayButton").hide();
						 $("#cancelPayButton").hide();
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
		     $("#resetSearch").click(function(){
		    	$("#searchInput").val("");
		    	$("tbody tr").show();
		    	$("#noDataMessage").text("");
	   		 });
		});
		