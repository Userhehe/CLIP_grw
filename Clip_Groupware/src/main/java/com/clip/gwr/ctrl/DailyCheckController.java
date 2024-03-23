package com.clip.gwr.ctrl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.clip.gwr.model.service.IDailyCheckService;
import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.vo.DailyCheckVo;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DailyCheckController {

	@Autowired
	IDailyCheckService service;

	@Autowired
	IPositionsService positionsService;

	@Autowired
	IDeptService deptService;

	@Autowired
	IRanksService ranksService;

	@GetMapping(value = "/selectDailyCheckList.do")
	public String selectDailyCheckList(Model model) {
		Map<String, Object> map = new HashMap<>();
		List<DailyCheckVo> lists = service.selectDailyCheckList(map);
		model.addAttribute("lists", lists);
		return "dailyCheck";
	}

//	@GetMapping(value = "/insertDailyCheckIntime.do")
//	@ResponseBody
//	public String insertDailyCheckIntime(HttpServletRequest request, HttpSession session) {
//
//	    String apiUrl = "https://api64.ipify.org?format=text";
//
//	    // RestTemplate 객체 생성
//	    RestTemplate restTemplate = new RestTemplate();
//
//	    // API 호출 및 응답 받기
//	    String clientIp = restTemplate.getForObject(apiUrl, String.class);
//
//	    log.info("#################################clientIp:" + clientIp);
//
//	    // 허용된 IP 주소 목록 설정
//	    List<String> allowedIpAddresses = Arrays.asList("106.240.92.179"); // 여기에 허용된 IP 주소 목록을 추가
//
//	    // 클라이언트의 IP 주소가 허용된 목록에 있는지 확인
//	    if (!allowedIpAddresses.contains(clientIp)) {
//	        return "accessError"; // 허용되지 않은 IP 주소로 접근한 경우 에러 메시지 반환
//	    }
//
//	    UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
//	    String userId = loginVo != null ? loginVo.getUser_id() : null; // 사용자 ID가 NULL이 아닌지 확인
//
//	    log.info("####################### user_id :" + userId);
//	    log.info("################# loginVo :" + loginVo);
//
//	    if (userId == null) {
//	        return "사용자 ID를 가져올 수 없습니다. 로그인이 필요합니다.";
//	    }
//
//	    Map<String, Object> insertMap = new HashMap<>();
//	    insertMap.put("user_id", userId); // 맵에 사용자 ID 추가
//
//	    try {
//	        int insertRows = service.insertDailyCheckIntime(insertMap);
//
//	        if (insertRows > 0) {
//	            return "출근 시간이 등록되었습니다.";
//	        } else {
//	            return "출근 시간 등록에 실패했습니다.";
//	        }
//	    } catch (DataIntegrityViolationException e) {
//	        e.printStackTrace();
//	        return "accessError";
//	    }
//	}
    

	@GetMapping(value = "/searchDailyCheckList.do")
	public String searchDailyCheckList(Model model) {
		List<PositionsVo> positionsList = positionsService.positionsAll();
		List<DeptVo> deptList = deptService.deptAll();
		List<RanksVo> ranksList = ranksService.ranksAll();
		model.addAttribute("positionsList", positionsList);
		model.addAttribute("deptList", deptList);
		model.addAttribute("ranksList", ranksList);
		log.info("$$$$$$$$$$$$$$$$$$" + ranksList);
		log.info("$$$$$$$$$$$$$$$$$$" + positionsList);
		log.info("$$$$$$$$$$$$$$$$$$" + deptList);
		return "dailyCheck";
	}
	
	
	
	
	
	
//	@GetMapping(value = "/updateDailyCheckOuttime.do")
//	@ResponseBody
//	public String updateDailyCheckOuttime(HttpServletRequest request, HttpSession session) {
//
//	    String apiUrl2 = "https://api64.ipify.org?format=text";
//
//	    // RestTemplate 객체 생성
//	    RestTemplate restTemplate2 = new RestTemplate();
//
//	    // API 호출 및 응답 받기
//	    String clientIp = restTemplate2.getForObject(apiUrl2, String.class);
//
//	    log.info("#################################clientIp:" + clientIp);
//
//	    // 허용된 IP 주소 목록 설정
//	    List<String> allowedIpAddresses = Arrays.asList("106.240.92.179"); // 여기에 허용된 IP 주소 목록을 추가
//
//	    // 클라이언트의 IP 주소가 허용된 목록에 있는지 확인
//	    if (!allowedIpAddresses.contains(clientIp)) {
//	        return "accessError"; // 허용되지 않은 IP 주소로 접근한 경우 에러 메시지 반환
//	    }
//
//	    UserinfoVo loginVo2 = (UserinfoVo) session.getAttribute("loginVo");
//	    String userId2 = loginVo2 != null ? loginVo2.getUser_id() : null; // 사용자 ID가 NULL이 아닌지 확인
//
//	    log.info("####################### user_id :" + userId2);
//	    log.info("################# loginVo :" + loginVo2);
//
//	    if (userId2 == null) {
//	        return "사용자 ID를 가져올 수 없습니다. 로그인이 필요합니다.";
//	    }
//
//	    Map<String, Object> updateMap = new HashMap<>();
//	    updateMap.put("userId2", userId2); // 맵에 사용자 ID 추가
//
//	    try {
//	        int updateRows = service.updateDailyCheckOuttime(updateMap);
//            log.info("#############insertRows : "+updateRows);
//	        if (updateRows > 0) {
//	            return "퇴근 시간이 등록되었습니다.";
//	        } else {
//	            return "퇴근 시간 등록에 실패했습니다.";
//	        }
//	    } catch (DataIntegrityViolationException e) {
//	        e.printStackTrace();
//	        return "accessError";
//	        
//	    }
//	}
    
}














