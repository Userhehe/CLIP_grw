/*달력 초기화*/
document.addEventListener('DOMContentLoaded',function() {
        const calendarEl = document.getElementById('calendar')
        const calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          dateClick: function() {
		  	
	
   		  }
        });
        calendar.render()
        
      });
      






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