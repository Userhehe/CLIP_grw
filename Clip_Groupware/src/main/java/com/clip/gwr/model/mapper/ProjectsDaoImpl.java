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
	public List<ProjectsVo> getProjectsAll() {
		return sqlSession.selectList(NS + "getProjectsAll");
	}

	@Override
	public ProjectsVo projectsDetail(String prj_id) {
		return sqlSession.selectOne(NS + "projectsDetail", prj_id);
	}

	@Override
	public int projectsInsert(Map<String, Object> map) {
		return sqlSession.insert(NS + "projectsInsert", map);
	}

	@Override
	public int projectsUpdate(Map<String, Object> map) {
		return sqlSession.update(NS + "projectsUpdate", map);
	}

//	@Override
//	public int projectsDelete(String gian_seq) {
//		return sqlSession.delete(NS+"projectsDelete",prj_id);
//	}

	@Override
	public List<ProjectsVo> projectsClientSel(String cli_id) {
		return sqlSession.selectList(NS + "projectsClientSel");
	}

	@Override
	public List<ProjectsVo> projectsPeriodSel(Map<String, Object> map) {
		return sqlSession.selectList(NS + "projectsPeriodSel");
	}

	@Override
	public List<ProjectsVo> projectsProgressSel() {
		return sqlSession.selectList(NS + "projectsProgressSel");
	}

	@Override
	public List<ProjectsVo> getCompletedProjects() {
		String sql = "SELECT * FROM projects WHERE prj_status = '완료'";
		return sqlSession.selectList(NS + "projectsProgressSel");
	}

}
