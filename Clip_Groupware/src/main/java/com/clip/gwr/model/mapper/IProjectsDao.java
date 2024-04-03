package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ProjectMemVo;
import com.clip.gwr.vo.ProjectsVo;

public interface IProjectsDao {

	// 프로젝트 전체 조회
	public List<ProjectsVo> getProjectsAll();

	//프로젝트 이름 조회
	public List<ProjectMemVo> getMemberName();
	
	// 프로젝트 진행중 검색
	public List<ProjectsVo> projectsProgressSel();
	
	// 프로젝트 완료된 검색
	public List<ProjectsVo> getCompletedProjects();
	
//	// 프로젝트 기간별 검색
//	public List<ProjectsVo> projectsPeriodSel(Map<String, Object> map);
	
	// 프로젝트 거래처별 검색
	public List<ProjectsVo> projectsClientSel(String cli_id);
	
	// 프로젝트 상세 조회
	public ProjectsVo projectsDetail(String prj_id);
	
	// 프로젝트 추가
	public int projectsInsert(Map<String, Object> map);

	// 프로젝트 수정
	public int projectsUpdate(Map<String, Object> map);

	// 진행중 혹은 완료 목록 조회
	public List<ProjectsVo> getProgressProjects(Map<String, Object> map);

	public int insertProject(Map<String, Object> map);

	public List<ProjectsVo> selectClientList();

	public int insertPrjMem(Map<String, Object> map);

	public int insertClient(Map<String, Object> map);

	public List<ProjectsVo> selectDetailList(String prjId);

	// 프로젝트 삭제
//	public int projectsDelete(String prj_id);
	
}
