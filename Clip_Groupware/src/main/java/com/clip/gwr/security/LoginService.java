package com.clip.gwr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.clip.gwr.model.mapper.IUserDao;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginService implements UserDetailsService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("####LoginService loadUserByUsername : {}", username);
		log.info("####LoginService repository : {}", dao);
		UserinfoVo userInfoVo = dao.userLogin(username);
		log.info("####userInfoVo : {}", userInfoVo);
		if(userInfoVo != null) {
			return new User(username, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth()));
		}else { 
			log.info("#### userInfoVo가 널이야 ####");
			return null; 
		}
	}
}
