package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IProjectsService;
import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.GianVo;
import com.clip.gwr.vo.ProjectMemVo;
import com.clip.gwr.vo.ProjectsVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectsController {

	@Autowired
	private IProjectsService service;

//------------진행도별 프로젝트 조회-----------------------//	
	
	@GetMapping(value = "/projectsProgress.do")
	public String projectsProgress(Model model) {
		log.info("PayController 진행도별 프로젝트 페이지");
		List<ProjectsVo> lists = service.projectsProgressSel();
		List<ProjectMemVo> lists2 = service.getMemberName();
		log.info("프로젝트 구성원 조회 :{}", lists2);
		
		int radioChk = 0;
		model.addAttribute("radioChk",radioChk);
		model.addAttribute("lists", lists);
		model.addAttribute("lists2", lists2);
		return "projectsProgress";
	}

//------------완료된 프로젝트 조회-----------------------//	

	@GetMapping(value = "/getCompletedProjects.do")
	public String getCompletedProjects(Model model) {
		log.info("PayController 완료된 프로젝트 페이지");
		List<ProjectsVo> lists = service.getCompletedProjects();
		List<ProjectMemVo> lists2 = service.getMemberName();		
		log.info("완료된프로젝트리스트:{}",lists);
		
		int radioChk = 1;
		model.addAttribute("radioChk",radioChk);
		model.addAttribute("lists",lists);
		model.addAttribute("lists2", lists2);
		return "projectsProgress";
	}

//------------기간별 프로젝트 조회-----------------------//	
	
	@GetMapping(value = "/projectsPeriod.do")
	public String projectsPeriod(Model model) {
		log.info("PayController 기간별 프로젝트 페이지");
		List<ProjectsVo> lists = service.getProjectsAll();
		List<ProjectMemVo> lists2 = service.getMemberName();
		
		model.addAttribute("lists", lists);
		model.addAttribute("lists2", lists2);
		return "projectsPeriod";
	}

//------------발주처별 프로젝트 조회-----------------------//	
	
	@GetMapping(value = "/projectClient.do")
	public String projectClient(Model model) {
		log.info("PayController 발주처별 프로젝트 페이지");
		List<ProjectsVo> lists = service.getProjectsAll();
		List<ProjectMemVo> lists2 = service.getMemberName();
		
		model.addAttribute("lists", lists);
		model.addAttribute("lists2", lists2);
		
		return "projectClient";
	}

//------------프로젝트 상세조회-----------------------//	
	
	@GetMapping(value = "/projectDetail.do")
	public String projectDetail() {
		return "projectDetail";
	}
}
