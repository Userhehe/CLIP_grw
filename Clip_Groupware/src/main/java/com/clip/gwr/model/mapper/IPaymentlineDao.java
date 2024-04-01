package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.PaymentlineVo;

public interface IPaymentlineDao {

	//결재라인 정보 가져오기
	public List<PaymentlineVo> getApprovalPayLine(String app_seq);
	
	//결재라인 정보 넣기
	public int putPayLine(Map<String, Object> map);
	
}
