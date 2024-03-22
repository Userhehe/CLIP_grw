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
	
	@PostMapping(value = "/main.do")
	public String postMain() {
		log.info("MainController main (post) 로그인 후 메인화면으로 이동");
		return "main";
	}

	@GetMapping(value = "/empty.do")
	public String empty() {
		log.info("MainController empty 빈화면");
		return "empty";
	}
	
	@GetMapping(value = "/annual.do")
	public String annual() {
		log.info("MainController annual 화면");
		return "annual";
	}
	
	@GetMapping(value = "/dailyCheck.do")
	public String dailyCheck() {
		log.info("MainController dailyCheck 화면");
		return "dailyCheck";
	}
	
	@GetMapping(value = "/position.do")
	public String position() {
		log.info("MainController position 화면");
		return "position";
	}
	
	@GetMapping(value = "/organization.do")
	public String organization() {
		log.info("MainController organization 화면");
		return "organization";
	}
	
	@GetMapping(value = "/access.do")
	public String access() {
		log.info("MainController access 화면");
		return "access";
	}
	
}
