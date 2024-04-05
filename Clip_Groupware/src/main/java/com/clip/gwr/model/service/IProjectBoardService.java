package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.clip.gwr.vo.ProjectBoardVo;
import com.clip.gwr.vo.ProjectsVo;

public interface IProjectBoardService {
	// 프로젝트 보드 입력
	public int insertProjectBoard(Map<String, Object> map);
	

	public int deletePrjDetailTop(Map<String, Object> map);
	
	public List<ProjectBoardVo> getDetailBottomList(Map<String, Object> map);


	public int deletePrjDetailBottom(Map<String, Object> map);


	public int selectMyPriv(Map<String, Object> map);


	public int updatePrjStatus(Map<String, Object> map);
}
