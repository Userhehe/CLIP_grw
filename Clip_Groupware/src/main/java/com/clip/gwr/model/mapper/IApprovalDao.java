package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.ApprovalVo;

public interface IApprovalDao {

	//내가 요청한 결재내역 전체 조회
	public List<ApprovalVo> getAllApproval(String user_id);
	
	// 내가/내팀이 참조된 결재내역 전체 조회
	public List<ApprovalVo> selectReferApproval(String user_id);
	
	//결재내역 단일 상세 조회
	public ApprovalVo getOneApproval(String appSeq);
	
	//결재 제목/작성자 이름 검색 리스트 조회
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map);
	
	//결재 조건별 선택 리스트 조회
	public List<ApprovalVo> optionalApprovalList(Map<String, Object> map);
	
	//임시저장한 결재파일 리스트 가져오기
	public List<ApprovalVo> getTempApproval(String user_id);
	
	//나의 결재승인을 받아야하는 결재 리스트조회
	public List<ApprovalVo> getMyPaycheck(String user_id);

	//나의 결재승인을 받아야하는 미처리한 결재 리스트조회
	public List<ApprovalVo> getMyUnprocessedPaycheck(String user_id);
	
	
	//	결재 승인/반려에 따른 결재 현황 정보 수정
	public int checkApprovalLine(ApprovalVo approvalVo);
	
	
	//기안 결재요청
	public int reqDynamicDateApproval(ApprovalVo approvalVo);
	
	//기안 결재 임시저장
	public int saveTempApproval(ApprovalVo approvalVo);
	
	//결재 취소
	public int cancelApproval(String appSeq);
	
	
	
	
	

	
}
