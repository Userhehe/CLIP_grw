package com.clip.gwr.ctrl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IAnnualService;
import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IFileUploadService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.ISignService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.FileVo;
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
	
	@Autowired
	private IFileUploadService fileUploadService;
	
	@Autowired
	private IAnnualService annualService;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private ISignService signService;
	
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
	/**
	 * 로그인페이지로 이동
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/loginForm.do") 
	public String loginForm(Model model) {
		return "loginForm";
	}
	
	/**
	 * 사용자정보등록 페이지로 이동
	 * @param model
	 * @return
	 */
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
			return "accessError";
		}
		return "signUp";
	}
	
	/**
	 * 사용자 정보 등록
	 * @param session
	 * @param response
	 * @param request
	 * @return
	 */
	@Transactional
	@PostMapping(value = "/signUp.do")
	public String signUpDone(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		String inputPhoneFirstnum = request.getParameter("inputPhoneFirstnum");
		String phoneFirstnum = "";
		if(inputPhoneFirstnum == null || inputPhoneFirstnum =="") {
			phoneFirstnum = request.getParameter("phoneFirstnum");
		} else {
			phoneFirstnum = inputPhoneFirstnum;
		}
		
		String user_password = passwordEncoder.encode("clip1234"); // 사용자 등록시 처음 비밀번호
		String user_name = request.getParameter("userName");
		String user_registnum = request.getParameter("userStartRegistnum") + "-"
								+ request.getParameter("userLastRegistnum");
		String user_email = request.getParameter("userEmail") + "@" + request.getParameter("emailDomain");
		
		String user_birthday = request.getParameter("userBirthday");
		String user_phonenum = phoneFirstnum + "-" 
							+ request.getParameter("phoneSecondnum") + "-"
							+ request.getParameter("phoneLastnum");
		String user_address = request.getParameter("userAddress");
		String dept_name = request.getParameter("deptName");
		String ranks_name = request.getParameter("ranksName");
		String positions_name = request.getParameter("positionsName");
		String user_auth = request.getParameter("userAuth");	
		String user_regdate = request.getParameter("userRegdate");
		
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
		log.info("#### user_regdate : " + user_regdate);
		
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
		map.put("user_regdate", user_regdate);
		try {
			int signUp = userService.insertUserinfo(map);
			log.info("####signUp : " + signUp);
//			int insertAnn = annualService.insertAnn(map);
//			log.info("####insertAnn : " + insertAnn);
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>");
            out.println("alert('사용자정보가 등록되었습니다.')");
            out.println("</script>");
            out.flush();
			return "signUp";
		} catch (Exception e) {
			e.printStackTrace();
			return "accessError";
		}
	}
	
	/**
	 * 사용자목록 조회로 이동 
	 * @param model
	 * @return
	 */
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
		}
		return "/user/signUp";
	}
	
	/**
	 * 사용자 목록 검색
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/searchUserList.do")
	public String searchUserList(HttpServletRequest request, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchName = request.getParameter("searchName");
		String searchRanks = request.getParameter("searchRanks");
		String searchDepts = request.getParameter("searchDepts");
		String searchPositions = request.getParameter("searchPositions");
		String user_status = request.getParameter("searchStatus");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
        try {
			map.put("user_name", searchName);
			map.put("ranks_name", searchRanks);
			map.put("dept_name", searchDepts);
			map.put("positions_name", searchPositions);
			map.put("user_status", user_status);
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
		}
		return "userInfo";
	}
	
	/**
	 * 사용자정보 상세조회
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/userInfoDetail.do")
	public String userInfoDetail(HttpServletRequest request, Model model) {
		String user_seq = request.getParameter("user_seq");
		log.info("####user_seq : " + user_seq);
		
		List<UserinfoVo> userDetailList = userService.selectUserinfoDetail(user_seq);
		log.info("####userDetailList : " + userDetailList);
		
		model.addAttribute("userDetailList",userDetailList);
		return "userInfoDetail";
	}
	
	/**
	 * 사용자정보 수정 화면 이동
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/userInfoUpdate.do")
	public String userInfoUpdate(HttpServletRequest request, Model model) {
		String user_id = request.getParameter("user_seq");
		log.info("####user_seq : " + user_id);
		
		List<UserinfoVo> userDetailList = userService.selectUserinfoDetail(user_id);
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
	
	/**
	 * 사용자정보 수정
	 * @param request
	 * @param response
	 */
	@PostMapping(value = "/userInfoUpdateData.do")
	public void userInfoUpdateData(HttpServletRequest request, HttpServletResponse response) {
		String inputPhoneFirstnum = request.getParameter("inputPhoneFirstnum");
		String phoneFirstnum = "";
		if(inputPhoneFirstnum == null || inputPhoneFirstnum =="") {
			phoneFirstnum = request.getParameter("phoneFirstnum");
		} else {
			phoneFirstnum = inputPhoneFirstnum;
		}
		
		String user_id = request.getParameter("userId");
		String user_name = request.getParameter("userName");
		String user_registnum = request.getParameter("userStartRegistnum") + "-"
								+ request.getParameter("userLastRegistnum");
		String user_email = request.getParameter("userEmail") + "@" + request.getParameter("emailDomain");
		
		String user_birthday = request.getParameter("userBirthday");
		String user_phonenum = phoneFirstnum + "-" 
							+ request.getParameter("phoneSecondnum") + "-"
							+ request.getParameter("phoneLastnum");
		String user_address = request.getParameter("userAddress");
		String dept_name = request.getParameter("deptName");
		String ranks_name = request.getParameter("ranksName");
		String positions_name = request.getParameter("positionsName");
		String user_auth = request.getParameter("userAuth");
		String user_status = request.getParameter("userStatus");
		String user_regdate = request.getParameter("userRegdate");
		
		log.info("#### user_id : " + user_id);
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
		log.info("#### user_status : " + user_status);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
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
		map.put("user_status", user_status);
		map.put("user_regdate", user_regdate);
		try {
			int updateUserInfo = userService.updateUserinfo(map);
			log.info("####updateUserInfo : " + updateUserInfo);
			if(user_status == "N") {
				response.sendRedirect("./userInfo.do");
			}
			response.sendRedirect("./userInfoUpdate.do?user_seq=" + user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 이메일 중복체크
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/emailCheck.do")
	@ResponseBody
	public Map<String, Integer> emailCheck(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String user_email = request.getParameter("frontEmail") + "@" + request.getParameter("backEmail");
		log.info("####user_email : " + user_email);
		map.put("user_email", user_email);
		int emailCheck = userService.duplicateCheckEmail(map);
		log.info("####emailCheck : " + emailCheck);
		
		Map<String, Integer> response = new HashMap<>();
	    response.put("emailCheck", emailCheck);
	    return response;
	}
	
	/**
	 * 마이페이지
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/myPage.do")
	public String myPage(HttpSession session, HttpServletResponse response, Model model) {
		UserinfoVo loginVo = (UserinfoVo)session.getAttribute("loginVo");
		log.info("####loginVo : " + loginVo);
		String user_id = loginVo.getUser_id();
		try {
			List<UserinfoVo> userDetailList = userService.selectUserinfoDetail(user_id);
			log.info("####userDetailList : " + userDetailList);
			List<FileVo> fileList = fileUploadService.selectPhotoinfo(user_id);
			log.info("####fileList : " + fileList);
			int checkPhotoUse = fileUploadService.checkPhotoUse(user_id);
			log.info("####checkPhotoUse : " + checkPhotoUse);
			int checkPad = signService.checkPad(user_id);
			log.info("####checkPad : " + checkPad);
			
			String fileStorename = fileUploadService.selectPhotoName(user_id);
			log.info("####beforeSaveFileName : " + fileStorename);
			
			model.addAttribute("fileStorename",fileStorename);
			model.addAttribute("userDetailList",userDetailList);
			model.addAttribute("fileList",fileList);
			model.addAttribute("checkPhotoUse",checkPhotoUse);
			model.addAttribute("checkPad", checkPad);
			return "myPage";
		} catch (Exception e) {
			e.printStackTrace();
			return "accessError";
		}
	}
	
	/**
	 * 재직증명서 조회
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/certiOfImpl.do")
	public String certiOfImpl(HttpSession session, Model model) {
		UserinfoVo loginVo = (UserinfoVo)session.getAttribute("loginVo");
		log.info("####loginVo : " + loginVo);
		String user_id = loginVo.getUser_id();
		List<UserinfoVo> jejicLists = userService.selectJejicDownload(user_id);
		log.info("####jejicLists : " + jejicLists);
		model.addAttribute("jejicLists",jejicLists);
		return "certiOfImpl";
	}
}
