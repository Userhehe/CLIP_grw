package com.clip.gwr.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("####login Success"); 
		List<String> roleNames = new ArrayList<String>(); 
		System.out.println("####roleNames : " + roleNames);

		authentication.getAuthorities().forEach(authority -> { 
			roleNames.add(authority.getAuthority()); 
		}); 
		log.info("####ROLE NAME : {}", roleNames);  

		/**
		 * 사용자 로그인
		 */
		if(roleNames.contains("ROLE_USER")) {
//		if(roleNames.contains("USER")) { 
			response.sendRedirect("./main.do"); 
			return; 
		} 

		/**
		 * 관리자 로그인
		 */
		if(roleNames.contains("ROLE_ADMIN")) { 
//		if(roleNames.contains("ADMIN")) { 
			response.sendRedirect("./adminMain.do"); 
			return; 
		}
//		response.sendRedirect("./index.jsp");
		response.sendRedirect("./loginForm.do"); 
	}

}
