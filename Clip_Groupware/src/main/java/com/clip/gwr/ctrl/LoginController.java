package com.clip.gwr.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IFileUploadService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private IFileUploadService fileUploadService;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
//	@PostMapping(value = "/loginForms.do")
//	public String loginSession(HttpSession session,
//			HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
//		String id = request.getParameter("username");
//	    String pw = request.getParameter("password");
//	    log.info("####pw: " + pw);
//	    
//		try {
//			UserinfoVo user = service.userLogin(id);
//			
//			System.out.println("####user : " + user);
//			
//			if(user != null) {
//				// DB에서 가져온 사용자의 암호화된 비밀번호
//				String dbPw = user.getUser_password();
//				log.info("####dbPw : " + dbPw);
//				
//				// 사용자가 입력한 비밀번호와 DB에서 가져온 사용자의 암호화된 비밀번호를 비교
//			    if (passwordEncoder.matches(pw, dbPw)) {
//			        session.setAttribute("loginVo", user);
//			        if (request.getSession().getAttribute("loginCookieAlert") == null) {
//			        	response.setContentType("text/html; charset=UTF-8");
//			        	PrintWriter out = response.getWriter();
//			        	out.println("<script language='javascript'>");
//			        	out.println("alert('로그인되었습니다')");
//			        	out.println("</script>");
//			        	out.flush();
//			        	
//			        	 로그인 alert를 한번만 띄우기 위한 쿠키 세션에 추가
//			        	Cookie alertCookie = new Cookie("loginCookieAlert", "true");
//			            alertCookie.setMaxAge(60 * 60 * 24); // 쿠키 유효시간 1일
//			            response.addCookie(alertCookie);
//			            session.setAttribute("loginCookieAlert", true);
//			        }
//			        return "main";
//			    } else {
//			        response.setContentType("text/html; charset=UTF-8");
//			        PrintWriter out = response.getWriter();
//			        out.println("<script language='javascript'>");
//			        out.println("alert('아이디 또는 비밀번호를 확인해주세요')");
//			        out.println("</script>");
//			        out.flush();
//			        return "loginForm";
//			    } 
//			} else {
//			    response.setContentType("text/html; charset=UTF-8");
//			    PrintWriter out = response.getWriter();
//			    out.println("<script language='javascript'>");
//			    out.println("alert('아이디 또는 비밀번호를 확인해주세요')");
//			    out.println("</script>");
//			    out.flush();
//			    return "loginForm";
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "accessError";
//		}
//	}
	
	
	@PostMapping(value = "/loginForms.do")
	@ResponseBody
	public int loginSession(HttpSession session,
			HttpServletResponse response, HttpServletRequest request, Model model) {
		String id = request.getParameter("username");
	    String pw = request.getParameter("password");
	    log.info("####pw: " + pw);
	    
		try {
			UserinfoVo user = service.userLogin(id);
			String user_id = user.getUser_id();
			String fileStorename = fileUploadService.selectPhotoName(user_id);
			
			System.out.println("####user : " + user);
			
			if(user != null) {
				// DB에서 가져온 사용자의 암호화된 비밀번호
				String dbPw = user.getUser_password();
				log.info("####dbPw : " + dbPw);
				
				// 사용자가 입력한 비밀번호와 DB에서 가져온 사용자의 암호화된 비밀번호를 비교
			    if (passwordEncoder.matches(pw, dbPw)) {
			        session.setAttribute("loginVo", user);
			        session.setAttribute("fileStorename", fileStorename);
			        return 1;
			    } else {
			        return 2;
			    } 
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	

	@GetMapping(value = "/logout.do")
	@ResponseBody
	public int logout(HttpSession session, HttpServletResponse response) throws IOException {
		log.info("--------로그아웃-------");
		session.invalidate();
		return 1;
	}
//	
//	@GetMapping(value = "/adminMain.do")
//	public String adminMain() {
//		return "adminMain";
//	}
}
