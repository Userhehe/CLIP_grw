package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.UserVo;
import com.clip.gwr.vo.UserinfoVo;

public interface IUserDao {
	
	/**
	 * 로그인
	 * @param username
	 * @return
	 */
	public UserinfoVo userLogin(String username);
	
	/**
	 * 아이디 찾기
	 * @param email 
	 * @return
	 */
	public UserVo findUserId(String email);
	
	/**
	 * 비밀번호 재설정 이메일 찾기
	 * @param user_id
	 * @return
	 */
	public UserVo findUserEmail(String user_id);
	
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
	 * 비밀번호 재설정
	 * @param map
	 * @return
	 */
	public int updateUserPassword(Map<String, Object> map);
	
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
	public int duplicateCheckEmail(Map<String, Object> map);
	
	/**
	 * 사원목록 전체조회
	 * @return
	 */
	public List<UserinfoVo> selectUserinfoList(Map<String, Object> map);
	
	/**
	 * 사원목록 검색
	 * @return
	 */
	public List<UserinfoVo> searchUserinfoList(Map<String, Object> map);
	
	/**
	 * 사원정보 상세조회
	 * @return
	 */
	public List<UserinfoVo> selectUserinfoDetail(String user_id);
	
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
	public List<UserinfoVo> selectJejicDownload(String user_id);
	
	/**
	 * 사용자 권한 조회
	 * @param user_id
	 * @return
	 */
	public String selectUserAuth(String user_id);
	
	/**
	 * 대표 싸인 가져오기
	 * @param boss_name
	 * @return
	 */
	public String selectSignImage(String boss_name);
	
	/**
	 * 사용자 수 카운트
	 * @return
	 */
	public int selectUserInfoListCnt();
	
	/**
	 * 사용자 검색 결과 수 카운트
	 * @param map
	 * @return
	 */
	public int selectSearchUserInfoListCnt(Map<String, Object> map);
	
	
	public List<String> selectAllUser();
}
