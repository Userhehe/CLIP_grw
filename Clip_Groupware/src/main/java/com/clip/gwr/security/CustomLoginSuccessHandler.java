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
		
			log.info("login Success"); 
			List<String> roleNames = new ArrayList<String>(); 
			/* 
				Spring Security의 Authentication 객체에서 사용자의 권한(authority) 정보를 추출하여 roleNames 리스트에 추가 
				authentication.getAuthorities()는 현재 사용자의 권한을 나타내는 컬렉션을 반환 
				ex) // ["ROLE_USER"],["ROLE_ADMIN"] 
			*/ 
			authentication.getAuthorities().forEach(authority -> { 
			roleNames.add(authority.getAuthority()); 
		}); 

		log.info("ROLE NAME : {}", roleNames); 

		// 시스템 관리자 로그인 시 

//		if(roleNames.contains("SYSADMIN")) { 
//			response.sendRedirect("./system.do"); 
//			return; 
//		} 

		// 관리자 로그인 시 

//		if(roleNames.contains("ADMIN")) { 
//			response.sendRedirect("./admin.do"); 
//			return; 
//		} 	 

		// 사용자 로그인 시 

		if(roleNames.contains("USER")) { 
			response.sendRedirect("./main.do"); 
			return; 
		} 

		response.sendRedirect("./login.do"); 
	}

}
