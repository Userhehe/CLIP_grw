package com.clip.gwr.model.mapper;

import java.util.List;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

public interface IReservationDao {
	
	public List<ReservationVo> myReservationAll(String user_id);
	
	public int myReservationInsert(ReservationVo vo);
	
	public List<MeeTingRoomVo> selectMeetingRoom();
	
	public List<UserinfoVo> selectAttends();
}
