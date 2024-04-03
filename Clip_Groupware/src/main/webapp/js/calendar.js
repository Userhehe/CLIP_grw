var selectScheduleAll = true;
var selectScheduleAllDate = "";
////화면 로드시 걸어주는 이벤트들 ------------------------------------------------
$(document).ready(function() {
	
	//화면 로드시 체크박스 상태 확인 하는 기능------------------------------------------------
	function updateType() {
        var type = [];
        if ($('#showPrs').prop('checked')) {
            type.push(1);
        }
        if ($('#showNct').prop('checked')) {
            type.push(2);
        }
        if ($('#showRe').prop('checked')) {
            type.push(3);
        }
        if ($('#showAn').prop('checked')) {
            type.push(4);
        }
        return type.length > 0 ? type.join(',') : 5;
    }
    
    var initialType = updateType();
    
	calendar(initialType);
	
    $('#showPrs, #showNct, #showRe, #showAn').change(function() {
		selectScheduleAll = false;
		var type = updateType();
        calendar(type);
    });
    
    $('#showPrs, #showNct, #showRe, #showAn').change(function() {
	    if ($('#showPrs').prop('checked') && $('#showNct').prop('checked') &&
	     	$('#showRe').prop('checked') && $('#showAn').prop('checked')) {
	
	        $('#showAllEvent').prop('checked', true);
	        
	    } else {
		
			$('#showAllEvent').prop('checked', false);
			
				}
	});
	
	$('#showAllEvent').change(function() {
	        var isChecked = $(this).prop('checked');
	        //해제
	        if (!isChecked) {
			$('#showPrs, #showNct, #showRe, #showAn').prop('checked', false);
			selectScheduleAll = false;
			var type = updateType();
        	calendar(type);
	        //체크
	        } else {
			$('#showPrs, #showNct, #showRe, #showAn').prop('checked', true);
			selectScheduleAll = false;
			var type = updateType();
        	calendar(type);
	        }
	    });
	//화면 로드시 체크박스 상태 확인 하는 기능 끝------------------------------------------------
	
	
	//DateTimePicker 설정------------------------------------------------
    $.datetimepicker.setLocale('ko');
    $("#start, #end, #upStart, #upEnd").datetimepicker({
        disabledWeekDays: [0, 6],
        minDate: 0,
        allowTimes: ['09:00', '09:30', '10:00', '10:30', 
			        	'11:00', '11:30', '12:00', '12:30',
			            '13:00', '13:30', '14:00', '14:30', 
			            '15:00', '15:30', '16:00', '16:30', 
			            '17:00', '17:30', '18:00']
    });
    //DateTimePicker 설정 끝------------------------------------------------
    
    //모달창 뒤로가기 막기 설정 끝------------------------------------------------
    $('#calendarModal, #calendarModalDetail, #calendarModalUpdate').modal({
        backdrop: 'static',
        keyboard: false
    });
    //모달창 뒤로가기 막기 설정------------------------------------------------
});
//화면 로드시 걸어주는 이벤트들 끝 ------------------------------------------------

