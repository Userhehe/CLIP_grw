package com.clip.gwr.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.ReferenceVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ReferenceDaoImpl implements IReferenceDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.ReferenceDaoImpl.";

	@Override
	public int putReference(List<ReferenceVo> list) {
		log.info("ReferenceDaoImpl putReference 참조인 입력");
		return sqlSession.insert(NS+"putReference",list);
	}

	
	@Override
	public List<ReferenceVo> getReferenceAll(String app_seq) {
		log.info("ReferenceDaoImpl getReferenceAll 참조인 가져오기");
		return sqlSession.selectList(NS+"getReferenceAll",app_seq);
	}

}
