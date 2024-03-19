package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.SignsVo;

public interface ISignService {

	// 서명 등록 
	public int insertPad(Map<String, Object> map) ;
	
	// 서명 삭제 
	public int delPad(Map<String, Object> map);
	
	// 서명 조회 
	public List<SignsVo> selectPad(String userId);
	
	// 서명 전체 조회 
    public List<SignsVo> AllselectPad();
}
