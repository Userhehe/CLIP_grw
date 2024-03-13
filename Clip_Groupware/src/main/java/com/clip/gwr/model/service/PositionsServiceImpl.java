package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IPositionsDao;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.PositionsVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PositionsServiceImpl implements IPositionsService {

	@Autowired
	private IPositionsDao dao;
	
	@Override
	public int insertPositions(Map<String, Object> map) {
		log.info("PositionsServiceImpl insertPositions 직책 등록 :{}",map);
		return dao.insertPositions(map);
	}

	@Override
	public int updatePositions(Map<String, Object> map) {
		log.info("PositionsServiceImpl updatePositions 직책 수정 :{}",map);
		return dao.updatePositions(map);
	}

	@Override
	public int delPosition(Map<String, Object>map) {
		log.info("PositionsServiceImpl delPosition 직책 삭제 :{}",map);
		return dao.delPosition(map);
	}

	@Override
	public List<PositionsVo> searchPosition(Map<String, Object>map) {
		log.info("PositionsServiceImpl searchPosition 직책 검색 :{}",map);
		return dao.searchPosition(map);
	}

	@Override
	public int duplicatePosItion(Map<String, Object>map) {
		log.info("PositionsServiceImpl duplicatePosItion 직책명 중복검색 :{}",map);
		return dao.duplicatePosItion(map);
	}

}
