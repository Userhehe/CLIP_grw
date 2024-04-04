package com.clip.gwr.model.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.MemoVo;
import com.clip.gwr.vo.NtcVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemoDaoImpl implements IMemoDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.MemoDaoImpl.";
	
	//유저 기능
	@Override
	public MemoVo myScheduleDetail(String seq) {
		log.info("myScheduleDetail 메모 상세조회");
		return sqlSession.selectOne(NS+"myScheduleDetail",seq);
	}

	@Override
	public int myScheduleInsert(Map<String, Object> map) {
		log.info("myScheduleInsert 메모 입력");
		return sqlSession.insert(NS+"myScheduleInsert", map);
	}
	
	@Override
	public int myScheduleDelete(String seq) {
		log.info("myScheduleDelete 메모 삭제" );
		return sqlSession.delete(NS+"myScheduleDelete",seq);
	}

	@Override
	public int myScheduleUpdate(Map<String, Object> map) {
		log.info("myScheduleUpdate 메모 수정");
		return sqlSession.update(NS+"myScheduleUpdate",map);
	}
	//유저 기능 끝
	
	
	@Override
	public List<MemoVo> selectScheduleAll(Map<String, Object> map) {
		log.info("selectScheduleAll 테스트용 전사 개인 일정 조회" );
		return sqlSession.selectList(NS+"selectScheduleAll",map);
	}
	
	
	//관리자 기능
	@Override
	public NtcVo ntcScheduleDetail(String seq) {
		log.info("ntcScheduleDetail 전사 상세조회");
		return sqlSession.selectOne(NS+"ntcScheduleDetail",seq);
	}
	
	@Override
	public int ntcScheduleInsert(Map<String, Object> map) {
		log.info("myScheduleInsert 전사 입력");
		return sqlSession.insert(NS+"ntcScheduleInsert", map);
	}
	
	@Override
	public int ntcScheduleDelete(String seq) {
		log.info("myScheduleDelete 전사 삭제" );
		return sqlSession.update(NS+"ntcScheduleDelete", seq);
	}
	
	@Override
	public int ntcScheduleUpdate(Map<String, Object> map) {
		log.info("ntcScheduleUpdate 전사 수정" );
		return sqlSession.update(NS+"ntcScheduleUpdate", map);
	}
	
	//공지사항(전사)
	@Override
	public List<NtcVo> selectNtcBoard() {
		log.info("selectNtcBoard 공지사항(전사) 전체 조회" );
		return sqlSession.selectList(NS+"selectNtcBoard");
	}
	
	//페이징 테스트
	@Override
	public int selectNtcCount() {
		log.info("selectNtcCount 공지사항 게시글 총 개수" );
		return sqlSession.selectOne(NS+"selectNtcCount");
	}
	
	@Override
	public List<NtcVo> selectNtcPage(Map<String, Object> map) {
		log.info("selectNtcPage 공지사항 페이징 구간별 게시글" );
		return sqlSession.selectList(NS+"selectNtcPage",map);
	}
}
