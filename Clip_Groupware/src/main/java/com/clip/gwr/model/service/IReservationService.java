package com.clip.gwr.model.service;

import java.util.List;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReservationVo;

public interface IReservationService {
	
	public List<ReservationVo> myReservationAll(String user_id);
	
	public int myReservationInsert(ReservationVo vo);
	
	public List<MeeTingRoomVo> selectMeetingRoom();
}
