package com.test.gwr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;import javax.print.DocFlavor.STRING;

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

//		나의 전체 결재요청 조회
//		List<ApprovalVo> list = service.getAllApproval("USER_012");
//		System.out.println(list);
//		for(ApprovalVo vo : list) {
//			System.out.println(vo);
//		}
//		assertNotEquals(list.size(),0);
		
		
		//내팀/내가 참조된 결재 조회
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("user_id1", "USER_005");
//		map.put("user_id2", "USER_005");
		
//		List<ApprovalVo> list = service.selectReferApproval("USER_005");
//		for(ApprovalVo vo : list) {
//			System.out.println(vo);
//		}
//		assertNotEquals(list.size(), 0);
		
		
		//단일 결재내역 조회
//	 	ApprovalVo approvalVo = service.getOneApproval("APPROVAL_006");
//	 	System.out.println(approvalVo);
//	 	assertNotNull(approvalVo);
		
		
		//결재내역 리스트 제목 검색조회 
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "김");
//		map.put("title", "제목");
//		List<ApprovalVo> list = service.conditionSearchApproval(map);
//		System.out.println(list);
//		assertNotEquals(list, 0);
		
		
		//임시저장한 나으 결재내역 리스트 조회
//		List<ApprovalVo> list = service.getTempApproval("USER_005");
//		for(ApprovalVo vo : list) {
//			System.out.println(vo);
//		}
//		assertEquals(list.size(), 1);
//		
		
		//나의 결재승인을 받아야하는 결재 리스트 조회
//		List<ApprovalVo> list = service.getMyPaycheck("USER_027");
		List<ApprovalVo> list = service.getMyUnprocessedPaycheck("USER_027");
		for(ApprovalVo vo : list) {
			System.out.println(vo);
		}
		assertNotEquals(list.size(), 1);
		
		
//		
//		//결재요청
//		ApprovalVo appVo = new ApprovalVo();
//		appVo.setApp_title("기안 결재 인서트 쿼리문입니다.");
//		appVo.setApp_content("휴가 결재서 			이름 : 		성명 : 		....");
//		appVo.setGian_seq("GIAN_001");
//		
//		
//		//결재라인 작성 칸
//		PaylineVo pVo = new PaylineVo();
//		pVo.setWriter("USER_005");	//결재 기안자
//		
//		//임시 저장은 위에까지.
//		
//
//		//결재라인
//		Map<String, Object> lineMap = new HashMap<String, Object>();
//		lineMap.put("first", "USER_027");
//		lineMap.put("second", "USER_026");
//		lineMap.put("third", "USER_025");
//		pVo.setPaymentLine(lineMap);
//		
//		//라인별 체크
//		Map<String, Object> cheMap = new HashMap<String, Object>();
//		cheMap.put("first", "N");
//		cheMap.put("second", "N");
//		cheMap.put("third", "N");
//		pVo.setPaymentOk(cheMap);
//		
//		//참조인
//		Map<String, Object> refMap = new HashMap<String, Object>();
//		List<String> empList = new ArrayList<String>();
//		empList.add("USER_006");
//		empList.add("USER_005");
//		refMap.put("emp", empList);
//		
//		//참조 팀
//		List<String> teamList = new ArrayList<String>();
//		teamList.add("DEPT_006");
//		refMap.put("team", teamList);
//		
//		pVo.setReference(refMap);
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(pVo);
//		System.out.println(json);
//		appVo.setApp_payline(json);
////		
////		//날짜 지정한 결재일 시 입력
//		appVo.setApp_strdate("2024-04-01");
//		appVo.setApp_enddate("2024-04-04");
//	 	int result = service.reqDynamicDateApproval(appVo);
//		assertEquals(result, 1);
//	 	
		
		
		
		//옵셜별 출력
//		Map<String, Object> opt = new HashMap<String, Object>();
//		opt.put("deptSeq", "DEPT_002");
//		opt.put("gianGubun", "");
//		opt.put("appDraft", "");
//		
//		List<ApprovalVo> list = service.optionalApprovalList(opt);
//		System.out.println(list);
//		assertNotEquals(list.size(), 0);
		
		
	}

}
