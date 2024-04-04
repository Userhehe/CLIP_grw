package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import com.clip.gwr.vo.AnnualVo;
import com.clip.gwr.vo.AnnualUseVo;


public interface IAnnualDao {

		 // 연차등록 (사원 등록시) 
		public int insertAnn(Map<String, Object>map);
	    
		// 1달마다 연차 등록 
		public int insertAnnualUp(String user_id);
		
		// 연차 전체 조회 
		public List<AnnualVo> annAll();
		
		// 나의 연차 조회 
		public AnnualVo myAnn(String user_id);
		
		// 연차 상세 조회
		public AnnualVo detailAnn(String user_id);
		
		// 연차 수정 
		public int updateAnn(Map<String, Object> map);
		
		// 1년마다 연차 초기화 
		public int resetAnn(Map<String, Object> map);
		
		// 1년마다 사용연차 초기화 
		public int resetAnnualUse(Map<String, Object> map);
		
       // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 여기서 부터 연차 신청      
 		
		//  연차 데이터 존재 유무 확인
		public int chkAnn(String user_id);
		
		// 데이터 잔여 일수 조회
        public int selAnnLe(String user_id);	
        
		// 데이터 없을경우 연차신청 
        public int applyAnn(Map<String, Object> map);
        
        //사용가능일수 조회
        public int selAvaliday(String user_id);
        
        //연차신정(update)
        public int applyUpdateAnn(String user_id);
        
        // 연차 검색 
        public List<AnnualVo> searchAnnual(Map<String, Object> map);
	 
		
}
