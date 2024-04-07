package com.clip.gwr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LoginCheckInterceptor implements AsyncHandlerInterceptor {
		@Autowired
	    private HttpSession session;
	
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			log.info("####인터셉터 시작 로그인 Session 확인 존재 /true, 없으면 false 로그인화면 호출");
			
//			UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
//			log.info("$$$$loginUser : " + loginUser);
//			if (isUserAlreadyLoggedIn(loginUser)) {
//				log.info("#####이미 로그인된 사용자래");
//	            // 이미 로그인한 사용자이면 다시 로그인 페이지로 리다이렉트 또는 에러 처리
//	            response.sendRedirect("./loginForm.do");
//	            return false;
//	        }
//			
//			if(request.getSession().getAttribute("loginVo")==null) {
//				log.info("####로그인 정보가 없습니다.");
//				response.sendRedirect("./loginForm.do");
//				return false;
//			}
//			return true;
			
			if(request.getSession().getAttribute("loginVo")==null) {
				log.info("####로그인 정보가 없습니다.");
				response.sendRedirect("./loginForm.do");
				return false;
			}
			return true;
		}
		
		private boolean isUserAlreadyLoggedIn(UserinfoVo user) {
			log.info("####로그인 상태래");
	        // 세션에 저장된 사용자 정보가 있으면 이미 로그인한 상태로 판단
	        return user != null;
	    }
		
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			log.info("####인터셉터 종료");
			AsyncHandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		}
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			log.info("####인터셉터 View 렌더링이 끝난 직후 ");
			AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		}
		@Override
		public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			log.info("####비동기(ResponseBody)식 호출되었을때 호출");
			AsyncHandlerInterceptor.super.afterConcurrentHandlingStarted(request, response, handler);
		}
}
