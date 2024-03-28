package com.clip.gwr.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.model.service.IAnnualService;
import com.clip.gwr.vo.AnnualVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AnnualController {
     
	@Autowired
	private IAnnualService service;
	
	
	@GetMapping(value = "/selAnnual.do")
	public String listAnnual(Model model) {
		log.info("AnnualController listAnnual 전체 조회");
		List<AnnualVo> anlist = service.selAnnual();
		model.addAttribute("anlist",anlist);
		log.info("anlist"+anlist);
		return "annual" ;
	}
}
