package com.clip.gwr.model.service;

import java.util.List;

import com.clip.gwr.vo.PaymentlineVo;

public interface IPaymentlineService {

	//결재라인 정보 가져오기
		public List<PaymentlineVo> getApprovalPayLine(String app_seq);
		
		//결재라인 정보 넣기
		public int putPayLine(List<PaymentlineVo> list);
		
		
		//반려결재 수정 재결재요청 시 반려했던 순서부터 다시이어지게 반려위치 'N'으로 바꾸기
		public int fixReqLine(String app_seq);
}
