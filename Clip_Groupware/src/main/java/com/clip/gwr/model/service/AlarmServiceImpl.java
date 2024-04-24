package com.clip.gwr.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IAlarmDao;
import com.clip.gwr.vo.AlarmVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlarmServiceImpl implements IAlarmService {

	@Autowired
	private IAlarmDao dao;
	
	/**
	 * 공지사항 알람
	 */
	@Override
	public List<AlarmVo> selectAlarmNotice() {
		log.info("AlarmServiceImpl selectAlarmNotice 공지사항 알람");
		return dao.selectAlarmNotice();
	}
	
}
