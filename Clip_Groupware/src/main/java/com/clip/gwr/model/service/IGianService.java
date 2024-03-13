package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.GianMarkVo;
import com.clip.gwr.vo.GianVo;

public interface IGianService {
	//결재양식 전체조회
	public List<GianVo> templateAll();
	//결재양식 상세조회
	public GianVo templateDetail (String gian_seq);
	//결재양식 추가
	public int tempateInsert  (Map<String,Object>map);
	//결재양식 수정
	public int templateUpdate (Map<String,Object>map);
	//결재양식 구분별 검색
	public List<GianVo> templateGubunSel();
	//결재양식 이름별 검색
	public List<GianVo> templateNameSel(String gian_name);
	//결재양식 삭제
	public int templateDelete(String gian_seq);
	//즐겨찾기한 기안서 양식 리스트 조회
	public List<GianVo> mySeletTemplate(String user_Id);
	//조회 후 기안서 즐겨찾기 추가
	public int myInsert(Map<String,Object>map);
	//조회 후 즐겨찾기한 기안서 양식 삭제
	public int myDel(String gian_seq);
}
