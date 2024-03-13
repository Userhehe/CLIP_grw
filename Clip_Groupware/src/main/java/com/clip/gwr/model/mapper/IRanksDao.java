package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.DeptVo;

public interface IRanksDao {
	
	        //직급 등록 
			public int insertRanks(Map<String, Object>map);
			
			//직급 수정 
			public int updateRanks(Map<String, Object>map);
			
			// 직급 삭제 
			public int delRanks(String ranks_seq);
			
			// 직급 검색 
			public List<DeptVo> searchRanks(String ranks_name);
			
			// 직급 중복검사 
			public int duplicateRanks(String ranks_name);

}
