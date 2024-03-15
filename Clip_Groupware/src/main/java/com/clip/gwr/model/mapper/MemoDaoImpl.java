package com.clip.gwr.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.MemoVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemoDaoImpl implements IMemoDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.clip.gwr.model.mapper.MemoDaoImpl.";
	
	@Override
	public List<MemoVo> myScheduleAll(String user_id) {
		log.info("myScheduleAll 메모 전체조회");
		return sqlSession.selectList(NS+"myScheduleAll",user_id);
	}

	@Override
	public MemoVo myScheduleDetail(String seq) {
		log.info("myScheduleDetail 메모 상세조회");
		return sqlSession.selectOne(NS+"myScheduleDetail",seq);
	}

	@Override
	public int myScheduleInsert(MemoVo vo) {
		log.info("myScheduleInsert 메모 입력");
		return sqlSession.insert(NS+"myScheduleInsert", vo);
	}

	@Override
	public int myScheduleUpdate(MemoVo vo) {
		log.info("myScheduleUpdate 메모 수정");
		return sqlSession.update(NS+"myScheduleUpdate",vo);
	}

	@Override
	public int myScheduleDelete(MemoVo vo) {
		log.info("myScheduleDelete 메모 삭제" );
		return sqlSession.delete(NS+"myScheduleDelete",vo);
	}

}
