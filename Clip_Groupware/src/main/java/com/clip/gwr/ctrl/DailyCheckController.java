package com.clip.gwr.ctrl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	 public DailyCheckController(IDailyCheckService service) {
	        this.service = service;
	    }

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
		List<PositionsVo> positionsList = positionsService.positionsAll();
		List<DeptVo> deptList = deptService.deptAll();
		List<RanksVo> ranksList = ranksService.ranksAll();
		
		model.addAttribute("positionsList", positionsList);
		model.addAttribute("deptList", deptList);
		model.addAttribute("ranksList", ranksList);
		model.addAttribute("lists", lists);
		return "dailyCheck";
	}

	@GetMapping(value = "/insertDailyCheckIntime.do")
	public void insertDailyCheckIntime(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException  {

	    String apiUrl = "https://api64.ipify.org?format=text";
	    RestTemplate restTemplate = new RestTemplate();

	    String clientIp = restTemplate.getForObject(apiUrl, String.class);

	    log.info("#################################clientIp:" + clientIp);

	    List<String> allowedIpAddresses = Arrays.asList("14.36.141.71");  /*"14.36.141.71"*/

	    if (!allowedIpAddresses.contains(clientIp)) {
	        response.sendRedirect(clientIp); 
	    }

	    UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
	    String userId = loginVo != null ? loginVo.getUser_id() : null; 

	    log.info("####################### user_id :" + userId);
	    log.info("################# loginVo :" + loginVo);

	    
	    Map<String, Object> insertMap = new HashMap<>();
	    insertMap.put("user_id", userId); 
	    log.info("%%%%%%%%%%%********************** insertMap"+insertMap);
	    

	    try {
	        int insertRows = service.insertDailyCheckIntime(insertMap);
             log.info("%%%%%%%%%%%%$$$$$$$$$$$$$$$$$$$$$ insertRows"+insertRows);
	        if (insertRows > 0) {
	            response.sendRedirect("./main.do");
	        } else {
	        	response.sendRedirect("./accessError.do");
	        }
	    } catch (DataIntegrityViolationException e) {
	        e.printStackTrace();
	        response.sendRedirect("./accessError.do");
	    }
	}
    
	@GetMapping(value = "/searchDailyCheckList.do")
	public String searchDailyCheckList(Model model, HttpServletRequest request) {
	    Map<String, Object> map = new HashMap<>();
	    String startDate = request.getParameter("startDate");
	    String lastDate = request.getParameter("lastDate");
	    String userName = request.getParameter("userName");
	    String positions = request.getParameter("positions");
	    String ranks = request.getParameter("ranks");
	    String dept = request.getParameter("dept");
	    
	    map.put("first_dailyregdate", startDate);
	    map.put("last_dailyregdate", lastDate);
	    map.put("user_name", userName);
	    map.put("positions_name", positions);
	    map.put("ranks_name", ranks);
	    map.put("dept_name", dept);
	    
        try {  
	    	
	        List<DailyCheckVo> lists = service.searchDailyCheckList(map);
	        List<DeptVo> deptLists = deptService.deptAll();
	        List<PositionsVo> positionsLists = positionsService.positionsAll();
	        List<RanksVo> ranksLists = ranksService.ranksAll();
	        
	        model.addAttribute("deptLists", deptLists);
	        model.addAttribute("positionsLists", positionsLists);
	        model.addAttribute("ranksLists", ranksLists);
	        model.addAttribute("lists", lists);
	        
	        log.info("#############  deptLists"+ deptLists);
		    log.info("############# positionsLists"+ positionsLists);
		    log.info("############# ranksLists"+ ranksLists);
		    log.info("############# lists"+ lists);
		    
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "dailyCheck";
	    }
	    
	    return "dailyCheck";
	}

	
	@GetMapping(value = "/updateDailyCheckOuttime.do")
	public void updateDailyCheckOuttime(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
	    // 클라이언트 IP 확인
	    String apiUrl = "https://api64.ipify.org?format=text";
	    RestTemplate restTemplate = new RestTemplate();
	    String clientIp = restTemplate.getForObject(apiUrl, String.class);
	    log.info("Client IP: " + clientIp);

	    // 허용된 IP 목록
	    List<String> allowedIpAddresses = Arrays.asList("14.36.141.71"); /*14.36.141.71*/

	    // IP 접근 제어
	    if (!allowedIpAddresses.contains(clientIp)) {
	        response.sendRedirect("./accessError.do");
	        return; // IP가 허용되지 않았으므로 함수 종료
	    }

	    // 세션에서 사용자 정보 가져오기
	    UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
	    String userId = loginVo != null ? loginVo.getUser_id() : null;
	    log.info("User ID: " + userId);

	    // 로그인 여부 확인
	    if (userId == null) {
	        response.sendRedirect("./accessError.do");
	        return; // 로그인되지 않았으므로 함수 종료
	    }

	    // dailyStatus 계산
	    // 요청 파라미터에서 dailyStatus 가져오기
	    String dailyStatus = request.getParameter("daily_status");
	    // dailyStatus 계산하는 부분은 생략하고, 요청 파라미터에서 가져오도록 유지합니다.

	    // 현재 시간 가져오기
	    Date currentTime = new Date();

	    // 출퇴근 정보를 Map에 담기
	    Map<String, Object> updateMap = new HashMap<>();
	    updateMap.put("user_id", userId);
	    updateMap.put("current_time", currentTime);
	    updateMap.put("daily_status", dailyStatus);

	    try {
	        // 서비스를 호출하여 출퇴근 정보 업데이트
	        int updateRows = service.updateDailyCheckOuttime(updateMap);
	        log.info("Rows Updated: " + updateRows);
	        if (updateRows > 0) {
	            response.sendRedirect("./main.do");
	        } else {
	            response.sendRedirect("./accessError.do");
	        }
	    } catch (DataIntegrityViolationException e) {
	        e.printStackTrace();
	        response.sendRedirect("./accessError.do");
	    }
	}



	
	@PostMapping("/updateDailyCheckStatus.do")
	@ResponseBody
	public String updateDailyCheckStatus(//@RequestParam("daily_seq") String daily_seq,@RequestParam("daily_reasonmodify") 
	                                     String daily_reasonmodify,
	                                     String daily_seq,
	                                     String daily_status) {
		log.info("daily_reasonmodify  :" + daily_reasonmodify);
		log.info("daily_seq  :" + daily_seq);
		log.info("daily_status :" + daily_status);
	    Map<String, Object> map = new HashMap<>();
	    map.put("daily_seq", daily_seq);
	    map.put("daily_modify", "Y");
	    map.put("daily_reasonmodify", daily_reasonmodify);
	    map.put("daily_status", daily_status);
        
	    log.info("map 확인:{}",map);
	    service.updateDailyCheckStatus(map);

	    
	    return "dailyCheck"; 
	}
	
	@GetMapping(value = "/selectDailyStatus.do")
	@ResponseBody
	public String selectDailyStatus(HttpServletRequest request) {
	    log.info("##### 출퇴근여부 가져오기 #####");
	    
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("user_id");

	    String dailyStatus = service.selectDailyStatus(userId);

	    return dailyStatus;
	}

	
	@GetMapping(value = "/myDailychk.do")
	public String myDailychk(Model model, HttpSession session) {
	    UserinfoVo loginUserVo = (UserinfoVo) session.getAttribute("loginVo");
	    String user_id = loginUserVo.getUser_id();

	    List<DailyCheckVo> lists = service.myDailychk(user_id);

	    model.addAttribute("lists", lists);

	    return "myDailychk";
	}
	   
	@GetMapping(value = "/chktime.do")
	@ResponseBody
	public String chktime(HttpSession session) {
		 UserinfoVo loginUserVo = (UserinfoVo) session.getAttribute("loginVo");
		 String user_id = loginUserVo.getUser_id();
		 int chktime = service.chktime(user_id);
		 log.info("$$$$$$$$$$$$$$$$$$$$$$$chktime:{}"+chktime)  ;
		 return String.valueOf(chktime);
	}
	
     
	
}














