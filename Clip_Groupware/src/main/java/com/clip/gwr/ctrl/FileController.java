package com.clip.gwr.ctrl;

import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.util.WebUtils;

import com.clip.gwr.model.service.IFileService;
import com.clip.gwr.model.service.IFileUploadService;
import com.clip.gwr.vo.FileVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {

	@Autowired
	private IFileUploadService fileUploadService;

	/**
	 * 사진이미지 업로드
	 * @param request
	 * @param response
	 * @param session
	 * @param file
	 */
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value = "/photoUpload.do")
	public void photoUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("uploadImage") MultipartFile file) {
		
        // 파일을 업로드할 경로
//        String uploadDirectory = "C:\\Users\\dongi\\git\\CLIP_grw\\Clip_Groupware\\src\\main\\webapp\\images\\userprofile\\";
		ServletContext servletContext = request.getServletContext();
		String uploadDirectory = servletContext.getRealPath("/images/userprofile/");
		log.info("######uploadDirectory : " + uploadDirectory);
		
		log.info("####file : " + file);
		String contentType = file.getContentType();
		log.info("####contentType : " + contentType);
		
		String filename = file.getOriginalFilename(); // 파일 원본 이름
		log.info("####filename : " + filename);
		
		int filesize = (int) file.getSize(); 
		log.info("####filesize : " + filesize);
		
		// 중복 방지 랜덤 파일명
		String saveFileName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
		log.info("####saveFileName : " + saveFileName);
		

		Map<String, Object> map = new HashMap<String, Object>();
		UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
		log.info("####loginVo : " + loginVo);
		String user_id = loginVo.getUser_id();
		log.info("####user_id :: " + user_id);
		map.put("user_id", user_id);
		map.put("file_originname", filename);
		map.put("file_storename", saveFileName);
		map.put("file_size", filesize);
		map.put("file_path", uploadDirectory);
		List<FileVo> fileList = fileUploadService.selectPhotoinfo(user_id); // 사진파일 조회
		log.info("####fileList : " + fileList);
		try {
	        int insertPhotoinfo = fileUploadService.insertPhotoinfo(map); // 사진파일 등록 1
	        log.info("####insertPhotoinfo : " + insertPhotoinfo);
	        int insertFileFeature = fileUploadService.insertFileFeature(map); // 사진파일 등록 2
	        log.info("####insertFileFeature : " + insertFileFeature);
	        int updateUserinfoPhoto = fileUploadService.updateUserinfoPhoto(map); // 사진파일 등록 3
	        log.info("####updateUserinfoPhoto : " + updateUserinfoPhoto);
	        
	        if (!file.isEmpty()) {
	            file.transferTo(new File(uploadDirectory + saveFileName)); // 업로드된 파일을 서버에 저장
	            log.info("----업로드 성공");
	            response.sendRedirect("./myPage.do");
	        } else {
	            response.sendRedirect("./accessError.do");
	        }
	    } catch (IOException e) {
	        log.info("----업로드 실패");
	        e.printStackTrace();
	    }
	}
	
	/**
	 * 사진이미지 수정
	 * @param request
	 * @param response
	 * @param session
	 * @param file
	 */
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value = "/photoUpdate.do")
	public void photoUpdate(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("updateImage") MultipartFile file) {
        // 파일을 수정할 경로
		ServletContext servletContext = request.getServletContext();
		String uploadDirectory = servletContext.getRealPath("/images/userprofile/");
		log.info("#####uploadDirectory" + uploadDirectory);
        
		log.info("####file : " + file);
		String contentType = file.getContentType();
		log.info("####contentType : " + contentType);
		
		String filename = file.getOriginalFilename(); // 파일 원본 이름
		log.info("####filename : " + filename);
		
		int filesize = (int) file.getSize(); 
		log.info("####filesize : " + filesize);
		
		String saveFileName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
		log.info("####saveFileName : " + saveFileName);
		
		Map<String, Object> map = new HashMap<String, Object>();
		UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
		log.info("####loginVo : " + loginVo);
		String user_id = loginVo.getUser_id();
		log.info("####user_id :: " + user_id);
		map.put("user_id", user_id);
		map.put("file_originname", filename);
		map.put("file_storename", saveFileName);
		map.put("file_size", filesize);
		map.put("file_path", uploadDirectory);
		try {
			List<FileVo> fileList = fileUploadService.selectPhotoinfo(user_id); // 사진파일 조회
			log.info("####fileList : " + fileList);
			
			String beforeSaveFileName = fileUploadService.selectPhotoName(user_id);
			log.info("####beforeSaveFileName : " + beforeSaveFileName);
			
			String beforeUploadDirectory = fileUploadService.selectPhotoPath(user_id);
			log.info("####beforeUploadDirectory : " + beforeUploadDirectory);
			
			File existingFile = new File(beforeUploadDirectory + beforeSaveFileName);
			if (existingFile.exists()) {
				existingFile.delete(); // 이미지 폴더 내부 기존파일 삭제
			}
			
	        int updatePhotoinfo = fileUploadService.updatePhotoinfo(map); // 사진파일 등록 1
	        log.info("####insertPhotoinfo : " + updatePhotoinfo);
	        
	        if (!file.isEmpty()) {
	            file.transferTo(new File(uploadDirectory + saveFileName)); // 업로드된 파일을 서버에 저장
	            log.info("----수정 성공");
	            response.sendRedirect("./myPage.do");
	        } else {
	            response.sendRedirect("./accessError.do");
	        }
	    } catch (IOException e) {
	        log.info("----수정 실패");
	        e.printStackTrace();
	    }
	}
	
	
	/**
	 * 사진이미지 삭제
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value = "/photoDel.do")
	public void photoDel(HttpServletResponse response, HttpSession session) throws IOException {
		log.info("----파일삭제----");
		UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
		String user_id = loginVo.getUser_id();
		
		try {
			String saveFileName = fileUploadService.selectPhotoName(user_id);
			String uploadDirectory = fileUploadService.selectPhotoPath(user_id);
			log.info("####saveFileName : " + saveFileName);
			log.info("####uploadDirectory : " + uploadDirectory);
			
	        int deletePhotoFileinfo = fileUploadService.deletePhotoFileinfo(user_id);
	        log.info("####deletePhotoFileinfo : " + deletePhotoFileinfo);

	        int updatePhotoPhotoinfo = fileUploadService.updatePhotoPhotoinfo(user_id);
	        log.info("####updatePhotoPhotoinfo : " + updatePhotoPhotoinfo);

	        int deletePhotoUserinfo = fileUploadService.deletePhotoUserinfo(user_id);
	        log.info("####deletePhotoUserinfo : " + deletePhotoUserinfo);
	        
	        File existingFile = new File(uploadDirectory + saveFileName);
	        if (existingFile.exists()) {
	            existingFile.delete(); // 이미지 폴더 내부 기존파일 삭제
	        }
	        
	        response.sendRedirect("./myPage.do");
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("./accessError.do");
	    }
	}
}
