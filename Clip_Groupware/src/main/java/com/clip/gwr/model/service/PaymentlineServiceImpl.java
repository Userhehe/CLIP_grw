package com.clip.gwr.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clip.gwr.vo.PaymentlineVo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PaymentlineServiceImpl implements IPaymentlineService {

	@Override
	public List<PaymentlineVo> getApprovalPayLine(String app_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int putPayLine(List<PaymentlineVo> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fixReqLine(String app_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
