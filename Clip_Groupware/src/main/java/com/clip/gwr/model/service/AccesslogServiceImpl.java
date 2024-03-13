package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IAccesslogDao;
import com.clip.gwr.vo.AccesslogVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccesslogServiceImpl implements IAccesslogService {

	@Autowired
	private IAccesslogDao dao;
	
	@Override
	public int insertUserLog(Map<String, Object> map) {
		log.info("AccesslogServiceImpl insertUserLog 사용자접속로그 등록 :{}",map);
		return dao.insertUserLog(map);
	}

	@Override
	public List<AccesslogVo> selectUserLog(Map<String, Object> map) {
		log.info("AccesslogServiceImpl selectUserLog 사용자접속로그 조회 :{}",map);
		return dao.selectUserLog(map);
	}

	@Override
	public List<AccesslogVo> searchUserLog(Map<String, Object> map) {
		log.info("AccesslogServiceImpl searchUserLog 사용자접속로그 검색 :{}",map);
		return dao.searchUserLog(map);
	}

}
