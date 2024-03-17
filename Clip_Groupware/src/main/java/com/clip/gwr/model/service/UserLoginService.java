package com.clip.gwr.model.service;

import java.util.HashMap;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IUserDao;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserLoginService implements UserDetailsService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		// loadUserByUsername(String userId)은 UserDetailsService 인터페이스의 추상메서드로 사용자의 아이디를 입력받아 사용자의 상세정보를 로드 
 
		Map<String, Object> map = new HashMap<String, Object>();
		
		log.info("############################## username : " + userId);
//		log.info("LoginService loadUserByUsername : {}", user_id); 

		log.info("LoginService repository : {}", dao); 

		UserinfoVo userInfoVo = (UserinfoVo)dao.selectUserinfoDetail(map);	//userId로 상세정보 조회 
		
		log.info("LoginService userInfoVo : {}", userInfoVo); 

		if(userInfoVo != null) {
			/* 
				ROLE 정보가 여러개 있다면 Collection 객제로 전달한다. 
				Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>(); 
				roles.add(new SimpleGrantedAuthority(userInfoVo.getAuth())); 
				return new User(userId, userInfoVo.getPassword(), roles); 
			*/ 
			//return new User(userId, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth())); 
			return null;
		}else { 
			return null; 
		} 
	}
}
