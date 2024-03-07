package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.GianVo;

public interface IGianDao {
	//결재양식 전체조회
	public List<GianVo> templateAll();
	//결재양식 상세조회
	public GianVo templateDetail (String gian_seq);
	//결재양식 추가
	public int tempateInsert  (GianVo vo);
	//결재양식 수정
	public int templateUpdate (GianVo vo);
	//결재양식 삭제
	public int templateDelete ();
	
}