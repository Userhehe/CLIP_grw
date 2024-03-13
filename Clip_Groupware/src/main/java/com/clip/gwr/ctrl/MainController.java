package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	
	@GetMapping(value="/main.do")
	public String main() {
		log.info("MainController main 시작화면");
		return "main";
	}
	
	@GetMapping(value="/empty.do")
	public String empty() {
		log.info("MainController empty 빈화면");
		return "empty";
	}
}
