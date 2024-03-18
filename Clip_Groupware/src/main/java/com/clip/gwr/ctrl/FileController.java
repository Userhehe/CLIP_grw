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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.clip.gwr.model.service.IFileService;

@Controller
public class FileController {

	@Autowired
	private IFileService service;
	
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
			service.insertFile(map);
			
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
}
