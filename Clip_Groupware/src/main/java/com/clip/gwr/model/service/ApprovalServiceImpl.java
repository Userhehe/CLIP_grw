package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IApprovalDao;
import com.clip.gwr.vo.ApprovalVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApprovalServiceImpl implements IApprovalService{

	@Autowired
	private IApprovalDao approvalDao;
	
	@Override
	public List<ApprovalVo> getAllApproval() {
		log.info("결재내역 getAllApproval전체조회");
		return approvalDao.getAllApproval();
	}

	@Override
	public ApprovalVo getOneApproval(String appSeq) {
		log.info("결재내역 getOneApproval상세조회: {}", appSeq);
		return approvalDao.getOneApproval(appSeq);
	}

	
	@Override
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map) {
		log.info("결재내역 conditionSearchApproval 조건별 검색 리스트 조회: {}", map);
		return approvalDao.conditionSearchApproval(map);
	}

	
	@Override
	public List<ApprovalVo> optionalApprovalList(Map<String, Object> map) {
		log.info("결재내역 optionalApprovalList 옵션별 리스트 조회: {}", map);
		return approvalDao.optionalApprovalList(map);
	}
	
	
	@Override
	public int reqDynamicDateApproval(ApprovalVo approvalVo) {
		log.info("결재 요청: {}",approvalVo);
		return approvalDao.reqDynamicDateApproval(approvalVo);
	}




}
