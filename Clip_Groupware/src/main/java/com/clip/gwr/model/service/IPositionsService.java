package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.DeptVo;

public interface IPositionsService {

	 //직책 등록 
		public int insertPositions(Map<String, Object>map);
		
		//직책 수정 
		public int updatePositions(Map<String, Object>map);
		
		// 직책 삭제 
		public int delPosition(String positions_seq);
		
		// 직책 검색 
		public List<DeptVo> searchPosition(String positions_name);
		
		// 직책 중복검사 
		public int duplicatePosItion(String positions_name);

}
