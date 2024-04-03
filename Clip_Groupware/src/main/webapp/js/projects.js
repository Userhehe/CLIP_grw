
$(document).ready(function() {
	
	
	selectProjectListAll();

	// 라디오 버튼 값에 따라서 이벤트 발생

	$('input[name="gridRadios"]').change(function() {	
		selectPrjProgressList();
	});
	
	//cliSrchBtn 버튼 이벤트 발생
	$("#cliSrchBtn").on("click", function() {

 		var clientNm = $("#ClientName").val();
        console.log("입력한 발주처 : "+ clientNm);
        
        selectClientList(clientNm);
    });

	// 기간 검색 버튼 이벤트 발생
	$("#periodSrchBtn").on("click", function(){
	
		var startDate = $("#prjStartDate").val();
		var endDate = $("#prjEndDate").val();
		console.log("입력한 기간 : " + startDate, endDate);
		
		if(!startDate) {
			console.log("시작일자없음");
			return;
		}
		if(!endDate){
			console.log("종료일자없음");
			return;
		}
		
		selectPrjPeriod(startDate, endDate);
		
	});
	
	// 모달창 등록 버튼 추가		
	$("#prjInsertBtn").on("click", function(){
		
		var formData = $('#newProject').serialize();
		
		
		console.log("모달 세이브세이브");
		console.log(formData);
		$.ajax({
			type:"post",
			url:"./insertProject.do",
			data:formData,
			success:function(result){
				console.log(result);
				if(result>0) {
					console.log('등록성공!');
					//모달 닫기해야함
					$("#verticalycentered").modal("hide");
					selectProjectListAll();
					//인풋칸 초기화해주는 구문 추가
					    $("#newProject :input").each(function() {
				        // 각 필드의 값을 빈 문자열로 설정합니다.
				        $(this).val("");
				    });
				} else {
					console.log('error!');
				}
			}
		});
			
	});
});

