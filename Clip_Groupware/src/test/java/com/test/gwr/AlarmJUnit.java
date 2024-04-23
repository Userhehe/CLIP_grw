package com.test.gwr;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clip.gwr.model.service.IAlarmService;
import com.clip.gwr.vo.AlarmVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class AlarmJUnit {
	
	@Autowired
	private IAlarmService alService;

	@Test
	public void selectAlarmNotice() {
		List<AlarmVo> lists = alService.selectAlarmNotice();
		assertNotNull(lists);
	}

}
