package com.test.gwr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
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

import com.clip.gwr.model.service.IApprovalService;
import com.clip.gwr.vo.ApprovalVo;
import com.clip.gwr.vo.PaylineVo;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class ApprovalJunitTest {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private IApprovalService service;

	@Test
	public void test() {
		SqlSessionFactory factory = context.getBean("sqlSessionFactoryBean", SqlSessionFactory.class);
		log.info("sqlsessionFactory : {}", factory);
		assertNotNull(factory);

		//전체 결재내역 조회
//		List<ApprovalVo> list = service.getAllApproval();
//		System.out.println(list);
//		for(ApprovalVo vo : list) {
//			System.out.println(vo);
//		}
//		assertEquals(list,2);
		
		
		//단일 결재내역 조회
//	 	ApprovalVo approvalVo = service.getOneApproval("APPROVAL_001");
//	 	System.out.println(approvalVo);
//	 	assertNull(approvalVo);
		
		
		//결재내역 리스트 조건별 검색조회 이름, 제목
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "김");
//		map.put("title", "제목");
//		List<ApprovalVo> list = service.conditionSearchApproval(map);
//		System.out.println(list);
//		assertNotEquals(list, 0);
		
		
		//결재요청
		ApprovalVo appVo = new ApprovalVo();
		appVo.setApp_Title("jUnitTest 날짜있는 제목");
		appVo.setApp_Content("jUnitTest 날짜있는 기안서 내용입니다 웋ㅎ핳핳핳하ㅏ핳ㅎ하하");
		appVo.setGian_Seq("GIAN_001");
		
		
		//결재라인 작성 칸
		PaylineVo pVo = new PaylineVo();
		pVo.setWriter("USER_008");

		Map<String, Object> lineMap = new HashMap<String, Object>();
		lineMap.put("first", "USER_001");
		lineMap.put("second", "USER_002");
		pVo.setPaymentLine(lineMap);
		
		Map<String, Object> cheMap = new HashMap<String, Object>();
		cheMap.put("first", "N");
		cheMap.put("second", "N");
		pVo.setPaymentOk(cheMap);
		
		Map<String, Object> refMap = new HashMap<String, Object>();
		List<String> empList = new ArrayList<String>();
		empList.add("USER_006");
		empList.add("USER_005");
		refMap.put("emp", empList);
		
		List<String> teamList = new ArrayList<String>();
		teamList.add("DEPT_001");
		refMap.put("team", teamList);
		
		pVo.setReference(refMap);
		
		Gson gson = new Gson();
		String json = gson.toJson(pVo);
		System.out.println(json);
		appVo.setApp_Payline(json);
		
		
//		String json = "{\"기안자\" : \"USER_008\",\r\n"
//				+ "							\"결재라인\" : { \"first\" : \"USER_001\",\r\n"
//				+ "								\"second\" : \"USER_002\" ,\r\n"
//				+ "								\"third\" : \"\" \r\n"
//				+ "								},\r\n"
//				+ "							\"결재승인\" : { \"first\" : \"N\",\r\n"
//				+ "								\"second\" : \"N\" ,\r\n"
//				+ "								\"third\" : \"N\"\r\n"
//				+ "								},\r\n"
//				+ "							\"참조\" : { \"참조인\" :\"[\"USER_006\", \"USER_005\"]\" ,\r\n"
//				+ "								\"참조팀\" : \"DEPT_001\"\r\n"
//				+ "								}\r\n"
//				+ "							}";
		
//		appVo.setApp_Payline(json);
//		날짜 입력시 결재 요청 날짜는 포멧을 바꿔서 실행
//		appVo.setApp_Strdate("2024-03-20");
//		appVo.setApp_Enddate("2024-03-25");
	 	int result = service.reqDynamicDateApproval(appVo);
		assertEquals(result, 1);
	 	
		
		
	}

}
