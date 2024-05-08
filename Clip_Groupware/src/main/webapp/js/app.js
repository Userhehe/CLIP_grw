var webSocket = null;
//window.onload = function() {
	// WebSocket 서버 주소
	var url = location.href;   //현재 주소를 받아온다.
	var checkUrl = "ws:"+(url.substring(url.indexOf("//"), url.lastIndexOf("/")+1)) + "clipWs.do";
	
	// WebSocket 객체 생성
	webSocket = new WebSocket(checkUrl);

	// 연결이 열렸을 때 실행되는 함수
	webSocket.onopen = function(event) {
		console.log("WebSocket 연결이 열렸습니다.");
		// 연결이 열리면 추가 작업을 수행할 수 있습니다.
	};

// 메시지를 수신했을 때 실행되는 함수
webSocket.onmessage = function(event) {
	console.log("서버로부터 메시지를 수신했습니다: " + event.data);
	
	// 현재시간 가져오기
	var currentDate = new Date();
	var currentYear = currentDate.getFullYear(); // 현재 연도
	var currentMonth = currentDate.getMonth() + 1; // 현재 월
	var currentDay = currentDate.getDate(); // 현재 일
	var currentHour = currentDate.getHours(); // 현재 시간(시)
	var currentMinute = currentDate.getMinutes(); // 현재 시간(분)
	var currentSecond = currentDate.getSeconds(); // 현재 시간(초)
	if(currentMonth < 10) {
		currentMonth = 0 + "" + currentMonth;
	}
	if(currentDay < 10) {
		currentDay = 0 + "" + currentDay;
	}
	var date = currentYear + "년-" + currentMonth + "월-" + currentDay + "일 " + currentHour + ":" + currentMinute + ":" + currentSecond;
							
	var ul = document.querySelector('.notifications');
	var html = "";
	html += '  <li><hr class="dropdown-divider"></li>';
	html += '  <li class="notification-item">';
	html += '   <i class="bi bi-exclamation-circle text-warning"></i>';
	html += '     <div><h4>알림</h4><p> 새로운 공지사항이 등록되었습니다. </p> [' +  date + ']</div>';
	html += '  </li>';
  	html += '<li><hr class="dropdown-divider"></li>';
  	ul.innerHTML += html;
  	var span = document.querySelectorAll('.alarmCnt');
  	for(let i=0; i<span.length; i++) {
	  	if(span[i].innerHTML == "" || span[i].innerHTML == 0) {
		  	span[i].innerHTML = 1;
		} else {
			span[i].innerHTML = parseInt(span[i].innerHTML) + 1;
		}
	}
};
// 연결이 닫혔을 때 실행되는 함수
webSocket.onclose = function(event) {
	console.log("WebSocket 연결이 닫혔습니다.");
	// 연결이 닫히면 추가 작업을 수행할 수 있습니다.
};

// 에러가 발생했을 때 실행되는 함수
webSocket.onerror = function(event) {
	console.error("WebSocket 오류가 발생했습니다:", event);
	// 오류가 발생하면 추가 작업을 수행할 수 있습니다.
};

// 메시지를 서버로 전송하는 함수
function sendMessage(message) {
	webSocket.send(message);
	console.log("##message : ", message);
}

//}
function ntcAlarm(){
	$.ajax({
			type:"get",
			url:"./ntcAlarm.do",
		    success:function(data){
				sendMessage("새로운 공지사항이 추가되었습니다");
			}
		});	
}
