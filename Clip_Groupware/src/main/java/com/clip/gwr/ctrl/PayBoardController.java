package com.clip.gwr.ctrl;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.clip.gwr.vo.PageVo;
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
	public String myTempPayList(Model model, HttpSession session,  @RequestParam(required = false, defaultValue = "1") String page) {
		log.info("myTempPayList 나의 임시저장 결재파일 리스트 창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		
		//페이징 정보설정
		PageVo pVo = new PageVo();
		pVo.setCountList(5);
		
		// 현재 페이지 설정
	    int selectPage = Integer.parseInt(page);
	    
	    // 페이징에 필요한 맵 생성
	    Map<String, Object> map = new HashMap<String, Object>() {{
	        put("first", selectPage * pVo.getCountList() - (pVo.getCountList() - 1));
	        put("last", selectPage * pVo.getCountList());
	        put("user_id",user_id);
	    }};
	    
	 // 게시글 전체값 조회
	    int totalCount = service.selectTempCount(user_id);
	    pVo.setTotalCount(totalCount);
	    pVo.setCountPage(5);
	    pVo.setTotalPage(totalCount);
	    pVo.setPage(selectPage);
	    pVo.setStagePage(selectPage);
	    pVo.setEndPage(pVo.getCountPage());
		
		List<ApprovalVo> lists = service.selectTempPage(map);
		model.addAttribute("lists",lists);
		model.addAttribute("page", pVo);
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
	
	//내 승인대기 결재 상세페이지로 이동.
	@PostMapping(value="/myAcceptPayList.do")
	@ResponseBody
	public ApprovalVo myPayList(@RequestParam("app_seq") String app_seq) {
		log.info("myPayList myPayList 결재내역 상세보기 : {}",app_seq);
		ApprovalVo vo =service.oneMyPaycheck(app_seq);
		return vo;
	}
	
	
	//내 승인대기 결재 상세페이지로 이동.
	@PostMapping(value="/myAcceptPayListChecked.do")
	@ResponseBody
	public ApprovalVo myPayCheckList(@RequestParam("app_seq") String app_seq,HttpSession session) {
		log.info("내가 승인했던거 조회 : {} ",app_seq);
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("app_seq", app_seq);
		ApprovalVo vo =service.oneMyPaychecked(map);
		return vo;
	} 
	
	//내가 반려한 결재 조회페이지로 이동.
	@PostMapping(value="/myAcceptPayListPause.do")
	@ResponseBody
	public ApprovalVo myPayCheckPause(@RequestParam("app_seq") String app_seq) {
		log.info("내가 반려했던거 조회 : {}",app_seq);
		ApprovalVo vo =service.oneMyPayPause(app_seq);
		return vo;
	}
	

	//본인 승인시 결재승인할 경우
	@PostMapping(value = "/okPay.do")
	public String okPay(@RequestParam("app_seq") String app_seq, HttpSession session) {
	    log.info("okPay 승인자 승인해주는 경우 : {}", app_seq);

	    UserinfoVo loginUser = (UserinfoVo) session.getAttribute("loginVo");
	    String user_id = loginUser.getUser_id();
	    System.out.println("사용자 ID:" + user_id);

	    // 결재 정보 확인
	    ApprovalVo vo = service.oneMyPaycheck(app_seq);
	    System.out.println("################결재라인 번호확인:" + vo.getPay_num());
	    System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆결재라인 담당자확인:" + vo.getPay_user());
	    System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆결재라인 서명:" + vo.getPay_sign());
	    System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆결재코드 :" + vo.getApp_seq());
	    
	    String app_draft = vo.getApp_draft();
	    String pay_num = null;

	    if ("결재대기".equals(app_draft) && "1".equals(vo.getPay_num())) {
	        app_draft = "결재진행";
	        pay_num = "1";
	    } else if ("결재진행".equals(app_draft) && "2".equals(vo.getPay_num())) {
	        pay_num = "2";
	    }else if ("결재진행".equals(app_draft) && "3".equals(vo.getPay_num())) {
	        pay_num = "3";
	    }else if ("결재진행".equals(app_draft) && "4".equals(vo.getPay_num())) {
	        pay_num = "4";
	    }else if ("결재진행".equals(app_draft) && "5".equals(vo.getPay_num())) {
	        pay_num = "5";
	    }else {
	        return "redirect:/accessError.do";
	    }

	    service.approvePay(app_draft,app_seq);
	    service.approvePayLine(app_seq,pay_num);
	    return "redirect:/myAcceptPayList.do";
	}

	//본인 승인시 결재반려할 경우//
	@PostMapping(value="/rejectionPay.do")
	public String rejectPay(@RequestParam("app_seq")String app_seq,@RequestParam("pay_rejectreason")String pay_rejectreason,HttpSession session){
		log.info("rejectPay 내가 승인하는데 싫어서 결재 반려하는 경우 : {}",app_seq);
		 UserinfoVo loginUser = (UserinfoVo) session.getAttribute("loginVo");
		 String user_id = loginUser.getUser_id();
	     System.out.println("사용자 ID:" + user_id);
	
	     // 결재 정보 확인
	     ApprovalVo vo = service.oneMyPaycheck(app_seq);
	     System.out.println("################결재라인 번호확인:" + vo.getPay_num());
	     System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆결재라인 담당자확인:" + vo.getPay_user());
	     System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆결재라인 서명:" + vo.getPay_sign());
	     System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆결재코드 :" + vo.getApp_seq());
	     System.out.println("◆◆◆◆◆◆◆◆◆◆◆◆◆◆거절사유 :" + pay_rejectreason);
	     
	     String app_draft = vo.getApp_draft();
	     String pay_num = vo.getPay_num();
	     String pay_user = null;
	    
	     if (("결재대기".equals(app_draft) || "결재진행".equals(app_draft)) && "1".equals(vo.getPay_num())) {
	    	    pay_num = "1";
	    	    pay_user = vo.getPay_user();
	    	} else if ("결재진행".equals(app_draft) && "2".equals(vo.getPay_num())) {
	    	    pay_num = "2";
	    	    pay_user = vo.getPay_user();
	    	} else if ("결재진행".equals(app_draft) && "3".equals(vo.getPay_num())) {
	    	    pay_num = "3";
	    	    pay_user = vo.getPay_user();
	    	} else if ("결재진행".equals(app_draft) && "4".equals(vo.getPay_num())) {
	    	    pay_num = "4";
	    	    pay_user = vo.getPay_user();
	    	} else if ("결재진행".equals(app_draft) && "5".equals(vo.getPay_num())) {
	    	    pay_num = "5";
	    	    pay_user = vo.getPay_user();
	    	} else {
	    	    return "redirect:/accessError.do";
	    	}

	    	service.banRuApproval(app_seq);
	    	service.banRuPayLine(pay_rejectreason, app_seq, pay_num, pay_user);


			 return "redirect:/myAcceptPayList.do";
	}
	
	@GetMapping(value = "/myReferPayList.do")
	public String myReferPayList(Model model, HttpSession session) {
		log.info("myReferPayList 내가 참조된 결재리스트 내역창");
		UserinfoVo loginUser = (UserinfoVo)session.getAttribute("loginVo");
		String user_id = loginUser.getUser_id();
		System.out.println("참조아이디:"+user_id);
		List<ApprovalVo> lists = service.selectReferApproval(user_id);
		model.addAttribute("lists",lists);
		System.out.println("담겨있는 리스트 : "+lists);
		return "myReferPayList";
	}
	
}