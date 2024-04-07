package com.clip.gwr.model.mapper;

import java.util.List;

import com.clip.gwr.vo.ReferenceVo;

public interface IReferenceDao {

	//결재 참조자 정보 넣기
	public int putReference(List<ReferenceVo> list);
	
	//참조자 정보 가져오기
	public List<ReferenceVo> getReferenceAll(String app_seq);
}
