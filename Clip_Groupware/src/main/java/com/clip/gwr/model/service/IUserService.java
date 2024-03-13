package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.UserVo;
import com.clip.gwr.vo.UserinfoVo;

public interface IUserService {
	
	/**
	 * 로그인
	 * @param map
	 * @return
	 */
	public UserVo userLogin(Map<String, Object> map);
	
	/**
	 * 아이디 찾기
	 * @param map
	 * @return
	 */
	public UserVo findUserId(Map<String, Object> map);
	
	/**
	 * 비밀번호 재설정
	 * @param map
	 * @return
	 */
	public int updateUserPassword(Map<String, Object> map);
	
	/**
	 * 인증번호 저장
	 * @param map
	 * @return
	 */
	public int updateUserCertnum(Map<String, Object> map);
	
	/**
	 * 인증번호 확인
	 * @param map
	 * @return
	 */
	public int comparisonCertNum(Map<String, Object> map);
	
	/**
	 * 사원정보 등록
	 * @param map
	 * @return
	 */
	public int insertUserinfo(Map<String, Object> map);
	
	/**
	 * 이메일 & 연락처 중복체크
	 * @param map
	 * @return
	 */
	public int duplicateCheckUserinfo(Map<String, Object> map);
	
	/**
	 * 사원목록 전체조회
	 * @return
	 */
	public List<UserinfoVo> selectUserinfoList();
	
	/**
	 * 사원목록 검색
	 * @return
	 */
	public List<UserinfoVo> searchUserinfoList(Map<String, Object> map);
	
	/**
	 * 사원정보 상세조회
	 * @return
	 */
	public List<UserinfoVo> selectUserinfoDetail(Map<String, Object> map);
	
	/**
	 * 사원정보 수정
	 * @param map
	 * @return
	 */
	public int updateUserinfo(Map<String, Object> map);
	
	/**
	 * 재직증명서 다운로드
	 * @param map
	 * @return
	 */
	public List<UserinfoVo> selectJejicDownload(Map<String, Object> map);
}
