package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ProjectBoardVo;
import com.clip.gwr.vo.ProjectsVo;

public interface IProjectBoardDao {

	//보드글입력   
	public int insertProjectBoard(Map<String, Object> map);
	
	// 프로젝트보드 선택 조회
	public List<ProjectBoardVo> getProjectBoard(Map<String, Object> map);

	public int deletePrjDetailTop(Map<String, Object> map);

	public int deletePrjDetailMem(Map<String, Object> map);
	

}	

