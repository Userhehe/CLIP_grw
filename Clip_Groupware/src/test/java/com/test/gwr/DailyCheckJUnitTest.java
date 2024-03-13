package com.test.gwr;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.DailyCheckServiceImpl;
import com.clip.gwr.vo.DailyCheckVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class DailyCheckJUnitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DailyCheckServiceImpl service;
	
	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 출근시간 등록
	 */
//	@Test
	public void insertDailyCheckIntime() {
		map.put("user_id","USER_001");
		int insertDailyCheckIntime = sqlSession.insert("com.clip.gwr.model.mapper.DailyCheckDaoImpl.insertDailyCheckIntime", map);
		System.out.println("##insertDailyCheckIntime : " + insertDailyCheckIntime);
		assertNotNull(insertDailyCheckIntime);
	}
	
	/**
	 * 퇴근시간 등록
	 */
//	@Test
	public void updateDailyCheckOuttime() {
		map.put("user_id","USER_001");
		int updateDailyCheckOuttime = sqlSession.update("com.clip.gwr.model.mapper.DailyCheckDaoImpl.updateDailyCheckOuttime", map);
		System.out.println("##updateDailyCheckOuttime : " + updateDailyCheckOuttime);
		assertNotNull(updateDailyCheckOuttime);
	}
	
	/**
	 * 출퇴근여부 등록
	 */
	
	
	/**
	 * 근태현황 조회
	 */
//	@Test
	public void selectDailyCheckList() {
		List<DailyCheckVo> lists = service.selectDailyCheckList(map);
		System.out.println("##lists : " + lists);
		assertNotNull(lists);
	}
	
	/**
	 * 근태현황 검색
	 */
	@Test
	public void searchDailyCheckList() {
		map.put("first_dailyregdate","2024-03-04");
		map.put("last_dailyregdate","2024-03-13");
		map.put("positions_name","팀장");
		map.put("ranks_name","대리");
		map.put("dept_name","설계");
		map.put("user_id","USER_");
		map.put("user_name","김");
		List<DailyCheckVo> lists = service.searchDailyCheckList(map);
		System.out.println("##lists : " + lists);
		assertNotNull(lists);
	}
	

	/**
	 * 근태현황 수정
	 */
//	@Test
	public void updateDailyCheckStatus() {
		map.put("daily_modify","Y");
		map.put("daily_reasonmodify","외근으로 인한 퇴근 미등록");
		map.put("daily_seq","DAILYCHECK_007");
		int updateDailyCheckStatus = sqlSession.update("com.clip.gwr.model.mapper.DailyCheckDaoImpl.updateDailyCheckStatus", map);
		System.out.println("##updateDailyCheckStatus : " + updateDailyCheckStatus);
		assertNotNull(updateDailyCheckStatus);
	}
	
}
