package com.clip.gwr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {

	@GetMapping(value = "resrvation.do")
	public String roomreservation() {
		log.info("ReservationController roomreservation 회의실 예약화면");
		return null;
	}
}
