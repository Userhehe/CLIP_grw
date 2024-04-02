package com.clip.gwr.ctrl;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;
import com.clip.gwr.vo.UserinfoVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DeptController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private IRanksService ranksService;
	
	
	
	
	@GetMapping(value = "/deptAll.do")
    public String deptAll(Model model) {
        log.info("DeptController 부서리스트 조회");
        List<DeptVo> lists = deptService.deptAll();
        model.addAttribute("lists", lists);
        return "departmentList"; 
    }

	@GetMapping(value = "/insertDept.do")
	public String insertDept(Model model) {
	    log.info("부서 등록 페이지 이동");
	    try {
	        List<DeptVo> deptLists = deptService.deptAll();
	        List<RanksVo> ranksLists = ranksService.ranksAll();
	        List<UserinfoVo> userLists = userService.selectUserinfoList();
	        
	        model.addAttribute("deptLists", deptLists);
	        model.addAttribute("positionsLists", userLists);
	        model.addAttribute("ranksLists", ranksLists);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "error";
	    }
	    return "insertDept"; // 부서 등록 페이지로 이동
	}

	@PostMapping("/insertDept.do")
	public String registerDept(@RequestParam("dept_name") String dept_name, RedirectAttributes redirectAttrs) {
	    int count = deptService.duplicateCheckDept(dept_name);
	    
	    if (count > 0) {
	        log.error("부서 중복 검사 실패: {}", dept_name);
	        redirectAttrs.addFlashAttribute("errorMessage", "부서명이 이미 존재합니다.");
	        return "redirect:/insertDept.do"; 
	    }
	    
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("dept_name", dept_name);
	    
	    int result = deptService.insertDept(paramMap);
	    if (result == 1) {
	        log.info("부서 등록 성공: {}", dept_name);
	        return "redirect:/deptAll.do"; 
	    } else {
	        log.error("부서 등록 실패: {}", dept_name);
	        return "error"; 
	    }
	}
	@PostMapping("/checkDuplicateDept.do")
	@ResponseBody
	public int checkDuplicateDept(@RequestParam("dept_name") String dept_name) {
	    return deptService.duplicateCheckDept(dept_name);
	}
		
	
//	@GetMapping(value = "/updateDept.do")
//    public String userInfoUpdate(HttpServletRequest request, Model model) {
//        // 부서 목록 등을 가져오는 작업 수행
//        List<DeptVo> deptLists = deptService.deptAll();
//        model.addAttribute("lists", deptLists);
//        return "deptUpdate";
//    }

	@PostMapping("/updateDept.do")
	@ResponseBody
	public String updateDailyCheckStatus(@RequestParam("dept_name") String deptName, @RequestParam("dept_seq") String deptSeq) {
	    log.info("dept_name: {}", deptName);
	    log.info("dept_seq: {}", deptSeq);

	    Map<String, Object> map = new HashMap<>();
	    map.put("dept_name", deptName);
	    map.put("dept_seq", deptSeq);

	    try {
	        deptService.updateDept(map);
	        return "success";
	    } catch (Exception e) {
	        log.error("부서 수정 중 오류 발생: {}", e.getMessage());
	        return "error";
	    }
	}


	@PostMapping("/delDept.do")
	@ResponseBody
	public String delDept(@RequestParam("dept_seq") String deptSeq) {
	    try {
	        int result = deptService.delDept(deptSeq);
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


//	@GetMapping(value = "/searchDept.do")
//	public String searchDept(Model model, @RequestParam("dept_name") String dept_name) {
//	    log.info("DeptController searchDept : {}", dept_name);
//	    try {
//	        List<DeptVo> lists2 = deptService.searchDept(dept_name);
//	        model.addAttribute("lists", lists2); 
//	        return "departmentList"; 	    
//	        } catch (Exception e) {
//	        log.error("부서 검색 중 오류가 발생했습니다", e);
//	        model.addAttribute("errorMessage", "부서 검색 중 오류가 발생했습니다. 나중에 다시 시도해주세요.");
//	        return "departmentList"; 
//	    }
//	}
}


