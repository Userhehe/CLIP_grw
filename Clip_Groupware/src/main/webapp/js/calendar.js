////화면 로드시 걸어주는 이벤트들 ------------------------------------------------

$(document).ready(function() {
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
    calendar();
});
//화면 로드시 걸어주는 이벤트들 끝 ------------------------------------------------
//calendar function ----------------------------
function calendar(){
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
		dayMaxEventRows: true,
		height: 1000,
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
			    if (clickedDate < yesterday) {
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
//            info.el.style.backgroundColor = 'orange';
            var seq = info.event.extendedProps.seq;
            calendarModalDetail(seq);
        },
        eventDidMount: function(info) {
				$('.koHol').click(function(event) {
			        event.preventDefault();
			    });
	
				$('#showPrs, #showNct').change(function() {
			        if ($('#showPrs').prop('checked') && $('#showNct').prop('checked')) {
			            $('#showAllEvent').prop('checked', true); 
			        } else {
								$('#showAllEvent').prop('checked', false);
							}
			    });
			    
				$('#showAllEvent').change(function() {
                    var isChecked = $(this).prop('checked');
                    if (!isChecked) {
						$('#showPrs, #showNct').prop('checked', false);
                      	$('.memo_event, .nct_event').hide();
                    } else {
						$('#showPrs, #showNct').prop('checked', true);
						$('.memo_event, .nct_event').show();
                    }
                });
                
                $('#showPrs').change(function() {
                    var isChecked = $(this).prop('checked');
                    if (!isChecked) {
                        $('.memo_event').hide();
                    } else {
                        $('.memo_event').show();
                    }
                });
                
                $('#showNct').change(function() {
                    var isChecked = $(this).prop('checked');
                    if (!isChecked) {
                        $('.nct_event').hide();
                    } else {
                        $('.nct_event').show();
                    }
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
                $.ajax({
                    type: "get",
                    url: "./Ajax.do",
                    dataType: "json",
                    success: function(data) {
                        var events = [];
                        data.forEach(function(event) {
                            var fcEvent = {
                                title: event.title,
                                start: event.start,
                                end: event.end,
                                seq: event.seq,
                                className: event.seq.includes('USERSCHEDULE') ? 'memo_event' : 'nct_event'
                            };
                            events.push(fcEvent);
                        });
                        successCallback(events);
                    },
                    error: function() {
                        failureCallback();
                        alert("일정을 불러오는데 실패했습니다.");
                    }
                });
            }
        }]
    });
    calendar.render();
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
			if($('#user_id').val()==Scheduledata.user_id){
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
					calendar();
				}
			});
		}
		
	});
}
// 등록 모달 설정 끝----------------------------




// 일정 삭제 기능 ----------------------------
$(document).on("click", "#myScheduleDelete", function(){
	console.log("dd");
	var seq = $('#dtSeq').val();
	$.ajax({
		type:"post",
		url:"./myScheduleDelete.do",
		dataType:"json",
	    data:{seq:seq},
	    success:function(isc){
			console.log(isc);
			modalclose();
			calendar();
		}
		
	});
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
					calendar();
				}
			});
		}
	});
		
});


//일정 수정 기능 끝 ----------------------------