package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.GianVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class GianDaoImpl implements IGianDao {

	@Autowired
	private SqlSessionTemplate sqlSession;	
	private final String NS = "com.clip.gwr.model.mapper.GianDaoImpl.";
	
	@Override
	public List<GianVo> templateAll() {
		return sqlSession.selectList(NS+"templateAll");
	}

	@Override
	public GianVo templateDetail(String gian_seq) {
		return sqlSession.selectOne(NS+"templateDetail",gian_seq);
	}

	@Override
	public int tempateInsert(Map<String,Object>map) {
		return sqlSession.insert(NS+"tempateInsert",map);
	}

	@Override
	public int templateUpdate(Map<String,Object>map) {
		return sqlSession.update(NS+"templateUpdate",map);
	}

	@Override
	public int templateDelete(String gian_seq) {
	    return sqlSession.delete(NS+"templateDelete"); 
	}

	@Override
	public List<GianVo> templateGubunSel() {
		return sqlSession.selectList(NS+"templateGubunSel");
	}

	@Override
	public List<GianVo> templateNameSel(String gian_name) {
		return sqlSession.selectList(NS+"templateNameSel",gian_name);
	}

	@Override
	public List<GianVo> mySeletTemplate(String user_Id) {
		return sqlSession.selectList(NS+"mySeletTemplate",user_Id);
	}

	@Override
	public int myInsert(Map<String, Object> map) {
		return sqlSession.insert(NS+"myInsert");
	}

	@Override
	public int myDel(String gian_seq,String user_id) {
		return sqlSession.delete(gian_seq,user_id);
	}

}