function selectProjectListAll() {
	
	var paramData = '';
	
	var progressVal = $('input[name="gridRadios"]:checked').val();
	if(progressVal) {
		console.log('선택된 옵션:', progressVal);
		  
		var statusVAl = '';
		if(progressVal==="option1"){
			// PRJ_STATUS 가 option1
			statusVAl = '진행중';
		} else {
			// PRJ_STATUS 가 option2
			statusVAl = '완료';
		}
		paramData = {prjStatus:statusVAl};
	}
	
	var clientVal = $("#ClientName").val();
	if(clientVal) {
		console.log('발주처 이름 :'+ clientVal);

		paramData = {clientNm:clientVal};
	}
	
	
	var startVal = $("#prjStartDate").val();
	var endVal = $("#prjEndDate").val();
	
	if(startVal) {
		console.log('시작 검색일 :'+ startVal);
		console.log('종료 검색일 :'+ endVal);
		paramData = {startDate:startDate, endDate:endDate}
	};
	  
  	// 이벤트 처리 등 추가 작업 가능
	$.ajax({
		url: "./getProgressList.do",
		type: "get",
        data : paramData,
        dataType:"json",         
		success: function(data) {
			console.log(data);
			if(data.length>0) {
				var listData = data; // 받아온 데이터를 listData 변수에 저장합니다.
		
			// 리스트를 순회하면서 HTML에 추가합니다.
			var $listContainer = $(".container .row");
			// 리스트 컨테이너를 초기화합니다.
			$listContainer.empty();
			var existingProjects = {}; // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
			
			$.each(listData, function(index, data) {
			    var prjId = data.PRJ_ID;
			    var userName = data.USER_NAME;
			
			    // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
			    if (existingProjects.hasOwnProperty(prjId)) {
			        // 기존에 있는 프로젝트에 참여자 정보를 추가합니다.
			        var existingProject = existingProjects[prjId];
			        existingProject.USER_NAME.push(userName);
			    } else {
			        // 새로운 프로젝트 정보를 추가합니다.
			        existingProjects[prjId] = data;
			        existingProjects[prjId].USER_NAME = [userName]; // 참여자 정보를 배열로 초기화합니다.
			    }
			});
			
			// 기존의 프로젝트 정보를 기반으로 HTML을 생성합니다.
			$.each(existingProjects, function(prjId, projectData) {
			    var $projectItem = $("<div>").addClass("col-md-4").css("width", "20%");
			    var $cardBody = $("<div>").addClass("card-body").css({
			        "margin-top": "30px",
			        "background-color": "white",
			        "height": "230px",
			        "width": "100%",
			        "border-radius": "20px"
			    });
			    var $cardTitle = $("<div>").addClass("card-title");
			    var $clientNameSpan = $("<span>").text("[" + projectData.CLI_NAME + "]").css({
			        "font-weight": "bold",
			        "font-size": "17px"
			    });
			    var $projectNameDiv = $("<div>").text(projectData.PRJ_NAME).css("margin-top", "5px");
			    var $participantName = $("<div>").addClass("participant").css("margin-top", "5px");
			
			    // 참여자 정보를 콤마로 구분하여 합칩니다.
			    var joinedUserNames = projectData.USER_NAME.join(", ");
			    $participantName.text("참여자: " + joinedUserNames);
			
			    var $detailButton = $("<button>").addClass("btn btn-secondary").attr("type", "button").text("상세보기").css("margin-right", "15px")
				    .click(function() {
				        location.href = 'projectDetail.do?project_id=' + prjId;
				    });
			
			    $cardTitle.append($clientNameSpan, "<br>", $projectNameDiv);
			    $cardBody.append($cardTitle, $participantName, $detailButton);
			    $projectItem.append($cardBody);
			    $listContainer.append($projectItem);
			});

			} else {
				// 리스트 컨테이너를 초기화합니다.
				var $listContainer = $(".container .row");
				$listContainer.empty();
			}

		},
		error: function(error) {
			console.log('에러시러요');
		}
	});

}


function selectPrjProgressList() {
	 var selectedValue = $('input[name="gridRadios"]:checked').val();
	  console.log('선택된 옵션:', selectedValue);
	  
	  var statusVAl = '';
	  if(selectedValue==="option1"){
		// PRJ_STATUS 가 option1
			statusVAl = '진행중';
		} else {
		// PRJ_STATUS 가 option2
			statusVAl = '완료';
		}
	  
	  	// 이벤트 처리 등 추가 작업 가능
		$.ajax({
			url: "./getProgressList.do",
			type: "get",
	        data : {prjStatus:statusVAl},
            dataType:"json",         
			success: function(data) {
				console.log(data);
				if(data.length>0) {
					var listData = data; // 받아온 데이터를 listData 변수에 저장합니다.
			
				// 리스트를 순회하면서 HTML에 추가합니다.
				var $listContainer = $(".container .row");
				// 리스트 컨테이너를 초기화합니다.
				$listContainer.empty();
				var existingProjects = {}; // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
				
				$.each(listData, function(index, data) {
				    var prjId = data.PRJ_ID;
				    var userName = data.USER_NAME;
				
				    // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
				    if (existingProjects.hasOwnProperty(prjId)) {
				        // 기존에 있는 프로젝트에 참여자 정보를 추가합니다.
				        var existingProject = existingProjects[prjId];
				        existingProject.USER_NAME.push(userName);
				    } else {
				        // 새로운 프로젝트 정보를 추가합니다.
				        existingProjects[prjId] = data;
				        existingProjects[prjId].USER_NAME = [userName]; // 참여자 정보를 배열로 초기화합니다.
				    }
				});
				
				// 기존의 프로젝트 정보를 기반으로 HTML을 생성합니다.
				$.each(existingProjects, function(prjId, projectData) {
				    var $projectItem = $("<div>").addClass("col-md-4").css("width", "20%");
				    var $cardBody = $("<div>").addClass("card-body").css({
				        "margin-top": "30px",
				        "background-color": "white",
				        "height": "230px",
				        "width": "100%",
				        "border-radius": "20px"
				    });
				    var $cardTitle = $("<div>").addClass("card-title");
				    var $clientNameSpan = $("<span>").text("[" + projectData.CLI_NAME + "]").css({
				        "font-weight": "bold",
				        "font-size": "17px"
				    });
				    var $projectNameDiv = $("<div>").text(projectData.PRJ_NAME).css("margin-top", "5px");
				    var $participantName = $("<div>").addClass("participant").css("margin-top", "5px");
				
				    // 참여자 정보를 콤마로 구분하여 합칩니다.
				    var joinedUserNames = projectData.USER_NAME.join(", ");
				    $participantName.text("참여자: " + joinedUserNames);
				
				    var $detailButton = $("<button>").addClass("btn btn-secondary").attr("type", "button").text("상세보기").css("margin-right", "15px")
				    .click(function() {
				        location.href = 'projectDetail.do?project_id=' + prjId;
				    });
				
				    $cardTitle.append($clientNameSpan, "<br>", $projectNameDiv);
				    $cardBody.append($cardTitle, $participantName, $detailButton);
				    $projectItem.append($cardBody);
				    $listContainer.append($projectItem);
				});

				}  else {
					// 리스트 컨테이너를 초기화합니다.
					var $listContainer = $(".container .row");
					$listContainer.empty();
				}

			},
			error: function(error) {
				console.log('에러시러요');
			}
		});

}

