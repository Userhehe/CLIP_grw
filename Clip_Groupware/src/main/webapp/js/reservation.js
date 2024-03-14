
//dateTimePicker
$(document).ready(function() {
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

});



