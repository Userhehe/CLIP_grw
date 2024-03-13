package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.SignsVo;

public interface ISignsDao {

	// 서명 등록 
	public int insertPad(Map<String, Object> map) ;
	
	// 서명 삭제 
	public int delPad(Map<String, Object> map);
	
	// 서명 조회 
	public List<SignsVo> selectPad(Map<String, Object> map);
}
