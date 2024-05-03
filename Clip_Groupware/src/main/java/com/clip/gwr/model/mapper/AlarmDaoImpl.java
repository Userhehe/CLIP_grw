package com.clip.gwr.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.AlarmVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AlarmDaoImpl implements IAlarmDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.AlarmDaoImpl.";
	/**
	 * 공지사항 알람
	 */
	@Override
	public List<AlarmVo> selectAlarmNotice(String user_id) {
		log.info("#### 공지사항 알람 alarmNotice ####");
		return sqlSession.selectList(NS + "selectAlarmNotice",user_id);
	}

}
