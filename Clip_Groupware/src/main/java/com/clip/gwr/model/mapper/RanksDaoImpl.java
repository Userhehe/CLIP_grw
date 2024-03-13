package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.DeptVo;

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
	public int delRanks(String ranks_seq) {
		log.info("##### 직급삭제 delRanks #####");
		return sqlSession.delete(NS+"delRanks",ranks_seq);
	}

	@Override
	public List<DeptVo> searchRanks(String ranks_name) {
		log.info("##### 직급검색 searchRanks #####");
		return sqlSession.selectList(NS+"searchRanks",ranks_name) ;
	}

	@Override
	public int duplicateRanks(String ranks_name) {
		log.info("##### 직급명 중복검사 duplicateRanks #####");
		return sqlSession.selectOne(NS+"duplicateRanks",ranks_name);
	}

}
