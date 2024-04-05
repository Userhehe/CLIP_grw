package com.clip.gwr.ctrl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.clip.gwr.model.service.ISignService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.SignsVo;
import com.clip.gwr.vo.UserinfoVo;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SignsController {
	
	@Autowired
	private ISignService service; 
	
	@Autowired 
	private IUserService userService;
	
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
	
//	@PostMapping("/checkPad.do")
//	@ResponseBody
//	public Map<String, Integer> checkPad(@RequestParam String userId) {
//	    Map<String, Integer> response = new HashMap<>();
//	    int count = service.checkPad(userId);
//	    response.put("count", count);
//	    return response;
//	}
	
	/*
	 * 서명 등록 
	 */
	
	@GetMapping(value = "/insertPad.do")
	public String insertPad(HttpSession session) {
	    log.info("****** insertPad.do");
	    UserinfoVo loginUserVo = (UserinfoVo) session.getAttribute("loginVo");
	    if (loginUserVo != null) {
	       
	        String user_id = loginUserVo.getUser_id();
	        String user_name = loginUserVo.getUser_name();
	        
	        log.info("$$$$$$$$$$$$$$$$$user_id : " + user_id);
	        log.info("$$$$$$$$$$$$$$$$$user_name : " + user_name);
	    }
	    return "insertPad";
	}

	@PostMapping(value = "/insertPad.do")
	@ResponseBody
	public void insertPad(@RequestBody String signJson, HttpSession session) {
	    try {
	        log.info("Signature_Upload insertPad");
	        Gson gson = new Gson();
	        Map<String, String> map = gson.fromJson(signJson, Map.class);
	        String signs_name = map.get("signs_name");
	        String signs_image = map.get("data");
	        
	        // 세션에서 사용자 정보 가져오기
	        UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
	        String user_id = loginVo.getUser_id();
	        String user_name = loginVo.getUser_name();

	        // Map에 데이터 설정
	        Map<String, Object> inMap = new HashMap<>();
	        inMap.put("user_id", user_id);
	        inMap.put("user_name", user_name);
	        inMap.put("signs_name", signs_name);
	        inMap.put("signs_image", signs_image);
	        log.info("$$$$$$$$$$$$$$$$$$$$ inMap :" + inMap);

	        // 서비스를 통해 데이터 저장
	        int cnt = service.insertPad(inMap);
	        log.info("Inserted rows: " + cnt);
	    } catch (Exception e) {
	        log.error("Error occurred while inserting sign: " + e.getMessage());
	    }
	}
	
	@GetMapping(value = "/selectPad.do")
	public String selectOneSign(HttpServletRequest request, Model model) {
		log.info("Signature_Upload selectPad.do");
		String signs_seq = (request.getParameter("signs_seq"));
		SignsVo sVo = service.selectPad(signs_seq);
		System.out.println(sVo);
		model.addAttribute("sVo",sVo);
		return "selectPad";
	}


@PostMapping("/deletePad.do")
@ResponseBody
public String delDept(@RequestParam("signs_seq") String signs_seq) {
    try {
        int result = service.delPad(signs_seq);
        if (result > 0) {
            return "success";
        } else {
            return "error";
        }
    } catch (Exception e) {
        log.error("부서 삭제 중 오류 발생: {}", e.getMessage());
        return "error";
    }
      
}

}