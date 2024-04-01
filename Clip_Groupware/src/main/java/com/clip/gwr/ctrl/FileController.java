package com.clip.gwr.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.clip.gwr.model.service.IFileService;
import com.clip.gwr.model.service.IFileUploadService;
import com.clip.gwr.vo.FileVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileController {

	@Autowired
	private IFileService fileService;
	
	@Autowired
	private IFileUploadService fileUploadService;
	
	@PostMapping(value = "/upload.do")
	public String upload(HttpServletRequest request, Model model, List<MultipartFile> file) throws IOException {
		System.out.println("FileUploadController upload 파일업로드 저장 처리:"+file.size());
		for(MultipartFile f: file) {
			String originFileName = f.getOriginalFilename();
			String saveFileName = UUID.randomUUID().toString()+originFileName.substring(originFileName.lastIndexOf("."));
			long fileSize = f.getSize();
			byte[] blobFile = f.getBytes();
			System.out.println("%%%%파일명:"+originFileName);
			System.out.println("%%%%저장파일명:"+saveFileName);
			System.out.println("%%%%파일크기:"+fileSize);
			System.out.println("%%%%파일:"+blobFile);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("file_oringinname",originFileName);
			map.put("file_storename",saveFileName);
			map.put("file_size",fileSize);
			map.put("file_ff", blobFile);
			fileService.insertFile(map);
			
			InputStream inputStream = null;
			OutputStream outputStream =null;
			
			String path="";
			
			try {
				//1)파일을 읽는다
				inputStream = f.getInputStream();
				//2)저장 위치를 만든다
				path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage"); //상대경로
				System.out.println(request.getSession().getServletContext().getRealPath("storage")); //절대경로
				System.out.println("****실제 저장될 업로드 테스트 경로: "+path);
				//3)저장할 파일이 없다면 만들어줌
				File storage = new File(path);
				if(!storage.exists()) {
					storage.mkdirs();
				}
				//4)저장할 파일 공간이 없다면 만들어주고 있다면 오버라이드함
				File newFile = new File(path+"/"+saveFileName);
				if(!newFile.exists()) {
					newFile.createNewFile();
				}
				//5)파일을 쓸 위치를 지정해줌
				outputStream = new FileOutputStream(newFile);
				//6)대상 파일을 읽어서 파일을 해당 outputStream에 써줌(읽고 쓰기의 반복)
				int read =0;
				byte[] b = new byte[(int)f.getSize()];
				while((read=inputStream.read(b))!=-1) {
					outputStream.write(b,0,read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "file";
	}
	
	@PostMapping(value = "/photoUpload.do")
	public void photoUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session
									, @RequestParam("uploadImage") MultipartFile file) {
		log.info("####file : " + file);
		
//		Map<String, Object> map = new HashMap<String, Object>();
		UserinfoVo loginVo = (UserinfoVo)session.getAttribute("loginVo");
		log.info("####loginVo : " + loginVo);
		String user_id = loginVo.getUser_id();
		log.info("####user_id :: " + user_id);
//		map.put("user_id", user_id);
//		List<FileVo> fileList = fileUploadService.selectPhotoinfo(user_id); // 사진파일 조회
//		log.info("####fileList : " + fileList);
		
		if (!file.isEmpty()) {
            try {
            	log.info("####됨");
                // 파일을 업로드할 경로
                String uploadDirectory = "C:\\Users\\dongi\\git\\CLIP_grw\\Clip_Groupware\\src\\main\\webapp\\images\\userprofile\\";
//            	String uploadDirectory = "..\\..\\..\\..\\..\\webapp\\images\\userprofile\\";
                // 업로드된 파일을 서버에 저장
                file.transferTo(new File(uploadDirectory + file.getOriginalFilename()));
                // 업로드가 성공했을 때 실행할 코드 작성
                log.info("----업로드 성공");
                // 예를 들어 데이터베이스에 파일 경로를 저장할 수 있음
                response.sendRedirect("./myPage.do");
            } catch (IOException e) {
            	log.info("####안됨");
                // 업로드 실패 시 실행할 코드 작성
            	log.info("----업로드 실패");
                e.printStackTrace();
            }
        } else {
            // 업로드된 파일이 없을 경우 실행할 코드 작성
        	try {
				response.sendRedirect("./accessError.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
		
//		int insertPhotoinfo = fileUploadService.insertPhotoinfo(map); // 사진파일 등록 1
//		int insertFileFeature = fileUploadService.insertFileFeature(map); // 사진파일 등록 2
//		int updateUserinfoPhoto = fileUploadService.updateUserinfoPhoto(map); // 사진파일 등록 3
//		Map<String, String> response = new HashMap<>();
//		response.put("fileList", fileList);
//		return response;
//		try {
//			response.sendRedirect("./myPage.do");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
