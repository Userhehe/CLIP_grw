package com.test.gwr;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/root-context.xml")
@Slf4j
public class junitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test() {
		SqlSessionFactory factory = context.getBean("sqlSessionFactoryBean",SqlSessionFactory.class);
		log.info("SqlSessionFactory : {}",factory);
		assertNotNull(factory);
	}

}
