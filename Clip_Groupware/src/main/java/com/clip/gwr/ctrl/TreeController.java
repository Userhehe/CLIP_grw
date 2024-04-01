package com.clip.gwr.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clip.gwr.model.service.IDeptService;
import com.clip.gwr.model.service.IRanksService;
import com.clip.gwr.model.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TreeController {
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IDeptService deptService;
    
    @Autowired 
    private IRanksService ranksService;
    
//    // jstree 화면으로 이동
//    @GetMapping("/tree.do")
//    public String showTree(Model model) {
//        return "tree"; // jsp 페이지 이름
//    }
//    
//    // 부서 등록
//    @PostMapping("/dept")
//    @ResponseBody
//    public String addDept(@RequestParam("dept_name") String dept_name) {
//        // 부서 등록 로직 추가
//        Map<String, Object> deptMap = new HashMap<>();
//        deptMap.put("dept_name", dept_name);
//        int result = deptService.insertDept(deptMap);
//        if (result == 1) {
//            log.info("Added department: {}", dept_name);
//            return "Department added successfully.";
//        } else {
//            log.error("Failed to add department: {}", dept_name);
//            return "Failed to add department.";
//        }
//    }
//    
//    // 부서 수정
//    @PutMapping("/dept/{dept_seq}")
//    @ResponseBody
//    public String updateDept(@PathVariable("dept_seq") String dept_seq, @RequestParam("dept_name") String dept_name) {
//        // 부서 수정 로직 추가
//        Map<String, Object> deptMap = new HashMap<>();
//        deptMap.put("dept_seq", dept_seq);
//        deptMap.put("dept_name", dept_name);
//        int result = deptService.updateDept(deptMap);
//        if (result == 1) {
//            log.info("Updated department: {} - {}", dept_seq, dept_name);
//            return "Department updated successfully.";
//        } else {
//            log.error("Failed to update department: {} - {}", dept_seq, dept_name);
//            return "Failed to update department.";
//        }
//    }
//    
//    // 부서 삭제
//    @DeleteMapping("/dept/{dept_seq}")
//    @ResponseBody
//    public String deleteDept(@PathVariable("dept_seq") String dept_seq) {
//        // 부서 삭제 로직 추가
//        int result = deptService.delDept(dept_seq);
//        if (result == 1) {
//            log.info("Deleted department: {}", dept_seq);
//            return "Department deleted successfully.";
//        } else {
//            log.error("Failed to delete department: {}", dept_seq);
//            return "Failed to delete department.";
//        }
//    }
//    
//    // 직급 등록
//    @PostMapping("/ranks")
//    @ResponseBody
//    public String addRanks(@RequestParam("ranks_name") String ranks_name) {
//        // 직급 등록 로직 추가
//        Map<String, Object> ranksMap = new HashMap<>();
//        ranksMap.put("ranks_name", ranks_name);
//        int result = ranksService.insertRanks(ranksMap);
//        if (result == 1) {
//            log.info("Added ranks: {}", ranks_name);
//            return "Ranks added successfully.";
//        } else {
//            log.error("Failed to add ranks: {}", ranks_name);
//            return "Failed to add ranks.";
//        }
//    }
//    
//    // 직급 수정
//    @PutMapping("/ranks/{ranks_seq}")
//    @ResponseBody
//    public String updateRanks(@PathVariable("ranks_seq") String ranks_seq, @RequestParam("ranks_name") String ranks_name) {
//        // 직급 수정 로직 추가
//        Map<String, Object> ranksMap = new HashMap<>();
//        ranksMap.put("ranks_seq", ranks_seq);
//        ranksMap.put("ranks_name", ranks_name);
//        int result = ranksService.updateRanks(ranksMap);
//        if (result == 1) {
//            log.info("Updated ranks: {} - {}", ranks_seq, ranks_name);
//            return "Ranks updated successfully.";
//        } else {
//            log.error("Failed to update ranks: {} - {}", ranks_seq, ranks_name);
//            return "Failed to update ranks.";
//        }
//    }
//    
//    // 직급 삭제
//    @DeleteMapping("/ranks/{ranks_seq}")
//    @ResponseBody
//    public String deleteRanks(@PathVariable("ranks_seq") String ranks_seq) {
//        // 직급 삭제 로직 추가
//        int result = ranksService.delRanks(ranks_seq);
//        if (result == 1) {
//            log.info("Deleted ranks: {}", ranks_seq);
//            return "Ranks deleted successfully.";
//        } else {
//            log.error("Failed to delete ranks: {}", ranks_seq);
//            return "Failed to delete ranks.";
//        }
//    }
}


