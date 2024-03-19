package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectsController {
	
	@GetMapping(value = "/projects.do")
	public String projects() {
		return "projects";
	}
}
