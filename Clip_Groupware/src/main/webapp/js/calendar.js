document.addEventListener('DOMContentLoaded',initCal);

function initCal(){ //달력 렌더링
	$.ajax({
		type: "get",
		url: "./Ajax.do",
		dataType: "json",
		success: function(data){
			var calendarEl = document.getElementById('calendar');
        	console.log(data);
			var calendar = new FullCalendar.Calendar(calendarEl, {
				height:900,
				headerToolbar: {
					center:'title', //월 표시
					left: 'dayGridMonth,timeGridWeek,timeGridDay,addEventButton'
				},
				titleFormat: function(date) { //년, 월, 한글로 표시
					return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';   //달력표시 한글로 변경
				},	
          		initialView: 'dayGridMonth',
          		droppable: false, // 날짜부분 드래그 안되게 막음
          		editable: false,
          		displayEventTime: false,
          		events: data,
          		eventColor: 'black',
          		customButtons: { //버튼 추가
					addEventButton: { // 추가한 버튼 설정
						text: "일정 추가",  // 버튼 내용
						click: function() { // 버튼 클릭 시 이벤트 추가
							console.log("ㅆㅂ모달도라돔라ㅣ몯리")
								memomodal();
						},
						
					}
				},
          		eventClick: function(info){
					var seq = info.event.extendedProps.prs_seq; // prs_seq를 이벤트객체의 속성처럼 동작시키기 위함
					info.el.style.backgroundColor = 'orange'
					console.log("클릭한 이벤트의seq값: " +seq);
					memodetail(seq);
					
				},
          		dateClick: function(){
					memomodal();	
				}
			});
			calendar.render(); 
		},
		error: function(){
			alert("달력 불러오기실패")
		}
	});
}	

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

function modalclose(){
	$("#calendarModal").modal("hide");
	$("#memodetail").modal("hide");
	initCal();
	consel.log("모달 닫습니다.")
}





//function rsrvtrigger(){
//	$("#rsrvmodal").modal("show");
//	console.log("모달 오픈")
//	
//};




	////예약 등록 모달 열기      
//
//document.getElementById('rsrvtrigger').addEventListener('click',function(){
//	document.getElementById('rsrvmodal').style.display = 'block';
//});
//
////예약 등록 모달 닫기
//  document.getElementById('rsrvclode').addEventListener('click', function() {
//    document.getElementById('rsrvmodal').style.display = 'none';
// });