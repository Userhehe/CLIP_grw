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
	public int deletePhotoFileinfo(String user_id);
	
	/**
	 * 사진파일 삭제 2
	 * @param map
	 * @return
	 */
	public int updatePhotoPhotoinfo(String user_id);
	
	/**
	 * 사진파일 삭제 3
	 * @param map
	 * @return
	 */
	public int deletePhotoUserinfo(String user_id);
	
	/**
	 * 사진파일 조회
	 * @param map
	 * @return
	 */
	public List<FileVo> selectPhotoinfo(String user_id);
	
	
	/**
	 * 사진유무 체크
	 * @param user_id
	 * @return
	 */
	public int checkPhotoUse(String user_id);
	
	
	/**
	 * 사진파일명 조회
	 * @param user_id
	 * @return
	 */
	public String selectPhotoName(String user_id);
	
	/**
	 * 사진경로 조회
	 * @param user_id
	 * @return
	 */
	public String selectPhotoPath(String user_id);
}
