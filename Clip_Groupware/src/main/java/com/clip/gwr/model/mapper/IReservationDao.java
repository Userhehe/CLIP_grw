package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReAttendsVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

public interface IReservationDao {
	
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
	
	//예약 상세조회
	public ReservationVo reDetail(int re_seq);
	
	//예약내용 수정하기
	public int reModifyRev(int re_seq);
	
	//참석자 수정하기
	public int reModifyAtt(String user_id);
	
	//예약 취소하기
	public int reDel(int re_seq);
	
	//참석자 조회
	public List<ReAttendsVo> reAttList(int seq);
	
	//최신 예약내역 조회
	public int cpRev(String user_id);
	
	//참석자 입력
	public int attinsert(Map<String, Object> map);
}
