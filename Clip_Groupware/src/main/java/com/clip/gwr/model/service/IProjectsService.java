package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ProjectsVo;

public interface IProjectsService {

	// 프로젝트 전체 조회
	public List<ProjectsVo> getProjectsAll();

	// 프로젝트 진척도별 검색
	public List<ProjectsVo> projectsProgressSel();

	// 프로젝트 거래처별 검색
	public List<ProjectsVo> projectsClientSel(String cli_id);

	// 완료 프로젝트 검색
	public List<ProjectsVo> getCompletedProjects();

//	// 프로젝트 기간별 검색
//	public List<ProjectsVo> projectsPeriodSel(Map<String, Object> map);
}
