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
	
	//내가 요청한 결재내역 전체 조회	
	@Override
	public List<ApprovalVo> getAllApproval(String app_seq) {
		log.info("결재내역 getAllApproval전체조회 {}", app_seq);
		return approvalDao.getAllApproval(app_seq);
	}
	
	// 내가/내팀이 참조된 결재내역 전체 조회
	@Override
	public List<ApprovalVo> selectReferApproval(String user_id) {
		log.info("결재내역 getAllApproval전체조회 {}", user_id);
		return approvalDao.selectReferApproval(user_id);
	}


	//결재내역 단일 상세조회
	@Override
	public ApprovalVo getOneApproval(String appSeq) {
		log.info("결재내역 getOneApproval상세조회: {}", appSeq);
		return approvalDao.getOneApproval(appSeq);
	}

	//결재 제목검색 리스트 조회
	@Override
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map) {
		log.info("결재내역 conditionSearchApproval 조건별 검색 리스트 조회: {}", map);
		return approvalDao.conditionSearchApproval(map);
	}

	
	//결재 조건별 선택 리스트 조회
	@Override
	public List<ApprovalVo> optionalApprovalList(Map<String, Object> map) {
		log.info("결재내역 optionalApprovalList 옵션별 리스트 조회: {}", map);
		return approvalDao.optionalApprovalList(map);
	}
	
	
	
	//기안 결재요청	(파일 업로드 트랜잭션걸기)
	@Override
	public int reqDynamicDateApproval(ApprovalVo approvalVo) {
		log.info("결재 요청: {}",approvalVo);
		return approvalDao.reqDynamicDateApproval(approvalVo);
	}



}
