package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IProjectsDao;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectsServiceImpl implements IProjectsService {
	
	@Autowired
	private IProjectsDao dao;

	@Override
	public List<ProjectsVo> getProjectsAll() {
		log.info("ProjectsServiceImpl projectsAll 프로젝트 전체조회");
		return dao.getProjectsAll();
	}
		
	
	@Override
	public List<ProjectsVo> projectsProgressSel() {
		log.info("ProjectsServiceImpl projectsProgressSel 진행도별 프로젝트 조회");
		return dao.projectsProgressSel();	
	}
	
	@Override
	public List<ProjectsVo> projectsClientSel(String cli_id) {
		log.info("ProjectsServiceImpl projectsClientSel 발주처별 프로젝트 조회");
		return dao.projectsClientSel(cli_id);
	}

//	@Override
//	public List<ProjectsVo> projectsPeriodSel(Map<String, Object> map) {
//		log.info("ProjectsServiceImpl projectsPeriodSel 기간별 프로젝트 조회");
//		return dao.projectsPeriodSel(prj_sdate);
//	}
}
