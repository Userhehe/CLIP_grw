package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.RanksVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class RanksDaoImpl implements IRanksDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.RanksDaoImpl.";

	@Override
	public int insertRanks(Map<String, Object> map) {
		log.info("##### 직급등록 insertRanks #####");
		return sqlSession.insert(NS+"insertRanks",map);
	}

	@Override
	public int updateRanks(Map<String, Object> map) {
		log.info("##### 직급수정 updateRanks #####");
		return sqlSession.update(NS+"updateRanks",map);
	}

	@Override
	public int delRanks(Map<String, Object> map) {
		log.info("##### 직급삭제 delRanks #####");
		return sqlSession.delete(NS+"delRanks",map);
	}

	@Override
	public List<RanksVo> searchRanks(Map<String, Object> map) {
		log.info("##### 직급검색 searchRanks #####");
		return sqlSession.selectList(NS+"searchRanks",map) ;
	}

	@Override
	public int duplicateRanks(Map<String, Object> map) {
		log.info("##### 직급명 중복검사 duplicateRanks #####");
		return sqlSession.selectOne(NS+"duplicateRanks",map);
	}

	@Override
	public List<RanksVo> ranksAll() {
		log.info("##### 직급 전체 조회  ranksAll() #####");
		return sqlSession.selectList(NS+"ranksAll");
	}

}
