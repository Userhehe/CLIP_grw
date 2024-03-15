package com.clip.gwr.ctrl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//비동기식으로 변경 해야됨, 모달창으로 띄울지는 고민중
	@ResponseBody
	@PostMapping(value = "/selectPossibleMeRoom.do")
	public List<String> selectPossibleMeRoom(String me_room, String re_start) {
		
		log.info("ReservationController selectPossibleMeRoom 회의실, 예약일 : {} , {}",me_room,re_start);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("me_room", me_room);
		map.put("re_start", re_start);
		List<String> possibleMeRooms = service.selectPossibleMeRoom(map);
		
		List<String> possibleMeRoomTimes = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String possibleMeRoom : possibleMeRooms) {
            LocalDateTime dateTime = LocalDateTime.parse(possibleMeRoom, formatter);
            String timePart = dateTime.toLocalTime().toString();
            possibleMeRoomTimes.add(timePart);
        }
        
        log.info("ReservationController selectPossibleMeRoom 예약가능시간 : {}",possibleMeRoomTimes);

		return possibleMeRoomTimes;
	}
}
