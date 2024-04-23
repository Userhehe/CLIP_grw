package com.clip.gwr.model.mapper;

import java.util.List;

import com.clip.gwr.vo.AlarmVo;

public interface IAlarmDao {
	
	/**
	 * 공지사항 알람
	 * @return
	 */
	public List<AlarmVo> selectAlarmNotice();
	
}
