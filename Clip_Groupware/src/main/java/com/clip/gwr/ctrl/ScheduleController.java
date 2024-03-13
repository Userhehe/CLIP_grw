package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ScheduleController {

	@GetMapping(value = "schedule.do")
	public String mainscheduel() {
		log.info("ScheduleController mainscheduel 달력조회");
		return "schedule";
	}
}
