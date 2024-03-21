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
@Component
public class LoginService implements UserDetailsService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserinfoVo userInfoVo = dao.userLogin(username);
		if(userInfoVo != null) {
			return new User(username, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth()));
		}else { 
			log.info("#### userInfoVo가 널이야 ####");
			return null; 
		}
	}

	
	
	
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// loadUserByUsername(String userId)은 UserDetailsService 인터페이스의 추상메서드로 사용자의 아이디를 입력받아 사용자의 상세정보를 로드 
//		log.info("######LoginService loadUserByUsername : {}", username); 
//
//		log.info("#####LoginService repository : {}", dao); 
//
//		UserinfoVo userInfoVo = dao.userLogin(username);
//		
//		log.info("#####LoginService userInfoVo : {}", userInfoVo); 
//
//		if(userInfoVo != null) {
//			return new User(username, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth()));
//		}else { 
//			log.info("#### userInfoVo가 널이야 ####");
//			return null; 
//		}
		
//		UserinfoVo user = dao.userLogin(userId);
//        
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + userId);
//        }
//        
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUser_id())
//                .password(user.getUser_password())
//                .authorities(user.getUser_auth())
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//	}
}
