package com.test.gwr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IApprovalService;
import com.clip.gwr.model.service.IProjectsService;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class ProjectJUnitTest {


	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private IProjectsService service;
	
	@Test
	@Ignore
	public void test() {
		SqlSessionFactory factory = context.getBean("sqlSessionFactoryBean", SqlSessionFactory.class);
		log.info("sqlsessionFactory : {}", factory);
		assertNotNull(factory);
	}
		
	@Test
	@Ignore
	public void getprojectAll() {
		List<ProjectsVo> lists =service.getProjectsAll();
		log.info("project 전체조회 :{}", lists);
		assertNotNull(lists);
	}
	
	@Test
	@Ignore
	public void projectsProgressSel() {
		List<ProjectsVo> lists = service.projectsProgressSel();
		log.info("project 진행도별 조회 :{}", lists);
		assertNotNull(lists);
	}
	
	@Test
	@Ignore
	public void projectsClientSel() {
		List<ProjectsVo> lists = service.projectsClientSel("CLI_001");
		log.info("project 발주처별 조회 :{}", lists);
		assertNotNull(lists);
	}
	

		
	}
