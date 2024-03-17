package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.UserVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.UserDaoImpl.";
	
	/**
	 * 로그인
	 */
	@Override
	public UserinfoVo userLogin(Map<String, Object> map) {
		log.info("##### 로그인 userLogin #####");
		return sqlSession.selectOne(NS + "userLogin", map);
	}
	
	/**
	 * 아이디찾기
	 */
	@Override
	public UserVo findUserId(Map<String, Object> map) {
		log.info("##### 아이디찾기 findUserId #####");
		return sqlSession.selectOne(NS + "findUserId", map);
	}

	/**
	 * 비밀번호 재설정
	 */
	@Override
	public int updateUserPassword(Map<String, Object> map) {
		log.info("##### 비밀번호 재설정 updateUserPassword #####");
		return sqlSession.update(NS + "updateUserPassword", map);
	}
	
	/**
	 * 인증번호 저장
	 */
	@Override
	public int updateUserCertnum(Map<String, Object> map) {
		log.info("##### 인증번호 저장 updateUserCertnum #####");
		return sqlSession.update(NS + "updateUserCertnum", map);
	}
	
	/**
	 * 인증번호 확인
	 */
	@Override
	public int comparisonCertNum(Map<String, Object> map) {
		log.info("##### 인증번호 확인 comparisonCertNum #####");
		return sqlSession.selectOne(NS + "comparisonCertNum", map);
	}
	
	/**
	 * 사원정보 등록
	 */
	@Override
	public int insertUserinfo(Map<String, Object> map) {
		log.info("##### 사원등록 insertUserinfo #####");
		return sqlSession.insert(NS + "insertUserinfo", map);
	}
	
	/**
	 * 이메일&연락처 중복체크
	 */
	@Override
	public int duplicateCheckUserinfo(Map<String, Object> map) {
		log.info("##### 이메일&연락처 중복체크 duplicateCheckUserinfo #####");
		return sqlSession.selectOne(NS + "duplicateCheckUserinfo", map);
	}
	
	/**
	 * 사원목록 전체조회
	 */
	@Override
	public List<UserinfoVo> selectUserinfoList() {
		log.info("##### 사원전체조회 selectUserinfoList #####");
		return sqlSession.selectList(NS + "selectUserinfoList");
	}
	
	/**
	 * 사원목록 검색
	 */
	@Override
	public List<UserinfoVo> searchUserinfoList(Map<String, Object> map) {
		log.info("##### 사원목록 검색 searchUserinfoList #####");
		return sqlSession.selectList(NS + "searchUserinfoList", map);
	}
	
	/**
	 * 사원정보 상세조회
	 */
	@Override
	public List<UserinfoVo> selectUserinfoDetail(Map<String, Object> map) {
		log.info("##### 사원목록 상세조회 selectUserinfoDetail #####");
		return sqlSession.selectList(NS + "selectUserinfoDetail", map);
	}

	/**
	 * 사원정보 수정
	 */
	@Override
	public int updateUserinfo(Map<String, Object> map) {
		log.info("##### 사원정보수정 insertUserinfo #####");
		return sqlSession.update(NS + "updateUserinfo", map);
	}
	
	/**
	 * 재직증명서 다운로드
	 */
	@Override
	public List<UserinfoVo> selectJejicDownload(Map<String, Object> map) {
		log.info("##### 재직증명서 다운로드 selectJejicDownload #####");
		return sqlSession.selectList(NS + "selectJejicDownload", map);
	}
}