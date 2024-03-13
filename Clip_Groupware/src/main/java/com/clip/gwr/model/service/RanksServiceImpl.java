package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IRanksDao;
import com.clip.gwr.vo.DeptVo;

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
	public int delRanks(String ranks_seq) {
		log.info("RanksServiceImpl delRanks 직급 삭제 :{}",ranks_seq);
		return dao.delRanks(ranks_seq);
	}

	@Override
	public List<DeptVo> searchRanks(String ranks_name) {
		log.info("RanksServiceImpl searchRanks 직급 검색 :{}",ranks_name);
		return dao.searchRanks(ranks_name);
	}

	@Override
	public int duplicateRanks(String ranks_name) {
		log.info("RanksServiceImpl duplicateRanks 직급명 중복 검사: {}",ranks_name);
		return dao.duplicateRanks(ranks_name);
	}

}
