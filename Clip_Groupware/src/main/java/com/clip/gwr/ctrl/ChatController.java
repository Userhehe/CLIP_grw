package com.clip.gwr.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@Controller
@Slf4j
public class ChatController {

	@GetMapping(value="/webSocketTest.do")
	public String webSocketTest() {
		return "webSocketTest";
	}

}
