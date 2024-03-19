package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReservationVo;
import com.clip.gwr.vo.UserinfoVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ReservationDaoImpl implements IReservationDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.ReservationDaoImpl.";

	@Override
	public List<ReservationVo> myReservationAll(String user_id) {
		log.info("##### 나의 예약정보 전체 조회 myReservationAll #####");
		return sqlSession.selectList(NS+"myReservationAll", user_id);
	}
	
	@Override
	public int myReservationInsert(Map<String, Object> map) {
		log.info("##### 회의실 예약 myReservationInsert #####");
		return sqlSession.insert(NS+"myReservationInsert", map);
	}
	
	@Override
	public List<MeeTingRoomVo> selectMeetingRoom() {
		log.info("##### 회의실 리스트 selectMeetingRoom #####");
		return sqlSession.selectList(NS+"selectMeetingRoom");
	}
	
	@Override
	public List<String> selectPossibleMeRoom(Map<String, Object> map) {
		log.info("##### 예약가능시간대 조회 selectPossibleMeRoom #####");
		return sqlSession.selectList(NS+"selectPossibleMeRoom",map);
	}
	
	@Override
	public List<UserinfoVo> selectAttendsJstree() {
		log.info("##### 참석자 선택을 위한 jsTree selectAttendsJstree #####");
		return sqlSession.selectList(NS+"selectAttendsJstree");
	}
}
