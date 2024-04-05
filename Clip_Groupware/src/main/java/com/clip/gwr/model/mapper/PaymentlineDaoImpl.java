package com.clip.gwr.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.PaymentlineVo;

import lombok.extern.slf4j.Slf4j;
@Repository
@Slf4j
public class PaymentlineDaoImpl implements IPaymentlineDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.PaymentlineDaoImpl.";
	
	//결재 시퀀스로 결재라인 정보를 가져오는 쿼리
	@Override
	public List<PaymentlineVo> getApprovalPayLine(String app_seq) {
		log.info("PaymentlineDaoImpl getApprovalPayLine 결재라인 정보 조회");
		return sqlSession.selectList(NS+"getApprovalPayLine", app_seq);
	}

	@Override
	public int putPayLine(List<PaymentlineVo> list) {
		log.info("PaymentlineDaoImpl putPayLine 결재라인 입력");
		return sqlSession.insert(NS+"putPayLine", list);
	}

	
	@Override
	public int fixReqLine(String app_seq) {
		log.info("PaymentlineDaoImpl fixReqLine 반려결재 수정후 요청결재상황 변경 : {}", app_seq);
		return sqlSession.update(NS+"fixReqLine",app_seq);
	}


}
