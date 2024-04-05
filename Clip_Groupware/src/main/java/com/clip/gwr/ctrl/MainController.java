package com.clip.gwr.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clip.gwr.model.service.IApprovalService;
import com.clip.gwr.vo.ApprovalVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	 
	@Autowired
	private IApprovalService service;
	
	@GetMapping(value = "/main.do")
	public String getMain(Model model,HttpSession session) {
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		List<ApprovalVo> lists = service.getMyPaycheck(user_id);
		model.addAttribute("lists",lists);
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
}
