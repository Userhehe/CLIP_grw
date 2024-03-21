package com.clip.gwr.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.clip.gwr.model.service.IApprovalService;
import com.clip.gwr.vo.ApprovalVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PayBoardController {
	
	@Autowired
	private IApprovalService service;

	//나의 요청결재 리스트 창 이동 매핑
	@GetMapping(value = "/myPayList.do")
	public String myPayList(Model model, HttpSession session) {
		log.info("myPayList 나의 결재요청 내역창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		List<ApprovalVo> lists = service.getAllApproval(user_id);
		model.addAttribute("lists",lists);
		return "myPayList";
	}
	
	
	//임시저장 결재 파일 리스트 창 이동
	@GetMapping(value = "/myTempPayList.do")
	public String myTempPayList(Model model, HttpSession session) {
		log.info("myTempPayList 나의 임시저장 결재파일 리스트 창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		List<ApprovalVo> lists = service.getTempApproval(user_id);
		model.addAttribute("lists",lists);
		return "myTempPayList";
	}
	
	
	//내 승인대기 결재 리스트 창 이동
	@GetMapping(value = "/myAcceptPayList.do")
	public String myAcceptPayList(Model model, HttpSession session) {
		log.info("myAcceptPayList 내가 결재자 지정된 결재리스트 내역창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		List<ApprovalVo> lists = service.getMyPaycheck(user_id);
		model.addAttribute("lists",lists);
		return "myAcceptPayList";
	}
	
	@GetMapping(value = "/myReferPayList.do")
	public String myReferPayList(Model model, HttpSession session) {
		log.info("myReferPayList 내가 참조된 결재리스트 내역창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		List<ApprovalVo> lists = service.selectReferApproval(user_id);
		model.addAttribute("lists",lists);
		return "myReferPayList";
	}
	
	
}
