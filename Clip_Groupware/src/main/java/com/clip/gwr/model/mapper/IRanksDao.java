package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.RanksVo;

public interface IRanksDao {
	
	        //직급 등록 
			public int insertRanks(Map<String, Object>map);
			
			//직급 수정 
			public int updateRanks(Map<String, Object>map);
			
			// 직급 삭제 
			public int delRanks(Map<String, Object>map);
			
			// 직급 검색 
			public List<RanksVo> searchRanks(Map<String, Object>map);
			
			// 직급 중복검사 
			public int duplicateRanks(Map<String, Object>map);
			
			// 직급 전체 조회 
			public List<RanksVo> ranksAll();

}
