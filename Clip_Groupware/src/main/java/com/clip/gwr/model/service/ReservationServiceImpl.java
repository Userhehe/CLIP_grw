package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IReservationDao;
import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservationServiceImpl implements IReservationService {
	
	@Autowired
	private IReservationDao dao;
	
	//본인 예약 정보 전체조회
	@Override
	public List<ReservationVo> myReservationAll(String user_id) {
		log.info("ReservationServiceImpl myReservationAll 사용자 아이디 :{}",user_id);
		return dao.myReservationAll(user_id);
	}
	
	//회의실 예약하기
	@Override
	public int myReservationInsert(ReservationVo vo) {
		log.info("ReservationServiceImpl myReservationAll 사용자 아이디 :{}",vo);
		return dao.myReservationInsert(vo);
	}
	
	//회의실 목록
	@Override
	public List<MeeTingRoomVo> selectMeetingRoom() {
		log.info("ReservationServiceImpl selectMeetingRoom 회의실 목록");
		return dao.selectMeetingRoom();
	}
	
	//예약가능시간조회
	@Override
	public List<String> selectPossibleMeRoom(Map<String, Object> map) {
		log.info("ReservationServiceImpl selectPossibleMeRoom 선택 날짜 : {}", map);
		return dao.selectPossibleMeRoom(map);
	}
	
	//참석자 선택 jstree
	@Override
	public List<String> selectAttends() {
		log.info("ReservationServiceImpl selectAttends 참석자 선택 jstree");
		return dao.selectAttends();
	}
	
}