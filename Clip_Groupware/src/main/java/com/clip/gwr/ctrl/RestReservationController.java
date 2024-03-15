package com.clip.gwr.ctrl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clip.gwr.model.service.IReservationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestReservationController {
	
	@Autowired
	private IReservationService service;
	

}
