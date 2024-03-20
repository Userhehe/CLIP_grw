package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProjectsDaoImpl implements IProjectsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.ProjectsDaoImpl.";
	
	@Override
	public List<ProjectsVo> projectsAll() {
		return sqlSession.selectList(NS+"projectsAll");
	}
	
	@Override
	public ProjectsVo projectsDetail(String prj_id) {
		return sqlSession.selectOne(NS+"projectsDetail",prj_id);
	}
	
	@Override
	public int projectsInsert(Map<String,Object>map) {
		return sqlSession.insert(NS+"projectsInsert",map);
	}
	
	@Override
	public int projectsUpdate(Map<String,Object>map) {
		return sqlSession.update(NS+"projectsUpdate",map);
	}

//	@Override
//	public int projectsDelete(String gian_seq) {
//		return sqlSession.delete(NS+"projectsDelete",prj_id);
//	}
	
//	@Override
//	public List<ProjectsVo> projectsClientSel(String cli_name) {
//		return sqlSession.selectList(NS+"projectsClientSel",cli_name);
//	}/

	@Override
	public List<ProjectsVo> projectsPeriodSel() {
		return sqlSession.selectList(NS+"projectsPeriodSel");
	}
	
	@Override
	public List<ProjectsVo> projectsProgressSel() {
		return sqlSession.selectList(NS+"projectsProgressSel");
	}

}
