
$(document).ready(function() {

	//dateTimePicker 날짜
	$("#re_start").datetimepicker({
		format: "Y-m-d",
	});
	// 언어를 한국어로 변경
	$.datetimepicker.setLocale('ko');
	//input 태그 클릭시 이벤트 처리
	$("#re_start").datetimepicker({
		// 시간 선택 비활성화
		timepicker: false,
		// 0: 일요일, 6: 토요일 // 주말 선택 불가
		disabledWeekDays: [0, 6],
		// 오늘 이후 날짜만 선택 가능
		minDate: 0,
	});

	//클릭시 창활성화
	$("#re_start").datetimepicker({});

	$("#re_start_img").click(function() {
		$("#re_start").datetimepicker('show');
	});


	//dateTimePicker 시간-------------------------------------------------
		$("#re_start_time").datetimepicker({
			format: "m:i",
		});
	//input 태그 클릭시 이벤트 처리
	$("#re_start_time").datetimepicker({
		datepicker: false,
		// 오늘 이후 날짜만 선택 가능
		minDate: 0,
	});

	//클릭시 창활성화
	$("#re_start_time").datetimepicker({});

	$("#re_start_time_img").click(function() {
		$("#re_start_time").datetimepicker('show');
	});
});

function selectPossibleMeRoomButton() {
	var me_room = document.getElementById("me_room").value;
	var re_start = document.getElementById("re_start").value;

	$.ajax({
		type: "POST",
		url: './selectPossibleMeRoom.do',
		data: { "me_room": me_room, "re_start": re_start },
		success: function(data) {
			console.log("반환 값", data);
			$("#nawarayo").show();
			
			$("#re_start_time").datetimepicker({
				allowTimes: data
			});
		}
	});
}






