package com.clip.gwr.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IApprovalService;
import com.clip.gwr.model.service.IGianService;
import com.clip.gwr.model.service.IPaymentlineService;
import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.ApprovalVo;
import com.clip.gwr.vo.GianVo;
import com.clip.gwr.vo.PaymentlineVo;
import com.clip.gwr.vo.UserinfoVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import aj.org.objectweb.asm.Type;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Slf4j
public class PayController {

	@Autowired
	private IGianService service;

	@Autowired
	private IReservationService reservationService;

	@Autowired
	private IApprovalService approvalService;
	
	@Autowired
	private IPaymentlineService paymentlineService;

	//결재 신청 페이지 이동
	@GetMapping(value = "/payRegister.do")
	public String payRegister(HttpServletResponse resp, Model model, HttpSession session) throws IOException {
		log.info("PayController payRegister 결재신청 페이지");
		UserinfoVo loginUser = (UserinfoVo) session.getAttribute("loginVo");

		String user_name = loginUser.getUser_name();
		String dept_name = loginUser.getDept_name();
		String ranks_name = loginUser.getRanks_name();
		System.out.println("로그인한 정보:" + user_name + "," + dept_name + "," + ranks_name);

		model.addAttribute("user_name", user_name);
		model.addAttribute("dept_name", dept_name);
		model.addAttribute("ranks_name", ranks_name);

		String[] templateIds = { "GIAN_1", "GIAN_2", "GIAN_3" };
		for (int i = 0; i < templateIds.length; i++) {
			GianVo vo = service.templateDetail(templateIds[i]);
			model.addAttribute("vo" + i, vo);
		}

		GianVo vo1 = service.templateDetail("GIAN_1");
		GianVo vo2 = service.templateDetail("GIAN_2");
		GianVo vo3 = service.templateDetail("GIAN_3");
		model.addAttribute("vo1", vo1);
		model.addAttribute("vo2", vo2);
		model.addAttribute("vo3", vo3);
		return "payRegister";
	}

	

	@GetMapping(value = "/myPaySelect.do")
	public String myPaySelect() {
		log.info("PayController myPaySelect 내 결재조회 페이지");
		return "myPaySelect";
	}

	
	
	// 결재 요청
	@PostMapping(value = "/myPayInsert.do")
	@ResponseBody
	public String myPayInsert(@RequestBody Map<String, Object> approvalVo){
		log.info("PayController myPayInsert 결재작성 post {}", approvalVo);

		System.out.println(approvalVo.get("ApprovalVo"));
		System.out.println((List <Map<String, String>>) approvalVo.get("PaymentlineVoList"));
	
		Map<String, String> appMap = (Map<String, String>) approvalVo.get("ApprovalVo");
		ApprovalVo reqApproval = new ApprovalVo();
		reqApproval.setUser_id(appMap.get("user_id"));
		reqApproval.setApp_title(appMap.get("app_title"));
		reqApproval.setApp_content(appMap.get("app_content"));
		reqApproval.setGian_seq(appMap.get("gian_seq"));
		reqApproval.setApp_strdate(appMap.get("app_strdate"));
		reqApproval.setApp_enddate(appMap.get("app_enddate"));
		
//		System.out.println(reqApproval);
		
		List<PaymentlineVo> payList = new ArrayList<PaymentlineVo>();
		for (Map<String, String> obj : (List <Map<String, String>> ) approvalVo.get("PaymentlineVoList")) {
			PaymentlineVo vo = new PaymentlineVo();
			vo.setPay_num(Integer.parseInt(obj.get("pay_num")));
			vo.setPay_user(obj.get("pay_user"));
//			System.out.println(obj.get("pay_num"));
//			System.out.println(obj.get("pay_user"));
			payList.add(vo);
		}
		
//		System.out.println("지정된 결재인 : " + payList);

		// 받은 json을 뜯고 서비스 돌리기
		boolean result = approvalService.reqDynamicDateApproval(reqApproval, payList);
		
		if(result) {
			return "success";
		} else {
			return "fail";
		}

	}

