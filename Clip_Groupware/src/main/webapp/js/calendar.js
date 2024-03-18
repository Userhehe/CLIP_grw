document.addEventListener('DOMContentLoaded',ajax());

function ajax(){
	$.ajax({
		type: "get",
		url: "./Ajax.do",
		dataType: "json",
		success: function(data){
			var calendarEl = document.getElementById('calendar');
        	console.log(data);
			var calendar = new FullCalendar.Calendar(calendarEl, {
          		initialView: 'dayGridMonth',
          		droppable: false, // 날짜부분 드래그 안되게 막음
          		editable: false,
          		events: data,	
          		dateClick: function(){
					modal();	
				}
			
			});
			calendar.render();
		},
		error: function(){
			alert("달력 불러오기실패 ㅎㅎ")
		}
	});
}	

function modal(){
	console.log("씨빨 줫같은 모달 불러와짐?");
	document.getElementById('calendarModal').style.display = 'block';
	console.log("불러와져야 하는데?");
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