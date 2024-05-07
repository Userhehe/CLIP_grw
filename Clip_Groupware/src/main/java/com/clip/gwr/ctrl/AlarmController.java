package com.clip.gwr.ctrl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clip.gwr.model.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AlarmController{
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/ntcAlarm.do")
	public List<String> ntcAlarm() {
		//전체유저 아이디
		List<String> idList = userService.selectAllUser();
		
		return idList;
	}
}
