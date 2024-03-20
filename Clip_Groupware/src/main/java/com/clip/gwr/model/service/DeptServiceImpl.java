package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IDeptDao;
import com.clip.gwr.vo.DeptVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao dao;
	
	//부서 등록 
	@Override
	public int insertDept(Map<String, Object> map) {
		log.info("DeptServiceImpl insertDept 부서 등록 :{}",map);
		return dao.insertDept(map);
	}
    // 부서 수정
	@Override
	public int updateDept(Map<String, Object> map) {
		log.info("DeptServiceImpl updateDept 부서 수정 : {}",map);
		return dao.updateDept(map);
	}
    //부서 삭제 
	@Override
	public int delDept(Map<String, Object> map) {
		log.info("DeptServiceImpl delDept 부서 삭제 : {}",map);
		return dao.delDept(map);
	}
    // 부서 검색 
	@Override
	public List<DeptVo> searchDept(Map<String, Object> map) {
		log.info("DeptServiceImpl searchDept 부서 검색 :{}",map);
		return dao.searchDept(map);
	}
    //부서 중복 검사 
	@Override
	public int duplicateCheckDept(Map<String, Object> map) {
		log.info("DeptServiceImpl duplicateCheckDept 부서 중복 검사 : {} ",map);
		return dao.duplicateCheckDept(map);
	}

}
