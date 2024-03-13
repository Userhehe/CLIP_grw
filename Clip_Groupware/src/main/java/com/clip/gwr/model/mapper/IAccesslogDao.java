package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.AccesslogVo;

public interface IAccesslogDao {

	 // 사용자접속로그 등록
	public int insertUserLog(Map<String, Object>map);
	
	 // 사용자접속로그 조회
	public List<AccesslogVo> selectUserLog(Map<String, Object>map);
	
	// 사용자접속로그 검색
	public List<AccesslogVo> searchUserLog(Map<String, Object>map);
	 
}
