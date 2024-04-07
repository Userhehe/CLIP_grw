package com.clip.gwr.security;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("####LoginService loadUserByUsername : {}", username);
		log.info("####LoginService repository : {}", dao);
		UserinfoVo userInfoVo = dao.userLogin(username);
		log.info("####userInfoVo : {}", userInfoVo);
//		if(userInfoVo != null) {
//			
//			return new User(username, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth()));
//		}else { 
//			log.info("#### userInfoVo가 널이야 ####");
//			return null; 
//		}
		if(userInfoVo != null) {
	        // 사용자 정보로 UserDetails 객체 생성
	        UserDetails userDetails = new User(username, userInfoVo.getUser_password(), AuthorityUtils.createAuthorityList(userInfoVo.getUser_auth()));
	        log.info("#### 왔어ㅓㅓㅓㅓ ####");
	        // 추가 정보 설정
	        Map<String, Object> additionalInfo = new HashMap<>();
	        additionalInfo.put("deptSeq", userInfoVo.getDept_seq()); // 부서코드 추가
	        additionalInfo.put("deptName", userInfoVo.getDept_name()); // 부서명 추가
	        additionalInfo.put("ranksSeq", userInfoVo.getRanks_seq()); // 직급코드 추가
	        additionalInfo.put("ranksName", userInfoVo.getRanks_name()); // 직급이름 추가
	        additionalInfo.put("positionsSeq", userInfoVo.getPositions_seq()); // 직책코드 추가
	        additionalInfo.put("positionsName", userInfoVo.getPositions_name()); // 직책이름 추가
	        additionalInfo.put("userStatus", userInfoVo.getUser_status()); // 재직여부 추가
	        additionalInfo.put("userRealname", userInfoVo.getUser_name()); // 이름 추가
	        log.info("****** deptSeq: " + userInfoVo.getDept_seq());
	        log.info("****** deptName: " + userInfoVo.getDept_name());
	        log.info("****** ranksSeq: " + userInfoVo.getRanks_seq());
	        log.info("****** ranksName: " + userInfoVo.getRanks_name());
	        log.info("****** positionsSeq: " + userInfoVo.getPositions_seq());
	        log.info("****** positionsName: " + userInfoVo.getPositions_name());
	        log.info("****** userStatus: " + userInfoVo.getUser_status());
	        log.info("****** userRealname: " + userInfoVo.getUser_name());
	        // 추가 정보를 포함한 UserDetails 객체 반환
	        return new CustomUserDetails(userDetails, additionalInfo);
	    } else { 
	        log.info("#### userInfoVo가 널이야 ####");
	        return null; 
	    }
		
		
	}
}
