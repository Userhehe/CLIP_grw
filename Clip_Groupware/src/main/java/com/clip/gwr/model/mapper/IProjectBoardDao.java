package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ProjectBoardVo;

public interface IProjectBoardDao {

	//ROOT글입력   
	public int insertBoard(ProjectBoardVo vo);
	
	//전체조회   
	public List<ProjectBoardVo> selectAllBoard();
	
	//글상세   
	public ProjectBoardVo selectDetailBoard(String seq);
	
	//답글업데이트   
	public int replyUpdate(ProjectBoardVo vo);
	
	//답글입력   
	public int replyInsert(ProjectBoardVo vo);
	
	//답글입력
//	public int reply(ProjectBoardVo vo);
	
	//글수정   
	public int modifyBoard(Map<String, Object>map);
	
	//글삭제  deleteBoard
	public int deleteBoard(String seq);
	
	//다중삭제 multideleteBoard
//	public int multidelete(String[] seqs);
	
	//다중 글삭제
	public int multideleteBoard(List<String> seqs);
}	

