package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.SignsVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class SignsDaoImpl implements ISignsDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.SignsDaoImpl.";

	@Override
	public int insertPad(Map<String, Object> map) {
		log.info("##### 서명 등록 insertPad #####");
		return sqlSession.insert(NS+"insertPad",map);
	}

	@Override
	public int delPad(String signs_seq) {
		log.info("##### 서명 삭제 delPad #####");
		return sqlSession.delete(NS+"delPad",signs_seq);
	}

	@Override
	public SignsVo selectPad(String signs_seq) {
		log.info("##### 서명 조회 selectPad #####");		
		return sqlSession.selectOne(NS + "selectPad",signs_seq);
	}

	@Override
	public List<SignsVo> AllselectPad() {
		log.info("##### 서명 전체 조회 AllselectPad #####");
		return sqlSession.selectList(NS+"AllselectPad");
	}

}
