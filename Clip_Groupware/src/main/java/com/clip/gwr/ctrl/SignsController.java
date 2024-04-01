package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.ISignService;
import com.clip.gwr.model.service.SignsServiceImpl;
import com.clip.gwr.vo.SignsVo;
import com.google.common.util.concurrent.Service;
import com.google.gson.Gson;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignsController {
	
	@Autowired
	private ISignService service; 
	
	/**
	 * 서명 조회
	 */
	@GetMapping(value = "/AllselectPad.do")
	public String AllselectPad(Model model) {
		log.info("****** SignsController 사인조회");
		List<SignsVo> lists = service.AllselectPad();
		model.addAttribute("lists",lists);
		return "signList" ;
	}
	/*
	 * 서명 등록 
	 */
	@GetMapping(value = "/insertPad.do")
	public String insertSign() {
		log.info("insertPad.do");
		return "insertPad";
	}
	
	@PostMapping(value = "/insertPad.do")
	@ResponseBody
	public void insertSign(@RequestBody String signJson) {
		log.info("Signature_Upload insertPad");
		Gson signGson = new Gson();
		Map<String, String> map = signGson.fromJson(signJson, Map.class);
		String user_id = map.get("user_id");
	    String user_name = map.get("user_name");
		String signs_name = map.get("title");
		String signs_image = map.get("data");
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("user_id", user_id);
		inMap.put("signs_image", signs_image);
		inMap.put("signs_name", signs_name);
		inMap.put("user_name", user_name);
		int cnt = service.insertPad(inMap);
		System.out.println(cnt);
	}
	
	@GetMapping(value = "/selectPad.do")
	public String selectPad(HttpServletRequest request, Model model) {
	    log.info("Signature_Upload selectPad.do");
	    String user_id = request.getParameter("user_id");
	    String signs_seq = request.getParameter("signs_seq");
	    
	    log.info("###### signs_seq : " + signs_seq);
	    
//	    List<SignsVo> sVoList = service.selectPad(user_id);
//	    System.out.println(sVoList);
//	    model.addAttribute("sVoList", sVoList);
//	    return "selectPad";
	    SignsVo sVoList = service.selectPad(signs_seq);
	    System.out.println(sVoList);
	    model.addAttribute("sVoList", sVoList);
	    return "selectPad";
	}
	
	 @GetMapping(value = "/deletePad.do")
	    public String deletePad(@RequestParam("signs_seq") String signs_seq) {
	        // 서명 삭제를 위한 맵 생성
	        Map<String, Object> map = new HashMap<>();
	        map.put("signs_seq", signs_seq); // 서명 일련번호 추가

	        // 서명 삭제 메서드 호출
	        int dels = service.delPad(map);

	        // 삭제가 성공했으면
	        if (dels > 0) {
	            // 삭제 성공 메시지를 모델에 추가하고 삭제 성공 페이지로 이동
	            return "signList";
	        } else {
	            // 삭제 실패 메시지를 모델에 추가하고 삭제 실패 페이지로 이동	
	            return "main";
	        }
	    }
	
	}


