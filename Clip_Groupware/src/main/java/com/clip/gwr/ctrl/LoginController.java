package com.clip.gwr.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private IUserService service;
		
	@PostMapping(value = "/login.do")
	public String loginSession(HttpSession session,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		String id = request.getParameter("user_id");
	    String pw = request.getParameter("user_password");
//	    pw = passwordEncoder.encode(pw);
	    Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id",id);
		map.put("user_password", pw);
	    log.info("####pw: " + pw);
		UserVo login = service.userLogin(map);
		session.setAttribute("UserVo", login);
		log.info("#####login : " + login);
		if(session.getAttribute("UserVo") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('존재하는 로그인정보가 없습니다')");
			out.println("</script>");
			out.flush();
			return "login";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('로그인되었습니다')");
			out.println("</script>");
			out.flush();
		}
		return "main";
	}
}
