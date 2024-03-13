package com.test.gwr;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IFileUploadService;
import com.clip.gwr.vo.FileVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class fileUploadJUnitTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IFileUploadService service; 

	Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 사진파일 등록1
	 */
//	@Test
	public void insertPhotoinfo() {
		map.put("user_id", "USER_002");
		int insertPhotoinfo = sqlSession.insert("com.clip.gwr.model.mapper.FileUploadDaoImpl.insertPhotoinfo", map);
		System.out.println("##insertPhotoinfo : " + insertPhotoinfo);
		assertNotNull(insertPhotoinfo);
	}
	
	/**
	 * 사진파일 등록2
	 */
//	@Test
	public void insertFileFeature() {
		map.put("user_id","USER_002");
		map.put("file_originname","originname1");
		map.put("file_storename","storename1");
		map.put("file_size",2000000);
		map.put("file_path","C:\\Users\\dongi\\Pictures");
		int insertFileFeature = sqlSession.insert("com.clip.gwr.model.mapper.FileUploadDaoImpl.insertFileFeature", map);
		System.out.println("##insertFileFeature : " + insertFileFeature);
		assertNotNull(insertFileFeature);
	}
	
	/**
	 * 사진파일 등록3
	 */
//	@Test
	public void updateUserinfoPhoto() {
		map.put("user_id","USER_002");
		int updateUserinfoPhoto = sqlSession.update("com.clip.gwr.model.mapper.FileUploadDaoImpl.updateUserinfoPhoto", map);
		System.out.println(updateUserinfoPhoto);
		assertNotNull(updateUserinfoPhoto);
	}
	
	
	/**
	 * 사진파일 수정
	 */
//	@Test
	public void updatePhotoinfo() {
		map.put("file_originname","originname3");
		map.put("file_storename","storename3");
		map.put("file_size",5000000);
		map.put("file_path","C:\\Users\\dongi\\Pictures");
		map.put("user_id","USER_001");
		int updatePhoto = sqlSession.update("com.clip.gwr.model.mapper.FileUploadDaoImpl.updatePhotoinfo", map);
		System.out.println(updatePhoto);
		assertNotNull(updatePhoto);
	}
	
	/**
	 * 사진파일 삭제 1
	 */
//	@Test
	public void deletePhotoFileinfo() {
		map.put("user_id","USER_002");
		int deletePhotoFileinfo = sqlSession.delete("com.clip.gwr.model.mapper.FileUploadDaoImpl.deletePhotoFileinfo", map);
		System.out.println("##deletePhotoFileinfo : " + deletePhotoFileinfo);
		assertNotNull(deletePhotoFileinfo);
	}
	
	/**
	 * 사진파일 삭제 2
	 */
//	@Test
	public void updatePhotoPhotoinfo() {
		map.put("user_id","USER_002");
		int updatePhotoPhotoinfo = sqlSession.update("com.clip.gwr.model.mapper.FileUploadDaoImpl.updatePhotoPhotoinfo", map);
		System.out.println("##updatePhotoPhotoinfo : " + updatePhotoPhotoinfo);
		assertNotNull(updatePhotoPhotoinfo);
	}
	
	/**
	 * 사진파일 삭제 3
	 */
//	@Test
	public void deletePhotoUserinfo() {
		map.put("user_id","USER_002");
		int deletePhotoUserinfo = sqlSession.delete("com.clip.gwr.model.mapper.FileUploadDaoImpl.deletePhotoUserinfo", map);
		System.out.println("##deletePhotoUserinfo : " + deletePhotoUserinfo);
		assertNotNull(deletePhotoUserinfo);
	}
	
	/**
	 * 사진파일 조회
	 */
//	@Test
	public void selectPhotoinfo() {
		map.put("user_id","USER_001");
		List<FileVo> lists = sqlSession.selectList("com.clip.gwr.model.mapper.FileUploadDaoImpl.selectPhotoinfo", map);
		System.out.println(lists);
		assertNotNull(lists);
	}
}
