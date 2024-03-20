package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IRanksDao;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.RanksVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RanksServiceImpl implements IRanksService {

	@Autowired
	private IRanksDao dao;
	
	@Override
	public int insertRanks(Map<String, Object> map) {
		log.info("RanksServiceImpl insertRanks 직급 등록 : {}",map);
		return dao.insertRanks(map);
	}

	@Override
	public int updateRanks(Map<String, Object> map) {
		log.info("RanksServiceImpl updateRanks 직급 수정 :{}",map);
		return dao.updateRanks(map);
	}

	@Override
	public int delRanks(Map<String, Object> map) {
		log.info("RanksServiceImpl delRanks 직급 삭제 :{}",map);
		return dao.delRanks(map);
	}

	@Override
	public List<RanksVo> searchRanks(Map<String, Object> map) {
		log.info("RanksServiceImpl searchRanks 직급 검색 :{}",map);
		return dao.searchRanks(map);
	}

	@Override
	public int duplicateRanks(Map<String, Object> map) {
		log.info("RanksServiceImpl duplicateRanks 직급명 중복 검사: {}",map);
		return dao.duplicateRanks(map);
	}

	@Override
	public List<RanksVo> ranksAll() {
		log.info("RanksServiceImpl ranksAll() 직급 전체 조회");
		return dao.ranksAll();
	}

}
