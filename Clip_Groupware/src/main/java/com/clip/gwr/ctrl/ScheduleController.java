package com.clip.gwr.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IMemoService;
import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ScheduleController {
	
	@Autowired
	private IMemoService memoservice;

	@GetMapping(value = "schedule.do")
	public String mainscheduel() {
		log.info("ScheduleController mainscheduel 달력조회");
		return "schedule";
	}
	
	@GetMapping(value = "/Ajax.do")
	@ResponseBody
	public JSONArray date(Model model, HttpSession session) {
		UserinfoVo id = (UserinfoVo)session.getAttribute("UserVo");
		log.info("session에서 받은값" + id);
		JSONArray memolist = new JSONArray();
		List<MemoVo> lists = memoservice.myScheduleAll(id.getUser_id());
		System.out.println("MemoVo list : " +lists);
		for(MemoVo vo : lists) {
			JSONObject obj = new JSONObject();
			obj.put("prs_seq", vo.getPrs_seq());
			obj.put("prs_title",vo.getPrs_title());
			obj.put("prs_content",vo.getPrs_content());
			obj.put("prs_create",vo.getPrs_create());
			obj.put("prs_start",vo.getPrs_start());
			obj.put("prs_end",vo.getPrs_end());
			memolist.add(obj);
			
		}
		System.out.println("넘겨줄 데이터"+memolist);
		return memolist;
		
		
	}
}
