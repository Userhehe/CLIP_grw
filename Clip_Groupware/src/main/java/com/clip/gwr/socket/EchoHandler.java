package com.clip.gwr.socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.clip.gwr.model.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Component(value = "clipWs.do")
@Slf4j
public class EchoHandler extends TextWebSocketHandler {

	@Autowired
	private IUserService service;
	
	//로그인 되어있는 유저 웹소켓 정보 
	private List<WebSocketSession> sessions = new ArrayList<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		log.info("웹소켓 session : {}",session);
		log.info("웹소켓 sessions : {}",sessions);
	}
}