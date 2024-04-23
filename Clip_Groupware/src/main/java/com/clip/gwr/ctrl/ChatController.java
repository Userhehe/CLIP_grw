package com.clip.gwr.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clip.gwr.model.service.IChatService;
import com.clip.gwr.vo.ChatVo;
import com.google.gson.GsonBuilder;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ChatController {

	@Autowired
	private IChatService service;

	@PostMapping(value = "sendMessage.do", produces = "text/html; charset=UTF-8")
	public void sendMessage(@RequestBody Map<String, Object> map) {
		log.info("ChatController sendMessage POST 메시지 전송 : {}", map);
		try {
			ChatVo vo = new ChatVo();
			vo.setChat_sender((String)map.get("chat_sender"));
			vo.setChat_recipient((String)map.get("chat_recipient"));
			vo.setChat_message((String)map.get("chat_message"));
			service.sendMessage(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "loadMessage.do", produces = "text/html; charset=UTF-8")
	public ResponseEntity<?> loadMessage(ChatVo vo) {
		log.info("ChatController loadMessage 대화목록 불러오기 : {}", vo.getChat_recipient());
		List<ChatVo> chatList = service.selectAllMessage(vo);
		for (ChatVo chatDto : chatList) {
			if(chatDto.getSender_pic() != null) {
				chatDto.setSender_pic_str(Base64Utils.encodeToString(chatDto.getSender_pic()));
				chatDto.setSender_pic(null);
			}
		}
		return ResponseEntity.ok(new GsonBuilder().create().toJson(chatList));
	}

	@GetMapping(value = "chatUserList.do", produces = "text/html; charset=UTF-8")
	public ResponseEntity<?> chatUserList(@RequestParam String ch_target) {
		log.info("ChatController chatUserList 채팅 유저목록 조회");
		List<ChatVo> list = service.chatUserList(ch_target);
		for(ChatVo vo : list) {
			if(vo.getSender_pic() != null) {
				vo.setSender_pic_str(Base64Utils.encodeToString (vo.getSender_pic()));
				vo.setSender_pic(null);
			}
		}
		return ResponseEntity.ok(new GsonBuilder().create().toJson(list));
	}

	@GetMapping("chatCount.do")
	public ResponseEntity<?> chatCount(ChatVo vo) {
		log.info("ChatController chatCount 안읽은 대화수 조회");
		int n = service.noReadList(vo);
		return ResponseEntity.ok(n);
	}

	@GetMapping("setReadMessage.do")
	public void setReadMessage(ChatVo vo) {
		log.info("ChatController setReadMessage 메세지 읽음 처리");
		service.setReadMessage(vo);
	}

}