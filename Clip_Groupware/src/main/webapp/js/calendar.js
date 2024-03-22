////화면 로드시 걸어주는 이벤트들 ------------------------------------------------
$(document).ready(function() {
    $.datetimepicker.setLocale('ko');
    $("#start, #end").datetimepicker({
        disabledWeekDays: [0, 6],
        minDate: 0,
        allowTimes: ['09:00', '09:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30',
            '13:00', '13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30', '17:00', '17:30',
            '18:00'
        ]
    });

    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
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
            memomodal();
        },
        titleFormat: function(date) {
            return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
        },
        eventClick: function(info) {
            var seq = info.event.extendedProps.prs_seq;
            info.el.style.backgroundColor = 'orange';
            console.log("클릭한 이벤트의seq값: " + seq);
            memodetail(seq);
        },
        eventDidMount: function(info) {
            var event = info.event;
            if (event && event.className && event.className.includes('memo_event')) {
                $('#showPrs').change(function() {
                    var isChecked = $(this).prop('checked');
                    if (isChecked) {
                        info.el.classList.remove('memo_event');
                    } else {
                        info.el.classList.add('memo_event');
                    }
                });
            }
        },
        eventSources: [{
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
   initCal();
   consel.log("모달 닫습니다.")
}
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
function memomodal(){
   console.log("TLqkf또모달...?")
   $("#calendarModal").modal("show");
   
   $("#addCalendar").on("click",function addmemo(){
      var title = $(title).val();
      var content = $(content).val();
      var start = $(start).val();
      var end= $(end).val();
      
      if(title == ""){
         alert("제목을 작성해주세요");
      }else if(content == ""){
         alert("내용을 작성해주세요");
      }else if(start == ""||end == ""){
         alert("날짜를 입력해 주세요");
      }else if(start > end){
         alert("시작시간은 종료시간보다 빨라야 합니다.")
      }else{ 
         
         var inmemo = $("#form").serialize();
         
      $.ajax({
         url:"./addmemo.do",
         data:inmemo,
         datatype:"json",
         type:"post",
         success:function(msg){
            console.log(msg)  // 작성필요
         }
      })
      }
   })
}
// 등록 모달 설정 끝----------------------------
