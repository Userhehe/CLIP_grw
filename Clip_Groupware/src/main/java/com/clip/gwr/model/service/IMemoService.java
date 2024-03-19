package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.MemoVo;

public interface IMemoService {

	List<MemoVo> myScheduleAll(String user_id); //개인 메모 조회
	
	public MemoVo myScheduleDetail(String seq); //개인메모 상세 조회
	
	public int myScheduleInsert(Map<String, Object> map); // 개인메모 입력
	
	public int myScheduleUpdate(MemoVo vo); // 개인메모 수정
	
	public int myScheduleDelete(MemoVo vo); // 개인 메모 삭제
}
