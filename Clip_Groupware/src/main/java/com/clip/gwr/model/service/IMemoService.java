package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.NtcVo;

public interface IMemoService {

	List<MemoVo> myScheduleAll(String user_id); //개인 메모 조회
	
	public MemoVo myScheduleDetail(String seq); //개인메모 상세 조회
	
	public int myScheduleInsert(Map<String, Object> map); // 개인메모 입력

	public int myScheduleDelete(String seq); // 개인 메모 삭제
	
	public int myScheduleUpdate(Map<String, Object> map); // 개인메모 수정
	
	public List<MemoVo> selectScheduleAll(Map<String, Object> map);
	
	public NtcVo ntcScheduleDetail(String seq); //전사일정 상세 조회
}
