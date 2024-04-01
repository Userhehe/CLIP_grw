package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IFileUploadDao;
import com.clip.gwr.vo.FileVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileUploadServiceImpl implements IFileUploadService {
	
	@Autowired
	private IFileUploadDao dao;
	
	/**
	 * 사진파일 등록 1
	 */
	@Override
	public int insertPhotoinfo(Map<String, Object> map) {
		log.info("FileUploadServiceImpl insertPhotoinfo 사진등록 1");
		return dao.insertPhotoinfo(map);
	}

	/**
	 * 사진파일 등록 2
	 */
	@Override
	public int insertFileFeature(Map<String, Object> map) {
		log.info("FileUploadServiceImpl insertFileFeature 사진등록 2");
		return dao.insertFileFeature(map);
	}

	/**
	 * 사진파일 등록 3
	 */
	@Override
	public int updateUserinfoPhoto(Map<String, Object> map) {
		log.info("FileUploadServiceImpl updateUserinfoPhoto 사진등록 3");
		return dao.updateUserinfoPhoto(map);
	}

	/**
	 * 사진파일 수정
	 */
	@Override
	public int updatePhotoinfo(Map<String, Object> map) {
		log.info("FileUploadServiceImpl updatePhotoinfo 사진수정");
		return dao.updatePhotoinfo(map);
	}
	
	/**
	 * 사진파일 삭제 1
	 */
	@Override
	public int deletePhotoFileinfo(Map<String, Object> map) {
		log.info("FileUploadServiceImpl deletePhotoFileinfo 사진파일 삭제 1");
		return dao.deletePhotoFileinfo(map);
	}
	
	/**
	 * 사진파일 삭제 2
	 */
	@Override
	public int updatePhotoPhotoinfo(Map<String, Object> map) {
		log.info("FileUploadServiceImpl updatePhotoPhotoinfo 사진파일 삭제 2");
		return updatePhotoPhotoinfo(map);
	}

	/**
	 * 사진파일 삭제 3
	 */
	@Override
	public int deletePhotoUserinfo(Map<String, Object> map) {
		log.info("FileUploadServiceImpl deletePhotoUserinfo 사진파일 삭제 3");
		return deletePhotoUserinfo(map);
	}
	
	/**
	 * 사진파일 조회
	 */
	@Override
	public List<FileVo> selectPhotoinfo(String user_id) {
		log.info("FileUploadServiceImpl selectPhotoinfo 사진파일 조회");
		return dao.selectPhotoinfo(user_id);
	}
	
}