function selectClientList(clientNm) {
		  	// 이벤트 처리 등 추가 작업 가능
		$.ajax({
			url: "./getProgressList.do",
			type: "get",
	        data : {clientNm:clientNm},
            dataType:"json",         
			success: function(data) {
				console.log(data);
				if(data.length>0) {
					var listData = data; // 받아온 데이터를 listData 변수에 저장합니다.
			
				// 리스트를 순회하면서 HTML에 추가합니다.
				var $listContainer = $(".container .row");
				// 리스트 컨테이너를 초기화합니다.
				$listContainer.empty();
				var existingProjects = {}; // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
				
				$.each(listData, function(index, data) {
				    var prjId = data.PRJ_ID;
				    var userName = data.USER_NAME;
				
				    // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
				    if (existingProjects.hasOwnProperty(prjId)) {
				        // 기존에 있는 프로젝트에 참여자 정보를 추가합니다.
				        var existingProject = existingProjects[prjId];
				        existingProject.USER_NAME.push(userName);
				    } else {
				        // 새로운 프로젝트 정보를 추가합니다.
				        existingProjects[prjId] = data;
				        existingProjects[prjId].USER_NAME = [userName]; // 참여자 정보를 배열로 초기화합니다.
				    }
				});
				
				// 기존의 프로젝트 정보를 기반으로 HTML을 생성합니다.
				$.each(existingProjects, function(prjId, projectData) {
				    var $projectItem = $("<div>").addClass("col-md-4").css("width", "20%");
				    var $cardBody = $("<div>").addClass("card-body").css({
				        "margin-top": "30px",
				        "background-color": "white",
				        "height": "230px",
				        "width": "100%",
				        "border-radius": "20px"
				    });
				    var $cardTitle = $("<div>").addClass("card-title");
				    var $clientNameSpan = $("<span>").text("[" + projectData.CLI_NAME + "]").css({
				        "font-weight": "bold",
				        "font-size": "17px"
				    });
				    var $projectNameDiv = $("<div>").text(projectData.PRJ_NAME).css("margin-top", "5px");
				    var $participantName = $("<div>").addClass("participant").css("margin-top", "5px");
				
				    // 참여자 정보를 콤마로 구분하여 합칩니다.
				    var joinedUserNames = projectData.USER_NAME.join(", ");
				    $participantName.text("참여자: " + joinedUserNames);
				
				    var $detailButton = $("<button>").addClass("btn btn-secondary").attr("type", "button").text("상세보기").css("margin-right", "15px").click(function() {
				        location.href = 'projectDetail.do?project_id=' + prjId;
				    });
				
				    $cardTitle.append($clientNameSpan, "<br>", $projectNameDiv);
				    $cardBody.append($cardTitle, $participantName, $detailButton);
				    $projectItem.append($cardBody);
				    $listContainer.append($projectItem);
				});

				} else {	
					// 리스트 컨테이너를 초기화합니다.
					var $listContainer = $(".container .row");
					$listContainer.empty();
					
				} 

			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
}

function selectPrjPeriod(startDate, endDate) {
	
	// 내가만든거
	
	  	// 이벤트 처리 등 추가 작업 가능
		$.ajax({
			url: "./getProgressList.do",
			type: "get",
	        data : {startDate:startDate, endDate:endDate},
            dataType:"json",         
			success: function(data) {
				console.log(data);
				if(data.length>0) {
					var listData = data; // 받아온 데이터를 listData 변수에 저장합니다.
			
				// 리스트를 순회하면서 HTML에 추가합니다.
				var $listContainer = $(".container .row");
				// 리스트 컨테이너를 초기화합니다.
				$listContainer.empty();
				var existingProjects = {}; // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
				
				$.each(listData, function(index, data) {
				    var prjId = data.PRJ_ID;
				    var userName = data.USER_NAME;
				
				    // PRJ_ID를 키로 사용하여 기존의 프로젝트 정보를 관리합니다.
				    if (existingProjects.hasOwnProperty(prjId)) {
				        // 기존에 있는 프로젝트에 참여자 정보를 추가합니다.
				        var existingProject = existingProjects[prjId];
				        existingProject.USER_NAME.push(userName);
				    } else {
				        // 새로운 프로젝트 정보를 추가합니다.
				        existingProjects[prjId] = data;
				        existingProjects[prjId].USER_NAME = [userName]; // 참여자 정보를 배열로 초기화합니다.
				    }
				});
				
				// 기존의 프로젝트 정보를 기반으로 HTML을 생성합니다.
				$.each(existingProjects, function(prjId, projectData) {
				    var $projectItem = $("<div>").addClass("col-md-4").css("width", "20%");
				    var $cardBody = $("<div>").addClass("card-body").css({
				        "margin-top": "30px",
				        "background-color": "white",
				        "height": "230px",
				        "width": "100%",
				        "border-radius": "20px"
				    });
				    var $cardTitle = $("<div>").addClass("card-title");
				    var $clientNameSpan = $("<span>").text("[" + projectData.CLI_NAME + "]").css({
				        "font-weight": "bold",
				        "font-size": "17px"
				    });
				    var $projectNameDiv = $("<div>").text(projectData.PRJ_NAME).css("margin-top", "5px");
				    var $participantName = $("<div>").addClass("participant").css("margin-top", "5px");
				
				    // 참여자 정보를 콤마로 구분하여 합칩니다.
				    var joinedUserNames = projectData.USER_NAME.join(", ");
				    $participantName.text("참여자: " + joinedUserNames);
				
				    var $detailButton = $("<button>").addClass("btn btn-secondary").attr("type", "button").text("상세보기").css("margin-right", "15px").click(function() {
				        location.href = 'projectDetail.do?project_id=' + prjId;
				    });
				
				    $cardTitle.append($clientNameSpan, "<br>", $projectNameDiv);
				    $cardBody.append($cardTitle, $participantName, $detailButton);
				    $projectItem.append($cardBody);
				    $listContainer.append($projectItem);
				});

				} else {
					// 리스트 컨테이너를 초기화합니다.
					var $listContainer = $(".container .row");
					$listContainer.empty();
				}

			},
			error: function(error) {
				console.log('에러시러요');
			}
		});
}




   
   
   