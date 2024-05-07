/*var sock = null;

$(document).ready(function(){
	connectWs();

});

//소켓
function connectWs(){
	var ws = new SockJS("ws://localhost:8080/Clip_Groupware/main.do");
	console.log(ws);
	ws.onopen = function() {
		console.log("연결완료");
	};



	ws.onclose = function() {
		console.log('close');
	};

};
*/
window.onload = function() {
	// WebSocket 서버 주소
	var url = location.href;   //현재 주소를 받아온다.
	var checkUrl = "ws:"+(url.substring(url.indexOf("//"), url.lastIndexOf("/")+1)) + "clipWs.do";

	
//	var serverUrl = "ws://192.168.0.81:8080/Clip_Groupware/clipWs.do";

	// WebSocket 객체 생성
	var webSocket = new WebSocket(checkUrl);

	// 연결이 열렸을 때 실행되는 함수
	webSocket.onopen = function(event) {
		console.log("WebSocket 연결이 열렸습니다.");
		// 연결이 열리면 추가 작업을 수행할 수 있습니다.
	};

	// 메시지를 수신했을 때 실행되는 함수
	webSocket.onmessage = function(event) {
		console.log("서버로부터 메시지를 수신했습니다: " + event.data);
		// 서버로부터 받은 메시지를 처리할 수 있습니다.
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

//	// 메시지를 서버로 전송하는 함수
//	function sendMessage(message) {
//		webSocket.send(message);
//	}
}