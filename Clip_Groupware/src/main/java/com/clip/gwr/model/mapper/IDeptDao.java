package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.DeptVo;

public interface IDeptDao {

	     //부서 등록 
		public int insertDept(Map<String, Object>map);
		
		//부서 수정 
		public int updateDept(Map<String, Object>map);
		
		// 부서 삭제 
		public int delDept(String dept_seq);
		
		// 부서 검색 
		public List<DeptVo> searchDept(String dept_name);
		
		// 부서 중복검사 
		public int duplicateCheckDept(String dept_name);
}