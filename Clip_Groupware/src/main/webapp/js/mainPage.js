//화면 로드시 실행되는 것들 ------------------------------------
document.addEventListener('DOMContentLoaded', function() {
	//모달창 뒤로가기 막기 설정 끝------------------------------------------------
    $('#calendarModalDetail').modal({
        backdrop: 'static',
        keyboard: false
    });
    //모달창 뒤로가기 막기 설정------------------------------------------------
	mainSchedule();
	ntcScheduleTableBody();
	
	
	
});
//화면 로드시 실행되는 것들 끝------------------------------------












//일정 공지 설정------------------------------


// 모달 닫기 설정----------------------------
function modalclose(){
	$("#calendarModalDetail").modal("hide");
	document.getElementById('dtButtons').innerHTML = '';	
}
// 모달 닫기 설정 끝----------------------------


//일정 관련 함수------------------------------
function mainSchedule(){
		var currentDate = new Date();
		var currentMonth = currentDate.getMonth() + 1;
		var date = currentDate.getFullYear() + "-" + (currentMonth < 10 ? "0" + currentMonth : currentMonth);
		var type = "1";
		$.ajax({
		type:"get",
		url:"./selectScheduleAll.do",
	    dataType:"json",
	    data:{type:type, date:date},
		success:function(data){
		console.log(data);
		 var tableBody = $("#scheduleTableBody");
            tableBody.empty();

            for (var i = 0; i < Math.min(data.length, 11); i++) {
                var schedule = data[i];
                var tr = $("<tr>").addClass("schedule").attr("data-seq", schedule.seq);
                tr.append($("<td>").addClass("scheduleTitle").text(schedule.title));
                tr.append($("<td>").addClass("scheduleStart").text(schedule.start));
                tr.append($("<td>").addClass("scheduleEnd").text(schedule.end));
                tableBody.append(tr);
                
                tr.click(function () {
                    var seq = $(this).attr("data-seq");
                    console.log("클릭한 시퀀스 값:", seq);
                    calendarModalDetail(seq);
                });
            }
		}
	});
}
//일정 관련 함수 끝------------------------------


//공지 관련 함수------------------------------
function ntcScheduleTableBody(){
		var currentDate = new Date();
		var currentMonth = currentDate.getMonth() + 1;
		var date = currentDate.getFullYear() + "-" + (currentMonth < 10 ? "0" + currentMonth : currentMonth);
		var type = "2";
		$.ajax({
		type:"get",
		url:"./selectScheduleAll.do",
	    dataType:"json",
	    data:{type:type, date:date},
		success:function(data){
		console.log(data);
		 var tableBody = $("#ntcScheduleTableBody");
            tableBody.empty();

            for (var i = 0; i < Math.min(data.length, 11); i++) {
                var schedule = data[i];
                var tr = $("<tr>").addClass("schedule").attr("data-seq", schedule.seq);
                tr.append($("<td>").addClass("scheduleTitle").text(schedule.title));
                tr.append($("<td>").addClass("scheduleEnd").text(schedule.start));
                tr.append($("<td>").addClass("scheduleStart").text(schedule.end));
                tableBody.append(tr);
                
                tr.click(function () {
                    var seq = $(this).attr("data-seq");
                    console.log("클릭한 시퀀스 값:", seq);
                    calendarModalDetail(seq);
                });
            }
		}
	});
}
//공지 관련 함수 끝------------------------------


// 상세 모달 설정----------------------------
function calendarModalDetail(seq){ //seq가져와 내용 상세조회 하기
	$.ajax({
		type:"post",
		url:"./calendarModalDetail.do",
	    dataType:"json",
	    data:{seq:seq},
		success:function(Scheduledata){
			var buttonHTML = '<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="modalclose()">뒤로가기</button>';
			document.getElementById('dtButtons').innerHTML += buttonHTML;
			
			
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
//일정 공지 설정 끝------------------------------

//전자결재 모달 설정----------------------------------


//----------------------------------
