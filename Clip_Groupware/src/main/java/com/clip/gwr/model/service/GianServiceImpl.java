package com.clip.gwr.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IGianDao;
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

}
