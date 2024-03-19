package com.clip.gwr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.clip.gwr.model.mapper.IUserDao;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginService implements UserDetailsService {
	
	@Autowired
	private IUserDao dao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
 
		// loadUserByUsername(String userId)은 UserDetailsService 인터페이스의 추상메서드로 사용자의 아이디를 입력받아 사용자의 상세정보를 로드 
		log.info("############################## username : " + userId);
		log.info("LoginService loadUserByUsername : {}", userId); 

		log.info("LoginService repository : {}", dao); 

		UserinfoVo userInfoVo = dao.userLogin(userId);
		
		log.info("#####LoginService userInfoVo : {}", userInfoVo); 

		if(userInfoVo != null) {
			return new User(userId, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth())); 
		}else { 
			return null; 
		} 
	}
}
