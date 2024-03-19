package com.test.gwr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IMemoService;
import com.clip.gwr.vo.MemoVo;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
@Slf4j
public class MemoJUnitTest {

	@Autowired
	private IMemoService service;
	
	@Test
	public void test() {
		List<MemoVo> lists = service.myScheduleAll("USER_005");
		log.info("메모 전체조회 {}:", lists);
		assertNotNull(lists);
		
		MemoVo detail = service.myScheduleDetail("USERSCHEDULE_003");
		log.info("메모 상세조회 {} :", detail );
		assertNotNull(detail);
		
		MemoVo insert = new MemoVo();
		insert.setUser_id("USER_005");
		insert.setPrs_title("어우 집가고싶넹");
		insert.setPrs_content("프로젝트 잘하고싶다");
		
		int cnt = service.myScheduleInsert(insert);
		log.info("개인메모 입력 {}:",insert);
		assertNotEquals(cnt,0);
		
		
		MemoVo update = new MemoVo();
		update.setPrs_seq("USERSCHEDULE_012");
		update.setUser_id("USER_005");
		update.setPrs_title("제목을 수정한다!");
		update.setPrs_content("내용을 고친다!");
		
		int cnt2 = service.myScheduleUpdate(update);
		log.info("개인 메모 수정 {} :", update);
		assertNotEquals(cnt2, 1);
		
		MemoVo delete = new MemoVo();
		delete.setPrs_seq("USERSCHEDULE_014");
		delete.setUser_id("USER_001");
		
		int cnt3 = service.myScheduleDelete(delete);
		log.info("개인 메모 삭제 {} :", delete);
		assertEquals(cnt3, 1);
			
		
		
	}

}
