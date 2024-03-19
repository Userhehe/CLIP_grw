package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

public interface IReservationService {
	
	//예약 조회(일정창에서)
	public List<ReservationVo> myReservationAll(String user_id);
	
	//예약 등록
	public int myReservationInsert(Map<String, Object> map);
	
	//회의실 목록
	public List<MeeTingRoomVo> selectMeetingRoom();
	
	//예약 가능 시간 조회
	public List<String> selectPossibleMeRoom(Map<String, Object> map);
	
	//참석자 선택 jstree
	public List<UserinfoVo> selectAttendsJstree();
	
}
