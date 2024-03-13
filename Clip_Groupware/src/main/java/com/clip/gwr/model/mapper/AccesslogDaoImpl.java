package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.AccesslogVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AccesslogDaoImpl implements IAccesslogDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.AccesslogDaoImpl.";
	
	 // 사용자접속로그 등록
	@Override
	public int insertUserLog(Map<String, Object> map) {
		log.info("##### 사용자접속로그 등록 insertUserLog #####");
		return sqlSession.insert(NS+"insertUserLog",map);
	}
    
	// 사용자접속로그 조회
	@Override
	public List<AccesslogVo> selectUserLog(Map<String, Object> map) {
		log.info("##### 사용자접속로그 조회  selectUserLog #####");
		return sqlSession.selectList(NS + "selectUserLog",map);
	}

	// 사용자접속로그 검색
	@Override
	public List<AccesslogVo> searchUserLog(Map<String, Object> map) {
		log.info("##### 사용자접속로그 검색 searchUserLog #####");
		return sqlSession.selectList(NS + "searchUserLog", map);
	}

}
