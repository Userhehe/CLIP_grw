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
	public List<ApprovalVo> getAllApproval(String user_id) {
		log.info("결재내역 getAllApproval전체조회 {}", user_id);
		return approvalDao.getAllApproval(user_id);
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

	//임시저장한 결재파일 리스트 가져오기
	@Override
	public List<ApprovalVo> getTempApproval(String user_id) {
		log.info("결재내역 getTempApproval 내 임시저장 결재파일 리스트 가져오기: {}", user_id);
		return approvalDao.getTempApproval(user_id);
	}

	//나의 결재승인을 받아야하는 결재 리스트조회
	@Override
	public List<ApprovalVo> getMyPaycheck(String user_id) {
		log.info("결재내역 getMyPaycheck 나의 결재승인을 받아야하는 결재 리스트 가져오기: {}", user_id);
		return approvalDao.getMyPaycheck(user_id);
	}

	//나의 결재승인을 받아야하는 미처리 결재 리스트조회
	@Override
	public List<ApprovalVo> getMyUnprocessedPaycheck(String user_id) {
		log.info("결재내역 getMyUnprocessedPaycheck 나의 결재승인을 받아야하는 미처리 결재 리스트 가져오기: {}", user_id);
		return approvalDao.getMyUnprocessedPaycheck(user_id);
	}
	
	//	결재 승인/반려에 따른 결재 현황 정보 수정
	@Override
	public int checkApprovalLine(ApprovalVo approvalVo) {
		log.info("결재내역 checkApprovalLine 결재 승인/반려시에 따른 결재 현황 정보 수정: {}", approvalVo);
		return approvalDao.checkApprovalLine(approvalVo);
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

	//기안 결재 임시저장
	@Override
	public int saveTempApproval(ApprovalVo approvalVo) {
		log.info("기안 결재 임시저장: {}",approvalVo);
		return approvalDao.saveTempApproval(approvalVo);
	}




	

	



}
