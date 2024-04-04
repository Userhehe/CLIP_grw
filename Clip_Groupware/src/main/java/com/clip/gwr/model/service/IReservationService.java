package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReAttendsVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

public interface IReservationService {
	
	//예약 조회(일정창에서)
	public List<ReservationVo> myReservationAll(Map<String, Object> map);
	
	//예약 등록
	public int myReservationInsert(Map<String, Object> map);
	
	//내가 등록한 예약 조회(일정수정창)
	public List<ReservationVo> myReservation (String user_id);
	
	//내가 참석되어있는 예약(일정수정창)
	public List<ReservationVo> myAttReservationAll (String user_id);
	
	//회의실 목록
	public List<MeeTingRoomVo> selectMeetingRoom();
	
	//예약 가능 시간 조회
	public List<String> selectPossibleMeRoom(Map<String, Object> map);
	
	//참석자 선택 jstree
	public List<UserinfoVo> selectAttendsJstree();
	
	//예약 상세조회
	public ReservationVo reDetail(int re_seq);
	
	//예약내용 수정하기
	public int reModifyRev(Map<String, Object> map);
		
	//참석자 수정하기
	public int reModifyAtt(int re_seq);
		
	//예약 취소하기
	public int reDel(int re_seq);
	
	//참석자 조회
	public ReAttendsVo reAttList(int seq);
	
	//최신 예약내역 조회
	public int cpRev(String user_id);
	
	//참석자 입력
	public int attinsert(Map<String, Object> map);
	
}
