$(document).ready(function() {
	
	selectBoardList();
	
	// 삭제권한 없는 인간은 아이콘 안보여줌
	
	// 매니저 아이디 가져오기
	var managerId = $("#prjManager").val();
	console.log('매니저아이디 : '+managerId);
	var loginUserId = $("#loginUserId").val();
	console.log('로그인한유저아이디 : '+loginUserId);
	if (managerId !== loginUserId) {
		$("#deletePrjTopBtn").hide();
	}
	
	// 모달창 등록 버튼 추가		
	$("#pboInsertBtn").on("click", function(){
		
		var formData = $('#insertProjectBoard').serialize();
		
		
		console.log("프로젝트보드 세이브세이브");
		console.log(formData);
		$.ajax({
			type:"post",
			url:"./insertProjectBoard.do",
			data:formData,
			success:function(result){
				console.log(result);
				if(result>0) {
					console.log('등록성공!');

					//인풋칸 초기화해주는 구문 추가
					 $("#insertProjectBoard :input").each(function() {
				        // 각 필드의 값을 빈 문자열로 설정합니다.
				        $(this).val("");
				    });
				    //하단 목록 재조회
				    selectBoardList();
				} else {
					console.log('error!');
				}
			}
		});
			
	});
	
	
	// 상위 삭제버튼 deletePrjTopBtn
	$("#deletePrjTopBtn").on("click", function(){
		
		// 프로젝트 아이디 찾아오기
		var prjId = $("#prjId").val();
		
		// 매니저 아이디 가져오기
		var managerId = $("#prjManager").val();
		
		//넘겨줘야할 데이터 prj id

		Swal.fire({
		  title: "프로젝트를 삭제하시겠습니까?",
		  text: "삭제 후 모든 데이터는 사라집니다.",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "프로젝트 삭제"
		}).then((result) => {
		  if (result.isConfirmed) {
			
			$.ajax({
				type:"get",
				url:"./deletePrjDetailTop.do",
				data:{prjId:prjId, prjManager: managerId},
				success:function(result){
					console.log(result);
					if(result>0) {
						console.log('삭제성공!');
	
						//메인 화면으로 넘어가세요
					    location.href = 'projectsProgress.do';
					    
					    Swal.fire({
					      title: "프로젝트가 삭제되었습니다.",
					      text: "프로젝트가 삭제되었습니다.",
					      icon: "success"
					    });
		    
					} else if(result < 0) {
						console.log('삭제 할 권한이 없습니다.');
					} else {
						console.log('error!');
					}
				}
			});
			
			

		  }
		});


		
	});
})

function selectBoardList() {
	
	//아이디 찾아오기
	var prjId = $("#prjId").val();
	
	//진행단계 찾아오기
	var pboProg =  $("#sales-tab").text();
	
		$.ajax({
			type: "get",
			url: "./getDetailBottomList.do",
            dataType:"json",
	        data : {prjId : prjId, pboProgress : pboProg},
			success: function(data) {
				console.log(data);
				
				var tableBody = $("#detailBottomList");
				tableBody.empty();

				for (var i = 0; i < Math.min(data.length, 11); i++) {
					var projectTable = data[i];
					var tr = $("<tr>").addClass("seq").attr("data-seq", projectTable.PBO_SEQ);
					tr.append($("<td>").addClass("USER_ID").text(projectTable.USER_ID));
					tr.append($("<td>").addClass("PBO_TITLE").text(projectTable.PBO_TITLE));
					tr.append($("<td>").addClass("PBO_CONTENT").text(projectTable.PBO_CONTENT));
					tr.append($("<td>").addClass("PBO_REGDATE").text(projectTable.PBO_REGDATE));

					tableBody.append(tr);

//					tr.click(function() {
//						var seq = $(this).attr("data-seq");
//						console.log("클릭한 시퀀스 값:", seq);
//						calendarModalDetail(seq);
//					});
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				

}
})
}
