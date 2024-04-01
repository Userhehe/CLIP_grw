package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.FileVo;

public interface IFileUploadDao {
	
	/**
	 * 사진파일 등록 1
	 * @param map
	 * @return
	 */
	public int insertPhotoinfo(Map<String, Object> map);
	
	/**
	 * 사진파일 등록 2
	 * @param map
	 * @return
	 */
	public int insertFileFeature(Map<String, Object> map);
	
	/**
	 * 사진파일 등록 3
	 * @param map
	 * @return
	 */
	public int updateUserinfoPhoto(Map<String, Object> map);
	
	/**
	 * 사진파일 수정
	 * @param map
	 * @return
	 */
	public int updatePhotoinfo(Map<String, Object> map);
	
	/**
	 * 사진파일 삭제 1
	 * @param map
	 * @return
	 */
	public int deletePhotoFileinfo(Map<String, Object> map);
	
	/**
	 * 사진파일 삭제 2
	 * @param map
	 * @return
	 */
	public int updatePhotoPhotoinfo(Map<String, Object> map);
	
	/**
	 * 사진파일 삭제 3
	 * @param map
	 * @return
	 */
	public int deletePhotoUserinfo(Map<String, Object> map);
	
	/**
	 * 사진파일 조회
	 * @param map
	 * @return
	 */
	public List<FileVo> selectPhotoinfo(String user_id);
}
