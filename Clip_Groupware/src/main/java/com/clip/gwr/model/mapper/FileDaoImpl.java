package com.clip.gwr.model.mapper;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDaoImpl implements IFileDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.FileDaoImpl.";
	
	@Override
	public int insertFile(Map<String, Object> map) {
		System.out.println("FileDaoImpl insertFile 파일 업로드");
		return sqlSession.insert(NS+"insertFile", map);
	}

}
