package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IMemoDao;
import com.clip.gwr.vo.MemoVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemoServiceImpl implements IMemoService{
	
	@Autowired
	private IMemoDao dao;

	@Override
	public List<MemoVo> myScheduleAll(String user_id) {
		log.info("myScheduleAll");
		return dao.myScheduleAll(user_id);
	}

	@Override
	public MemoVo myScheduleDetail(String seq) {
		
		return dao.myScheduleDetail(seq);
	}

	@Override
	public int myScheduleInsert(Map<String, Object> map) {
		
		return dao.myScheduleInsert(map);
	}

	@Override
	public int myScheduleUpdate(MemoVo vo) {
		return dao.myScheduleUpdate(vo);
	}

	@Override
	public int myScheduleDelete(MemoVo vo) {
		return dao.myScheduleDelete(vo);
	}
	
	@Override
	public List<MemoVo> selectScheduleAll(Map<String, Object> map) {
		return dao.selectScheduleAll(map);
	}
}
