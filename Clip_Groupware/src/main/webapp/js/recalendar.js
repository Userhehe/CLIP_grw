document.addEventListener('DOMContentLoaded',initCal);
function initCal(){ //달력 렌더링
	$.ajax({
		type: "get",
		url: "./reList.do",
		dataType: "json",
		success: function(data){
			console.log("달력 기능 불러오기")
			var calendarEl = document.getElementById('recalendar');
        	console.log("달력 전체조회" , data)
			var calendar = new FullCalendar.Calendar(calendarEl, {
				height:900,
				headerToolbar: {
					center:'title', //월 표시
					left: 'dayGridMonth,timeGridWeek,timeGridDay'
				},
				titleFormat: function(date) { //년, 월, 한글로 표시
					return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';   //달력표시 한글로 변경
				},	
          		initialView: 'dayGridMonth',
          		droppable: false, // 날짜부분 드래그 안되게 막음
          		editable: false,
          		displayEventTime: false,
          		events: data,
          		eventColor: 'forestgreen',
          		customButtons: { //버튼 추가
					addEventButton: { // 추가한 버튼 설정
						text: "예약하기",  // 버튼 내용
						click: function() { // 버튼 클릭 시 이벤트 추가
						},
						
					}
				},
          		eventClick: function(info){
					var seq = info.event.extendedProps.prs_seq; // prs_seq를 이벤트객체의 속성처럼 동작시키기 위함
					info.el.style.backgroundColor = 'orange'
					
				},
          		dateClick: function(){
				}
			});
			calendar.render(); 
		},
		error: function(){
			alert("달력 불러오기실패")
		}
	});
}	
