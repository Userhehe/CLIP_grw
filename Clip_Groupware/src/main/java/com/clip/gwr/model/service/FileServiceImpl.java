package com.clip.gwr.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IFileDao;

@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	private IFileDao dao;
	
	@Override
	public int insertFile(Map<String, Object> map) {
		System.out.println("FileServiceImpl insertFile ");
		return dao.insertFile(map);
	}

}
