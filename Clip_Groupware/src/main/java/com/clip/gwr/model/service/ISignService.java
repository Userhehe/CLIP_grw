package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.SignsVo;

public interface ISignService {

	// 서명 등록 
	public int insertPad(Map<String, Object> map) ;
	
	// 서명 삭제 
	public int delPad(String signs_seq);
	
	// 서명 조회 
	public SignsVo selectPad(String signs_seq);
	
	// 서명 전체 조회 
    public List<SignsVo> AllselectPad();
}
