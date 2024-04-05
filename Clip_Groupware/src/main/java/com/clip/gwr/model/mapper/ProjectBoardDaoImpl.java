package com.clip.gwr.model.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.ProjectBoardVo;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProjectBoardDaoImpl implements IProjectBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.ProjectBoardDaoImpl.";

	@Override
	public int insertProjectBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS + "insertProjectBoard", map);
	}


	@Override
	public int deletePrjDetailTop(Map<String, Object> map) {
		return sqlSession.delete(NS + "deletePrjDetailTop", map);
	}

	@Override
	public int deletePrjDetailMem(Map<String, Object> map) {
		return sqlSession.delete(NS + "deletePrjDetailMem", map);
	}
	
	@Override
	public List<ProjectBoardVo> getDetailBottomList(Map<String, Object> map) {
		return sqlSession.selectList(NS + "getDetailBottomList", map);
	}


	@Override
	public int deletePrjDetailBottom(Map<String, Object> map) {
		return sqlSession.delete(NS + "deletePrjDetailBottom", map);
	}


	@Override
	public int selectMyPriv(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "selectMyPriv", map);
	}


	@Override
	public int updatePrjStatus(Map<String, Object> map) {
		return sqlSession.update(NS + "updatePrjStatus", map);
	}


}
