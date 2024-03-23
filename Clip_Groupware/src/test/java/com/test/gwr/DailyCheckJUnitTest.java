package com.test.gwr;

import static org.junit.Assert.assertEquals;
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

import com.clip.gwr.model.mapper.DailyCheckDaoImpl;
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
//	@Test
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
	
	@Test
	public void selectDailyStatus() {
       DailyCheckDaoImpl checker = new DailyCheckDaoImpl();
        
        // "정상근무" 입력 시 정상 근무를 반환하는지 확인합니다.
        String result1 = checker.selectDailyStatus("정상근무");
        assertEquals("정상근무", result1);
        
        // "조퇴" 입력 시 조퇴를 반환하는지 확인합니다.
        String result2 = checker.selectDailyStatus("조퇴");
        assertEquals("조퇴", result2);
        
        // "결근" 입력 시 결근을 반환하는지 확인합니다.
        String result3 = checker.selectDailyStatus("결근");
        assertEquals("결근", result3);
        
        // "지각" 입력 시 지각을 반환하는지 확인합니다.
        String result4 = checker.selectDailyStatus("지각");
        assertEquals("지각", result4);
    }

	}
	

