package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.ProjectMemVo;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProjectsDaoImpl implements IProjectsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.ProjectsDaoImpl.";

	// 프로젝트 전체 조회
	@Override
	public List<ProjectsVo> getProjectsAll() {
		return sqlSession.selectList(NS + "getProjectsAll");
	}

	//프로젝트 이름 조회
	@Override
	public List<ProjectMemVo> getMemberName() {
		log.info("##### 프로젝트이름 조회 getMemberName");
		return sqlSession.selectList(NS+"getMemberName");
	}
	
	// 프로젝트 진행중 검색	
	@Override
	public List<ProjectsVo> projectsProgressSel() {
		return sqlSession.selectList(NS + "projectsProgressSel");
	}
	
	// 프로젝트 완료된 검색	
	@Override
	public List<ProjectsVo> getCompletedProjects() {
		return sqlSession.selectList(NS + "getCompletedProjects");
	}
	
//	// 프로젝트 기간별 검색	
//	@Override
//	public List<ProjectsVo> projectsPeriodSel(Map<String, Object> map) {
//		return sqlSession.selectList(NS + "projectsPeriodSel");
//	}
	
	// 프로젝트 거래처별 검색	
	@Override
	public List<ProjectsVo> projectsClientSel(String cli_id) {
		return sqlSession.selectList(NS + "projectsClientSel");
	}

	// 프로젝트 상세 조회	
	@Override
	public ProjectsVo projectsDetail(String prj_id) {
		return sqlSession.selectOne(NS + "projectsDetail", prj_id);
	}

	// 프로젝트 추가
	@Override
	public int projectsInsert(Map<String, Object> map) {
		return sqlSession.insert(NS + "projectsInsert", map);
	}

	// 프로젝트 수정
	@Override
	public int projectsUpdate(Map<String, Object> map) {
		return sqlSession.update(NS + "projectsUpdate", map);
	}


	// 프로젝트 삭제

//	@Override
//	public int projectsDelete() {
//		sqlSession.delete(NS+"projectsDelete",prj_id);
//		return sqlSession.delete(NS + "projectsDelete", map);
//	}

}
