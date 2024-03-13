package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.UserinfoVo;

public interface IUserService {
	/**
	 * 사원목록 전체조회
	 * @return
	 */
	public List<UserinfoVo> selectUserinfoList();
	
	/**
	 * 사원정보 등록
	 * @param map
	 * @return
	 */
	public int insertUserinfo(Map<String, Object> map);
	
	/**
	 * 사원정보 수정
	 * @param map
	 * @return
	 */
	public int updateUserinfo(Map<String, Object> map);
}
