package com.clip.gwr.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IProjectBoardService;
import com.clip.gwr.model.service.IProjectsService;
import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.GianVo;
import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.ProjectBoardVo;
import com.clip.gwr.vo.ProjectMemVo;
import com.clip.gwr.vo.ProjectsVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectsController {

	@Autowired
	private IProjectsService projectsService;
	
	@Autowired
	private IProjectBoardService projectBoardService;

//------------진행도별 프로젝트 조회 : 메인 화면 -----------------------//	
	
	@GetMapping(value = "/projectsProgress.do")
	public String projectsProgress(Model model) {
		log.info("PayController 최초 로딩된 프로젝트 페이지");
		
		int radioChk = 0;
		model.addAttribute("radioChk", radioChk);
		//발주처 select box 데이터 조회
		List<ProjectsVo> clientList = projectsService.selectClientList();
		model.addAttribute("clientList", clientList);
		return "projectsProgress";
	}

//------------진행도별 프로젝트 조회 : 조건 검색-----------------------//	

	@GetMapping(value="/getProgressList.do")
	@ResponseBody
	public JSONArray getProgressList(String prjStatus, String clientNm, String startDate, String endDate, HttpSession session) {
		log.info("PayController 프로젝트 페이지");

		Map<String, Object> map = new HashMap<String, Object>();
		
	    // prjStatus 값이 있을 때만 map에 담아줍니다.
	    if (prjStatus != null && !prjStatus.isEmpty()) {
	    	map.put("PRJ_STATUS",prjStatus);
	    }
	    if(clientNm != null && !clientNm.isEmpty()) {
	    	map.put("CLI_NAME",clientNm);
	    }
	    
	    if(startDate != null && !startDate.isEmpty()) {
	    	map.put("PRJ_SDATE",startDate);
	    	map.put("PRJ_EDATE",endDate);
	    }
	    
		UserinfoVo loginVo = (UserinfoVo)session.getAttribute("loginVo");
		map.put("USER_ID",loginVo.getUser_id());
				
		List<ProjectsVo> lists = projectsService.getProgressProjects(map);
		log.info("완료된프로젝트리스트:{}",lists);
		JSONArray prjList = new JSONArray();
	    for(ProjectsVo vo : lists) {
	        JSONObject obj = new JSONObject();
	        obj.put("PRJ_NAME", vo.getPrj_name());
	        obj.put("CLI_NAME", vo.getCli_name());
	        obj.put("USER_NAME", vo.getUser_name());
	        obj.put("PRJ_ID", vo.getPrj_id());
	        prjList.add(obj);
	    }
	    System.out.println("넘겨줄 데이터"+prjList);

	    return prjList;
	}

//------------기간별 프로젝트 조회-----------------------//	
	
	@GetMapping(value = "/projectsPeriod.do")
	public String projectsPeriod(Model model) {
		
		//발주처 select box 데이터 조회
		List<ProjectsVo> clientList = projectsService.selectClientList();
		model.addAttribute("clientList", clientList);

		return "projectsPeriod";
	}

//------------발주처별 프로젝트 조회-----------------------//	
	
	@GetMapping(value = "/projectClient.do")
	public String projectClient(Model model) {
		
		//발주처 select box 데이터 조회
		List<ProjectsVo> clientList = projectsService.selectClientList();
		model.addAttribute("clientList", clientList);
		
		return "projectClient";
	}

//------------프로젝트 상세조회-----------------------//	
	
	@GetMapping(value = "/projectDetail.do")
	public String projectDetail(HttpServletRequest request, Model model) {
		
		String prjId = request.getParameter("project_id");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		 List<ProjectsVo> prjectDetail = projectsService.selectDetailList(prjId);
		 model.addAttribute("result", prjectDetail);


		return "projectDetail";
	}
	
	//-----------프로젝트 디테일 하단 목록 조회-----------------------//	
	@GetMapping(value="/getDetailBottomList.do")
	@ResponseBody
	public JSONArray getDetailBottomList(String prjId, String pboProgress, HttpSession session) {
		log.info("PayController 프로젝트 페이지"); 
		// 필요한 인자값 :  prj_id pbo_progress  
		Map<String, Object> map = new HashMap<String, Object>();
		
    	map.put("prj_id",prjId);
    	map.put("pbo_progress",pboProgress);
    	log.info("맵에 뭐이써:{}",map);

    	//여기에 데이터가 조회되지 않음
    	List<ProjectBoardVo> prjectDetail = projectBoardService.getDetailBottomList(map);

		log.info("선택된 탭의 리스트 보드 값:{}",prjectDetail);
		JSONArray boardList = new JSONArray();
	    for(ProjectBoardVo vo : prjectDetail) {
	        JSONObject obj = new JSONObject();
	        obj.put("PBO_SEQ", vo.getPbo_seq());
	        obj.put("USER_ID", vo.getUser_id());
	        obj.put("PBO_TITLE", vo.getPbo_title());
	        obj.put("PBO_CONTENT", vo.getPbo_content());
	        obj.put("PBO_PROGRESS", vo.getPbo_progress());
	        obj.put("PBO_DELFLAG", vo.getPbo_delflag());
	        obj.put("PBO_REGDATE", vo.getPbo_regdate());
	        obj.put("PRJ_ID", vo.getPrj_id());
	        
	        boardList.add(obj);

	    }
	    System.out.println("넘겨줄 데이터"+boardList);

	    return boardList;
	}
	
//-----------프로젝트 추가-----------------------//	
	
	@PostMapping(value = "/insertProject.do") 
	@ResponseBody
	public int insertProject(@RequestParam Map<String, Object> map, HttpSession session) {
		UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
		map.put("user_id", id.getUser_id());

		log.info("담긴 map 내용 {} : " , map);
		int isc = projectsService.insertProject(map);
		return isc;
	}
	
	// ------------클라이언트 추가 : 메인 화면 -----------------------//

	@GetMapping(value = "/addClient.do")
	public String addClient() {
		log.info("PayController 최초 로딩된 프로젝트 페이지");

		return "addClient";
	}

	@PostMapping(value = "/addClient.do")
	@ResponseBody
	public int insertClient(@RequestParam Map<String, Object> map) {

		log.info("담긴 map 내용 {} : ", map);
		int isc = projectsService.insertClient(map);
		return isc;
	}
	
	// ------------프로젝트 보드 추가 : 디테일 화면 -----------------------//

	@PostMapping(value = "/insertProjectBoard.do")
	@ResponseBody
	public int insertProjectBoard(@RequestParam Map<String, Object> map, HttpSession session) {

		UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
		map.put("user_id", id.getUser_id());
		log.info("담긴 map 내용 {} : ", map);
		int isc = projectBoardService.insertProjectBoard(map);
		return isc;
	}

	// ------------프로젝트 디테일 상단 삭제버튼 -----------------------//

	
	@GetMapping(value="/deletePrjDetailTop.do")
	@ResponseBody
	public int deletePrjDetailTop(String prjId, String prjManager, HttpSession session) {
		log.info("deletePrjDetailTop 상단 삭제버튼");
		
		int cnt=0;
		
		// 삭제권한체크
		UserinfoVo loginVo = (UserinfoVo)session.getAttribute("loginVo");
		String loginId = loginVo.getUser_id();

		if (!loginId.equals(prjManager)) {
			cnt = -1;
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("PRJ_ID",prjId);
			map.put("PRJ_MANAGER",prjManager);
			
			cnt = projectBoardService.deletePrjDetailTop(map);
		}	
		return cnt;

	}


}
