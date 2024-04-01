package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;
import com.clip.gwr.vo.DeptVo;
import com.clip.gwr.vo.UserinfoVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DeptController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDeptService service;
	
	@Autowired 
	private IRanksService ranksService;

	@GetMapping(value = "/department.do")
	public String department() {
		log.info("DeptController department 화면");
		return "departmentList";
	}
	
	@GetMapping(value = "/deptAll.do")
    public String deptAll(Model model) {
        log.info("DeptController 부서리스트 조회");
        List<DeptVo> lists = service.deptAll();
        model.addAttribute("lists", lists);
        return "departmentList"; 
    }

	@GetMapping(value = "/insertDept.do")
public String signUp() {
		log.info("부서 등록 화면 이동");
		return "insertDept";
	}

	@PostMapping(value = "/insertDept.do")
	public String insertDept(@RequestParam("dept_name") String dept_name, HttpSession session, Model model) {
		session.setAttribute("dept_name", dept_name);
		log.info("#### dept_name : " + dept_name);

		Map<String, Object> map = new HashMap<>();
		map.put("dept_name", dept_name);

		int insertedRows = service.insertDept(map);
		if (insertedRows > 0) {
		model.addAttribute("successMessage", "부서가 성공적으로 등록되었습니다.");
		} else {
			model.addAttribute("errorMessage", "부서 등록 중 오류가 발생했습니다.");
		}
		return "departmentList";
	}

	@PostMapping(value = "/updateDept.do")
	public String updateDept(@RequestParam("dept_seq") String dept_seq, @RequestParam("dept_name") String newDeptName,
			RedirectAttributes redirectAttributes) {
		Map<String, Object> map = new HashMap<>();
		map.put("dept_seq", dept_seq);
		map.put("newDeptName", newDeptName);

		int updatedRows = service.updateDept(map);

	if (updatedRows > 0) {
			redirectAttributes.addFlashAttribute("successMessage", "부서가 성공적으로 수정되었습니다.");
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "부서 수정 중 오류가 발생했습니다.");
		}

		return "departmentList";
	}

	@PostMapping(value = "/delDept.do")
	public String delDept(@RequestParam("dept_seq") String dept_seq, Model model) {
		log.info("DeptController delDept POST");

		int deletedRows = service.delDept(dept_seq);
		if (deletedRows > 0) {
			model.addAttribute("successMessage", "부서가 성공적으로 삭제되었습니다.");
		} else {
			model.addAttribute("errorMessage", "부서 삭제 중 오류가 발생했습니다.");
		}

		return "departmentList";
	}

	@GetMapping(value = "/searchDept.do")
	public String searchDept(Model model, @RequestParam("dept_name") String dept_name) {

		log.info("DeptController searchDept GET : {}", dept_name);
		try {
			List<DeptVo> lists2 = service.searchDept(dept_name);
		model.addAttribute("departments", lists2);
		} catch (Exception e) {
			log.error("부서 검색 중 오류가 발생했습니다", e);
		model.addAttribute("errorMessage", "부서 검색 중 오류가 발생했습니다. 나중에 다시 시도해주세요.");
		}
	return "departmentList";
	}

	@GetMapping(value = "/duplicateCheckDept.do")
	public String duplicateCheckDept(@RequestParam("dept_name") String dept_name, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("dept_name", dept_name);

	int result = service.duplicateCheckDept(map);

		if (result == 1) {
			model.addAttribute("errorMessage", "이미 존재하는 부서명입니다.");
		} else {
		model.addAttribute("successMessage", "사용 가능한 부서명입니다.");
		}
	return "departmentList";
	}
}
