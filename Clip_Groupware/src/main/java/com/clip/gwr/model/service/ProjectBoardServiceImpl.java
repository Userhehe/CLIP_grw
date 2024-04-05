package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IProjectBoardDao;
import com.clip.gwr.vo.ProjectBoardVo;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectBoardServiceImpl implements IProjectBoardService {

	@Autowired
	private IProjectBoardDao dao;
	
	@Override
	public int insertProjectBoard(Map<String, Object> map) {
		int cnt = 0;
		// 클라이언트 인서트
		cnt = dao.insertProjectBoard(map);
		return cnt;
	}


	@Override
	public int deletePrjDetailTop(Map<String, Object> map) {
		int daoCnt = 0;
		log.info("ProjectBoardServiceImpl deletePrjDetailTop 프로젝트 상단 삭제버튼");
		daoCnt = dao.deletePrjDetailTop(map);
		
		if(daoCnt >0) {
			dao.deletePrjDetailMem(map);
		}
		return daoCnt;
	}
	
	@Override
	public List<ProjectBoardVo> getDetailBottomList(Map<String, Object> map) {
		return dao.getDetailBottomList(map);
	}


	@Override
	public int deletePrjDetailBottom(Map<String, Object> map) {
		return dao.deletePrjDetailBottom(map);
	}


	@Override
	public int selectMyPriv(Map<String, Object> map) {
		return dao.selectMyPriv(map);
	}


	@Override
	public int updatePrjStatus(Map<String, Object> map) {
		return dao.updatePrjStatus(map);
	}

}
