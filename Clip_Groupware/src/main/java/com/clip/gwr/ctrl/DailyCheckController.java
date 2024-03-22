package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.model.service.IDailyCheckService;
import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.vo.DailyCheckVo;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;
import com.clip.gwr.vo.RanksVo;

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
	 
	 @GetMapping(value = "/searchDailyCheckList.do")
	 public String searchDailyCheckList(Model model) {
		 List<PositionsVo> positionsList = positionsService.positionsAll();
		 List<DeptVo> deptList = deptService.deptAll();
		 List<RanksVo> ranksList = ranksService.ranksAll();
		    model.addAttribute("positionsList", positionsList);
	        model.addAttribute("deptList", deptList);
	        model.addAttribute("ranksList", ranksList);
	        log.info("$$$$$$$$$$$$$$$$$$"+ranksList);
	        log.info("$$$$$$$$$$$$$$$$$$"+positionsList);
	        log.info("$$$$$$$$$$$$$$$$$$"+deptList);
	        return "dailyCheck";
	 }
}
