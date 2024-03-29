package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IGianDao;
import com.clip.gwr.vo.GianMarkVo;
import com.clip.gwr.vo.GianVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GianServiceImpl implements IGianService {
	
	@Autowired
	private IGianDao dao;
	
	@Override
	public List<GianVo> templateAll() {
		log.info("GianServiceImpl templateAll 기안서 전체조회");
		return dao.templateAll();
	}

	@Override
	public GianVo templateDetail(String gian_seq) {
		log.info("GianServiceImpl templateDetail 기안서양식 상세조회 :{}",gian_seq);
		return dao.templateDetail(gian_seq);
	}

	@Override
	public int tempateInsert(Map<String,Object>map) {
		log.info("GianServiceImpl tempateInsert 기안서양식 추가 : {}",map);
		return dao.tempateInsert(map);
	}

	@Override
	public int templateUpdate(Map<String,Object>map) {
		log.info("GianServiceImpl tempateInsert 기안서양식 수정 : {}",map);
		return dao.templateUpdate(map);
	}

	@Override
	public List<GianVo> templateGubunSel() {
		log.info("GianServiceImpl templateGubunSel 기안식양식 구분별 조회");
		return dao.templateGubunSel();
	}

	@Override
	public List<GianVo> templateNameSel(String gian_name) {		
		log.info("GianServiceImpl templateNameSel 기안식양식 이름별 조회 : {}",gian_name);
		return dao.templateNameSel(gian_name);
	}

	@Override
	public int templateDelete(String gian_seq) {
		log.info("GianServiceImpl templateDelete 기안식양식 삭제 : {}",gian_seq);
		return dao.templateDelete(gian_seq);
	}

	@Override
	public List<GianVo> mySeletTemplate(String user_Id) {
		log.info("GianServiceImpl mySeletTemplate 즐겨찾기한 기안서 양식 리스트 조회 ",user_Id);
		return dao.mySeletTemplate(user_Id);
	}

	@Override
	public int myInsert(Map<String, Object> map) {
		log.info("GianServiceImpl myInsert 기안서즐겨찾기 추가 : {}",map);
		return dao.myInsert(map);
	}

	@Override
	public int myDel(String gian_seq,String user_id) {
		log.info("GianServiceImpl myDel 즐겨찾기 삭제: {} {}",gian_seq,user_id);
		return dao.myDel(gian_seq,user_id);
	}

}
