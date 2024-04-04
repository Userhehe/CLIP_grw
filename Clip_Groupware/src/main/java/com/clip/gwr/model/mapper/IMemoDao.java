package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.NtcVo;

public interface IMemoDao {
	//유저기능
	public MemoVo myScheduleDetail(String seq); //개인메모 상세 조회
	
	public int myScheduleInsert(Map<String, Object> map); // 개인메모 입력
	
	public int myScheduleDelete(String seq); // 개인 메모 삭제
	
	public int myScheduleUpdate(Map<String, Object> map); // 개인메모 수정
	
	//유저기능 끝
	
	
	public List<MemoVo> selectScheduleAll(Map<String, Object> map);
	
	
	//관리자기능
	public NtcVo ntcScheduleDetail(String seq); //전사일정 상세 조회
	
	public int ntcScheduleInsert(Map<String, Object> map); //전사일정 입력
	
	public int ntcScheduleDelete(String seq); // 전사일정 삭제
	
	public int ntcScheduleUpdate(Map<String, Object> map); // 전사일정 수정
	
	
	//공지사항(전사)
	public List<NtcVo> selectNtcBoard(); //전체 조회
	
	
	//페이징 테스트
	public int selectNtcCount(); //전체 공지 게시글 수
	
	public List<NtcVo> selectNtcPage(Map<String, Object> map); //공지 페이징 구간별 게시글 가져오기
	
	
}
