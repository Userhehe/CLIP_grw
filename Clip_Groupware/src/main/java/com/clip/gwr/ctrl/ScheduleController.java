package com.clip.gwr.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IMemoService;
import com.clip.gwr.model.service.IReservationService;
import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.NtcVo;
import com.clip.gwr.vo.PageVo;
import com.clip.gwr.vo.ReAttendsVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ScheduleController {
	
	@Autowired
	private IMemoService memoservice;
	@Autowired
	private IReservationService reservice;
	
	
	
	//화면 이동
	@GetMapping(value = "schedule.do")
	public String mainscheduel() {
		log.info("ScheduleController mainscheduel 달력조회");
		return "schedule";
	}
	

	
	
	//전체 조회
	@GetMapping(value = "/selectScheduleAll.do")
	@ResponseBody
	public JSONArray selectScheduleAll(HttpSession session, String date, String type){
	    log.info("화면에서 date값 : {}" + date);
	    log.info("화면에서 type값 : {}" + type);
	    Map<String, Object> map = new HashMap<String, Object>();
	    UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
	    map.put("user_id", id.getUser_id());
	    map.put("fullDate", date);

	    if (type != null && !type.isEmpty()) {
	        List<Integer> intList = new ArrayList<>();
	        String[] stringArray = type.split(",");
	        for (String str : stringArray) {
	            intList.add(Integer.parseInt(str));
	        }
	        map.put("type", intList);
	    } else {
	        return null;
	    }

	    log.info("Map 값 : {}" + map);

	    List<MemoVo> lists = memoservice.selectScheduleAll(map);
	    JSONArray memolist = new JSONArray();
	    for(MemoVo vo : lists) {
	        JSONObject obj = new JSONObject();
	        obj.put("seq", vo.getPrs_seq());
	        obj.put("title", vo.getPrs_title());
	        obj.put("start", vo.getPrs_start());
	        obj.put("end", vo.getPrs_end());
	        obj.put("user_id", vo.getUser_id());
	        memolist.add(obj);
	    }
	    System.out.println("넘겨줄 데이터"+memolist);
	    return memolist;
	}
	
	//상세 조회
	@PostMapping(value = "/calendarModalDetail.do") 
	@ResponseBody
	public Object memodetail(String seq, Model model) {
		log.info("ScheduleController memodetail 메모상세조회");
		log.info("화면에서 넘겨받은 seq값 {} : " , seq);
		
		MemoVo mVo = new MemoVo();
		NtcVo nVo = new NtcVo();
		ReservationVo rVo = new ReservationVo();
		ReAttendsVo atts = new ReAttendsVo();
		
		if(seq.indexOf("USER") == 0) {
			mVo = memoservice.myScheduleDetail(seq);
			log.info("전달받은 개인seq의 메모 : {}" , mVo);
			return mVo;
		}else if(seq.indexOf("NTC") == 0) {
			nVo = memoservice.ntcScheduleDetail(seq);
			log.info("전달받은 전사seq의 메모 : {}" , nVo);
			return nVo;
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			String numSeq = seq.replaceAll("\\D+", "");
	        int intSeq = Integer.parseInt(numSeq);
			rVo = reservice.reDetail(intSeq);
			atts = reservice.reAttList(intSeq);
			map.put("rVo", rVo);
			map.put("atts", atts);
			log.info("전달받은 예약seq의 메모 : {}" , rVo);
			log.info("전달받은 예약seq의 참석자 : {}" , atts);
			return map;
		}
	}
	
	
	//유저 기능
	//메모 추가
	@PostMapping(value = "/addMemo.do") 
	@ResponseBody
	public int addmemo(@RequestParam Map<String, Object> map, HttpSession session) {
		UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
		map.put("user_id", id.getUser_id());
		if(map.get("prs_end")== "") {
			map.put("prs_end", map.get("prs_start"));
		}
		log.info("메모 내용 {} : " , map);
		int isc = memoservice.myScheduleInsert(map);
		return isc;
	}
	
	//메모 삭제
	@PostMapping(value = "/myScheduleDelete.do")
	@ResponseBody
	public int myScheduleDelete(String seq) {
		int isc = memoservice.myScheduleDelete(seq);
		return isc;
	}
	
	//메모 수정
	@PostMapping(value = "/myScheduleUpdate.do")
	@ResponseBody
	public int myScheduleUpdate(@RequestParam Map<String, Object> map) {
		if(map.get("prs_end")== "") {
			map.put("prs_end", map.get("prs_start"));
		}
		log.info("메모 내용 {} : " , map);
		int isc = memoservice.myScheduleUpdate(map);
		return isc;
	}
	
	//유저기능 끝
	
	
	
	//관리자 기능
	//전사 추가
	@PostMapping(value = "/addNtc.do") 
	@ResponseBody
	public int addNtc(@RequestParam Map<String, Object> map, HttpSession session) {
		UserinfoVo id = (UserinfoVo)session.getAttribute("loginVo");
		map.put("user_id", id.getUser_id());
		if(map.get("ntc_end")== "") {
			map.put("ntc_end", map.get("ntc_start"));
		}
		log.info("전사 내용 {} : " , map);
		int isc = memoservice.ntcScheduleInsert(map);
		return isc;
	}
	
	//전사 삭제
	@PostMapping(value = "/ntcScheduleDelete.do")
	@ResponseBody
	public int ntcScheduleDelete(String seq) {
		int isc = memoservice.ntcScheduleDelete(seq);
		return isc;
	}
	
	//전사 수정
	@PostMapping(value = "/ntcScheduleUpdate.do")
	@ResponseBody
	public int ntcScheduleUpdate(@RequestParam Map<String, Object> map) {
		if(map.get("ntc_end")== "") {
			map.put("ntc_end", map.get("ntc_start"));
		}
		log.info("전사 내용 {} : " , map);
		int isc = memoservice.ntcScheduleUpdate(map);
		return isc;
	}
	
	//공지 사항
//	@GetMapping(value = "/nctBoard.do")
//	public String nctBoard(Model model) {
//		log.info("ScheduleController nctBoard 공지사항페이지 이동");
//		List<NtcVo> lists = memoservice.selectNtcBoard();
//		log.info("ScheduleController nctBoard 공지사항 내용 : {}",lists);
//		model.addAttribute("selectNtcBoard", lists);
//		return "nctBoard";
//	}
	
	
	@GetMapping(value = "/nctBoard.do")
	public String nctBoard(Model model,
	                        @RequestParam(required = false, defaultValue = "1") String page) {
		
	    log.info("nctBoard 현재페이지 : {}", page);
	    
	    // 페이징 정보 설정
	    PageVo pVo = new PageVo();
	    pVo.setCountList(5);
	    
	    // 현재 페이지 설정
	    int selectPage = Integer.parseInt(page);
	    
	    // 페이징에 필요한 맵 생성
	    Map<String, Object> map = new HashMap<String, Object>() {{
	        put("first", selectPage * pVo.getCountList() - (pVo.getCountList() - 1));
	        put("last", selectPage * pVo.getCountList());
	    }};
	    
	    // 게시글 전체값 조회
	    int totalCount = memoservice.selectNtcCount();
	    pVo.setTotalCount(totalCount);
	    pVo.setCountPage(5);
	    pVo.setTotalPage(totalCount);
	    pVo.setPage(selectPage);
	    pVo.setStagePage(selectPage);
	    pVo.setEndPage(pVo.getCountPage());
	    
	    // 게시글 페이지에 대한 정보 조회
	    List<NtcVo> lists = memoservice.selectNtcPage(map);
	    
	    // 모델에 데이터 저장
	    model.addAttribute("lists", lists);
	    model.addAttribute("page", pVo);
	    
	    return "nctBoard";
	}

}
