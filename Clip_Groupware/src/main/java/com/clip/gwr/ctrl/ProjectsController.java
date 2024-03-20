package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
//
@Controller
@Slf4j
public class ProjectsController {
	
	@GetMapping(value = "/projectsProgress.do")
	public String projectsProgress() {
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
}
