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
	
	//전체 결재내역 전체 조회
	@Override
	public List<ApprovalVo> getAllApproval() {
		log.info("ApprovalDaoImpl getAllApproval 전체 결재내역 조회");
		return sqlSession.selectList(NS+"getAllApproval");
	}

	//결재내역 단일 상세 조회
	@Override
	public ApprovalVo getOneApproval(String appSeq) {
		log.info("ApprovalDaoImpl getOneApproval 결재내역 단일 상세조회");
		return sqlSession.selectOne(NS+"getOneApproval", appSeq);
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

	

	

	
}
