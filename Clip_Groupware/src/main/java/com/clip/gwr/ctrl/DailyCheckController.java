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

	    List<String> allowedIpAddresses = Arrays.asList("14.36.141.71");

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
	public void updateDailyCheckOuttime(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException {
	    String apiUrl2 = "https://api64.ipify.org?format=text";

	    
	    RestTemplate restTemplate2 = new RestTemplate();

	    
	    String clientIp = restTemplate2.getForObject(apiUrl2, String.class);

	    log.info("#################################clientIp:" + clientIp);

	  
	    List<String> allowedIpAddresses = Arrays.asList("14.36.141.71"); 

	   
	    if (!allowedIpAddresses.contains(clientIp)) {
	    	response.sendRedirect("./accessError.do");
	    }

	    UserinfoVo loginVo2 = (UserinfoVo) session.getAttribute("loginVo");
	    String userId2 = loginVo2 != null ? loginVo2.getUser_id() : null; 

	    log.info("####################### user_id :" + userId2);
	    log.info("################# loginVo :" + loginVo2);

	    if (userId2 == null) {
	    	response.sendRedirect("./accessError.do");
	    }

	    Map<String, Object> updateMap = new HashMap<>();
	    updateMap.put("user_id", userId2); 
	    updateMap.put("current_time", new Date()); 

	    try {
	        int updateRows = service.updateDailyCheckOuttime(updateMap);
	        log.info("#############insertRows : " + updateRows);
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

	
}














