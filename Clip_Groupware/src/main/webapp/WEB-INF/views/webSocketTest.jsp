<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>웹소켓 테스트</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript" src="./js/app.js"></script>
<script>
    const webSocket = new WebSocket("ws://localhost:8080/clipWs.do");

    // 웹 소켓 연결 이벤트
    webSocket.onopen = function () {
      alert("웹소켓 서버와 연결에 성공했습니다.");
    };

    // 웹 소켓 메세지 수신
    webSocket.onmessage = function (event) {
      alert(event.data);
    };

    // 웹 소켓 연결 종료
    webSocket.onclose = function () {
      alert("웹소켓 서버와 연결이 종료되었습니다.");
    };

    // 오류 발생
    webSocket.onerror = function (error) {
      console.log(error);
    };

    function sendMessage() {
      const message = document.getElementById("message").value;
      webSocket.send(message);
    }
</script>
<body>
2323ㄱ
	<div>
      <input type="text" id="message" />
      <button type="button" onclick="sendMessage()">전송</button>
    </div>
    <div></div>
</body>
</html>