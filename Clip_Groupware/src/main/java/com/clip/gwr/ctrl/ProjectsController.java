package com.clip.gwr.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.model.service.IProjectsService;
import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.GianVo;
import com.clip.gwr.vo.ProjectsVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectsController {
	
	@Autowired
	private IProjectsService service;
	
	@GetMapping(value = "/projectsProgress.do")
	public String projectsProgress(Model model) {
		log.info("PayController 진행도별 프로젝트 페이지");
		List<ProjectsVo> lists = service.projectsProgressSel();
		
		model.addAttribute("lists", lists);
		return "projectsProgress";
	}
	
	@GetMapping(value = "/projectsProgressDone.do")
	public String projectsProgressDone(Model model) {
	    log.info("PayController 완료된 프로젝트 페이지");
	    List<ProjectsVo> doneProjects = service.getCompletedProjects();

	    model.addAttribute("lists", doneProjects);

	    return "projectsProgress";
	}
	
	@GetMapping(value = "/projectsPeriod.do")
	public String projectsPeriod() {
		return "projectsPeriod";
	}
	@GetMapping(value = "/projectClient.do")
	public String projectClient() {
		return "projectClient";
	}
	@GetMapping(value = "/projectDetail.do")
	public String projectDetail() {
		return "projectDetail";
	}
}
