
$(document).ready(function() {
	
	//dateTimePicker 날짜-------------------------------------------------
	$("#re_start").datetimepicker({
		format: "Y-m-d",
	});
	// 언어를 한국어로 변경
	$.datetimepicker.setLocale('ko');
	//input 태그 클릭시 이벤트 처리
	$("#re_start").datetimepicker({
		// 시간 선택 비활성화
		timepicker: false,
		// 0: 일요일, 6: 토요일 // 주말 선택 불가
		disabledWeekDays: [0, 6],
		// 오늘 이후 날짜만 선택 가능
		minDate: 0,
	});

	//클릭시 창활성화
	$("#re_start").datetimepicker({});

	$("#re_start_img").click(function() {
		$("#re_start").datetimepicker('show');
	});


	//dateTimePicker 시간-------------------------------------------------
		$("#re_start_time").datetimepicker({
			format: "H:00",
		});
	//input 태그 클릭시 이벤트 처리
	$("#re_start_time").datetimepicker({
		datepicker: false,
	});

	//클릭시 창활성화
	$("#re_start_time").datetimepicker({});

	$("#re_start_time_img").click(function() {
		$("#re_start_time").datetimepicker('show');
	});
	
	
	
	//jstree 참석자-----------------------------------
		
	//데이터 jstree형식으로 바꿔 줄꺼는 놈 정의
	function convertData(data) {
		var jstreeData = [];
		data.forEach(function(item) {
			jstreeData.push({
				"id": item.user_id,
				"parent": item.dept_seq,
				"text": item.user_name+" "+item.ranks_name
			});
		});
		jstreeData.push({"id":"DEPT_001","parent":"#","text":"디자인","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_002","parent":"#","text":"설계","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_003","parent":"#","text":"공무","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_004","parent":"#","text":"시공","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_005","parent":"#","text":"영업","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_006","parent":"#","text":"관리","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_007","parent":"#","text":"인사","state":{"opened":false}});
		
		return jstreeData;
	}
	
	//데이터 받아오는 아작스 
	function initializeJSTree() {
		$.ajax({
			url: './selectAttendsJstree.do',
			dataType: 'json',
			success: function(data) {
				var jstreeData = convertData(data);
				$('#selectAttendsJstree').jstree({
					'core': {
						'data': jstreeData
					},//코어 영역끝

					checkbox: {
						three_state: false
						
					},
					search: {
						'case_insensitive': true,
						'show_only_matches': true
					},

					plugins: ["search", "checkbox"]

				});
			}//success끝나는 부분
		});//ajax끝나는 부분
	}
	//아작스 실행하는 놈
	initializeJSTree();
	
	// 검색창 글자 입력하면 나오는놈
	$('#selectAttendsJstree_search').keyup(function() {
		$('#selectAttendsJstree').jstree(true).show_all();
		$('#selectAttendsJstree').jstree('search', $(this).val());
	});
	

	
	//jstree-----------------------------------
	

	//예약 등록 버튼-----------------------------------
	$("#addReservation").click(function() {
		var selectedNodes = $('#selectAttendsJstree').jstree('get_selected', true);
		var selectedNodeIds = selectedNodes.map(function(node) {
			return node.id;
		});
		console.log("선택된 항목 ID: " + selectedNodeIds.join(", "));
		
		var attendV = selectedNodeIds.join(",");
		var attends = attendV.split(",");
		var attendsReal = {"Attend": []};

		if (attends !== null) {
		    for (var i = 0; i < attends.length; i++) {
				if(attends[i].includes("USER")){
			        var attend = attends[i];
			        attendsReal["Attend"].push({"attend": attend});
				}
		      
		    }
		}

		attendsReal = JSON.stringify(attendsReal);
		
		document.getElementById("re_attend").value = attendsReal;
		
		
	  	var me_room = document.getElementById("me_room").value;
		var re_start = document.getElementById("re_start").value;
		var re_start_time = document.getElementById("re_start_time").value;
		var re_title = document.getElementById("re_title").value;
		var re_content = document.getElementById("re_content").value;
		var re_attend = document.getElementById("re_attend").value;
		
		if (me_room == null || me_room == "") {
			alert("회의실을 선택하세요.");
		} else if (re_start == null || re_start == "") { 
			alert("예약일을 선택하세요.");
		} else if (re_start_time == null || re_start_time == "") { 
			alert("예약시간을 선택하세요.");
		}  else if (re_title == null || re_title == "") { 
			alert("회의 주제를 작성해주세요.");
		} else if (re_content == null || re_content == "") { 
			alert("회의 내용을 작성해주세요.");
		} else if (re_attend == null || re_attend == "" ||re_attend == '{"Attend":[{"attend":""}]}') {  
			alert("회의 참석자를 선택하세요.");
		}
		 else {
			datata = $("#reservationForm").serialize();
			
			$.ajax({
				type: "POST",
				url:"./myReservationInsert.do",
				data:datata,
				success:function(data){
					if(data!=1){
						alert("예약 실패");
						return false;
					}else{
						alert("예약 성공");
						$("#reservationForm")[0].reset();
						$('#selectAttendsJstree').jstree("deselect_all");
						$("#selectAttendsJstree").jstree("close_all");
						$("#reservationModal").modal("hide");
					}
				},error: function() {
						alert("서버 에러");
					}
			});		
		}		
	});
	
	$("#addReservationCancel").click(function() {
		$("#reservationForm")[0].reset();
		$('#selectAttendsJstree').jstree("deselect_all");
		$("#selectAttendsJstree").jstree("close_all");
		$("#reservationModal").modal("hide");
	});
	$('#reservationModal').modal({
        backdrop: 'static',
        keyboard: false
    });
	
});
// 예약가능시간 조회
function selectPossibleMeRoomButton() {
	var me_room = document.getElementById("me_room").value;
	var re_start = document.getElementById("re_start").value;

	$.ajax({
		type: "POST",
		url: './selectPossibleMeRoom.do',
		data: { "me_room": me_room, "re_start": re_start },
		success: function(data) {
			console.log("반환 값", data);
			$("#nawarayo").show();
			
			
			data.forEach(function(item) {
				console.log(item);
			});
			$("#re_start_time").datetimepicker({
				allowTimes: data
			});
		}
	});
}
//예약 일 + 시간 
function reservationTime(){
	var day = document.getElementById("re_start").value;
	var time = document.getElementById("re_start_time").value;
	
	console.log("나온나", day, time);
	document.getElementById("re_start").value = day + " " +time;
	$("#nawarayo").hide();
}

function reservationModal(){
	console.log("모달나온나");
	$("#reservationModal").modal("show");
}




