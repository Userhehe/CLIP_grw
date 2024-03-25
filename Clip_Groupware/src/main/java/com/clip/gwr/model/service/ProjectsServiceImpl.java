package com.clip.gwr.model.service;

import java.util.List;

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
	public List<ProjectsVo> projectsAll() {
		log.info("ProjectsServiceImpl projectsAll 프로젝트 전체조회");
		return dao.projectsAll();
	}

}
