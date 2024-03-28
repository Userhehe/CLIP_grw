package com.test.gwr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
//		List<ApprovalVo> list = service.getMyUnprocessedPaycheck("USER_027");
//		for(ApprovalVo vo : list) {
//			System.out.println(vo);
//		}
//		assertNotEquals(list.size(), 1);
		
		
		
		
		//결재 승인/반려에 따른 결재 현황 정보 수정 로직

//		String approvalSeq = "APPROVAL_027";
//		ApprovalVo approvalVo = service.getOneApproval(approvalSeq);
//		String payLine = approvalVo.getApp_payline();
//		System.out.println(payLine);
//		Gson transGson = new Gson();
//		PaylineVo paylineVo = transGson.fromJson(payLine, PaylineVo.class);
//		System.out.println("paymentLine First : " + paylineVo.getPaymentLine().get("first"));
//		System.out.println("paymentOk First : " + paylineVo.getPaymentOk().get("first"));
//		//기존의 내 사원 번호로 내의 순서를 먼저 조회 후 순서에 맞는 결재 승인 정보를 내결재승인 결과에 맞게 변환시켜주고 결재현황도 맞춰서 변경 시켜주기.
//		String myUser_id = "USER_027";
//		
//		Map<String, Object> voLine = paylineVo.getPaymentLine();
//		Map<String, Object> voLineOk = paylineVo.getPaymentOk();
//		String[] order = {"first", "second", "third"};
//		String app_draft = "결재대기";
//		ApprovalVo checkingApprovalVo = new ApprovalVo();
//		
		//승인 시
//		for (int i = 0; i < order.length; i++) {
//			if(voLine.get(order[i]).equals(myUser_id)) {
//				voLineOk.put(order[i], "Y");
//				
//				System.out.println(voLine.get(order[i]));
//				System.out.println(voLineOk.get(order[i]));
//				if(order[i].equals("third")) {
//					app_draft = "결재완료";
//				}
//				paylineVo.setPaymentLine(voLine);
//				paylineVo.setPaymentOk(voLineOk);
//				String strPayline = transGson.toJson(paylineVo);
//				checkingApprovalVo.setApp_payline(strPayline);
//				checkingApprovalVo.setApp_draft(app_draft);
//				checkingApprovalVo.setApp_seq(approvalSeq);
//				System.out.println(checkingApprovalVo);
//			}
//		}
//		
//		int result = service.checkApprovalLine(checkingApprovalVo);
//		assertEquals(result, 1);
		
		//반려 시
//		for (int i = 0; i < order.length; i++) {
//			if(voLine.get(order[i]).equals(myUser_id)) {
//				voLineOk.put(order[i], "N");
//				app_draft = "결재반려";
//				System.out.println(voLine.get(order[i]));
//				System.out.println(voLineOk.get(order[i]));
//				paylineVo.setPaymentLine(voLine);
//				paylineVo.setPaymentOk(voLineOk);
//				String strPayline = transGson.toJson(paylineVo);
//				checkingApprovalVo.setApp_payline(strPayline);
//				checkingApprovalVo.setApp_draft(app_draft);
//				checkingApprovalVo.setApp_seq(approvalSeq);
//				System.out.println(checkingApprovalVo);
//			}
//		}
//		
//		int rejectResult = service.checkApprovalLine(checkingApprovalVo);
//		assertEquals(rejectResult, 1);
		
		
		
		
		
//		
		//결재요청
		ApprovalVo appVo = new ApprovalVo();
		appVo.setApp_title("조회 참조된 조회");
		appVo.setApp_content("휴가 결재서 			이름 : 		성명 : 		....");
		appVo.setGian_seq("GIAN_1");
		
		
		//결재라인 작성 칸
		PaylineVo pVo = new PaylineVo();
		pVo.setWriter("USER_49");	//결재 기안자
		
		//임시 저장은 위에까지.
		

		//결재라인
		Map<String, Object> lineMap = new HashMap<String, Object>();
		lineMap.put("first", "USER_6");
		lineMap.put("second", "USER_5");
		lineMap.put("third", "USER_28");
		pVo.setPaymentLine(lineMap);
		
		//라인별 체크
		Map<String, Object> cheMap = new HashMap<String, Object>();
		cheMap.put("first", "N");
		cheMap.put("second", "N");
		cheMap.put("third", "N");
		pVo.setPaymentOk(cheMap);
		
		//참조인
		Map<String, Object> refMap = new HashMap<String, Object>();
		List<String> empList = new ArrayList<String>();
		empList.add("USER_5");
		empList.add("USER_51");
		refMap.put("emp", empList);
		
		//참조 팀
		List<String> teamList = new ArrayList<String>();
		teamList.add("DEPT_2");
		refMap.put("team", teamList);
		
		pVo.setReference(refMap);
		
		Gson gson = new Gson();
		String json = gson.toJson(pVo);
		System.out.println(json);
		appVo.setApp_payline(json);
//		
//		//날짜 지정한 결재일 시 입력
		appVo.setApp_strdate("2024-04-08");
		appVo.setApp_enddate("2024-04-10");
	 	int result = service.reqDynamicDateApproval(appVo);
		assertEquals(result, 1);
	 	
		
		
		
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
