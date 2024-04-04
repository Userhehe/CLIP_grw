package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IDailyCheckDao;
import com.clip.gwr.vo.DailyCheckVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DailyCheckServiceImpl implements IDailyCheckService {
	
	@Autowired
	private IDailyCheckDao dao;

	/**
	 * 출근시간 등록
	 */
	@Override
	public int insertDailyCheckIntime(Map<String, Object> map) {
		log.info("DailyCheckServiceImpl insertDailyCheckIntime 출근시간 등록");
		return dao.insertDailyCheckIntime(map);
	}

	/**
	 * 퇴근시간 등록
	 */
	@Override
	public int updateDailyCheckOuttime(Map<String, Object> map) {
		log.info("DailyCheckServiceImpl updateDailyCheckOuttime 출근시간 등록");
		return dao.updateDailyCheckOuttime(map);
	}

	/**
	 * 출퇴근여부 등록
	 */
	@Override
	public int insertDailyCheckStatus(Map<String, Object> map) {
		log.info("DailyCheckServiceImpl insertDailyCheckStatus 출퇴근여부 등록");
		return dao.insertDailyCheckStatus(map);
	}

	/**
	 * 근태현황 조회
	 */
	@Override
	public List<DailyCheckVo> selectDailyCheckList(Map<String, Object> map) {
		log.info("DailyCheckServiceImpl selectDailyCheckList 근태현황 조회");
		return dao.selectDailyCheckList(map);
	}

	/**
	 * 근태현황 검색
	 */
	@Override
	public List<DailyCheckVo> searchDailyCheckList(Map<String, Object> map) {
		log.info("DailyCheckServiceImpl searchDailyCheckList 근태현황 검색");
		return dao.searchDailyCheckList(map);
	}

	/**
	 * 근태현황 수정
	 */
	@Override
	public int updateDailyCheckStatus(Map<String, Object> map) {
		log.info("DailyCheckServiceImpl updateDailyCheckStatus 근태현황 수정");
		return dao.updateDailyCheckStatus(map);
	}

	@Override
	public String selectDailyStatus(String daily_status) {
		log.info("DailyCheckServiceImpl selectDailyStatus 출퇴근상태 조회");
		return dao.selectDailyStatus(daily_status);
	}

	@Override
	public List<DailyCheckVo> myDailychk(String user_id) {
		log.info("DailyCheckServiceImpl myDailychk 출퇴근상태 조회");
		return dao.myDailychk(user_id);
	}
	
	
	
}
