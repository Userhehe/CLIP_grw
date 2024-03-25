////화면 로드시 걸어주는 이벤트들 ------------------------------------------------
$(document).ready(function() {
    $.datetimepicker.setLocale('ko');
    $("#start, #end").datetimepicker({
        disabledWeekDays: [0, 6],
        minDate: 0,
        allowTimes: ['09:00', '09:30', '10:00', '10:30', 
			        	'11:00', '11:30', '12:00', '12:30',
			            '13:00', '13:30', '14:00', '14:30', 
			            '15:00', '15:30', '16:00', '16:30', 
			            '17:00', '17:30', '18:00']
    });

    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
		dayMaxEventRows: 4,
        height: 900,
        initialView: 'dayGridMonth',
        droppable: false,
        editable: false,
        displayEventTime: false,
        customButtons: {
            addEventButton: {
                text: "일정 추가",
                click: function() {
                    memomodal();
                },
            }
        },
        headerToolbar: {
            center: 'title',
            left: 'dayGridMonth,timeGridWeek,timeGridDay,addEventButton'
        },
        dateClick: function() {
			 $('.fc-day-mon, .fc-day-tue, .fc-day-wed, .fc-day-thu, .fc-day-fri').click(function() {
				var clickedDate = new Date($(this).data('date'));
			 	var today = new Date();
				var yesterday = new Date(today);
				yesterday.setDate(today.getDate() - 1);
			    if (clickedDate < yesterday) {
			        return;
			    }
			    var day = $(this).data('date');
			    calendarModal(day);
		    });
        },
        titleFormat: function(date) {
            return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
        },
        eventClick: function(info) {
//            var seq = info.event.extendedProps.prs_seq;
//            info.el.style.backgroundColor = 'orange';
//            console.log("클릭한 이벤트의seq값: " + seq);
//            memodetail(seq);
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
});
//화면 로드시 걸어주는 이벤트들 끝 ------------------------------------------------

    


// 모달 닫기 설정----------------------------
function modalclose(){


	$("#calendarModal").modal("hide");
	$("#memodetail").modal("hide");

// 모달 닫기 설정 끝----------------------------

// 상세 모달 설정----------------------------
function memodetail(seq){ //seq가져와 내용 상세조회 하기
   console.log(seq)
   $.ajax({
      type:"post",
      url:"./memodetail.do",
      dataType:"json",
      data:{seq:seq},
      
      success: function(data){
         console.log( "썩세스", data.prs_seq);
         $("#memodetail").modal("show");
         $("#dttitle").text(data.prs_title);
         $("#dtcontent").text(data.prs_content);
         $("#dtstart").text(data.prs_start);
         $("#dtend").text(data.prs_end);
      },
      error: function() {
         alert("서버요청 실패했음....");
      },
   });
}
// 상세 모달 설정 끝----------------------------

// 수정 모달 설정----------------------------
function memoModify(seq){
   $("#calendarModalUpdate").modal("show");
}
// 수정 모달 설정 끝----------------------------

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
		$('#addCalendar').attr('name', 'addCalendarMemo');
	}
//	$("#addCalendar").on("click",function addmemo(){
//		var title = $(title).val();
//		var content = $(content).val();
//		var start = $(start).val();
//		var end= $(end).val();
//		
//		if(title == ""){
//			alert("제목을 작성해주세요");
//		}else if(content == ""){
//			alert("내용을 작성해주세요");
//		}else if(start == ""||end == ""){
//			alert("날짜를 입력해 주세요");
//		}else if(start > end){
//			alert("시작시간은 종료시간보다 빨라야 합니다.")
//		}else{ 
//			
//			var inmemo = $("#form").serialize();
//			
//		$.ajax({
//			url:"./addmemo.do",
//			data:inmemo,
//			datatype:"json",
//			type:"post",
//			success:function(msg){
//				console.log(msg)  // 작성필요
//			}
//		})
//		}
//	})

}
}
// 등록 모달 설정 끝----------------------------
