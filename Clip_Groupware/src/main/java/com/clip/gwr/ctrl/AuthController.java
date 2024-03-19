package com.clip.gwr.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {
	
	@GetMapping("/all.do")
	public String doAll() {
		log.info("▶▶▶ AuthController All◀◀◀");
		return "loginForm";
	}
	
	
	@GetMapping("/member.do")
//	@GetMapping("/user/**.do")
	public String doMember() {
		log.info("▶▶▶ AuthController Member◀◀◀");
		return "main"; 
	}
	
	@GetMapping("/admin.do")
//	@GetMapping("/admin/**.do")
	public String doAdmin() {
		log.info("▶▶▶ AuthController Admin◀◀◀");
		return "adminMain";
	}
	
	
}
