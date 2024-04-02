	var selectRevAll = true;
	var selectRevAllDate = "";
$(document).ready(function(){
	calendar();
});

function calendar(){
    var calendarEl = document.getElementById('recalendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
      dayMaxEventRows: true,
      height: 1000,
        initialView: 'dayGridMonth',
        droppable: false,
        
        editable: false,
        displayEventTime: false,
        customButtons: {
            addEventButton: {
                text: "예약 추가",
                click: function() {
                    calendarModal("");
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
        eventSources: [      {
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
                                      title: event.title,
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
                                      title: event.title,
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
        calendar.render();
   }else{
      calendar.changeView('dayGridMonth', selectRevAllDate);
      selectRevAll = true;
      calendar.render();
   }
};