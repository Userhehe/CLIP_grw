package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ApprovalVo;
import com.clip.gwr.vo.PaymentlineVo;

public interface IApprovalService {

	//내가 요청한 결재내역 전체 조회
	public List<ApprovalVo> getAllApproval(String user_id);
	
	// 내가/내팀이 참조된 결재내역 전체 조회
	public List<ApprovalVo> selectReferApproval(String user_id);
	
	//결재내역 단일 상세조회
	public ApprovalVo getOneApproval(String appSeq);

	//임시저장한 결재파일 리스트 가져오기
	public List<ApprovalVo> getTempApproval(String user_id);
	
	//나의 결재승인을 받아야하는 결재 리스트조회
	public List<ApprovalVo> getMyPaycheck(String user_id);
	
	//나의 결재승인을 받아야하는 미처리한 결재 리스트조회
	public List<ApprovalVo> getMyUnprocessedPaycheck(String user_id);
	
	//내가 보류처리한 결재를 보여주는 리스트 조회
	public List<ApprovalVo> getMyRejectPay(String user_id);
	
	//	결재 승인/반려에 따른 결재 현황 정보 수정
	public int checkApprovalLine(ApprovalVo approvalVo);	
	
	//결재 제목검색 리스트 조회
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map);
	
	//결재 조건별 선택 리스트 조회
	public List<ApprovalVo> optionalApprovalList(Map<String, Object> map);
	
	//기안 결재요청	
	public boolean reqDynamicDateApproval(ApprovalVo approvalVo, List<PaymentlineVo> list);
	
	//기안 결재 임시저장
	public boolean saveTempApproval(ApprovalVo approvalVo, List<PaymentlineVo> list);
	
	//0단계 결재 수정
	public int fixWatingApproval(ApprovalVo approvalVo);
	
	//반려결재 수정
	public int fixReqApproval(ApprovalVo approvalVo, String app_seq);
	
	//결재 취소
	public int cancelApproval(String appSeq);
	
	//임시저장된 결재 삭제
	public int tempDelete(String appSeq);
	
	//결재 승인 처리 
	public int approvePay(String app_draft,String app_seq);
	public int approvePayLine(String app_seq,String pay_num);
	
	//승인시 단건조회
	public ApprovalVo oneMyPaycheck(String app_seq);
	
	//승인했던거 단건조회
	public ApprovalVo oneMyPaychecked(String user_id);

	//내가 반려했던거 단건조회
	public ApprovalVo oneMyPayPause(String app_seq);
	
	//결재 반려 처리
	public int banRuApproval(String app_seq);
	public int banRuPayLine(String pay_rejectreason,String app_seq,String pay_num,String pay_user);
	
}
