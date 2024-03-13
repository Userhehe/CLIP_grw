package com.clip.gwr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessFilter implements Filter {
	
	@Override
	public void destroy() {
		log.info("▶▶▶ AccessFilter  destroy 실행 ◀◀◀");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("▶▶▶ AccessFilter  init 실행 ◀◀◀");
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
	
}
