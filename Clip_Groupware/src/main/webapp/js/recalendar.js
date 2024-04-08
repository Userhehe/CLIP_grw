var empId = []; //참석자로 선택된 사원 배열

/*-------------------- FULL CALENDAR --------------------*/
	var selectRevAll = true;
	var selectRevAllDate = "";
$(document).ready(function(){
	calendar();
});

function calendar(){
    var calendarEl = document.getElementById('recalendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
      locale: 'ko',
      dayMaxEventRows: true,
      height: 1000,
        initialView: 'dayGridMonth',
        droppable: false,
        editable: false,
        displayEventTime: true,
        customButtons: {
            addEventButton: {
                text: "예약 추가",
                click: function() {
                    reservationModal();
                },
            }
        },
        headerToolbar: {
            center: 'title',
            left: 'dayGridMonth,timeGridWeek,timeGridDay,addEventButton'
        },
        titleFormat: function(date) {
            return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
        },
         eventClick: function(info) {
			if(info.el.classList.contains('koHol')){
				return false;
			}
            var seq = info.event.extendedProps.seq;
            console.log(seq)
            reCalendarModalDetail(seq);
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
			if(selectRevAll == true){
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
               selectRevAllDate = date
               console.log("날짜값 : ",date);
                   $.ajax({
                       type: "get",
                       url: "./reList.do",
                       data : {date:date},
                       dataType:"json",
                       success: function(data) {
                     if(data.length == 0||data == null){
                        console.log("조회내용 없음");
                        successCallback(data);
                     }else{
                        var events = [];
                              data.forEach(function(event) {
                                  var fcEvent = {
                                      title: (event.title.length>5)?event.title.substring(0, 5) + '...'+"(" + event.meroom + "번 회의실)" : event.title+"(" + event.meroom + "번 회의실)",
                                      start: event.start,
                                      end: event.end,
                                      seq: event.seq,
                                      className: 'reser_event'
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
				var date = selectRevAllDate;
				console.log("날짜값",date);
					$.ajax({
                       type: "get",
                       url: "./reList.do",
                       data : {date:date},
                       dataType:"json",
                       success: function(data) {
                     if(data.length == 0||data == null){
                        console.log("조회내용 없음");
                        successCallback(data);
                     }else{
                        var events = [];
                              data.forEach(function(event) {
                                  var fcEvent = {
                                      title: (event.title.length>5)?event.title.substring(0, 5) + '...'+"(" + event.meroom + "번 회의실)" : event.title+"(" + event.meroom + "번 회의실)",
                                      start: event.start,
                                      end: event.end,
                                      seq: event.seq,
                                      className: 'reser_event'
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
 	if(selectRevAll == true){
	console.log('ssss', selectRevAllDate);
	    calendar.changeView('dayGridMonth'); 
        calendar.render();
        
   }else{
      calendar.changeView('dayGridMonth', selectRevAllDate);
      selectRevAll = true;
      calendar.render();
   }
};
	
/*-------------------- FULL CALENDAR END --------------------*/
// 모달 닫기 설정----------------------------
function modalclose(){
	$("#calendarModalDetail").modal("hide");
	document.getElementById('dtButtons').innerHTML = '';
}
// 모달 닫기 설정 끝----------------------------

// 상세 모달 설정----------------------------
function reCalendarModalDetail(seq){ //seq가져와 내용 상세조회 하기
	$.ajax({
		type:"post",
		url:"./calendarModalDetail.do",
	    dataType:"json",
	    data:{seq:seq},
		success:function(Scheduledata){
		
				var buttonHTML = '<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">뒤로가기</button>';
				document.getElementById('dtButtons').innerHTML += buttonHTML;
					
			
		
				$("#calendarModalDetail").modal("show");
		        $("#dtTitle").text(Scheduledata.rVo.re_title);
		        $("#dtContent").text(Scheduledata.rVo.re_content);
		        $("#dtStart").text(Scheduledata.rVo.re_start);
		        $("#dtEnd").text(Scheduledata.rVo.re_end);
		        $("#dtSeq").val(Scheduledata.rVo.re_seq);
		        $("#meRoom").text(Scheduledata.rVo.me_room);
		        $("#attends").text(Scheduledata.atts.attendees);
		        $("#attendDiv").css("display", "block");
				$("#meRoomDiv").css("display", "block");
			
		}
		
	});
}
// 상세 모달 설정 끝----------------------------


//예약 등록모달 호출
function reservationModal(){
   console.log("예약 등록 모달");
   $("#reservationModal").modal("show");
}



    //예약 등록 버튼-----------------------------------
    $(document).ready(function() {
   $("#addReservation").click(function() {
	  var dateTimeRegex = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
      var me_room = document.getElementById("me_room").value;
      var re_start = document.getElementById("re_start").value;
      var re_start_time = document.getElementById("re_start_time").value;
      var re_title = document.getElementById("re_title").value;
      var re_content = document.getElementById("re_content").value;
      console.log("re_srart:",re_start)
      
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
      } else if(!dateTimeRegex.test(re_start)){
		 alert("<예약 시간 선택 완료> 버튼을 눌러주세요")
	  } else{
         datata = $("#reservationForm").serialize();
         
         $.ajax({
            type: "POST",
            url:"./myReservationInsert.do",
            data:datata,
            success:function(data){
               console.log("data값", data);
               if(data==0){
                  alert("예약 실패");
                  return false;
               }else{
            alert("예약 되었습니다.");
            $("#reservationForm")[0].reset();
            $("#hiddenValue").val(data);
//          $("#selectAttendsJstree").jstree("deselect_all");
//          $("#selectAttendsJstree").jstree("close_all");
            
            var result = confirm("회의 참가인원을 선택하시겠습니까?")
            if(result){
               $("#reservationModal").modal("hide");
               insertAddAtt();
               
            }else{
               $("#reservationModal").modal("hide");
               alert("참가인원을 정하지 않고 예약되었습니다.")
               location.reload();
            }
               }
               
            },error: function() {
                  alert("서버 에러");
               }
         });      
      }      
   });
   });