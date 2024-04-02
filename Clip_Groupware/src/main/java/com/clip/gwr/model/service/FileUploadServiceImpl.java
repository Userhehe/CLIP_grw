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
	public int deletePhotoFileinfo(String user_id) {
		log.info("FileUploadServiceImpl deletePhotoFileinfo 사진파일 삭제 1");
		return dao.deletePhotoFileinfo(user_id);
	}
	
	/**
	 * 사진파일 삭제 2
	 */
	@Override
	public int updatePhotoPhotoinfo(String user_id) {
		log.info("FileUploadServiceImpl updatePhotoPhotoinfo 사진파일 삭제 2");
		return dao.updatePhotoPhotoinfo(user_id);
	}

	/**
	 * 사진파일 삭제 3
	 */
	@Override
	public int deletePhotoUserinfo(String user_id) {
		log.info("FileUploadServiceImpl deletePhotoUserinfo 사진파일 삭제 3");
		return dao.deletePhotoUserinfo(user_id);
	}
	
	/**
	 * 사진파일 조회
	 */
	@Override
	public List<FileVo> selectPhotoinfo(String user_id) {
		log.info("FileUploadServiceImpl selectPhotoinfo 사진파일 조회");
		return dao.selectPhotoinfo(user_id);
	}

	/**
	 * 사진유무 조회
	 */
	@Override
	public int checkPhotoUse(String user_id) {
		log.info("FileUploadServiceImpl checkPhotoUse 사진유무 체크");
		return dao.checkPhotoUse(user_id);
	}

	/**
	 * 사진파일명 조회
	 */
	@Override
	public String selectPhotoName(String user_id) {
		log.info("FileUploadServiceImpl selectPhotoName 사진파일명 조회");
		return dao.selectPhotoName(user_id);
	}
	
	/**
	 * 사진파일 경로 조회
	 */
	@Override
	public String selectPhotoPath(String user_id) {
		log.info("FileUploadServiceImpl selectPhotoPath 사진파일 경로 조회");
		return dao.selectPhotoPath(user_id);
	}
}
