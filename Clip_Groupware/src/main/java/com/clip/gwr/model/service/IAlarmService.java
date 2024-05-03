package com.clip.gwr.model.service;

import java.util.List;

import com.clip.gwr.vo.AlarmVo;

public interface IAlarmService {

	/**
	 * 공지사항 알람
	 * @return
	 */
	public List<AlarmVo> selectAlarmNotice(String user_id);
}