//calendar function ----------------------------
function calendar(type){
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
		locale: 'ko',
		dayMaxEventRows: true,
		height: 800,
        initialView: 'dayGridMonth',
        droppable: false,
        editable: false,
        displayEventTime: false,
        customButtons: {
            addEventButton: {
                text: "일정 추가",
                click: function() {
                    calendarModal("");
                },
            }
        },
        headerToolbar: {
            center: 'title',
            left: 'dayGridMonth,timeGridWeek,timeGridDay,addEventButton'
        },
        dateClick: function(info) {
			var clickedDate = info.date;
        	var dayOfWeek = clickedDate.getDay();
        	if (dayOfWeek >= 1 && dayOfWeek <= 5) {
				var today = new Date();
				var yesterday = new Date(today);
				yesterday.setDate(today.getDate() - 1);
			    if (clickedDate < yesterday && $('#user_auth').val() == 'ROLE_ADMIN') {
			        return;
			    }
			    var year = clickedDate.getFullYear();
				var month = clickedDate.getMonth() + 1; 
				var dayday = clickedDate.getDate();
				
			    var day = year + '-' + month + '-' + dayday;
			    calendarModal(day);
	        }
        },
        titleFormat: function(date) {
            return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
        },
        eventClick: function(info) {
			if(info.el.classList.contains('annual_event')||info.el.classList.contains('koHol')){
				return false;
			}
            var seq = info.event.extendedProps.seq;
            calendarModalDetail(seq);
        },
        eventDidMount: function(info) {
				$('.koHol').click(function(event) {
			        event.preventDefault();
			    });
        },
        eventSources: [
		{
			googleCalendarApiKey:'AIzaSyCGXimE4uA8rNgGcVRCutS94Drt6rkPUQc',
			googleCalendarId: "ko.south_korea.official#holiday@group.v.calendar.google.com", 
			className: "koHol", 
			color: "red", 
			textColor: "white"
		},
		{
            id: "allEvents",
            events: function(info, successCallback, failureCallback) {
				if(selectScheduleAll == true){
					var year = info.start.getFullYear();
					var startMonth = info.start.getMonth();
					var endMonth = info.end.getMonth();
					var month = endMonth - startMonth;
					
					if(month<0){
						month+=12;
					}
					
					var nextMonth = (startMonth + month)%12;
					
					if(nextMonth ===0){
						nextMonth = 12;
					}
					
					if(nextMonth === 1&&month !==0){
						year+=1;
					}
					
					var formattedNextMonth = ('0'+nextMonth).slice(-2);
					var date = year + '-' + formattedNextMonth;
					selectScheduleAllDate = date
					console.log("날짜값 : ",date);
	                $.ajax({
	                    type: "get",
	                    url: "./selectScheduleAll.do",
	                    data : {date:date, type:type},
	                    dataType:"json",
	                    success: function(data) {
							if(data.length == 0||data == null){
								console.log("조회내용 없음");
								successCallback(data);
							}else{
								var events = [];
		                        data.forEach(function(event) {
		                            var fcEvent = {
		                                title: event.title,
		                                start: event.start,
		                                end: event.end,
		                                seq: event.seq,
		                                className: event.seq.includes('USERSCHEDULE') ?
		                                			'memo_event' : event.seq.includes('NTCSCHEDULE') ?
		                                			'nct_event' : event.seq.includes('RESERVATION') ? 
		                                			'reser_event':'annual_event'
		                            };
		                            events.push(fcEvent);
		                        });
		                        successCallback(events);
							}
	                        
	                    },
	                    error: function() {
	                        failureCallback();
	                        alert("일정을 불러오는데 실패했습니다.");
	                    }
	                });
				}else{
					var date = selectScheduleAllDate;
					console.log("날짜값 : ",date);
	                $.ajax({
	                    type: "get",
	                    url: "./selectScheduleAll.do",
	                    data : {date:date, type:type},
	                    dataType:"json",
	                    success: function(data) {
							if(data.length == 0||data == null){
								successCallback(data);
								console.log("조회내용 없음");
							}else{
								var events = [];
		                        data.forEach(function(event) {
		                            var fcEvent = {
		                                title: event.title,
		                                start: event.start,
		                                end: event.end,
		                                seq: event.seq,
		                                className: event.seq.includes('USERSCHEDULE') ?
		                                			'memo_event' : event.seq.includes('NTCSCHEDULE') ?
		                                			'nct_event' : event.seq.includes('RESERVATION') ? 
		                                			'reser_event':'annual_event'
		                            };
		                            events.push(fcEvent);
		                        });
		                        successCallback(events);
							}
	                        
	                    },
	                    error: function() {
	                        failureCallback();
	                        alert("일정을 불러오는데 실패했습니다.");
	                    }
	                });
				}
				
            }
        }]
    }); 
    if(selectScheduleAll == true){
        calendar.render();
	}else{
		calendar.changeView('dayGridMonth', selectScheduleAllDate);
		selectScheduleAll = true;
		calendar.render();
	}
	
};
//calendar function 끝----------------------------
    


// 모달 닫기 설정----------------------------
function modalclose(){
	$("#addForm")[0].reset();
	$("#upForm")[0].reset();
	$("#calendarModal").modal("hide");
	$("#calendarModalDetail").modal("hide");
	$("#calendarModalUpdate").modal("hide");
	document.getElementById('dtButtons').innerHTML = '';	
}
// 모달 닫기 설정 끝----------------------------

