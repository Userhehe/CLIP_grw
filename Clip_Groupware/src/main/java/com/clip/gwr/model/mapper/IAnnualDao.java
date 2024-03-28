package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.AnnualVo;
import com.clip.gwr.vo.AnnualctVo;
import com.clip.gwr.vo.AnnualctVo;

public interface IAnnualDao {

		 // 연차등록 (사원 등록시) 
		public int insertAnnual(Map<String, Object>map);
	    
		//  발생연차 합산 
		public int insertAnnualup(Map<String, Object> map);
		
		// 연차 전체 조회 
		public List<AnnualVo> selAnnual();
		// 연차 상세 조회
		public AnnualVo detailAnnual(String user_id);
		
		// 연차 수정 
		public int updateAnnual(Map<String, Object> map);
		// 연차 초기화 
		public int resetAnnual(Map<String, Object> map);
		// 연차 신청
		public int annUse(Map<String, Object> map);
		// 사용량 업데이트
        public int annUseUpdate(Map<String, Object> map);		
		// 잔여 연차 수정 
        public int annLeovUpdate(String user_id);
        
        // 연차 검색 
        public List<AnnualVo> searchAnnual(Map<String, Object> map);
	 
		
}
