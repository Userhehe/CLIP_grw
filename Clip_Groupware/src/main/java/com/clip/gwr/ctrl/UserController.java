package com.clip.gwr.ctrl;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;
import com.clip.gwr.vo.UserVo;
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
		try {
			List<DeptVo> deptLists = deptService.deptAll();
			List<PositionsVo> positionsLists = positService.positionsAll();
			List<RanksVo> ranksLists = ranksService.ranksAll();
			
			model.addAttribute("deptLists", deptLists);
			model.addAttribute("positionsLists", positionsLists);
			model.addAttribute("ranksLists", ranksLists);
		} catch (Exception e) {
			e.printStackTrace();
			return "signUp";
		}
		return "signUp";
	}
	
	@PostMapping(value = "/signUp.do")
	public String signUpDone(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		
		String user_password = passwordEncoder.encode("clip1234");
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
		
		Map<String, Object> map = new HashMap<String, Object>();
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
		try {
			int signUp = userService.insertUserinfo(map);
			return "signUp";
		} catch (Exception e) {
			e.printStackTrace();
			return "signUp";
		}
	}
	
	@GetMapping(value = "/userInfo.do")
	public String userInfo(Model model) {
		log.info("userInfo 이동");
		
		try {
			List<UserinfoVo> userinfoList = userService.selectUserinfoList();
			List<DeptVo> deptLists = deptService.deptAll();
			List<PositionsVo> positionsLists = positService.positionsAll();
			List<RanksVo> ranksLists = ranksService.ranksAll();
			
			model.addAttribute("userList", userinfoList);
			model.addAttribute("deptLists", deptLists);
			model.addAttribute("positionsLists", positionsLists);
			model.addAttribute("ranksLists", ranksLists);
		} catch (Exception e) {
			e.printStackTrace();
			return "userInfo";
		}
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
		try {
			List<DeptVo> deptLists = deptService.deptAll();
			List<PositionsVo> positionsLists = positService.positionsAll();
			List<RanksVo> ranksLists = ranksService.ranksAll();
			
			model.addAttribute("deptLists", deptLists);
			model.addAttribute("positionsLists", positionsLists);
			model.addAttribute("ranksLists", ranksLists);
		} catch (Exception e) {
			e.printStackTrace();
			return "/user/signUp";
		}
		return "/user/signUp";
	}
	
//	@PostMapping(value = "/updatePasswordForm.do")
//	public ResponseEntity<String> updatePassword(UserVo vo, HttpServletRequest request, HttpServletResponse response){
//		Map<String, Object> map = new HashMap<String, Object>();
//		HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "text/html; charset=UTF-8");
//        String id = request.getParameter("id");
//		log.info("####아이디 값 : " + id);
//		String password = request.getParameter("password");
//		password = passwordEncoder.encode(password);
//		log.info("####비밀번호 값 : " + password);
//		map.put("password", password);
//		map.put("user_id", id);
//		try {
//			int updateUser =  userService.updateUserPassword(map);
//			log.info("####updateUser : " + updateUser);
//			return new ResponseEntity<>("비밀번호가 변경되었습니다.", headers, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>("비밀번호가 변경되지않았습니다.", headers, HttpStatus.OK);
//		}
//	}
	
	@GetMapping(value = "/searchUserList.do")
	public String searchUserList(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String searchDepts = request.getParameter("searchDepts");
		String searchPositions = request.getParameter("searchPositions");
		String searchRanks = request.getParameter("searchRanks");
		String searchName = request.getParameter("searchName");
		log.info("####startDate : " + startDate);
		log.info("####endDate : " + endDate);
		log.info("####searchDepts : " + searchDepts);
		log.info("####searchPositions : " + searchPositions);
		log.info("####searchRanks : " + searchRanks);
		log.info("####searchName : " + searchName);
		
		// 문자열을 Date 객체로 변환
        try {
			map.put("user_name", searchName);
			map.put("ranks_name", searchRanks);
			map.put("dept_name", searchDepts);
			map.put("positions_name", searchPositions);
			map.put("start_regdate", startDate);
			map.put("end_regdate", endDate);
			List<UserinfoVo> userList = userService.searchUserinfoList(map);
			log.info("####userList :: " + userList);
			List<DeptVo> deptLists = deptService.deptAll();
			List<PositionsVo> positionsLists = positService.positionsAll();
			List<RanksVo> ranksLists = ranksService.ranksAll();
			
			model.addAttribute("deptLists", deptLists);
			model.addAttribute("positionsLists", positionsLists);
			model.addAttribute("ranksLists", ranksLists);
			model.addAttribute("userList",userList);
		} catch (Exception e) {
			e.printStackTrace();
			return "userInfo";
		}
		return "userInfo";
	}
	
	@GetMapping(value = "/userInfoDetail.do")
	public String userInfoDetail(HttpServletRequest request, Model model) {
		String user_seq = request.getParameter("user_seq");
		log.info("####user_seq : " + user_seq);
		
		List<UserinfoVo> userDetailList = userService.selectUserinfoDetail(user_seq);
		log.info("####userDetailList : " + userDetailList);
		
		model.addAttribute("userDetailList",userDetailList);
		return "userInfoDetail";
	}
	
	@GetMapping(value = "/userInfoUpdate.do")
	public String userInfoUpdate(HttpServletRequest request, Model model) {
		String user_seq = request.getParameter("user_seq");
		log.info("####user_seq : " + user_seq);
		
		List<UserinfoVo> userDetailList = userService.selectUserinfoDetail(user_seq);
		log.info("####userDetailList : " + userDetailList);
		List<DeptVo> deptLists = deptService.deptAll();
		List<PositionsVo> positionsLists = positService.positionsAll();
		List<RanksVo> ranksLists = ranksService.ranksAll();
		
		model.addAttribute("userDetailList",userDetailList);
		model.addAttribute("deptLists", deptLists);
		model.addAttribute("positionsLists", positionsLists);
		model.addAttribute("ranksLists", ranksLists);
		return "userInfoUpdate";
	}
}
