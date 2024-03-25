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
		log.info("$$$$$$$$$$$$$$$$$$" + ranksList);
		log.info("$$$$$$$$$$$$$$$$$$" + positionsList);
		log.info("$$$$$$$$$$$$$$$$$$" + deptList);
		model.addAttribute("lists", lists);
		return "dailyCheck";
	}

	@GetMapping(value = "/insertDailyCheckIntime.do")
	public void insertDailyCheckIntime(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException  {

	    String apiUrl = "https://api64.ipify.org?format=text";
	    // RestTemplate 객체 생성
	    RestTemplate restTemplate = new RestTemplate();

	    // API 호출 및 응답 받기
	    String clientIp = restTemplate.getForObject(apiUrl, String.class);

	    log.info("#################################clientIp:" + clientIp);

	    // 허용된 IP 주소 목록 설정
	    List<String> allowedIpAddresses = Arrays.asList("59.6.141.59"); // 여기에 허용된 IP 주소 목록을 추가

	    // 클라이언트의 IP 주소가 허용된 목록에 있는지 확인
	    if (!allowedIpAddresses.contains(clientIp)) {
	        response.sendRedirect(clientIp); // 허용되지 않은 IP 주소로 접근한 경우 에러 메시지 반환
	    }

	    UserinfoVo loginVo = (UserinfoVo) session.getAttribute("loginVo");
	    String userId = loginVo != null ? loginVo.getUser_id() : null; // 사용자 ID가 NULL이 아닌지 확인

	    log.info("####################### user_id :" + userId);
	    log.info("################# loginVo :" + loginVo);

	    Map<String, Object> insertMap = new HashMap<>();
	    insertMap.put("user_id", userId); // 맵에 사용자 ID 추가

	    try {
	        int insertRows = service.insertDailyCheckIntime(insertMap);

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
	public String searchDailyCheckList(Model model,
	                                   @RequestParam(defaultValue = "") String startDate,
	                                   @RequestParam(defaultValue = "") String lastDate,
	                                   @RequestParam(defaultValue = "") String userName,
	                                   @RequestParam(defaultValue = "") String positions,
	                                   @RequestParam(defaultValue = "") String ranks,
	                                   @RequestParam(defaultValue = "") String dept) {
		
		Map<String, Object> map = new HashMap<>();
		List<DailyCheckVo> lists = service.selectDailyCheckList(map);
		List<PositionsVo> positionsList = positionsService.positionsAll();
		List<DeptVo> deptList = deptService.deptAll();
		List<RanksVo> ranksList = ranksService.ranksAll();
		model.addAttribute("positionsList", positionsList);
		model.addAttribute("deptList", deptList);
		model.addAttribute("ranksList", ranksList);
		log.info("$$$$$$$$$$$$$$$$$$" + ranksList);
		log.info("$$$$$$$$$$$$$$$$$$" + positionsList);
		log.info("$$$$$$$$$$$$$$$$$$" + deptList);
		model.addAttribute("lists", lists);

	    // 검색 조건을 Map에 담아서 서비스에 전달
	    Map<String, Object> searchMap = new HashMap<>();
	    if (!startDate.isEmpty()) {
	        searchMap.put("first_dailyregdate", startDate);
	    }
	    if (!lastDate.isEmpty()) {
	        searchMap.put("last_dailyregdate", lastDate);
	    }
	    if (!userName.isEmpty()) {
	        searchMap.put("user_name", userName);
	    }
	    if (!positions.isEmpty()) {
	        searchMap.put("positions_name", positions);
	    }
	    if (!ranks.isEmpty()) {
	        searchMap.put("ranks_name", ranks);
	    }
	    if (!dept.isEmpty()) {
	        searchMap.put("dept_name", dept);
	    }

	    // 서비스를 호출하여 검색 결과를 가져옴
	    List<DailyCheckVo> searchResult = service.searchDailyCheckList(searchMap);

	    // 검색 결과를 모델에 추가
	    model.addAttribute("searchResult", searchResult);
	    
	    log.info("#############################  searchMap :"+searchMap);
	    log.info("##########################searchResult :"+searchResult);

	    return "dailyCheckSearchResult"; // 검색 결과를 표시할 JSP 페이지 이름 리턴
	}

	
	

	@GetMapping(value = "/updateDailyCheckOuttime.do")
	public void updateDailyCheckOuttime(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException {
	    String apiUrl2 = "https://api64.ipify.org?format=text";

	    // RestTemplate 객체 생성
	    RestTemplate restTemplate2 = new RestTemplate();

	    // API 호출 및 응답 받기
	    String clientIp = restTemplate2.getForObject(apiUrl2, String.class);

	    log.info("#################################clientIp:" + clientIp);

	    // 허용된 IP 주소 목록 설정
	    List<String> allowedIpAddresses = Arrays.asList("59.6.141.59"); // 여기에 허용된 IP 주소 목록을 추가

	    // 클라이언트의 IP 주소가 허용된 목록에 있는지 확인
	    if (!allowedIpAddresses.contains(clientIp)) {
	    	response.sendRedirect("./accessError.do"); // 허용되지 않은 IP 주소로 접근한 경우 에러 메시지 반환
	    }

	    UserinfoVo loginVo2 = (UserinfoVo) session.getAttribute("loginVo");
	    String userId2 = loginVo2 != null ? loginVo2.getUser_id() : null; // 사용자 ID가 NULL이 아닌지 확인

	    log.info("####################### user_id :" + userId2);
	    log.info("################# loginVo :" + loginVo2);

	    if (userId2 == null) {
	    	response.sendRedirect("./accessError.do");
	    }

	    Map<String, Object> updateMap = new HashMap<>();
	    updateMap.put("user_id", userId2); // 맵에 사용자 ID 추가
	    updateMap.put("current_time", new Date()); // 현재 시간을 맵에 추가

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
	
	@PostMapping(value = "/Clip_Groupware/updateDailyCheckStatus.do") // 수정된 URL
	public String updateDailyCheckStatus(@RequestParam("daily_seq") int dailySeq,
	                                     @RequestParam("re_content") String reasonContent) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("daily_seq", dailySeq);
	    map.put("daily_modify", "Y");
	    map.put("daily_reasonmodify", reasonContent);

	    service.updateDailyCheckStatus(map);

	    return "redirect:/Clip_Groupware/selectDailyCheckList.do"; // 수정된 URL
	}
}














