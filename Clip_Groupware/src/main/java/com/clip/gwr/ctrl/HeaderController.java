//package com.clip.gwr.ctrl;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.clip.gwr.model.service.IFileUploadService;
//import com.clip.gwr.vo.UserinfoVo;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Controller
//@Slf4j
//public class HeaderController {
//	
//	@Autowired
//	private IFileUploadService fileUploadService;
//	
//	@GetMapping(value = "/header.do")
//	@ResponseBody
//	public String header(HttpSession session) {
//		log.info("######오니");
//		UserinfoVo loginVo = (UserinfoVo)session.getAttribute("loginVo");
//		String user_id = loginVo.getUser_id();
//		log.info("######user_id!!: " + user_id); 
//		
//		String fileStorename = fileUploadService.selectPhotoName(user_id);
//		log.info("####beforeSaveFileName : " + fileStorename);
//		return fileStorename;
//	}
//}