	// 임시저장
	@PostMapping(value = "/myTempInsert.do")
	@ResponseBody
	public String tempSave(@RequestBody Map<String, Object> jsonMap) {
		
		Map<String, String> appMap = (Map<String, String>) jsonMap.get("ApprovalVo");
		ApprovalVo reqApproval = new ApprovalVo();
		reqApproval.setUser_id(appMap.get("user_id"));
		reqApproval.setApp_title(appMap.get("app_title"));
		reqApproval.setApp_content(appMap.get("app_content"));
		reqApproval.setGian_seq(appMap.get("gian_seq"));
		

		List<PaymentlineVo> payList = new ArrayList<PaymentlineVo>();
		for (Map<String, String> obj : (List <Map<String, String>> ) jsonMap.get("PaymentlineVoList")) {
			PaymentlineVo vo = new PaymentlineVo();
			vo.setPay_num(Integer.parseInt(obj.get("pay_num")));
			vo.setPay_user(obj.get("pay_user"));
//			System.out.println(obj.get("pay_num"));
//			System.out.println(obj.get("pay_user"));
			payList.add(vo);
		}
		
		boolean result = approvalService.saveTempApproval(reqApproval, payList);
		if(result) {
			return "success";
		} else {
			return "fail";
		}
		
		
	}
	
	//임시저장 결재 서류 이어 작성하기.
	@GetMapping("/continuePay.do")
	public String continuePay(Model model, String app_seq) {
		log.info("PayController continuePay 임시저장서류 이어 작성하기 이동 {}", app_seq);
		ApprovalVo approvalVo = approvalService.getOneApproval(app_seq);
		List<PaymentlineVo> lineList = paymentlineService.getApprovalPayLine(app_seq);
		
		model.addAttribute("approvalVo", approvalVo);
		model.addAttribute("lineList", lineList);
		
		return "continuePay";
		
	}
	
	//결재대기중인 결재 수정
	@PostMapping(value = "/fixWating.do")
	@ResponseBody
	public String fixWating(@RequestBody String jsonMap) {
		log.info("PayController fixReq 반려서류 수정하여 재요청 {}", jsonMap);
		
		
		Gson gson = new GsonBuilder().create();
		ApprovalVo approvalVo = gson.fromJson(jsonMap, ApprovalVo.class);
		
		int result = approvalService.fixWatingApproval(approvalVo);
		
		System.out.println("json에서 객체로 : " + approvalVo);
		
		if(result == 1) {
			return "success";
		}
		else{
			return "fail";
		}
	}


	//반려 결재 수정 
	@PostMapping(value = "/fixReq.do")
	@ResponseBody
	public String fixReq(@RequestBody String jsonMap) {
		log.info("PayController fixReq 반려서류 수정하여 재요청 {}", jsonMap);
		
		
		Gson gson = new GsonBuilder().create();
		ApprovalVo approvalVo = gson.fromJson(jsonMap, ApprovalVo.class);
		String seq = approvalVo.getApp_seq();
		
		System.out.println("받은 데이터에서 GSON으로 객체로 변환한 것 : " + approvalVo);
		
		int result = approvalService.fixReqApproval(approvalVo, seq);
		
		if(result == 1) {
			return "success";
		}
		else{
			return "fail";
		}
		
	}
	
	
	
	
	
	@GetMapping(value = "/templateDelete.do")
	public String gianDelete(HttpServletResponse resp, @RequestParam("gian_seq") String gian_seq) throws IOException {
		log.info("PayController gianDelete POST:{}", gian_seq);
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script language='javascript'>");
		out.println("alert('삭제를 완료하였습니다.');");
		int n = service.templateDelete(gian_seq);
		out.println("window.location.href='./paytemplate.do';");
		out.println("</script>");
		out.flush();
		return null;
	}

