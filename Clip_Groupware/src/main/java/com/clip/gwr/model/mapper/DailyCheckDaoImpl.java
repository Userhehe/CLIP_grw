package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.DailyCheckVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class DailyCheckDaoImpl implements IDailyCheckDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.DailyCheckDaoImpl.";
	
	/**
	 * 출근시간 등록
	 */
	@Override
	public int insertDailyCheckIntime(Map<String, Object> map) {
		log.info("##### 출근시간 등록 insertDailyCheckIntime #####");
		return sqlSession.insert(NS + "insertDailyCheckIntime", map);
	}

	/**
	 * 퇴근시간 등록
	 */
	@Override
	public int updateDailyCheckOuttime(Map<String, Object> map) {
		log.info("##### 퇴근시간 등록 updateDailyCheckOuttime #####");
		return sqlSession.insert(NS + "updateDailyCheckOuttime", map);
	}

	/**
	 * 출퇴근여부 등록
	 */
	@Override
	public int insertDailyCheckStatus(Map<String, Object> map) {
		log.info("##### 퇴근시간 등록 updateDailyCheckOuttime #####");
		return 0;
	}

	/**
	 * 근태현황 조회
	 */
	@Override
	public List<DailyCheckVo> selectDailyCheckList(Map<String, Object> map) {
		log.info("##### 근태현황 조회 selectDailyCheckList #####");
		return sqlSession.selectList(NS + "selectDailyCheckList", map);
	}

	/**
	 * 근태현황 검색
	 */
	@Override
	public List<DailyCheckVo> searchDailyCheckList(Map<String, Object> map) {
		log.info("##### 근태현황 검색 searchDailyCheckList #####");
		return sqlSession.selectList(NS + "searchDailyCheckList", map);
	}

	/**
	 * 근태현황 수정
	 */
	public int updateDailyCheckStatus(Map<String, Object> map) {
	    log.info("##### 근태현황 수정 updateDailyCheckStatus #####");
	    return sqlSession.update(NS + "updateDailyCheckStatus", map);
	}

	@Override
	public String selectDailyStatus(String daily_status) {
		log.info("##### 출퇴근여부 등록 updateDailyCheckStatus #####");
		return sqlSession.selectOne(NS+"selectDailyStatus",daily_status);
	}

	@Override
	public List<DailyCheckVo> myDailychk(String user_id) {
		log.info("##### 나의 연차조회  myDailychk #####");
		return sqlSession.selectList(NS+"myDailychk",user_id);
	}

	@Override
	public int chktime(String user_id) {
		log.info("##### 나의 체크타임  chktime #####");
		return sqlSession.selectOne(NS+"chktime",user_id);
	}

	
}
