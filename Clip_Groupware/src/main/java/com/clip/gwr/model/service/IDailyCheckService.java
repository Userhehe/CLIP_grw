package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.DailyCheckVo;

public interface IDailyCheckService {

	/**
	 * 출근시간 등록
	 * @param map
	 * @return
	 */
	public int insertDailyCheckIntime(Map<String, Object> map);
	
	/**
	 * 퇴근시간 등록
	 * @param map
	 * @return
	 */
	public int updateDailyCheckOuttime(Map<String, Object> map);
	
	/**
	 * 출퇴근여부 등록
	 * @param map
	 * @return
	 */
	public int insertDailyCheckStatus(Map<String, Object> map);
	
	/**
	 * 근태현황 조회
	 * @param map
	 * @return
	 */
	public List<DailyCheckVo> selectDailyCheckList(Map<String, Object> map);
	
	/**
	 * 근태현황 검색
	 * @param map
	 * @return
	 */
	public List<DailyCheckVo> searchDailyCheckList(Map<String, Object> map);
	
	/**
	 * 근태현황 수정
	 * @param map
	 * @return
	 */
	public int updateDailyCheckStatus(Map<String, Object> map);
}
