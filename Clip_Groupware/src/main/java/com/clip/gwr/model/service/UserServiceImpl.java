package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IUserDao;
import com.clip.gwr.vo.UserVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;
	
	/** 
	 * 로그인
	 */
	@Override
	public UserinfoVo userLogin(String username) {
		log.info("UserServiceImpl userLogin 로그인");
		return dao.userLogin(username);
	}

	/**
	 * 아이디찾기
	 */
	@Override
	public UserVo findUserId(String email) {
		log.info("UserServiceImpl findUserId 아이디찾기");
		return dao.findUserId(email);
	}
	
	/**
	 * 비밀번호 재설정 이메일 찾기
	 */
	@Override
	public UserVo findUserEmail(String user_id) {
		log.info("UserServiceImpl findUserId 아이디찾기");
		return dao.findUserEmail(user_id);
	}
	
	/**
	 * 인증번호 저장
	 */
	@Override
	public int updateUserCertnum(Map<String, Object> map) {
		log.info("UserServiceImpl updateUserPassword 인증번호 저장");
		return dao.updateUserCertnum(map);
	}
	
	/**
	 * 인증번호 확인
	 */
	@Override
	public int comparisonCertNum(Map<String, Object> map) {
		log.info("UserServiceImpl updateUserPassword 인증번호 확인");
		return dao.comparisonCertNum(map);
	}
	
	/**
	 * 비밀번호 재설정
	 */
	@Override
	public int updateUserPassword(Map<String, Object> map) {
		log.info("UserServiceImpl updateUserPassword 비밀번호 재설정");
		return dao.updateUserPassword(map);
	}
	
	/**
	 * 사원정보 등록
	 */
	@Override
	public int insertUserinfo(Map<String, Object> map) {
		log.info("UserServiceImpl insertUserinfo 사원정보등록");
		return dao.insertUserinfo(map);
	}
	
	/**
	 * 이메일&연락처 중복체크
	 */
	@Override
	public int duplicateCheckUserinfo(Map<String, Object> map) {
		log.info("UserServiceImpl duplicateCheckUserinfo 이메일&연락처 중복체크");
		return dao.duplicateCheckUserinfo(map);
	}
	
	/**
	 * 사원목록 전체조회
	 */
	@Override
	public List<UserinfoVo> selectUserinfoList() {
		log.info("UserServiceImpl selectUserinfoList 사원목록전체조회");
		return dao.selectUserinfoList();
	}

	/**
	 * 사원목록 검색
	 */
	@Override
	public List<UserinfoVo> searchUserinfoList(Map<String, Object> map) {
		log.info("UserServiceImpl searchUserinfoList 사원목록 검색");
		return dao.searchUserinfoList(map);
	}

	
	/**
	 * 사원정보 상세조회
	 */
	@Override
	public List<UserinfoVo> selectUserinfoDetail(String user_id) {
		log.info("UserServiceImpl selectUserinfoDetail 사원정보 상세조회");
		return dao.selectUserinfoDetail(user_id);
	}
	
	/**
	 * 사원정보 수정
	 */
	@Override
	public int updateUserinfo(Map<String, Object> map) {
		log.info("UserServiceImpl updateUserinfo 사원정보 수정");
		return dao.updateUserinfo(map);
	}

	
	/**
	 * 재직증명서 다운로드
	 */
	@Override
	public List<UserinfoVo> selectJejicDownload(Map<String, Object> map) {
		log.info("UserServiceImpl selectJejicDownload 재직증명서 다운로드");
		return dao.selectJejicDownload(map);
	}

	/**
	 * 사용자 권한 조회
	 */
	@Override
	public String selectUserAuth(String user_id) {
		log.info("UserServiceImpl selectUserAuth 사용자 권한 조회");
		return dao.selectUserAuth(user_id);
	}

}