// 상세 모달 설정----------------------------
function calendarModalDetail(seq){ //seq가져와 내용 상세조회 하기
	$.ajax({
		type:"post",
		url:"./calendarModalDetail.do",
	    dataType:"json",
	    data:{seq:seq},
		success:function(Scheduledata){
			if($('#user_id').val()==Scheduledata.user_id&&!("re_seq" in Scheduledata)){
				var buttonHTML = 
				'<button type="button" class="btn btn-secondary" id="myScheduleUpdate">수정</button>' +
                '<button type="button" class="btn btn-secondary" id="myScheduleDelete">삭제</button>' +
                '<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">뒤로가기</button>';
				document.getElementById('dtButtons').innerHTML += buttonHTML;
			}else{
				var buttonHTML = '<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">뒤로가기</button>';
				document.getElementById('dtButtons').innerHTML += buttonHTML;
			}
			
			
			if("prs_seq" in Scheduledata){
				$("#calendarModalDetail").modal("show");
		        $("#dtTitle").text(Scheduledata.prs_title);
		        $("#dtContent").text(Scheduledata.prs_content);
		        $("#dtStart").text(Scheduledata.prs_start);
		        $("#dtEnd").text(Scheduledata.prs_end);
		        $("#dtSeq").val(Scheduledata.prs_seq);
			}else if("ntc_seq" in Scheduledata){
				$("#calendarModalDetail").modal("show");
		        $("#dtTitle").text(Scheduledata.ntc_title);
		        $("#dtContent").text(Scheduledata.ntc_content);
		        $("#dtStart").text(Scheduledata.ntc_start);
		        $("#dtEnd").text(Scheduledata.ntc_end);
		        $("#dtSeq").val(Scheduledata.ntc_seq);
			}else if("re_seq" in Scheduledata){
				$("#calendarModalDetail").modal("show");
		        $("#dtTitle").text(Scheduledata.re_title);
		        $("#dtContent").text("회의 내용 : "+Scheduledata.re_content+"\n회의실 : "+Scheduledata.me_room+"번 \n회의실 참석자 : "+ Scheduledata.re_attend);
		        $("#dtStart").text(Scheduledata.re_start);
		        $("#dtEnd").text(Scheduledata.re_end);
		        $("#dtSeq").val(Scheduledata.re_seq);
			}
		}
		
	});
}
// 상세 모달 설정 끝----------------------------



// 등록 모달 설정 ----------------------------
function calendarModal(day){
	$("#calendarModal").modal("show");
	$("#start").val(day)
	
	var auth = $("#user_auth").val();
	if(auth == 'ROLE_USER'){
		$('#title').attr('name', 'prs_title');
		$('#content').attr('name', 'prs_content');
		$('#start').attr('name', 'prs_start');
		$('#end').attr('name', 'prs_end');
	}else{
		$('#title').attr('name', 'ntc_title');
		$('#content').attr('name', 'ntc_content');
		$('#start').attr('name', 'ntc_start');
		$('#end').attr('name', 'ntc_end');
	}
	
	 $('#addCalendar').off("click").on("click",function(){
		var title = $('#title').val();
		var content = $('#content').val();
		var start = $('#start').val();
		var end= $('#end').val()==""?start:$('#end').val();
		
		if(title == ""){
			alert("제목을 작성해주세요");
			return;
		}else if(content == ""){
			alert("내용을 작성해주세요");
			return;
		}else if(start == ""){
			alert("시작날짜는 필수입니다.");
			return;
		}else if(start > end){
			alert("시작시간은 종료시간보다 빨라야 합니다.");
			return;
		}
		
		if(auth == 'ROLE_USER'){
			var memo = $("#addForm").serialize();
			$.ajax({
				type:"post",
				url:"./addMemo.do",
				data:memo,
				success:function(msg){
					console.log(msg);
					modalclose();
					selectScheduleAll = false;
					var type = updateTypeModal();
        			calendar(type);
				}
			});
		}else{
			var ntc = $("#addForm").serialize();
			$.ajax({
				type:"post",
				url:"./addNtc.do",
				data:ntc,
				success:function(msg){
					console.log(msg);
					modalclose();
					selectScheduleAll = false;
					var type = updateTypeModal();
        			calendar(type);
				}
			});
		}
		
	});
}
// 등록 모달 설정 끝----------------------------




