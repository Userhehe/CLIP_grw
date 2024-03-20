package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ProjectsVo;

public interface IProjectsDao {

	
	// 프로젝트 전체 조회
	public List<ProjectsVo> projectsAll();
	
	// 프로젝트 상세 조회
	public ProjectsVo projectsDetail(String prj_id);
	
	// 프로젝트 추가
	public int projectsInsert(Map<String, Object> map);
	
	// 프로젝트 수정
	public int projectsUpdate(Map<String, Object> map);
	
	// 프로젝트 삭제
//	public int projectsDelete(String prj_id);/
	
	// 프로젝트 거래처별 검색
//	public List<ProjectsVo> projectsClientSel();
	
	// 프로젝트 기간별 검색
	public List<ProjectsVo> projectsPeriodSel();
	
	// 프로젝트 진척도별 검색
	public List<ProjectsVo> projectsProgressSel();
	
}
