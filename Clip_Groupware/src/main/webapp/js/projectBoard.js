$(document).ready(function() {
	
	selectBoardList();

	
	// 삭제권한 없는 인간은 아이콘 안보여줌
	var managerId = $("#prjManager").val();
	console.log('매니저아이디 : '+managerId);
	var loginUserId = $("#loginUserId").val();
	console.log('로그인한유저아이디 : '+loginUserId);
	if (managerId !== loginUserId) {
		$("#deletePrjTopBtn").hide();
		$("#updatePrjTopBtn").hide();
	}
	
	// 모달창 등록 버튼 추가		
	$("#pboInsertBtn").on("click", function(){
		
		var progressVal = $(".nav-link.active").text();	
		$('#pboProgress').val(progressVal);
		
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
				    $("#pboTitle").val('');
          			$("#pboContent").val('');
				    
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
	
	//최하단 상태 업데이트 버튼 statusUpdateBtn
	$("#statusUpdateBtn").on("click", function(){
		
		var prjId = $("#prjId").val();
		var progressVal = $(".nav-link.active").text();
		var pboProgress = '';
		// deptSeq는 권한을 확인하기 위한 로그인한 유저의 
		var deptSeq = '';
		
		switch (progressVal) {
		    case '영업팀':
		        pboProgress = '디자인팀';
		        deptSeq = 'DEPT_5';
		        break;
		    case '디자인팀':
		        pboProgress = '설계팀';
		        deptSeq = 'DEPT_1';
		        break;
		    case '설계팀':
		        pboProgress = '공무팀';
		        deptSeq = 'DEPT_2';
		        break;
		    case '공무팀':
		        pboProgress = '시공팀';
		        deptSeq = 'DEPT_3';
		        break;
		    default:
		        pboProgress = '관리팀';
		        deptSeq = 'DEPT_4';
		}

		var statusVal = '';
		
		if(progressVal=='관리팀') {
			statusVal = '완료';
		} else {
			statusVal = '진행중';
		}
		
		
		// ajax호출
		
		var formData = {
			prjId : prjId,
			pboProgress : pboProgress,
			prjStatus : statusVal,
			deptSeq :deptSeq
		};
		$.ajax({
			type:"post",
			url:"./updatePrjStatus.do",
			data:formData,
			success:function(result){
				console.log(result);
				if(result>0) {
					console.log('수정 성공');
				} else {
					console.log('수정권한 없음');
					// 성공시에 sweetAlert로 바꿔주기
				}

			}, error: function(error) {
				console.log('에러시러요');
			}
		});
		
	});
})

function selectBoardList() {
	
	//아이디 찾아오기
	var prjId = $("#prjId").val();
	
	//진행단계 찾아오기 -> 활성화된 탭의 이름을 추가
	var pboProg = $(".nav-link.active").text();
	
	console.log('지금 클릭한 탭은 : '+pboProg);
		$.ajax({
			type: "get",
			url: "./getDetailBottomList.do",
            dataType:"json",
	        data : {prjId : prjId, pboProgress : pboProg},
			success: function(data) {
				console.log(data);
				
				var tableBody = $("tbody");
				tableBody.empty(); // tbody 비우기
	
				for (var i = 0; i < Math.min(data.length, 11); i++) {
				    var projectTable = data[i];
				    var tr = $("<tr>").addClass("seq").attr("data-seq", projectTable.PBO_SEQ);
				    tr.append($("<td>").addClass("PBO_SEQ").text(projectTable.PBO_SEQ));
				    tr.append($("<td>").addClass("USER_ID").text(projectTable.USER_ID));
				    tr.append($("<td>").addClass("PBO_TITLE").text(projectTable.PBO_TITLE));
				    tr.append($("<td>").addClass("PBO_CONTENT").text(projectTable.PBO_CONTENT));
				    tr.append($("<td>").addClass("PBO_REGDATE").text(projectTable.PBO_REGDATE));
				
				
				    // Delete 버튼
				    var deleteButton = $("<button>").attr("type", "button").addClass("btn btn-outline-danger");
				    deleteButton.append($("<i>").addClass("bi bi-trash"));
				    var deleteTd = $("<td>").css({"text-align": "center", "width": "60px"}).append(deleteButton);
				    tr.append(deleteTd);
				
				    tableBody.append(tr);
				
				    // Delete 버튼 클릭 이벤트 처리
				    deleteButton.click(deleteBoardBtn(projectTable.PBO_SEQ, projectTable.USER_ID));
	
				}

		}, error: function(error) {
				console.log('에러시러요');
		}
})
}


function deleteBoardBtn(seq, regId) {
	return function() {
        // 여기에 Delete 버튼을 클릭했을 때 할 작업을 작성하세요.
        // 예: 해당 행을 삭제하는 등의 작업
        console.log("삭제클릭했음!!!!!!");
        console.log("삭제할 데이터의 PBO_SEQ:", seq);
        console.log("해당 게시물 등록한 reg id는 :", regId);
        // seq전달해서 아작스로 호출하기
        
        //권한판별
        var loginUserId = $("#loginUserId").val();
		console.log('로그인한유저아이디 : '+loginUserId);
        
        // 등록한 아이디와 로그인 아이디가 같을때만 삭제가능
        if(regId == loginUserId) {
			console.log('아작스 태워야함');
			
			// 프로젝트 아이디 찾아오기
			var prjId = $("#prjId").val();
			
			Swal.fire({
			  title: "게시글을 삭제하시겠습니까?",
			  text: "삭제 후 모든 데이터는 사라집니다.",
			  icon: "warning",
			  showCancelButton: true,
			  confirmButtonColor: "#3085d6",
			  cancelButtonColor: "#d33",
			  confirmButtonText: "게시글 삭제"
			}).then((result) => {
			  if (result.isConfirmed) {
				
				$.ajax({
					type:"get",
					url:"./deletePrjDetailBottom.do",
					data:{pboSeq:seq, regId:regId},
					success:function(result){
						console.log(result);
						if(result>0) {
							console.log('삭제성공!');
		
						    //인풋칸 초기화해주는 구문 추가
						    $("#pboTitle").val('');
                  			$("#pboContent").val('');
						    
						    //하단 목록 재조회
				    		selectBoardList();
						    
						    Swal.fire({
						      title: "게시글이 삭제되었습니다.",
						      text: "게시글이 삭제되었습니다.",
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
				
			
		} else {
			Swal.fire({
			  icon: "error",
			  title: "삭제실패",
			  text: "권한이 없습니다.!",
			});
			return;
		}

    };
}



function settingTab() {
	//인풋칸 초기화해주는 구문 추가
    $("#pboTitle").val('');
	$("#pboContent").val('');
    
    //하단 목록 재조회
	selectBoardList();
}


