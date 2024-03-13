package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IUserDao;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao dao;

	/**
	 * 사원목록전체조회
	 */
	@Override
	public List<UserinfoVo> selectUserinfoList() {
		log.info("UserServiceImpl selectUserinfoList 사원목록전체조회");
		return dao.selectUserinfoList();
	}
	
	/**
	 * 사원정보등록
	 */
	@Override
	public int insertUserinfo(Map<String, Object> map) {
		log.info("UserServiceImpl insertUserinfo 사원정보등록");
		return dao.insertUserinfo(map);
	}

	/**
	 * 사원정보수정
	 */
	@Override
	public int updateUserinfo(Map<String, Object> map) {
		log.info("UserServiceImpl updateUserinfo 사원정보수정");
		return dao.updateUserinfo(map);
	}
	
}
