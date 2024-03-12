package com.clip.gwr.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.clip.gwr.model.service.IGianService;
import com.clip.gwr.vo.GianVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PayController {
	
	@Autowired
	private IGianService service;
	
	@GetMapping(value="/paytemplate.do")
	public String payTemplate(Model model) {
		log.info("PayController 기안서 양식관리 페이지");
		List<GianVo> lists=service.templateAll();
		model.addAttribute("lists",lists);
		return "gianList";
	}
	
	@GetMapping(value="/gianDetail.do")
	public String gianDetail(Model model,HttpServletRequest request) {
		log.info("PayController 기안서 양식 조회 페이지 ");
		String seq = request.getParameter("gian_seq");
		GianVo vo = service.templateDetail(seq);
		model.addAttribute("vo",vo);
		return "gianDetail";
	}
	
	@GetMapping(value="/gianInsert.do")
	public String gianInsert() {
		log.info("PayController 기안서 양식 추가 페이지 ");
		
		return "gianInsert";
	}
	
	@GetMapping(value="/gianModify.do")
	public String gianModify(Model model,HttpServletRequest request) {		
		log.info("PayController gianModify 수정 GET");
		String seq = request.getParameter("gian_seq");
		GianVo vo = service.templateDetail(seq);
		model.addAttribute("vo",vo);
		return "gianModify";
	}
	
	@PostMapping(value="/gianMod.do")
	public String gianModify(String gian_html) {
		log.info("PayController gianModify 수정 POST :{}",gian_html);
		
		return null;
	}
}
