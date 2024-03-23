package com.clip.gwr.ctrl;

                 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private IPositionsService positService;
	
	@Autowired
	private IRanksService ranksService;
	
//	private UserServiceImpl service;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
//	@GetMapping(value = "/loginForm.do") 
//	public String loginForm(String error, String logout, Model model) {
//		log.info("error : {} ", error);
//		log.info("logout : {} ", logout);
//		
//		if(error != null) {
//			model.addAttribute("error", "없는 계정입니다.");
//		}
//		
//		if(logout != null) {
//			model.addAttribute("logout", "로그아웃 되었습니다.");
//		}
//		return "loginForm";
//	}
	@GetMapping(value = "/loginForm.do") 
	public String loginForm(Model model) {
		return "loginForm";
	}
	
	@GetMapping(value = "/signUp.do")
	public String signUp(Model model) {
		log.info("회원가입 이동");
		List<DeptVo> deptLists = deptService.deptAll();
		List<PositionsVo> positionsLists = positService.positionsAll();
		List<RanksVo> ranksLists = ranksService.ranksAll();
		
		model.addAttribute("deptLists", deptLists);
		model.addAttribute("positionsLists", positionsLists);
		model.addAttribute("ranksLists", ranksLists);
		return "signUp";
	}
	
	@PostMapping(value = "/signUp.do")
	public String signUpDone(HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		
		//String user_password = passwordEncoder.encode("clip1234!");
		String user_password = passwordEncoder.encode("1111");
		String user_name = request.getParameter("user_name");
		String user_registnum = request.getParameter("user_start_registnum") + "-"
								+ request.getParameter("user_last_registnum");
		String user_email = request.getParameter("user_email") + "@" + request.getParameter("email");
		
		String user_birthday = request.getParameter("user_birthday");
		String user_phonenum = request.getParameter("phone_firstnum") + "-" 
							+ request.getParameter("phone_secondnum") + "-"
							+ request.getParameter("phone_lastnum");
		String user_address = request.getParameter("user_address");
		String dept_name = request.getParameter("dept_name");
		String ranks_name = request.getParameter("ranks_name");
		String positions_name = request.getParameter("positions_name");
		String user_auth = request.getParameter("user_auth");	
		
		log.info("#### user_password : " + user_password);
		log.info("#### user_name : " + user_name);
		log.info("#### user_registnum : " + user_registnum);
		log.info("#### user_email : " + user_email);
		log.info("#### user_birthday : " + user_birthday);
		log.info("#### user_phonenum : " + user_phonenum);
		log.info("#### user_address : " + user_address);
		log.info("#### dept_name: " + dept_name);
		log.info("#### ranks_name : " + ranks_name);
		log.info("#### positions_name : " + positions_name);
		log.info("#### user_auth : " + user_auth);
		
		Map<String, Object> map = new HashMap();
		map.put("user_password", user_password);
		map.put("user_name", user_name);
		map.put("user_registnum", user_registnum);
		map.put("user_email", user_email);
		map.put("user_birthday", user_birthday);
		map.put("user_phonenum", user_phonenum);
		map.put("user_address", user_address);
		map.put("dept_name", dept_name);
		map.put("ranks_name", ranks_name);
		map.put("positions_name", positions_name);
		map.put("user_auth", user_auth);
		int signUp = userService.insertUserinfo(map);
		return "loginForm";
	}
	
	@GetMapping(value = "/userInfo.do")
	public String userInfo(Model model) {
		log.info("userInfo 이동");
		
		List<UserinfoVo> userinfoList = userService.selectUserinfoList();
		List<DeptVo> deptLists = deptService.deptAll();
		List<PositionsVo> positionsLists = positService.positionsAll();
		List<RanksVo> ranksLists = ranksService.ranksAll();
		
		model.addAttribute("userList", userinfoList);
		model.addAttribute("deptLists", deptLists);
		model.addAttribute("positionsLists", positionsLists);
		model.addAttribute("ranksLists", ranksLists);
		return "userInfo";
	}
	
	@GetMapping(value = "/user/main.do")
	public String userMain() {
		log.info("#####user/main!!");
		return "user/main";
	}
	
	@GetMapping(value = "/admin/main.do")
	public String adminMain() {
		log.info("#####admin/main!!");
		return "admin/main";
	}
	
	@GetMapping(value = "/user/signUp.do")
	public String userSignUp(Model model) {
		log.info("회원가입 이동");
		List<DeptVo> deptLists = deptService.deptAll();
		List<PositionsVo> positionsLists = positService.positionsAll();
		List<RanksVo> ranksLists = ranksService.ranksAll();
		
		model.addAttribute("deptLists", deptLists);
		model.addAttribute("positionsLists", positionsLists);
		model.addAttribute("ranksLists", ranksLists);
		return "/user/signUp";
	}
}
