package com.clip.gwr.filter;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessFilter implements Filter {
	
	@Override
	public void destroy() {
		log.info("----- AccessFilter  destroy -----");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "URL 없음");
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
		
		log.info("Client 요청주소 \n\t  {}",url+queryString);
		chain.doFilter(req, response);

	}
	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest)request;
//		String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "URL 없음");
//		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
//		
//		HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = req.getSession(false); // 세션이 없을 경우 null 반환
//
//        if (session == null || session.getAttribute("loginVo") == null) {
////            httpResponse.sendRedirect("./Clip_Groupware/loginForm.do");
//            httpResponse.sendRedirect("/Clip_Groupware/loginForm.do");
//        } else {
//        	log.info("Client 요청주소 \n\t  {}",url + queryString);
//            chain.doFilter(request, response);
//        }
//	}
	
//	@Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//
//        // 특정 URL을 제외하고 싶은 경우
//        if (!url.equals("/loginForm.jsp")) {
//        	HttpServletRequest req = (HttpServletRequest)request;
//    		url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "URL 없음");
//    		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
//    		
//    		HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//            HttpSession session = req.getSession(false); // 세션이 없을 경우 null 반환
//
//            if (session == null || session.getAttribute("loginVo") == null) {
//                httpResponse.sendRedirect("./loginForm.do");
//            } else {
//            	log.info("Client 요청주소 \n\t  {}",url + queryString);
//                chain.doFilter(request, response);
//            }
//            chain.doFilter(request, response);
//        } else {
//            // 제외할 URL인 경우 필터를 통과시킴
//            chain.doFilter(request, response);
//        }
//    }

}
