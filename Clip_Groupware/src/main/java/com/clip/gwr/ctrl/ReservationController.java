package com.clip.gwr.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.MeeTingRoomVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {
	
	@Autowired
	private IReservationService service;

	@GetMapping(value = "/reservation.do")
	public String reservation(Model model) {
		List<MeeTingRoomVo> meeTingRoomVo = service.selectMeetingRoom();
		model.addAttribute("meeTingRoomVo",meeTingRoomVo);
		log.info("ReservationController reservation 회의실 예약화면 이동");
		return "reservation";
	}
}
