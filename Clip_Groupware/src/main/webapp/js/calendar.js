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
          		editable: true,
          		displayEventTime: false,
          		events: data,	
          		
          		eventClick: function(info){
					var prsseq = info.event.extendedProps.prs_seq;
					memodetail(prsseq);
					console.log(prsseq);
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
				console.log(msg)
			}
			

		})
			
		}
		
	})
	
}

function memodetail(prsseq){
	console.log(prsseq)
	$.ajax({
		type:"get",
		url:"./memodetail.do",
		dataTyp: "text", //확인~
		success: function(data){
			$("#dttitle").
			$("#dtcontent").
			$("#dtstart").
			$("#dtend")
		}
		
	})
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