package com.clip.gwr.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clip.gwr.vo.ApprovalVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ApprovalDaoImpl implements IApprovalDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.ApprovalDaoImpl.";
	
	//내가 요청한 결재내역 전체 조회
	@Override
	public List<ApprovalVo> getAllApproval(String user_id) {
		log.info("ApprovalDaoImpl getAllApproval 전체 나의결재내역 조회");
		return sqlSession.selectList(NS+"getAllApproval", user_id);
	}

	
	// 내가/내팀이 참조된 결재내역 전체 조회
	@Override
	public List<ApprovalVo> selectReferApproval(String user_id) {
		log.info("ApprovalDaoImpl selectReferApproval 내팀/내가 참조된 결재리스트 조회:{} ",user_id);
		return sqlSession.selectList(NS+"selectReferApproval",user_id);
	}


	//결재내역 단일 상세 조회
	@Override
	public ApprovalVo getOneApproval(String appSeq) {
		log.info("ApprovalDaoImpl getOneApproval 결재내역 단일 상세조회");
		return sqlSession.selectOne(NS+"getOneApproval", appSeq);
	}

	
	@Override
	//나의 임시 저장한 결재파일 불러오기
	public List<ApprovalVo> getTempApproval(String user_id) {
		log.info("ApprovalDaoImpl getTempApproval 임시저장 결재파일들 조회");
		return sqlSession.selectList(NS+"getTempApproval", user_id);
	}

	@Override
	//나의 결재승인을 받아야하는 결재 리스트조회
	public List<ApprovalVo> getMyPaycheck(String user_id){
		log.info("ApprovalDaoImpl getMyPaycheck 나의 결재승인을 받아야하는 결재 리스트조회");
		return sqlSession.selectList(NS+"getMyPaycheck", user_id);
	}
	


	@Override
	//나의 결재승인을 받아야하는 미처리한 결재 리스트조회
	public List<ApprovalVo> getMyUnprocessedPaycheck(String user_id) {
		log.info("ApprovalDaoImpl getMyUnprocessedPaycheck 나의 결재승인을 받아야하는 미처리한 결재 리스트조회");
		return sqlSession.selectList(NS+"getMyUnprocessedPaycheck",user_id);
	}

	//내가 승인해야할것들 중 반려처리한 결재들을 조회해준다.(작성자랑 반려처리한 사람만 조회가능.)
	@Override
	public List<ApprovalVo> getMyRejectPay(String user_id) {
		log.info("ApprovalDaoImpl getMyRejectPay 해당 승인자가 반려처리한 결재들을 조회한다.");
		return sqlSession.selectList(NS+"getMyRejectPay",user_id);
	}


//	결재 승인/반려에 따른 결재 현황 정보 수정
	@Override
	public int checkApprovalLine(ApprovalVo approvalVo) {
		log.info("ApprovalDaoImpl checkApprovalLine 결재의 결재라인과 결재 현황을 결재승인 및 반려에 맞게 변경.");
		return sqlSession.update(NS+"checkApprovalLine", approvalVo);
	}


	
	
	
	//결재 제목검색 리스트 조회
	@Override
	public List<ApprovalVo> conditionSearchApproval(Map<String, Object> map) {
		log.info("ApprovalDaoImpl conditionSearchApproval 결재 제목/작성자 검색 리스트 조회");
		return sqlSession.selectList(NS+"conditionSearchApproval", map);
	}

	
	@Override
	public List<ApprovalVo> optionalApprovalList(Map<String, Object> map) {
		log.info("ApprovalDaoImpl optionalApprovalList 결재 옵션 선택 리스트 조회");
		return sqlSession.selectList(NS+"optionalApprovalList", map);
	}
	
	
	
	
	//기안 결재요청
	@Override
	public int reqDynamicDateApproval(ApprovalVo approvalVo) {
		log.info("ApprovalDaoImpl reqDynamicDateApproval 결재신청");
		return sqlSession.insert(NS+"reqDynamicDateApproval",approvalVo);
	}

	
	//기안 결재 임시저장
	@Override
	public int saveTempApproval(ApprovalVo approvalVo) {
		log.info("ApprovalDaoImpl saveTempApproval 결재파일 임시저장");
		return sqlSession.insert(NS+"saveTempApproval", approvalVo);
	}

	//결재 취소
	@Override
	public int cancelApproval(String appSeq) {
		log.info("ApprovalDaoImpl cancelApproval 결재취소");
		return sqlSession.update(NS+"cancelApproval",appSeq);
	}

	//임시저장 결재 삭제
	@Override
	public int tempDelete(String appSeq) {
		log.info("ApprovalDaoImpl tempDelete 결재 삭제",appSeq);
		return sqlSession.delete(NS+"tempDelete",appSeq);
	}

	//승인 처리시 실행
	@Override
	public int approvePay(String app_draft,String app_seq) {
		log.info("approvePays 승인 처리 : {} {}", app_draft, app_seq);
		    Map<String, Object> map = new HashMap<>();
		    map.put("app_draft", app_draft);
		    map.put("app_seq", app_seq);
	    return sqlSession.update(NS + "approvePay", map);
	}
	@Override
	public int approvePayLine(String app_seq,String pay_num) {
		log.info("approvePayLine 승인 처리 : {} {}",app_seq,pay_num);
		Map<String, Object> map = new HashMap<>();
	    map.put("app_seq", app_seq);
	    map.put("pay_num", pay_num);
		return sqlSession.update(NS+"approvePayLine",map);
	}


	@Override
	public ApprovalVo oneMyPaycheck(String app_seq) {
		log.info("approvePayLine 승인 처리 : {} ",app_seq);
		return sqlSession.selectOne(NS+"oneMyPaycheck",app_seq);
	}


	@Override
	public ApprovalVo oneMyPaychecked(String user_id) {
		log.info("oneMyPaychecked 했던거 불러오기 : {} ",user_id);
		return sqlSession.selectOne(NS+"oneMyPaychecked",user_id);
	}


	@Override
	public ApprovalVo oneMyPayPause(String app_seq) {
		log.info("oneMyPayPause 반려 했던거 불러오기 : {} ",app_seq);
		return sqlSession.selectOne(NS+"oneMyPayPause",app_seq);
	}


	@Override
	public int banRuApproval(String app_seq) {
		log.info("banRuApproval 결재상태 번경 :  {} ",app_seq);
		return sqlSession.update(NS+"banRuApproval",app_seq);
	}
	@Override
	public int banRuPayLine(String pay_rejectreason,String app_seq,String pay_num,String pay_user) {
		log.info("banRuPayLine 결재라인 번경 :{} {} {} {}  ",pay_rejectreason,app_seq,pay_num,pay_user);
		Map<String, Object> map = new HashMap<>();
		map.put("pay_rejectreason", pay_rejectreason);
	    map.put("app_seq", app_seq);
	    map.put("pay_num", pay_num);
	    map.put("pay_user", pay_user);
		return sqlSession.update(NS+"banRuPayLine",map);
	}


	
}
