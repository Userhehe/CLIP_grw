package com.clip.gwr.ctrl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReAttendsVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationController {

	@Autowired
	private IReservationService service;

	// 예약 페이지 이동
	@GetMapping(value = "/reservation.do")
	public String reservation(Model model) {
				List<MeeTingRoomVo> meeTingRoomVo = service.selectMeetingRoom();
		model.addAttribute("meeTingRoomVo", meeTingRoomVo);
		log.info("ReservationController reservation 회의실 예약화면 이동");
		return "reservation";
	}
	
	//예약 달력에 전체 조회 하기
	@GetMapping(value = "/reList.do")
	@ResponseBody
	public JSONArray reAllList(HttpSession session) {
		UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
		log.info("session에서 받은값 :" + id);
		List<ReservationVo>lists = service.myReservationAll(id.getUser_id());
		JSONArray reArr = new JSONArray();
		for(ReservationVo vo : lists) {
			JSONObject obj = new JSONObject();
			obj.put("seq",vo.getRe_seq());
			obj.put("id",vo.getUser_id());
			obj.put("title",vo.getRe_title());
			obj.put("content",vo.getRe_content());
			obj.put("start",vo.getRe_start());
			obj.put("end",vo.getRe_end());
			reArr.add(obj);
		}
		return reArr;
	}
	
	//예약 상세조회
	@GetMapping(value = "/reDetail.do")
	@ResponseBody
	public Map<String, Object> reDetail(int seq) {
		log.info("ReservationController reDetail 상세조회");
		System.out.println("전달받은 re_seq값:" + seq);
		List<ReAttendsVo> attlists = service.reAttList(seq);// 회의실 참석자 리스트
		log.info("참석자 리스트:{}", attlists);
		int index=0;
		String attends ="";
		for(ReAttendsVo att : attlists) {
			log.info("att : {}", att);
			attends += att.getUser_name();
			attends += " ";
			attends += att.getRanks_name();
			if(index < attlists.size()-1) {
				attends +=",";
			}
			index++;
		}
		
		Map<String, Object> map = new HashMap<>(); //예약한 회의실 내용을 담을 예정
		ReservationVo vo = service.reDetail(seq);
		log.info("전달받은 seq의 내용 {}:" , vo);
		map.put("roomNum", vo.getMe_room());
		map.put("title", vo.getRe_title());
		map.put("content", vo.getRe_content());
		map.put("start", vo.getRe_start());
		map.put("end", vo.getRe_end());
		log.info("선택된 seq의 상세보기 내용: {}", map);
		return map;
	}

	//예약내용 수정하기
	@GetMapping(value = "/reModify.do")
	public ReservationVo reModify() {
		log.info("ReservationController reModify");
		
		return null;
	}
	
	//예약 취소하기
	@GetMapping(value = "/reDel")
	public String reDel() {
		log.info("ReservationController reDel");
		
		return null;
	}
	
	

	
	// 내 예약 페이지 이동
	@GetMapping(value = "/myReservation.do")
	public String myReservation(Model model, HttpSession session) {
		log.info("ReservationController myReservation 회의실 예약 수정 화면 이동");
		UserinfoVo id = (UserinfoVo) session.getAttribute("loginVo");
		List<ReservationVo> myReservationList = service.myReservationAll(id.getUser_id());
		model.addAttribute("myReservationList",myReservationList);
		return "myReservation";
	}

	
	// 예약하기 모달 기능 시작
	// 예약 가능 시간 확인
	@ResponseBody
	@PostMapping(value = "/selectPossibleMeRoom.do")
	public List<String> selectPossibleMeRoom(String me_room, String re_start) {

		log.info("ReservationController selectPossibleMeRoom 회의실, 예약일 : {} , {}", me_room, re_start);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("me_room", me_room);
		map.put("re_start", re_start);
		List<String> possibleMeRooms = service.selectPossibleMeRoom(map);
		log.info("ReservationController possibleMeRooms 예약가능시간 : {}", possibleMeRooms);
		List<String> possibleMeRoomTimes = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (String possibleMeRoom : possibleMeRooms) {
			LocalDateTime dateTime = LocalDateTime.parse(possibleMeRoom, formatter);
			String timePart = dateTime.toLocalTime().toString();
			possibleMeRoomTimes.add(timePart);
		}

		log.info("ReservationController selectPossibleMeRoom 예약가능시간 : {}", possibleMeRoomTimes);

		return possibleMeRoomTimes;
	}
	

	// jstree
	@GetMapping(value = "/selectAttendsJstree.do")
	@ResponseBody
	public String selectAttendsJstree() {
		log.info("selectAttendsJstree.do 실행");
		List<UserinfoVo> lists = service.selectAttendsJstree();
		log.info("lists : {}", lists);
		Gson gson = new GsonBuilder().create();
		log.info("gson :{}", gson);
		String result = gson.toJson(lists);
		log.info("result : {}", result);
		return result;
	}
	
	//예약등록하기
	@PostMapping(value = "/myReservationInsert.do")
	@ResponseBody
	public int myReservationInsert(@RequestParam Map<String, Object> map, 
												 HttpSession session) {
		UserinfoVo id = (UserinfoVo) session.getAttribute("loginVo");
		log.info("등록할 예약자 정보 : {}", id);
		map.put("user_id", id.getUser_id());
		log.info("등록할 예약 정보 : {}", map);
		int isc = service.myReservationInsert(map);
		
		int seq = service.cpRev(id.getUser_id());
		log.info("예약 등록 성공 여부 : {}", isc == 0 ? "예약실패" : "예약성공");
		log.info("최신 예약 seq : {}", seq);
		
		if(isc !=0) {
			return seq;
		}else {
			return isc;
		}
		
		
	}
	
	//참석자 등록하기
	@PostMapping(value = "/attinsert.do")
	@ResponseBody
	public String attinsert(String id, int seq) {
		log.info("ReservationController attinsert");
		log.info("배열 : {}",id);
		log.info("최신시퀀스:{}",seq);
		
		int cnt =0;
		String[] ids = id.split(",");
		for(String att: ids) {
			Map<String, Object> map = new HashMap<>();
			
			map.put("user_id", att);
			map.put("re_seq", seq);
			service.attinsert(map);
			cnt++;
		}
		System.out.println("총"+cnt+"명이 입력됨");
		return "myReservation";
	}
	
	// 예약하기 모달 기능 시작

}
