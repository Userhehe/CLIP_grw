package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ApprovalVo;

public interface IApprovalDao {

	//전체 결재내역 전체 조회
	public List<ApprovalVo> getAllApproval();
	
	//결재내역 단일 상세 조회
	public ApprovalVo getOneApproval(String appSeq);
	
	//결재 조건 리스트 조회
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map);
	
	//기안 결재요청
	public int reqDynamicDateApproval(ApprovalVo approvalVo);
	
	
	

	
}
