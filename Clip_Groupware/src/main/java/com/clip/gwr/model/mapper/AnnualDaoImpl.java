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
	public int insertAnnual(Map<String, Object> map) {
		log.info("AnnualDaoImpl insertAnnual 연차등록");
		return sqlSession.insert(NS+"insertAnnual",map);
	}

	@Override
	public int insertAnnualup(Map<String, Object> map) {
		log.info("AnnualDaoImpl insertAnnual 발생연차 합산  ");
		return sqlSession.update(NS+"insertAnnualup" , map);
	}

	@Override
	public List<AnnualVo> selAnnual() {
		log.info("AnnualDaoImpl selAnnual 연차 전체 조회");
		return sqlSession.selectList(NS);
	}

	@Override
	public AnnualVo detailAnnual(String user_id) {
		log.info("AnnualDaoImpl selAnnual 연차 상세 조회");
		return sqlSession.selectOne(NS+"detailAnnual",user_id);
	}

	@Override
	public int updateAnnual(Map<String, Object> map) {
		log.info("AnnualDaoImpl selAnnual 연차 수정");
		return sqlSession.update(NS+"updateAnnual",map);
	}

	@Override
	public int resetAnnual(Map<String, Object> map) {
		log.info("AnnualDaoImpl resetAnnual 연차 초기화");
		return sqlSession.update(NS+"resetAnnual",map);
	}

	@Override
	public int annUse(Map<String, Object> map) {
		log.info("AnnualDaoImpl annUse 연차 신청");
		return sqlSession.insert(NS+"annUse",map);
	}

	@Override
	public int annUseUpdate(Map<String, Object> map) {
		log.info("AnnualDaoImpl annUseUpdate  사용량 업데이트");
		return sqlSession.update(NS+"annUseUpdate",map);
	}

	@Override
	public int annLeovUpdate(String user_id) {
		log.info("AnnualDaoImpl annLeovUpdate  잔여연차 업데이트");
		return sqlSession.update(NS+"annLeovUpdate",user_id);
	}

	@Override
	public List<AnnualVo> searchAnnual(Map<String, Object> map) {
		log.info("AnnualDaoImpl searchAnnual  연차검색");
		return sqlSession.selectList(NS+"searchAnnual",map);
	}

}
