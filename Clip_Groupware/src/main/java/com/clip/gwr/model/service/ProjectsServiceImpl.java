package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IProjectsDao;
import com.clip.gwr.vo.ProjectMemVo;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectsServiceImpl implements IProjectsService {
	
	@Autowired
	private IProjectsDao dao;

	// 프로젝트 전체 조회
	@Override
	public List<ProjectsVo> getProjectsAll() {
		log.info("ProjectsServiceImpl projectsAll 프로젝트 전체조회");
		return dao.getProjectsAll();
	}

	//프로젝트 이름 조회
	@Override
	public List<ProjectMemVo> getMemberName() {
		return dao.getMemberName();
	}
	
	// 프로젝트 진행중 검색	
	@Override
	public List<ProjectsVo> projectsProgressSel() {
		log.info("ProjectsServiceImpl projectsProgressSel 진행도별 프로젝트 조회");
		return dao.projectsProgressSel();
	}
	
	// 프로젝트 완료된 검색	
	@Override
	public List<ProjectsVo> getCompletedProjects() {
		log.info("ProjectsServiceImpl getCompletedProjects 완성된 프로젝트 조회");
		return dao.getCompletedProjects();
	}
	
//	// 프로젝트 기간별 검색	
//	@Override
//	public List<ProjectsVo> projectsPeriodSel(Map<String, Object> map) {
//		log.info("ProjectsServiceImpl projectsPeriodSel 기간별 프로젝트 조회");
//		return dao.projectsPeriodSel(prj_sdate);
//	}
	
	// 프로젝트 거래처별 검색	
	@Override
	public List<ProjectsVo> projectsClientSel(String cli_id) {
		log.info("ProjectsServiceImpl projectsClientSel 발주처별 프로젝트 조회");
		return dao.projectsClientSel(cli_id);
	}

	// 프로젝트 추가	
	@Override
	public int projectsInsert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProjectsVo> getProgressProjects(Map<String, Object> map) {
		return dao.getProgressProjects(map);
	}

	@Override
	public int insertProject(Map<String, Object> map) {
		int cnt = 0;
		String prjId = "";
		// 프로젝트 인서트
		 // cnt = dao.insertProject(map);
		cnt = dao.insertProject(map);
		// 프로젝트 멤버도 인서트
		if(cnt>0) {
			dao.insertPrjMem(map);
		}

		return cnt;
	}
	
	@Override
	public int insertClient(Map<String, Object> map) {
		int cnt = 0;
		String cliName = "";
		// 프로젝트 인서트
		cnt = dao.insertClient(map);
		return cnt;
	}

	@Override
	public List<ProjectsVo> selectClientList() {
		return dao.selectClientList();
	}

	@Override
	public List<ProjectsVo> selectDetailList(String prjId) {
		return dao.selectDetailList(prjId);
	}


}
