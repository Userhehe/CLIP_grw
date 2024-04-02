package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.RanksVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RanksController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDeptService deptService;
	
	@Autowired
	private IRanksService ranksService;
	
	
	@GetMapping(value = "/ranksAll.do")
    public String deptAll(Model model) {
        log.info("RanksController 직급리스트 조회");
        List<RanksVo> lists = ranksService.ranksAll();
        model.addAttribute("lists", lists);
        return "ranksList"; 
    }

	@GetMapping(value = "/insertRanks.do")
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
	    return "insertRanks"; // 부서 등록 페이지로 이동
	}

	@PostMapping("/insertRanks.do")
	public String registerDept(@RequestParam("ranks_name") String ranks_name, RedirectAttributes redirectAttrs) {
	    int count = ranksService.duplicateRanks(ranks_name);
	    
	    if (count > 0) {
	        log.error("부서 중복 검사 실패: {}", ranks_name);
	        redirectAttrs.addFlashAttribute("errorMessage", "부서명이 이미 존재합니다.");
	        return "redirect:/insertDept.do"; 
	    }
	    
	    Map<String, Object> ranksMap = new HashMap<>();
	    ranksMap.put("ranks_name", ranks_name);
	    
	    int result = ranksService.insertRanks(ranksMap);
	    if (result == 1) {
	        log.info("직급 등록 성공: {}", ranks_name);
	        return "redirect:/ranksAll.do"; 
	    } else {
	        log.error("부서 등록 실패: {}", ranks_name);
	        return "error"; 
	    }
	}
	
	@PostMapping("/duplicateRanks.do")
	@ResponseBody
	public int checkDuplicateRanks(@RequestParam("ranks_name") String ranks_name) {
	    return ranksService.duplicateRanks(ranks_name);
	}
	
	@PostMapping("/updateRanks.do")
	@ResponseBody
	public String updateRanks(@RequestParam("ranks_name") String ranksName, @RequestParam("ranks_seq") String ranksSeq) {
	    log.info("ranks_name: {}", ranksName);
	    log.info("ranks_seq: {}", ranksSeq);

	    Map<String, Object> map = new HashMap<>();
	    map.put("ranks_name", ranksName); 
	    map.put("ranks_seq", ranksSeq);   

	    try {
	        ranksService.updateRanks(map);
	        return "success";
	    } catch (Exception e) {
	        log.error("직급 수정 중 오류 발생: {}", e.getMessage());
	        return "error";
	    }
	}
	
	@PostMapping("/delRanks.do")
	@ResponseBody
	public String delDept(@RequestParam("ranks_seq") String ranksSeq) {
	    try {
	        int result = ranksService.delRanks(ranksSeq);
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









