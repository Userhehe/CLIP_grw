package com.clip.gwr.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.model.service.IAnnualService;
import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IPositionsService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.vo.AnnualUseVo;
import com.clip.gwr.vo.AnnualVo;

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
	
	
	@GetMapping(value = "/annAll.do")
	public String listAnnual(Model model) {
		log.info("AnnualController listAnnual 전체 조회");
		
		List<AnnualVo> anlist = service.annAll();
		model.addAttribute("anlist",anlist);
		log.info("anlist :"+anlist);
		return "annual" ;
	}
	
/*
 * @GetMapping(value = "/detailAnnual.do") public String
 * detailAnnual(HttpServletRequest request, Model model) {
 * log.info("AnnualController detailAnnual 상세 조회");
 * 
 * String user_id = request.getParameter("user_id"); log.info("####user_id : " +
 * user_id);
 * 
 * 
 * AnnualVo anDetail = service.detailAnnual(user_id);
 * 
 * 
 * List<AnnualVo> anDetailList = new ArrayList<>(); anDetailList.add(anDetail);
 * 
 * 
 * model.addAttribute("anDetailList", anDetailList);
 * log.info("####anDetailList : " + anDetailList);
 * 
 * 
 * return "detailAnn"; }
 * 
 * 
 */
}
