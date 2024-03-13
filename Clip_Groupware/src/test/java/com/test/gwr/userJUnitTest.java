package com.test.gwr;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class userJUnitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IUserService service;

	/**
	 * 사원목록 전체조회
	 */
	@Test
	public void selectUserinfoList() {
		SqlSessionFactory factory = context.getBean("sqlSessionFactoryBean",SqlSessionFactory.class);
		log.info("SqlSessionFactory : {}",factory);
		assertNotNull(factory);
		
		List<UserinfoVo> lists = service.selectUserinfoList();
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 사원정보 등록
	 */
//	@Test
	public void insertUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_name", "서종우");
		map.put("user_registnum", "950423-1049382");
		map.put("user_phonenum", "010-1122-4455");
		map.put("user_email", "jongu@naver.com");
		map.put("user_birthday", "19950423");
		map.put("user_address", "서울특별시 금천구 가산동");
		map.put("ranks_name", "대리");
		map.put("dept_name", "영업");
		map.put("positions_name", "팀장");
		int insertUser = sqlSession.insert("com.clip.gwr.model.mapper.UserDaoImpl.insertUserinfo",map);
		System.out.println("##insertUser : " + insertUser);
		assertNotNull(insertUser);
	}
	
	/**
	 * 사원정보 수정
	 */

}
