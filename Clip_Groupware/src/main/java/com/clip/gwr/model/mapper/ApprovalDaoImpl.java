package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		log.info("ApprovalDaoImpl selectReferApproval 내팀/내가 참조된 결재리스트 조회");
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

	

	

	
}
