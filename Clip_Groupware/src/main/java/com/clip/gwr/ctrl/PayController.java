package com.clip.gwr.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clip.gwr.model.service.IGianService;
import com.clip.gwr.vo.GianVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PayController {

	@Autowired
	private IGianService service;

	@GetMapping(value="/payRegister.do")
	public String payRegister(Model model) {
		log.info("PayController payRegister 결재신청 페이지");
		GianVo vo =service.templateDetail("GIAN_001");//연차 seq (GIAN_001)
	    model.addAttribute("vo", vo);
		return "payRegister";
	}
	
	@GetMapping(value="/myPaySelect.do")
	public String myPaySelect() {
		log.info("PayController myPaySelect 내 결재조회 페이지");
		return "myPaySelect";
	}
	
	@PostMapping(value="/templateDelete.do")
	public String gianDelete(@RequestParam("gian_seq") String gian_seq) {
		log.info("PayController gianDelete POST");
		int n = service.templateDelete(gian_seq);
		return "redirect:/paytemplate.do";
	}
	
	@GetMapping(value="/templateReasearch.do")
	public String templateSelect(Model model,@RequestParam("gian_name")String gian_name) {
		log.info("PayController templateSelect GET :{}",gian_name);
		List<GianVo> lists2=service.templateNameSel(gian_name);
		model.addAttribute("lists2",lists2);
		return "paytemplate" ;
	}
	
	@GetMapping(value = "/paytemplate.do")
	public String payTemplate(Model model) {
		log.info("PayController 기안서 양식관리 페이지");
		List<GianVo> lists = service.templateAll();
		model.addAttribute("lists", lists);
		return "gianList";
	}

	@GetMapping(value = "/gianDetail.do")
	public String gianDetail(Model model, HttpServletRequest request) {
		log.info("PayController 기안서 양식 조회 페이지 ");
		String seq = request.getParameter("gian_seq");
		GianVo vo = service.templateDetail(seq);
		model.addAttribute("vo", vo);
		return "gianDetail";
	}

	@GetMapping(value = "/gianInsert.do")
	public String gianInsert() {
		log.info("PayController 기안서 양식 추가 페이지 GET ");
		return "gianInsert";
	}
	
	@PostMapping(value="/gianInsert.do")
	public String gianInsertPost(@RequestParam("gian_gubun") String gian_gubun,@RequestParam("gian_name") String gian_name ,@RequestParam("gian_modifier") String gian_modifier, @RequestParam("gian_html") String gian_html) {
		log.info("PayController 기안서 양식 추가 페이지 POST:{} {} {} {} ",gian_gubun,gian_name,gian_modifier,gian_html);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gian_gubun", gian_gubun);
		map.put("gian_name", gian_name);
		map.put("gian_html", gian_html);
		map.put("gian_modifier", gian_modifier);
		int n = service.tempateInsert(map);
		return "redirect:/paytemplate.do";
	}
	
	
	@GetMapping(value = "/gianModify.do")
	public String gianModify(Model model, HttpServletRequest request) {
		log.info("PayController gianModify GET");
		String seq = request.getParameter("gian_seq");
		GianVo vo = service.templateDetail(seq);
		model.addAttribute("vo", vo);
		return "gianModify";
	}

	@PostMapping(value = "/gianMod.do")
	public String gianModify(@RequestParam("gian_seq") String gian_seq, @RequestParam("gian_html") String gianhtml) {
		log.info("PayController gianModify POST : {}", gianhtml);
		System.out.println("$$$$$$$$gian_seq:" + gian_seq);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gian_html", gianhtml);
		map.put("gian_seq", gian_seq);
		int n = service.templateUpdate(map);
		return "redirect:/paytemplate.do";
	}

	
}
