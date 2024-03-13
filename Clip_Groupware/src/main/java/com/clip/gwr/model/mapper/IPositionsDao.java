package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;

public interface IPositionsDao {

	 //직책 등록 
	public int insertPositions(Map<String, Object>map);
	
	//직책 수정 
	public int updatePositions(Map<String, Object>map);
	
	// 직책 삭제 
	public int delPosition(Map<String, Object>map);
	
	// 직책 검색 
	public List<PositionsVo> searchPosition(Map<String, Object>map);
	
	// 직책 중복검사 
	public int duplicatePosItion(Map<String, Object>map);

}
