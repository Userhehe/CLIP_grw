package com.clip.gwr.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@PostMapping(value = "/loginForm.do") 
	public String loginSession(HttpSession session,
			HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
		//Map<String, Object> map = new HashMap<String, Object>();
		
		String id = request.getParameter("username");
	    String pw = request.getParameter("password");
	    log.info("####pw: " + pw);
		//map.put("username",id);
		//map.put("user_password", pw);
		UserinfoVo user = service.userLogin(id);
		
		//session.setAttribute("UserVo", user);
		System.out.println("!!!!!!!!!!!!login : " + user);
		
		if(user != null) {
			// DB에서 가져온 사용자의 암호화된 비밀번호
			String dbPw = user.getUser_password();
			log.info("####dbPw : " + dbPw);
			
			// 사용자가 입력한 비밀번호와 DB에서 가져온 사용자의 암호화된 비밀번호를 비교
	        if (passwordEncoder.matches(pw, dbPw)) {
	            session.setAttribute("loginVo", user);
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script language='javascript'>");
	            out.println("alert('로그인되었습니다')");
	            out.println("</script>");
	            out.flush();
	            return "main";
	        } else {
	            response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script language='javascript'>");
	            out.println("alert('아이디 또는 비밀번호를 확인해주세요')");
	            out.println("</script>");
	            out.flush();
	            return "loginForm";
	        } 
		} else {
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script language='javascript'>");
	        out.println("alert('아이디 또는 비밀번호를 확인해주세요')");
	        out.println("</script>");
	        out.flush();
	        return "loginForm";
	    }
		
//		if(session.getAttribute("UserVo") == null) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script language='javascript'>");
//			out.println("alert('존재하는 로그인정보가 없습니다')");
//			out.println("</script>");
//			out.flush();
//			return "login";
//		}
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script language='javascript'>");
//		out.println("alert('로그인 되었습니다')");
//		out.println("</script>");
//		out.flush();
//		return "main";
	}

//	@GetMapping(value = "/logout.do")
//	public String logout() {
//		return "login";
//	}
}
