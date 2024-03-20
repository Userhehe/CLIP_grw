package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;

import lombok.extern.slf4j.Slf4j;
@Repository
@Slf4j
public class PositionsDaoImpl implements IPositionsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.PositionsDaoImpl.";
	
	@Override
	public int insertPositions(Map<String, Object> map) {
		log.info("##### 직책등록 insertPositions #####");
		return sqlSession.insert(NS+"insertPositions",map);
	}

	@Override
	public int updatePositions(Map<String, Object> map) {
		log.info("##### 직책수정 updatePositions #####");
		return sqlSession.update(NS+"updatePositions",map);
	}

	@Override
	public int delPosition(Map<String, Object>map) {
		log.info("##### 직책삭제 updatePositions #####");
		return sqlSession.delete(NS+"delPosition",map);
	}

	@Override
	public List<PositionsVo> searchPosition(Map<String, Object>map) {
		log.info("##### 직책검색 searchPosition #####");
		return sqlSession.selectList(NS+"searchPosition",map);
	}

	@Override
	public int duplicatePosition(Map<String, Object>map) {
		log.info("##### 직책명 중복검사 duplicatePosition  #####");
		return sqlSession.selectOne(NS+"duplicatePosItion",map);
	}

	@Override
	public List<PositionsVo> positionsAll() {
		log.info("##### 직책 전체 조회  positionsAll #####");
		return sqlSession.selectList(NS+"positionsAll()");
	}

}