// 일정 삭제 기능 ----------------------------
$(document).on("click", "#myScheduleDelete", function(){
	
	var seq = $('#dtSeq').val();
	var auth = $("#user_auth").val();
	
	if(auth == 'ROLE_USER'){
		$.ajax({
			type:"post",
			url:"./myScheduleDelete.do",
			dataType:"json",
		    data:{seq:seq},
		    success:function(isc){
				console.log(isc);
				modalclose();
				selectScheduleAll = false;
				var type = updateTypeModal();
        		calendar(type);
			}
			
		});
	}else{
		$.ajax({
			type:"post",
			url:"./ntcScheduleDelete.do",
			dataType:"json",
		    data:{seq:seq},
		    success:function(isc){
				console.log(isc);
				modalclose();
				selectScheduleAll = false;
				var type = updateTypeModal();
        		calendar(type);
			}
			
		});
	}
});
// 일정 삭제 기능 끝 ----------------------------


//일정 수정 기능 ----------------------------
$(document).on("click", "#myScheduleUpdate", function(){
	$("#calendarModalUpdate").modal("show");
	
	
	var auth = $("#user_auth").val();
	if(auth == 'ROLE_USER'){
		$('#upTitle').attr('name', 'prs_title');
		$('#upContent').attr('name', 'prs_content');
		$('#upStart').attr('name', 'prs_start');
		$('#upEnd').attr('name', 'prs_end');
		$('#upSeq').attr('name', 'prs_seq');
		
		$("#upTitle").val($("#dtTitle").text());
		$("#upContent").val($("#dtContent").text());
		$("#upStart").val($("#dtStart").text());
		$("#upEnd").val($("#dtEnd").text());
		$("#upSeq").val($("#dtSeq").val());
	}else{
		$('#upTitle').attr('name', 'ntc_title');
		$('#upContent').attr('name', 'ntc_content');
		$('#upStart').attr('name', 'ntc_start');
		$('#upEnd').attr('name', 'ntc_end');
		$('#upSeq').attr('name', 'ntc_seq');
		
		$("#upTitle").val($("#dtTitle").text());
		$("#upContent").val($("#dtContent").text());
		$("#upStart").val($("#dtStart").text());
		$("#upEnd").val($("#dtEnd").text());
		$("#upSeq").val($("#dtSeq").val());
	}
	
	 $('#updateCalendar').off("click").on("click",function(){
		var title = $('#upTitle').val();
		var content = $('#upContent').val();
		var start = $('#upStart').val();
		var end= $('#upEnd').val()==""?start:$('#upEnd').val();
		
		if(title == ""){
			alert("제목을 작성해주세요");
			return;
		}else if(content == ""){
			alert("내용을 작성해주세요");
			return;
		}else if(start == ""){
			alert("시작날짜는 필수입니다.");
			return;
		}else if(start > end){
			alert("시작시간은 종료시간보다 빨라야 합니다.");
			return;
		}
		
		if(auth == 'ROLE_USER'){
			var memo = $("#upForm").serialize();
			$.ajax({
				type:"post",
				url:"./myScheduleUpdate.do",
				data:memo,
				success:function(msg){
					console.log(msg);
					modalclose();
					selectScheduleAll = false;
					var type = updateTypeModal();
        			calendar(type);
				}
			});
		}else{
			var ntc = $("#upForm").serialize();
			$.ajax({
				type:"post",
				url:"./ntcScheduleUpdate.do",
				data:ntc,
				success:function(msg){
					console.log(msg);
					modalclose();
					selectScheduleAll = false;
					var type = updateTypeModal();
        			calendar(type);
				}
			});
		}
	});
		
});


//일정 수정 기능 끝 ----------------------------
//모달에서 등록,삭제,수정 시 체크박스 상태 다시 확인 기능----------------------------
function updateTypeModal() {
        var type = [];
        if ($('#showPrs').prop('checked')) {
            type.push(1);
        }
        if ($('#showNct').prop('checked')) {
            type.push(2);
        }
        if ($('#showRe').prop('checked')) {
            type.push(3);
        }
        if ($('#showAn').prop('checked')) {
            type.push(4);
        }
        return type.length > 0 ? type.join(',') : null;
    }
//모달에서 등록,삭제,수정 시 체크박스 상태 다시 확인 기능 끝----------------------------