package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clip.gwr.model.mapper.IApprovalDao;
import com.clip.gwr.model.mapper.IPaymentlineDao;
import com.clip.gwr.model.mapper.IReferenceDao;
import com.clip.gwr.vo.ApprovalVo;
import com.clip.gwr.vo.PaymentlineVo;
import com.clip.gwr.vo.ReferenceVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApprovalServiceImpl implements IApprovalService{

	@Autowired
	private IApprovalDao approvalDao;
	
	@Autowired
	private IPaymentlineDao PaymentlineDao;
	
	@Autowired
	private IReferenceDao referenceDao;
	
	//내가 요청한 결재내역 전체 조회	
	@Override
	public List<ApprovalVo> getAllApproval(String user_id) {
		log.info("결재내역 getAllApproval전체조회 {}", user_id);
		return approvalDao.getAllApproval(user_id);
	}
	
	// 내가/내팀이 참조된 결재내역 전체 조회
	@Override
	public List<ApprovalVo> selectReferApproval(String user_id) {
		log.info("결재내역 getAllApproval전체조회 {} ", user_id);
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
	
	//나의 결재승인을 받는데 내가 보류처리한 리스트 조회
	@Override
	public List<ApprovalVo> getMyRejectPay(String user_id) {
		log.info("결재내역 getMyRejectPay 내가 결재보류처리한 리스트 조회 : {}", user_id);
		return approvalDao.getMyRejectPay(user_id);
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
	
	
	
	//기안 결재요청	
	@Transactional
	@Override
	public boolean reqDynamicDateApproval(ApprovalVo approvalVo, List<PaymentlineVo> list, List<ReferenceVo> refList) {
		log.info("결재 요청: {},\n 결재라인 정보들 {},\n 결재참조인 정보: {}",approvalVo, list, refList);
		boolean isc = false;
		int reqResult = approvalDao.reqDynamicDateApproval(approvalVo);
		int payLineResult = PaymentlineDao.putPayLine(list);
		
		isc = (reqResult>0 && payLineResult>0) ? true:false;
		
		if(refList.size() > 0) {
			int refResult = referenceDao.putReference(refList);
			if(refResult <= 0) {
				isc = false;
			}
		}
		
		return isc;
	}

	//기안 결재 임시저장
	@Override
	public boolean saveTempApproval(ApprovalVo approvalVo, List<PaymentlineVo> list, List<ReferenceVo> refList) {
		boolean isc = false ; 
		log.info("임시저장 결재 요청: {},\n 결재라인 정보들 {},\n 결재참조인 정보: {}",approvalVo, list, refList);
		int tempresult = approvalDao.saveTempApproval(approvalVo);
		int payline = PaymentlineDao.putPayLine(list);
		isc = (tempresult>0 && payline>0) ? true:false;
		
		if(refList.size() > 0) {
			int refResult = referenceDao.putReference(refList);
			if(refResult <= 0) {
				isc = false;
			}
		}
		
		return isc;
		
		
	}
	
	//승인대기중인 결재 수정 
	@Override
	public int fixWatingApproval(ApprovalVo approvalVo) {
		log.info("승인 대기중인 결재 수정: {}",approvalVo);
		int result = approvalDao.fixReqApproval(approvalVo);
		return (result != 0) ? 1 : 0;
	}
	
	//반려결재 수정
	@Transactional
	@Override
	public int fixReqApproval(ApprovalVo approvalVo,String app_seq) {
		log.info("기안 결재 임시저장: {}",approvalVo);
		int fixResult = approvalDao.fixReqApproval(approvalVo);
		int fixPaylineSign = PaymentlineDao.fixReqLine(app_seq);
		
		return (fixResult>0 && fixPaylineSign>0)? 1 : 0;
	}
	

	//결재 취소
	@Override
	public int cancelApproval(String appSeq) {
		log.info("결재취소 : {}",appSeq);
		return approvalDao.cancelApproval(appSeq);
	}
	
	//임시저장된 결재 삭제
	@Override
	public int tempDelete(String appSeq) {
		log.info("결제삭제 : {}",appSeq);
		return approvalDao.tempDelete(appSeq);
	}

	@Override
	public ApprovalVo oneMyPaycheck(String app_seq) {
		log.info("결재 단건 조회 : {}",app_seq);
		return approvalDao.oneMyPaycheck(app_seq);
	}

	@Override
	public ApprovalVo oneMyPaychecked(String user_id) {
		log.info("결재 단건 조회 : {}",user_id);
		return approvalDao.oneMyPaychecked(user_id);
	}

	@Override
	public ApprovalVo oneMyPayPause(String app_seq) {
		log.info("결재 단건 조회 : {}",app_seq);
		return approvalDao.oneMyPayPause(app_seq);
	}

	//승인시 
	@Override
	public int approvePay(String app_draft,String app_seq) {
		log.info("결재 승인 결재상태 수정 : {}",app_draft,app_seq);
		return approvalDao.approvePay(app_draft, app_seq);
	}

	@Override
	public int approvePayLine(String app_seq,String pay_num) {
		log.info("결재 승인 결재라인수정 : {}",app_seq,pay_num);
		return approvalDao.approvePayLine(app_seq,pay_num);
	}

	@Override
	public int banRuApproval(String app_seq) {
		log.info("결재 승인 결재상태 수정 : {}",app_seq);
		return approvalDao.banRuApproval(app_seq);
	}

	@Override
	public int banRuPayLine(String pay_rejectreason,String app_seq,String pay_num,String pay_user) {
		log.info("결재 승인 결재상태 수정 : {} {} {} {}",pay_rejectreason, app_seq ,pay_num,pay_user);
		return approvalDao.banRuPayLine(pay_rejectreason, app_seq ,pay_num,pay_user);
	}


	@Override
	public int selectTempCount(String user_id) {
		return approvalDao.selectTempCount(user_id);
	}

	@Override
	public List<ApprovalVo> selectTempPage(Map<String, Object> map) {
		return approvalDao.selectTempPage(map);
	}


	
}
