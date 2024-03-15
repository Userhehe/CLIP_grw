package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ApprovalVo;

public interface IApprovalService {

	//내가 요청한 결재내역 전체 조회
	public List<ApprovalVo> getAllApproval(String app_seq);
	
	// 내가/내팀이 참조된 결재내역 전체 조회
	public List<ApprovalVo> selectReferApproval(String user_id);
	
	//결재내역 단일 상세조회
	public ApprovalVo getOneApproval(String appSeq);

	//결재 제목검색 리스트 조회
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map);
	
	//결재 조건별 선택 리스트 조회
	public List<ApprovalVo> optionalApprovalList(Map<String, Object> map);
	
	//기안 결재요청	(파일 업로드 트랜잭션걸기)
	public int reqDynamicDateApproval(ApprovalVo approvalVo);
	
}
