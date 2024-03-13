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

import com.clip.gwr.model.service.ISignService;
import com.clip.gwr.vo.AccesslogVo;
import com.clip.gwr.vo.SignsVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class SignsJUnitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ISignService service;
	
	Map<String, Object> map = new HashMap<String, Object>();

	
	/**
	 * 서명 등록
	 */
	//@Test
	public void insertPad() {
		map.put("user_id", "USER_012");
		map.put("signs_image", "https://data1.pokemonkorea.co.kr/newdata/pokedex/mid/008801.png");
		int insertPad = sqlSession.insert("com.clip.gwr.model.mapper.SignsDaoImpl.insertPad",map);
		System.out.println("##insertPad : " + insertPad);
		assertNotNull(insertPad);
	}
	
	/**
	 * 서명 조회 
	 */
	//@Test
	public void selectPad() {
		map.put("user_id", "USER_012");
		List<SignsVo> lists = service.selectPad(map);
		System.out.println(lists);
		assertNotNull(lists);
	}
	
	/**
	 * 서명 삭제
	 */
	@Test
	public void delPad() {
		map.put("signs_seq", "SIGNS_001");
		int delPad = sqlSession.delete("com.clip.gwr.model.mapper.SignsDaoImpl.delPad",map);
		System.out.println("##delPad : " + delPad);
		assertNotNull(delPad);
	}

}
