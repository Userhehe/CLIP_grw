package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.ISignsDao;
import com.clip.gwr.vo.SignsVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SignsServiceImpl implements ISignService {
	 
	@Autowired
	private ISignsDao dao;

	@Override
	public int insertPad(Map<String, Object> map) {
		log.info("SignsServiceImpl insertPad 서명 등록 : {}",map);
		return dao.insertPad(map);
	}

	@Override
	public int delPad(Map<String, Object> map) {
		log.info("SignsServiceImpl delPad 서명 삭제 : {}",map);
		return dao.delPad(map);
	}

	@Override
//	public List<SignsVo> selectPad(String userId) {
	public SignsVo selectPad(String userId) {
		log.info("SignsServiceImpl selectPad 서명 조회 : {}",userId);
		return dao.selectPad(userId);
	}

	@Override
	public List<SignsVo> AllselectPad() {
		return dao.AllselectPad();
	}

}
