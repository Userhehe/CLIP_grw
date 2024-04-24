package com.clip.gwr.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clip.gwr.model.service.IAnnualService;
import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.AnnualUseVo;
import com.clip.gwr.vo.AnnualVo;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AnnualController {

	@Autowired
	private IAnnualService service;

	@Autowired
	private IDeptService deptService;

	@Autowired
	private IPositionsService positService;

	@Autowired
	private IRanksService ranksService;

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/annAll.do")
	public String listAnnual(Model model) {
		log.info("AnnualController listAnnual 전체 조회");

		List<AnnualVo> anlist = service.annAll();
		model.addAttribute("anlist", anlist);
		log.info("anlist :" + anlist);
		return "annual";
	}

	@GetMapping(value = "/detailAnn.do")
	public String detailAnnual(HttpServletRequest request, Model model) {
		log.info("AnnualController detailAnnual 상세 조회");

		String user_id = request.getParameter("user_id");
		log.info("####user_id : " + user_id);
		AnnualVo anDetail = service.detailAnn(user_id);
		List<AnnualVo> anDetailList = new ArrayList<>();
		anDetailList.add(anDetail);

		model.addAttribute("anDetailList", anDetailList);
		log.info("####anDetailList : " + anDetailList);

		return "detailAnn";
	}
	
	@GetMapping(value = "/myAnn.do")
	public String myAnn(HttpServletRequest request, Model model, HttpSession session) {
	    log.info("AnnualController myAnn 나의 연차조회");

	    // 세션에서 사용자 아이디 가져오기
	    UserinfoVo loginUserVo = (UserinfoVo) session.getAttribute("loginVo");
	    String user_id = loginUserVo.getUser_id();

	    log.info("####user_id : " + user_id);

	    // DAO를 통해 연차 정보 조회
	    AnnualVo myDetail = service.myAnn(user_id);
	    log.info("####myDetail : " + myDetail);
	    List<AnnualVo> myDetailList = new ArrayList<>();
	    myDetailList.add(myDetail);

	    model.addAttribute("myDetailList", myDetailList);
	    log.info("####myDetailList : " + myDetailList);

	    return "myAnn";
	}



	@GetMapping(value = "/updateAnn.do")
	public String updateAnn(HttpServletRequest request, Model model) {
		String user_id = request.getParameter("user_id");
		List<UserinfoVo> userInfoList = (List<UserinfoVo>) userService.selectUserinfoDetail(user_id);
		if (userInfoList.isEmpty()) {
			return "error_page";
		}
		UserinfoVo userInfo = userInfoList.get(0);

		model.addAttribute("user_id", user_id);
		model.addAttribute("user_name", userInfo.getUser_name());
		model.addAttribute("dept_name", userInfo.getDept_name());
		model.addAttribute("positions_name", userInfo.getPositions_name());
		model.addAttribute("ranks_name", userInfo.getRanks_name());

		return "updateAnn";
	}

	@PostMapping(value = "/updateAnn.do")
	public String updateAnnData(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String ann_day = request.getParameter("ann_day");

		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("ann_day", ann_day);

		service.updateAnn(map);

		return "redirect:/detailAnn.do?user_id=" + user_id;
	}
	
	
	@GetMapping(value = "/searchAnnual.do")
	public String searchUserList(HttpServletRequest request, Model model) {
		log.info("AnnualController searchAnnual 검색");

	    String user_name = request.getParameter("user_name");
	    String ranks_name = request.getParameter("ranks_name");
	    String dept_name = request.getParameter("dept_name");
	    String positions_name = request.getParameter("positions_name");

	    // 검색 조건을 담을 Map 생성
	    Map<String, Object> searchMap = new HashMap<>();
	    searchMap.put("user_name", user_name);
	    searchMap.put("ranks_name", ranks_name);
	    searchMap.put("dept_name", dept_name);
	    searchMap.put("positions_name", positions_name);

	    // 서비스 계층에서 검색 결과 받아오기
	    List<AnnualVo> searchResult = service.searchAnnual(searchMap);

	    // 검색 결과를 모델에 담아서 화면으로 전달
	    model.addAttribute("searchResult", searchResult);

	    return "annual"; // 검색 결과를 보여줄 뷰의 이름
	}
	
	@Scheduled(cron = "0 0/1 0 1 * *", zone = "Asia/Seoul") // 매월 1일 0시에 실행되도록 스케줄링합니다
	public void insertAnnualUp() {       // 연차를 추가하는 메서드입니다
	    List<AnnualVo> userList = service.annAll(); // 모든 사용자의 연차 정보를 가져옵니다
	    
	    for (AnnualVo user : userList) { // 각 사용자에 대해 반복합니다
	        service.insertAnnualUp(user.getUser_id()); // 해당 사용자의 연차를 추가합니다
	    }
	}
	@Scheduled(cron = "0 0/1 0 1 1 *", zone = "Asia/Seoul") // 매년 1월 1일 0시에 실행되도록 스케줄링합니다
	public void resetAnnual() { // 연차와 연차 사용 내역을 초기화하는 메서드입니다
	    Map<String, Object> map = new HashMap<>(); // 빈 맵을 생성합니다
	    service.resetAnn(map); // 연차를 초기화합니다
	    service.resetAnnualUse(map); // 연차 사용 내역을 초기화합니다
	}
	
	
	
}