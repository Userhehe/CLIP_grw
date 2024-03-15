package com.test.gwr;

import static org.junit.Assert.assertEquals;
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

import com.clip.gwr.model.service.IGianService;
import com.clip.gwr.vo.GianMarkVo;
import com.clip.gwr.vo.GianVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class junitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IGianService service;
	
	
	@Test
	public void test() {
		SqlSessionFactory factory = context.getBean("sqlSessionFactoryBean",SqlSessionFactory.class);
		log.info("SqlSessionFactory : {}",factory);
		assertNotNull(factory);
		
		List<GianVo> lists=service.templateNameSel("휴가");
		System.out.println(lists);
		assertNotNull(lists); 
	}
	

	

}
