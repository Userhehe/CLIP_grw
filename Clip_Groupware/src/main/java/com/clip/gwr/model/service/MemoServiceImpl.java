package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IMemoDao;
import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.NtcVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemoServiceImpl implements IMemoService{
	
	@Autowired
	private IMemoDao dao;
	//유저기능
	@Override
	public MemoVo myScheduleDetail(String seq) {
		return dao.myScheduleDetail(seq);
	}

	@Override
	public int myScheduleInsert(Map<String, Object> map) {
		
		return dao.myScheduleInsert(map);
	}

	@Override
	public int myScheduleDelete(String seq) {
		return dao.myScheduleDelete(seq);
	}
	
	@Override
	public int myScheduleUpdate(Map<String, Object> map) {
		return dao.myScheduleUpdate(map);
	}
	//유저기능 끝
	
	
	@Override
	public List<MemoVo> selectScheduleAll(Map<String, Object> map) {
		return dao.selectScheduleAll(map);
	}
	
	
	//관리자기능
	@Override
	public NtcVo ntcScheduleDetail(String seq) {
		return dao.ntcScheduleDetail(seq);
	}
	
	@Override
	public int ntcScheduleInsert(Map<String, Object> map) {
		return dao.ntcScheduleInsert(map);
	}
	
	@Override
	public int ntcScheduleDelete(String seq) {
		return dao.ntcScheduleDelete(seq);
	}
	
	@Override
	public int ntcScheduleUpdate(Map<String, Object> map) {
		return dao.ntcScheduleUpdate(map);
	}
	
	//공지사항(전사)
	@Override
	public List<NtcVo> selectNtcBoard() {
		return dao.selectNtcBoard();
	}
	
	//페이징 테스트
	@Override
	public int selectNtcCount() {
		return dao.selectNtcCount();
	}
	
	@Override
	public List<NtcVo> selectNtcPage(Map<String, Object> map) {
		return dao.selectNtcPage(map);
	}
}
