package com.clip.gwr.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@GetMapping(value = "/signUp.do")
	public String signUp() {
		return "signUp";
	}
	
}
