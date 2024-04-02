package com.clip.gwr.model.service;

import java.util.List;

import com.clip.gwr.vo.PaymentlineVo;

public interface IPaymentlineService {

	//결재라인 정보 가져오기
		public List<PaymentlineVo> getApprovalPayLine(String app_seq);
		
		//결재라인 정보 넣기
		public int putPayLine(List<PaymentlineVo> list);
}
