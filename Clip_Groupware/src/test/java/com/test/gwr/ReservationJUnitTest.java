package com.test.gwr;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class ReservationJUnitTest {

	@Autowired
	private IReservationService service;

	// 일정페이지에서 예약 확인
	// @Test
	public void myReservationAll() {
		List<ReservationVo> lists = service.myReservationAll("USER_034");
		log.info("예약 전체조회 : {}", lists);
		assertNotNull(lists);
	}

	// 예약등록
	// @Test
	public void test() {
		String attendsView = "USER_011,USER_034";

		ArrayList<String> attendCtrl = new ArrayList<>(Arrays.asList(attendsView.split(",")));

		String attends = "{\"Attend\":[";
		for (int i = 0; i < attendCtrl.size(); i++) {
			String attend = attendCtrl.get(i);
			attends += "{\"attend\":\"" + attend + "\"}";
			if (i < attendCtrl.size() - 1) {
				attends += ",";
			}
		}
		attends += "]}";

		ReservationVo vo = new ReservationVo();
		vo.setUser_id("USER_011");
		vo.setRe_title("영태님의 예약");
		vo.setRe_content("끝까지가면 내가 다 이겨");
		vo.setMe_room("1");
		vo.setRe_attend(attends);
		int isc = service.myReservationInsert(vo);
		log.info("입력한 예약 정보 : {}", vo);
		assertNotEquals(isc, 0);

	}

	// 예약가능시간조회
	// @Test
	public void selectPossibleMeRoom() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("me_room", "1");
		map.put("re_start", "2024-02-01");
		List<String> lists = service.selectPossibleMeRoom(map);

		List<String> timeParts = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (String dateTimeString : lists) {
			LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
			String timePart = dateTime.toLocalTime().toString();
			timeParts.add(timePart);
		}
		System.out.println(timeParts);

		log.info("예약 가능 시간대 : {}", lists);
		assertNotNull(lists);
	}

	// 참석자를 위한 jstree
	@Test
	public void selectAttends() {
		List<UserinfoVo> lists = service.selectAttendsJstree();
		log.info("참석자를 위한 jstree : {}", lists);
		assertNotNull(lists);
	}

}
