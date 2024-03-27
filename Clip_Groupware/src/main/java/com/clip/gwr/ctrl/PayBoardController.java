package com.clip.gwr.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	//나의 요청결재 리스트에서 상세페이지로 이동.
	@PostMapping(value="/myPayList.do")
	@ResponseBody
	public ApprovalVo selectMyPayList(@RequestParam("app_seq") String app_seq) {
		log.info("myPayList selectMyPayList 결재내역 상세보기 : {}",app_seq);
		ApprovalVo vo =service.getOneApproval(app_seq);
		return vo;
	}
	@GetMapping(value = "/cancelPay.do")
	public String cancelPay(@RequestParam("app_seq") String app_seq , HttpSession session , HttpServletResponse resp) throws IOException {
		log.info("myTempPayList cancelPay 결재취소 : {}",app_seq);
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		int n = service.cancelApproval(app_seq);
		if(n>0) {
			out.println("<script language='javascript'>");
			out.println("alert('결재를 성공적으로 취소하였습니다.');");
			out.println("window.location.href='./myPayList.do';");
			out.println("</script>");
			out.flush();		
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('이용에 불편을 드려 죄송합니다.잠시후 다시 시도해주십시요.');");
			out.println("window.location.href='./myPayList.do';");
			out.println("</script>");
			out.flush();
		}
		return null;
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
	
	//임시저장 결재 리스트에서 모달창으로 이동.
	@PostMapping(value="/myTempPayList.do")
	@ResponseBody
	public ApprovalVo selectMyTempPayList(@RequestParam("app_seq")String app_seq) {
		log.info("myTempPayList selectMyTempPayList 나의 임시저장 결재파일 상세 모달창 : {}",app_seq);
		ApprovalVo vo =  service.getOneApproval(app_seq);
		return vo;
	}
	
	//임시저장된 결재 삭제
	@GetMapping(value="/myTempDelete.do")
	public String myTempDel(@RequestParam("app_seq") String app_seq ,HttpServletResponse resp) throws IOException {
		log.info("myTempDel 임시저장 결재 삭제 : {} ",app_seq);
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script language='javascript'>");
		out.println("alert('임시저장된 결재를 하시겠습니까?');");
		
		int n = service.tempDelete(app_seq);
		
		if(n>0) {
			out.println("alert('삭제가 정상적으로 처리되었습니다.');");
			out.println("window.location.href='./myTempPayList.do';");
			out.println("</script>");
			out.flush();	
		}else {
			out.println("alert('오류입니다.다시 접속하여주십시오.');");
			out.println("window.location.href='./myTempPayList.do';");
			out.println("</script>");
			out.flush();	
		}
		return null;
	}
	
	//내 승인대기 결재 리스트 창 이동
	@GetMapping(value = "/myAcceptPayList.do")
	public String myAcceptPayList(Model model, HttpSession session) {
		log.info("myAcceptPayList 내가 결재자 지정된 결재리스트 내역창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		List<ApprovalVo> lists = service.getMyPaycheck(user_id);
		List<ApprovalVo> lists2 =service.getMyUnprocessedPaycheck(user_id);
		List<ApprovalVo> lists3=service.getMyRejectPay(user_id);
		model.addAttribute("lists",lists);
		model.addAttribute("lists2",lists2);
		model.addAttribute("lists3",lists3);
		return "myAcceptPayList";
	}
	
	//결재승인시 현황 정보에 따른 수정
	
	
	
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
