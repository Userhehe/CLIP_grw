package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IGianService;
import com.clip.gwr.vo.GianVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PayController {

	@Autowired
	private IGianService service;

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
		log.info("PayController 기안서 양식 추가 페이지 ");

		return "gianInsert";
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
