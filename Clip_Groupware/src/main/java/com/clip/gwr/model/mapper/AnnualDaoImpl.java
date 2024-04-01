package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.AnnualVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AnnualDaoImpl implements IAnnualDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.AnnualDaoImpl.";
	
	
	
	@Override
	public int insertAnn(Map<String, Object> map) {
		log.info("##### 연차등록 (사원 등록시) insertAnn #####");
		return sqlSession.insert(NS+"insertAnn",map);
	}

	@Override
	public int insertAnnualUp(String user_id) {
		log.info("##### 1달마다 연차 등록  insertAnnualUp #####");
		return sqlSession.update(NS+"insertAnnualUp",user_id);
	}

	@Override
	public List<AnnualVo> annAll() {
		log.info("##### 연차전체조회 annAll #####");
		return sqlSession.selectList(NS+"annAll");
	}

	@Override
	public AnnualVo detailAnn(String user_id) {
		log.info("##### 연차상세조회 annAll #####");
		return sqlSession.selectOne(NS+"detailAnn",user_id);
	}

	@Override
	public int updateAnn(Map<String, Object> map) {
		log.info("##### 연차 수정 updateAnn #####");
		return sqlSession.update(NS+"updateAnn",map);
	}

	@Override
	public int resetAnn(Map<String, Object> map) {
		log.info("##### 1년마다 연차 초기화  resetAnn #####");
		return sqlSession.update(NS+"resetAnn",map);
	}

	@Override
	public int resetAnnualUse(Map<String, Object> map) {
		log.info("##### 1년마다 사용 연차 초기화  resetAnnualUse #####");
		return sqlSession.update(NS+"resetAnnualUse",map);
	}
	
	@Override
	public List<AnnualVo> searchAnnual(Map<String, Object> map) {
		log.info("##### 연차검색 searchAnnual #####");
		return sqlSession.selectList(NS+"searchAnnual",map);
	}

	@Override
	public int chkAnn(String user_id) {
		log.info("##### 연차 데이터 존재 유무 확인 chkAnn #####");
		return sqlSession.selectOne(NS+"chkAnn",user_id);
	}

	@Override
	public int selAnnLe(String user_id) {
		log.info("##### 데이터 잔여 일수 조회 selAnnLe #####");
		return sqlSession.selectOne(NS+"selAnnLe",user_id);
	}

	@Override
	public int applyAnn(Map<String, Object> map) {
		log.info("##### 데이터 없을경우 연차신청 applyAnn #####");
		return sqlSession.insert(NS+"applyAnn",map);
	}

	@Override
	public int selAvaliday(String user_id) {
		log.info("##### 사용가능일수 조회 selAvaliday #####");
		return sqlSession.selectOne(NS+"selAvaliday",user_id);
	}

	@Override
	public int applyUpdateAnn(String user_id) {
		log.info("##### 연차신정(update) applyUpdateAnn #####");
		return sqlSession.update(NS+"applyUpdateAnn",user_id);
	}

		
}
