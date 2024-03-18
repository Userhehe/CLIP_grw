package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {
	
	@GetMapping(value = "/all.do")
	public String doAll() {
		log.info("▶▶▶ AuthController All◀◀◀");
		return "all";
	}
	
	@GetMapping(value = "/member.do")
	public String doMember() {
		log.info("▶▶▶ AuthController Member◀◀◀");
		return "member";
	}
	
	@GetMapping(value = "/admin.do")
	public String doAdmin() {
		log.info("▶▶▶ AuthController Admin◀◀◀");
		return "admin";
	}
	
	
}
