package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IAnnualDao;
import com.clip.gwr.vo.AnnualVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnnualServiceImpl implements IAnnualService {

	@Autowired
	private IAnnualDao dao; 
	
	@Override
	public int insertAnnual(Map<String, Object> map) {
		log.info("AnnualServiceImpl insertAnnual 연차등록");
		return dao.insertAnnual(map);
	}

	@Override
	public int insertAnnualup(Map<String, Object> map) {
	   log.info("AnnualServiceImpl insertAnnualup 발생연차 합산");
		return dao.insertAnnualup(map);
	}

	@Override
	public List<AnnualVo> selAnnual() {
	 log.info("AnnualServiceImpl selAnnual 연차 전체 조회");
		return dao.selAnnual();
	}

	@Override
	public AnnualVo detailAnnual(String user_id) {
		log.info("AnnualServiceImpl detailAnnual 연차 상세 조회");
		return dao.detailAnnual(user_id);
	}

	@Override
	public int updateAnnual(Map<String, Object> map) {
		log.info("AnnualServiceImpl updateAnnual 연차 수정");
		return dao.updateAnnual(map);
	}

	@Override
	public int resetAnnual(Map<String, Object> map) {
		log.info("AnnualServiceImpl resetAnnual  연차 초기화 ");
		return dao.resetAnnual(map);
	}

	@Override
	public int annUse(Map<String, Object> map) {
		log.info("AnnualServiceImpl annUse 연차 신청");
		return dao.annUse(map);
	}

	@Override
	public int annUseUpdate(Map<String, Object> map) {
		log.info("AnnualServiceImpl annUseUpdate  사용량 업데이트");
		return dao.annUseUpdate(map);
	}

	@Override
	public int annLeovUpdate(String user_id) {
		log.info("AnnualServiceImpl annLeovUpdate 잔여연차 업데이트");
		return dao.annLeovUpdate(user_id);
	}

	@Override
	public List<AnnualVo> searchAnnual(Map<String, Object> map) {
		log.info("AnnualServiceImpl searchAnnual 연차 검색");
		return dao.searchAnnual(map);
	}

	

}