	@GetMapping(value = "/templateReasearch.do")
	public String templateSelect(Model model, @RequestParam("gian_name") String gian_name) {
		log.info("PayController templateSelect GET :{}", gian_name);
		List<GianVo> lists2 = service.templateNameSel(gian_name);
		model.addAttribute("lists2", lists2);
		return "paytemplate";
	}

	@GetMapping(value = "/paytemplate.do")
	public String payTemplate(Model model) {
		log.info("PayController 기안서 양식관리 페이지");
		List<GianVo> lists = service.templateAll();
		model.addAttribute("lists", lists);
		return "gianList";
	}

	@GetMapping(value = "/gianDetail.do")
	public String gianDetail(Model model, HttpServletRequest request) {
		log.info("PayController 기안서 양식 조회 페이지 ");
		String seq = request.getParameter("gian_seq");
		GianVo vo = service.templateDetail(seq);
		model.addAttribute("vo", vo);
		return "gianDetail";
	}

	@GetMapping(value = "/gianInsert.do")
	public String gianInsert(HttpSession session, Model model) {
		log.info("PayController 기안서 양식 추가 페이지 GET ");
		UserinfoVo loginUser = (UserinfoVo) session.getAttribute("loginVo");
		String user_name = loginUser.getUser_name();
		String dept_name = loginUser.getDept_name();
		model.addAttribute("user_name", user_name);
		model.addAttribute("dept_name", dept_name);
		return "gianInsert";
	}

	@PostMapping(value = "/gianInsert.do")
	public String gianInsertPost(@RequestParam("gian_gubun") String gian_gubun,
			@RequestParam("gian_name") String gian_name, @RequestParam("gian_modifier") String gian_modifier,
			@RequestParam("gian_html") String gian_html) {
		log.info("PayController 기안서 양식 추가 페이지 POST:{} {} {} {} ", gian_gubun, gian_name, gian_modifier, gian_html);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gian_gubun", gian_gubun);
		map.put("gian_name", gian_name);
		map.put("gian_html", gian_html);
		map.put("gian_modifier", gian_modifier);
		int n = service.tempateInsert(map);
		return "redirect:/paytemplate.do";
	}

	@GetMapping(value = "/gianModify.do")
	public String gianModify(Model model, HttpServletRequest request) {
		log.info("PayController gianModify GET");
		String seq = request.getParameter("gian_seq");
		GianVo vo = service.templateDetail(seq);
		model.addAttribute("vo", vo);
		return "gianModify";
	}

	@PostMapping(value = "/gianMod.do")
	public String gianModify(@RequestParam("gian_seq") String gian_seq, @RequestParam("gian_html") String gianhtml,
			HttpServletResponse resp) throws IOException {
		log.info("PayController gianModify POST : {}", gianhtml);
		System.out.println("$$$$$$$$gian_seq:" + gian_seq);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gian_html", gianhtml);
		map.put("gian_seq", gian_seq);
		int n = service.templateUpdate(map);
		if (n == 1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script language='javascript'>");
			out.println("window.location.href='./paytemplate.do';");
			out.println("</script>");
			out.flush();
		}
		return "redirect:/paytemplate.do";
	}

//	jstree 결재라인 테스트용
	@GetMapping(value = "/payLine.do")
	public String paylineTest(Model model) {
		log.info("PayController paylineTest 결재라인 지정 페이지...");
		return "payLine";
	}

	// ajax 데이터 가져오기
	@GetMapping(value = "/getTree.do")
	@ResponseBody
	public String getPayLine() {
		log.info("PayController getPayLine 결재라인 지정 페이지...");
		List<UserinfoVo> list = reservationService.selectAttendsJstree();

		log.info("모든 사원 가져온 값 : {}", list);
		Gson gson = new GsonBuilder().create();
		String treeResult = gson.toJson(list);
		log.info("가져온 사원 리스트를 제이슨 형태로 바꾼 형태 : {}", treeResult);
		return treeResult;
	}

}
