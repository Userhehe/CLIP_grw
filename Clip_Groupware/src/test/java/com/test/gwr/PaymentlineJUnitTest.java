package com.test.gwr;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
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

import com.clip.gwr.model.mapper.IPaymentlineDao;
import com.clip.gwr.vo.PaymentlineVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class PaymentlineJUnitTest {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private IPaymentlineDao paymentlineDao;

	
	@Test
	public void test() {
		
//		List<PaymentlineVo> lists = paymentlineDao.getApprovalPayLine("APPROVAL_18");
//		assertNotEquals(0, lists.size());
		
		
		
//		Map<String, Object> parameterMap = new HashMap();
//		parameterMap.put("appSeq", "APPROVAL_18");
//		
		

		List<PaymentlineVo> list = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
		    PaymentlineVo paymentLine = new PaymentlineVo();
		    paymentLine.setApp_seq("APPROVAL_20");
		    paymentLine.setPay_user("USER_" + (27-i));
		    paymentLine.setPay_num(i);
		    list.add(paymentLine);
		}
		
		System.out.println(list);

		// MyBatis의 SQL 세션을 이용하여 쿼리를 실행
		int result = paymentlineDao.putPayLine(list);
		System.out.println("********실행된 로우의 수는 몇개일 까? : " + result);
		assertNotEquals(0, result);
		
//		List<PaymentlineVo> addPayline = new ArrayList<PaymentlineVo>();
//		
//		for (int i=1; i<=3; i++) {
//			PaymentlineVo vo = new PaymentlineVo();
//			vo.setApp_seq("APPROVAL_23");
//			vo.setPay_user("USER_"+(27-i));
//			vo.setPay_num(i);
//			addPayline.add(vo);
//		}
//		
//		paymentlineDao.putPayLine();
		
		
	}

}
