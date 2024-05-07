package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.AlarmVo;

public interface IAlarmService {
	
	/**
	 * 공지사항 알람 등록
	 * @return
	 */
	public int AddAlarm();
	
	/**
	 * 공지사항 알람 대상 등록
	 * @return
	 */
	public int AddAlarmTarget(String user_id);

	/**
	 * 공지사항 알람
	 * @return
	 */
	public List<AlarmVo> selectAlarmNotice(String user_id);
}
