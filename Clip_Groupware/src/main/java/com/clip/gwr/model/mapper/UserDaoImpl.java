package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.UserDaoImpl.";
	
	/**
	 * 사원전체조회
	 */
	@Override
	public List<UserinfoVo> selectUserinfoList() {
		log.info("##### 사원전체조회 selectUserinfoList #####");
		return sqlSession.selectList(NS + "selectUserinfoList");
	}

	/**
	 * 사원정보등록
	 */
	@Override
	public int insertUserinfo(Map<String, Object> map) {
		log.info("##### 사원등록 insertUserinfo #####");
		return sqlSession.insert(NS + "insertUserinfo", map);
	}

	/**
	 * 사원정보수정
	 */
	@Override
	public int updateUserinfo(Map<String, Object> map) {
		log.info("##### 사원정보수정 insertUserinfo #####");
		return sqlSession.update(NS + "updateUserinfo", map);
	}
	
	
}