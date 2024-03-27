package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.MeeTingRoomVo;
import com.clip.gwr.vo.ReAttendsVo;
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

	@Override
	public int reModifyRev(int re_seq) {
		log.info("##### 예약내용 수정 reModifyRev");
		return sqlSession.update(NS+"reModify", re_seq);
	}
	
	@Override
	public int reModifyAtt(String user_id) {
		log.info("##### 참석자 삭제 reModifyAtt");
		return sqlSession.delete(NS+"reModifyAtt", user_id );
	}

	@Override
	public int reDel(int re_seq) {
		log.info("##### 예약내용 삭제 reDetail");
		return sqlSession.update(NS+"reDel",re_seq);
	}

	@Override
	public ReservationVo reDetail(int re_seq) {
		log.info("##### 예약내용 상세조회 reDetail");
		return sqlSession.selectOne(NS+"reDetail", re_seq);
	}

	@Override
	public List<ReAttendsVo> reAttList(int seq) {
		log.info("##### 참석자 리스트 조회 reAttList");
		return sqlSession.selectList(NS+"reAttList",seq);
	}

	@Override
	public int cpRev(String user_id) {
		log.info("##### 최신예약내역 가져오기 cpRev");
		return sqlSession.selectOne(NS+"cpRev",user_id);
	}

	@Override
	public int attinsert(Map<String, Object> map) {
		log.info("##### 회의 참석자 입력하기 attinsert");
		return sqlSession.insert(NS+"attinsert",map);
	}

	
}
