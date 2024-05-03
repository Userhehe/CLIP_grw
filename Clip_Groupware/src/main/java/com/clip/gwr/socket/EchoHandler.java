package com.clip.gwr.socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.clip.gwr.model.service.IAlarmService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.AlarmVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Component(value = "clipWs.do")
@Slf4j
public class EchoHandler extends TextWebSocketHandler {

	@Autowired
	private IUserService service;
	
	@Autowired
	private IAlarmService alarmService;
	
	//로그인 되어있는 유저 웹소켓 정보 
	private List<WebSocketSession> sessions = new ArrayList<>();
	//전체 유저 아이디
	private List<UserinfoVo> lists = service.selectAllUser();
	
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
		
		for(WebSocketSession single : sessions) {
			//세션아이디
			String user_id = (String)single.getAttributes().get("user_id");
			
			//세션값이 같을때, 알람보낼 것이 있을 때만 전송 -> 로그인 한 사용자가 처음으로 알람 받는 순간임
			//해당 sendMsg에 DB정보 넣어서 체크 안된 알람 전부 전송하기
			if(single.getAttributes().get("user_id").equals(session.getAttributes().get("user_id"))) {//체크 안된 알림들만 담아서 View
				List<AlarmVo> vo = alarmService.selectAlarmNotice(user_id);
				for(AlarmVo alarm : vo) {
					String alarm_seq = alarm.getAlarm_seq();
					String alarm_type = alarm.getAlarm_type();
					String alarm_title = alarm.getAlarm_title();
					String alarm_time = alarm.getAlarm_time();
					String alarm_receiver = alarm.getAlarm_receiver();
					String alarm_flag = alarm.getAlarm_flag();
					TextMessage sendMsg = new TextMessage(alarm_flag);
					single.sendMessage(sendMsg);
				}
			}
		}
		
		
	}
	
//	for (WebSocketSession clientSession : sessionList) {
//        if (clientSession.isOpen() && !clientSession.equals(session)) {
//           try {
//              // 본인 제외 전체 푸쉬
////              clientSession.sendMessage(new TextMessage("노티피케이션!"));
//           } catch (Exception e) {
//              e.printStackTrace();
//           }
//        }
//     }
	
	
	
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		// TODO Auto-generated method stub
//		super.afterConnectionClosed(session, status);
//	}
}