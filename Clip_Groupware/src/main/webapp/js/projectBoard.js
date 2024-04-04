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
		  title: "Are you sure?",
		  text: "You won't be able to revert this!",
		  icon: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#3085d6",
		  cancelButtonColor: "#d33",
		  confirmButtonText: "Yes, delete it!"
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
					      title: "Deleted!",
					      text: "Your file has been deleted.",
					      icon: "success"
					    });
		    
					} else if(result < 0) {
						console.log('삭제권한없음!');
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
			url: "./getDetailBottomList.do",
			type: "get",
	        data : {prjId : prjId, pboProgress : pboProg},
            dataType:"json",
			success: function(data) {
				console.log(data);
				if(data.length>0) {
					var listData = data; // 받아온 데이터를 listData 변수에 저장합니다.   	
					console.log('불러오기 성공!');
					console.log(listData);
					
					//listData 가 정상적으로 나오면, 하단 tr td 태그를 생성하는 소스를 짜야함
					
	};
}
})
}