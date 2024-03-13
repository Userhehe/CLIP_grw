package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.FileVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class FileUploadDaoImpl implements IFileUploadDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.FileUploadDaoImpl.";
	
	/**
	 * 사진파일 등록 1
	 */
	@Override
	public int insertPhotoinfo(Map<String, Object> map) {
		log.info("##### 사진파일 등록 1 insertPhotoinfo #####");
		return sqlSession.insert(NS + "insertPhotoinfo", map);
	}

	/**
	 * 사진파일 등록 2
	 */
	@Override
	public int insertFileFeature(Map<String, Object> map) {
		log.info("##### 사진파일 등록 1 insertPhotoinfo #####");
		return sqlSession.insert(NS + "insertFileFeature", map);
	}

	/**
	 * 사진파일 등록 3
	 */
	@Override
	public int updateUserinfoPhoto(Map<String, Object> map) {
		log.info("##### 사진파일 등록 1 insertPhotoinfo #####");
		return sqlSession.update(NS + "updateUserinfoPhoto", map);
	}
	
	/**
	 * 사진파일 수정
	 */
	@Override
	public int updatePhotoinfo(Map<String, Object> map) {
		log.info("##### 사진파일 수정 updatePhoto #####");
		return sqlSession.update(NS + "updatePhotoinfo", map);
	}
	
	/**
	 * 사진파일 삭제 1
	 */
	@Override
	public int deletePhotoFileinfo(Map<String, Object> map) {
		log.info("##### 사진파일 삭제 1 deletePhotoFileinfo #####");
		return sqlSession.delete(NS + "deletePhotoFileinfo", map);
	}
	
	/**
	 * 사진파일 삭제 2
	 */
	@Override
	public int updatePhotoPhotoinfo(Map<String, Object> map) {
		log.info("##### 사진파일 삭제 2 updatePhotoPhotoinfo #####");
		return 0;
	}

	/**
	 * 사진파일 삭제 3
	 */
	@Override
	public int deletePhotoUserinfo(Map<String, Object> map) {
		log.info("##### 사진파일 삭제 3 deletePhotoUserinfo #####");
		return 0;
	}
	
	/**
	 * 사진파일 조회
	 */
	@Override
	public List<FileVo> selectPhotoinfo(Map<String, Object> map) {
		log.info("##### 사진파일 조회 selectPhotoinfo #####");
		return sqlSession.selectList(NS + "selectPhotoinfo", map);
	}

}
