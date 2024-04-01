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
	public int insertAnn(Map<String, Object> map) {
		log.info("AnnualServiceImpl insertAnn 연차등록 (사원 등록시)");
		return dao.insertAnn(map);
	}

	@Override
	public int insertAnnualUp(String user_id) {
		log.info("AnnualServiceImpl insertAnnualUp 1달마다 연차 등록");
		return dao.insertAnnualUp(user_id);
	}

	@Override
	public List<AnnualVo> annAll() {
		log.info("AnnualServiceImpl annAll 연차전체 조회");
		return dao.annAll();
	}

	@Override
	public AnnualVo detailAnn(String user_id) {
		log.info("AnnualServiceImpl detailAnn 연차 상세 조회");
		return dao.detailAnn(user_id);
	}

	@Override
	public int updateAnn(Map<String, Object> map) {
		log.info("AnnualServiceImpl updateAnn 연차 수정");
		return dao.updateAnn(map);
	}

	@Override
	public int resetAnn(Map<String, Object> map) {
		log.info("AnnualServiceImpl resetAnn 1년마다 연차 초기화 ");
		return dao.resetAnn(map);
	}

	@Override
	public int resetAnnualUse(Map<String, Object> map) {
		log.info("AnnualServiceImpl resetAnnualUse 1년마다 사용연차 초기화 ");
		return dao.resetAnnualUse(map);
	}
	
	@Override
	public List<AnnualVo> searchAnnual(Map<String, Object> map) {
		log.info("AnnualServiceImpl searchAnnual  연차검색 ");
		return dao.searchAnnual(map);
	} 

	@Override
	public int chkAnn(String user_id) {
		log.info("AnnualServiceImpl chkAnn 연차 데이터 존재 유무 확인 ");
		return dao.chkAnn(user_id);
	}

	@Override
	public int selAnnLe(String user_id) {
		log.info("AnnualServiceImpl selAnnLe  데이터 잔여 일수 조회 ");
		return dao.selAnnLe(user_id);
	}

	@Override
	public int applyAnn(Map<String, Object> map) {
		log.info("AnnualServiceImpl applyAnn  데이터 없을경우 연차신청 ");
		return dao.applyAnn(map);
	}

	@Override
	public int selAvaliday(String user_id) {
		log.info("AnnualServiceImpl selAvaliday  사용가능일수 조회 ");
		return dao.selAvaliday(user_id);
	}

	@Override
	public int applyUpdateAnn(String user_id) {
		log.info("AnnualServiceImpl applyUpdateAnn  연차신정(update) ");
		return dao.applyUpdateAnn(user_id);
	}
	

}
