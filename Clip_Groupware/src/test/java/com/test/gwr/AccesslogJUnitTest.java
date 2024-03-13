package com.test.gwr;

import static org.junit.Assert.*;

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

import com.clip.gwr.model.service.IAccesslogService;
import com.clip.gwr.vo.AccesslogVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class AccesslogJUnitTest {
	
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IAccesslogService service;
	
	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 사용자접속로그 등록
	 */
	//@Test
	public void insertUserLog() {
		map.put("alog_id", "USER_012");
		map.put("alog_ip", "192.1234.1.12");
		map.put("alog_url", "access.do");
		map.put("alog_comment", "로그인");
		int insertUserLog = sqlSession.insert("com.clip.gwr.model.mapper.AccesslogDaoImpl.insertUserLog",map);
		System.out.println("##insertUserLog : " + insertUserLog);
		assertNotNull(insertUserLog);
	}
	
	/**
	 * 사용자접속로그 조회 
	 */
	//@Test
	public void selectUserLog() {
		List<AccesslogVo> lists = service.selectUserLog(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사용자접속로그 검섹
	 */
	@Test
	public void searchUserLog() {
		map.put("alog_id", "USER_012");
		map.put("alog_ip", "192.1234.1.12");
		map.put("alog_url", "access.do");
		map.put("alog_comment", "로그인");
		List<AccesslogVo> lists = service.selectUserLog(map);
		System.out.println(lists);
		assertNotNull(lists);
	}

}
