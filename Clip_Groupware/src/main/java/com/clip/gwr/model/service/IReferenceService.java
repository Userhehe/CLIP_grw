package com.clip.gwr.model.service;

import java.util.List;

import com.clip.gwr.vo.ReferenceVo;

public interface IReferenceService {
	
	//결재정보의 참조인 가져오기
	public List<ReferenceVo> getReferenceAll(String app_seq);

}
