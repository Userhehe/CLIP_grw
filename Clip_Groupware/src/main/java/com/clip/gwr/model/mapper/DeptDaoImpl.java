package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.DeptVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class DeptDaoImpl implements IDeptDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.DeptDaoImpl.";

	// 부서등록
	@Override
	public int insertDept(Map<String, Object> map) {
		log.info("##### 부서등록 insertDept #####");
		return sqlSession.insert(NS+"insertDept",map);
	}
    // 부서 수정 
	@Override
	public int updateDept(Map<String, Object> map) {
		log.info("##### 부서수정 updateDept #####");
		return sqlSession.update(NS+"updateDept",map);
	}
    // 부서 삭제 
	@Override
	public int delDept(String dept_seq) {
		log.info("##### 부서삭제 delDept #####");
		return sqlSession.delete(NS+"delDept",dept_seq);
	}
    //부서 검색 
	@Override
	public List<DeptVo> searchDept(String dept_name) {
		log.info("##### 부서검색 searchDept #####");
		return sqlSession.selectList(NS+"searchDept",dept_name);
	}
    // 부서 중복 검사 
	@Override
	public int duplicateCheckDept(String dept_name) {
		log.info("##### 부서 중복검사 duplicateCheckDept #####");
		return sqlSession.selectOne(NS+"duplicateCheckDept",dept_name);
	}
	// 부서 전체 조회  
	@Override
	public List<DeptVo> deptAll() {
		log.info("##### 부서 중복검사 deptAll #####");
		return sqlSession.selectList(NS+"deptAll");
	}

}
