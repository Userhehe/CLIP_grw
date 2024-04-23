package com.clip.gwr.ctrl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	public JSONArray reAllList(HttpSession session,String date) {
		UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
		log.info("session에서 받은값 :" + id);
		Map<String, Object> map =new HashMap<>();
		map.put("user_id", id.getUser_id());
		map.put("fulldate", date);
		log.info("map값:{}",map);
		List<ReservationVo>lists = service.myReservationAll(map);
		JSONArray reArr = new JSONArray();
		for(ReservationVo vo : lists) {
			JSONObject obj = new JSONObject();
			obj.put("seq",vo.getRe_seq());
			obj.put("id",vo.getUser_id());
			obj.put("title",vo.getRe_title());
			obj.put("content",vo.getRe_content());
			obj.put("start",vo.getRe_start());
			obj.put("end",vo.getRe_end());
			obj.put("meroom", vo.getMe_room());
			reArr.add(obj);
		}
		return reArr;
	}
	
	//예약 상세조회
	@GetMapping(value = "/reDetail.do")
	@ResponseBody
	public Map<String, Object> reDetail(int seq, Model model) {
		log.info("ReservationController reDetail 상세조회");
		System.out.println("전달받은 re_seq값:" + seq);
		ReAttendsVo atts = service.reAttList(seq);// 회의실 참석자 리스트
		
//		log.info("참석자 명단:{}", atts.getAttendees());
		List<MeeTingRoomVo> meeTingRoomVo = service.selectMeetingRoom(); //회의실 리스트
		model.addAttribute("meeTingRoomVo", meeTingRoomVo);
		log.info("meeTingRoomVo", meeTingRoomVo);
		
//		int index=0;
//		String attends ="";
//		int cnt=0;
//		if(attlists.size()>0) {
//			cnt=1;
//		}
//		for(ReAttendsVo att : attlists) {
//			log.info("att : {}", att);
//			attends += att.getUser_name();
//			attends += " ";
//			attends += att.getRanks_name();
//			if(index < attlists.size()-1) {
//				attends +=",";
//				cnt++;
//			}
//			index++;
//		}
		Map<String, Object> map = new HashMap<>();
		ReservationVo vo = service.reDetail(seq);
		log.info("전달받은 seq의 내용 {}:" , vo);
		log.info("전달받은 seq의 내용 {}:" , atts);
		if(atts == null) {
			map.put("attends", "지정된 참석자가 없습니다.");
		}else {
			map.put("attends", atts.getAttendees());
		}
		map.put("seq", vo.getRe_seq());
		map.put("roomNum", vo.getMe_room()+"번");
		map.put("title", vo.getRe_title());
		map.put("content", vo.getRe_content());
		map.put("start", vo.getRe_start());
		map.put("end", vo.getRe_end());
		

//		map.put("count", cnt);
		log.info("선택된 seq의 상세보기 내용: {}", map);
		return map;
	}

	
	// 내 예약 페이지 이동
	@GetMapping(value = "/myReservation.do")
	public String myReservation(Model model, HttpSession session) {
		log.info("ReservationController myReservation 회의실 예약 수정 화면 이동");
		UserinfoVo id = (UserinfoVo) session.getAttribute("loginVo");
		List<ReservationVo> myReservationList = service.myReservation(id.getUser_id());
		List<ReservationVo> myAttReservationAll = service.myAttReservationAll(id.getUser_id());
		model.addAttribute("myReservationList",myReservationList);
		model.addAttribute("myAttReservationAll",myAttReservationAll);
		
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
		
//		 // 현재 날짜와 시간 가져오기
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        // 날짜와 시간 형식 지정
//        DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        // 현재 날짜와 시간을 형식에 맞게 출력
//        String todayTime = currentDateTime.format(today);
//        System.out.println("현재 날짜 및 시간: " + todayTime);
        
		for (String possibleMeRoom : possibleMeRooms) {
			LocalDateTime dateTime = LocalDateTime.parse(possibleMeRoom, formatter);
			String timePart = dateTime.toLocalTime().toString();
			possibleMeRoomTimes.add(timePart);
		}

		log.info("ReservationController selectPossibleMeRoom 예약가능시간 : {}", possibleMeRoomTimes);

				if(possibleMeRoomTimes != null) {
					return possibleMeRoomTimes;
				}else {
					return null;
				}
	}
	

	//jstree
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
	public Map<String, Object> attinsert(String id, int seq) { 
		log.info("ReservationController attinsert 참석자 입력");
		log.info("참석자 id : {}",id);
		log.info("최신시퀀스:{}",seq);
		int cnt =0;
		
		String[] ids = id.split(",");
		Map<String, Object> map = new HashMap<>();
		for(String att: ids) {
			map.put("user_id", att);
			map.put("re_seq", seq);
			service.attinsert(map);
			cnt++;
		}
		System.out.println("총"+cnt+"명이 입력됨");
		return map;
	}
	
	//예약 취소하기
		@GetMapping(value = "/reDel.do")
		@ResponseBody
		public int reDel(int seq) {
			//예약이 취소되면 회의실에 참석자로 등록된 사람들도 지워져야 한다.
			log.info("ReservationController reDel 예약을 삭제한다.");
			log.info("삭제할 예약번호",seq);
			int isc = service.reDel(seq);
			log.info(isc > 0 ? "예약이 취소 성공":"예약 취소 실패");
			return isc;
		}
		
		
	//예약내용 수정하기
		@PostMapping(value = "/reModify.do")
		@ResponseBody
		public Map<String, Object> reModifyRev(@RequestParam Map<String, Object> map, HttpSession session) {
			log.info("ReservationController reModify 예약내용을 수정한다.");
			UserinfoVo vo = (UserinfoVo) session.getAttribute("loginVo");
			log.info("vo의 값:{}",vo);
			String id = vo.getUser_id();
			
			map.put("user_id", id);
			log.info("사용자 아이디:{}",id);
			log.info("map값:{}",map);
			service.reModifyRev(map);
//			service.reModifyAtt(id);
			return map;
		}
		
		
	//예약 참석자 수정하기 
		@PostMapping(value="/reAttModify.do")
		@ResponseBody
		public int reModifyAtt(int seq, String id) {
			log.info("ReservationController reModifyAtt 참석자를 수정한다.");
			log.info("참석자가 초기화될 예약 seq :{}", seq);
			 int isc = service.reModifyAtt(seq);
			 int cnt =0;
				String[] ids = id.split(",");
				Map<String, Object> map = new HashMap<>();
				for(String att: ids) {
					map.put("user_id", att);
					map.put("re_seq", seq);
					service.attinsert(map);
					cnt++;
				}
				System.out.println("총"+cnt+"명이 입력됨");
			 
			return isc;
		}
	


}
