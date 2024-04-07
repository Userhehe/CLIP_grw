package com.clip.gwr.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IReferenceDao;
import com.clip.gwr.vo.ReferenceVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReferenceServiceImpl implements IReferenceService {

	@Autowired
	private IReferenceDao referenceDao;
	
	
	@Override
	public List<ReferenceVo> getReferenceAll(String app_seq) {
		log.info("ReferenceServiceImpl getReferenceAll 참조정보 가져오기 : {}", app_seq);
		return referenceDao.getReferenceAll(app_seq);
	}

}
