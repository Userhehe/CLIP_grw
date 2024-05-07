package com.clip.gwr.socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.clip.gwr.model.service.IAlarmService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.AlarmVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Component
//@RequestMapping("/clipWs.do")
@Slf4j
public class EchoHandler extends TextWebSocketHandler {
	
	@Autowired
	private IAlarmService alarmService;
	
	//로그인 되어있는 유저 웹소켓 정보 
	private List<WebSocketSession> sessions = new ArrayList<>();
	
	//js에서 websocket on일때 실행 메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		log.info("웹소켓 session : {}",session);
		log.info("웹소켓 sessions : {}",sessions);
		
	}
	
	//알림 보내는 역할
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String fullMsg = message.getPayload();
		log.info(fullMsg);
		String user_id = (String)session.getAttributes().get("user_id");
		List<AlarmVo> alarms = alarmService.selectAlarmNotice(user_id);
		for(AlarmVo alarm : alarms) {
			String title = alarm.getAlarm_title();
			String type = alarm.getAlarm_type();
			String flag = alarm.getAlarm_flag();
			TextMessage sendMsg = new TextMessage(title+","+type+","+flag);
			session.sendMessage(sendMsg);
		}
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {//연결 해제
		log.info("Socket 끊음");
		//웹 소켓이 종료될 때마다 리스트에서 뺀다.
		sessions.remove(session);
	}
}