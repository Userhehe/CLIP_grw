package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	 
	@GetMapping(value = "/main.do")
	public String loginForm() {
		log.info("MainController main 시작화면");
		return "main";
	}
	
//	@PostMapping(value = "/main.do")
//	public String postMain() {
//		log.info("MainController main (post) 로그인 후 메인화면으로 이동");
//		return "main";
//	}
	
	@GetMapping(value = "/empty.do")
	public String empty() {
		log.info("MainController empty 빈화면");
		return "empty";
	}
	
	@GetMapping(value = "/userInfo.do")
	public String userInfo() {
		log.info("userInfo 이동");
		return "userInfo";
	}
}
