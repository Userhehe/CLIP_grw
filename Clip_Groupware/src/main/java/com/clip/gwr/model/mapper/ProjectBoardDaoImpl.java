package com.clip.gwr.model.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.clip.gwr.vo.ProjectBoardVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProjectBoardDaoImpl implements IProjectBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.clip.gwr.model.mapper.ProjectBoardDaoImpl.";
	
	@Override
	public int insertBoard(ProjectBoardVo vo) {
		log.info("ProjectBoardDaoImpl insertboard");
		log.info("전달받은 값 : "+vo);
		return sqlSession.insert(NS+"insertBoard");
	}

	@Override
	public List<ProjectBoardVo> selectAllBoard() {
		log.info("ProjectBoardDaoImpl selectAllBoard");
		return sqlSession.selectList(NS+"selectAllBoard");
	}

	@Override
	public ProjectBoardVo selectDetailBoard(String seq) {
		log.info("ProjectBoardDaoImpl selectDetailBoard");
		log.info("전달받은 값 : "+seq);
		return sqlSession.selectOne(NS+"selectDetailBoard",seq);
	}

	@Override
	public int replyUpdate(ProjectBoardVo vo) {
		log.info("ProjectBoardDaoImpl replyUpdate");
		log.info("전달받은 부모의 seq 값 : "+vo.getPbo_seq());
		return sqlSession.update(NS+"replyUpdate",vo);
	}

	@Override
	public int replyInsert(ProjectBoardVo vo) {
		log.info("ProjectBoardDaoImpl replyInsert");
		log.info("전달받은 값 : "+vo);
		return sqlSession.insert(NS+"replyInsert",vo);
	}


	@Override
	public int modifyBoard(Map<String, Object> map) {
		log.info("ProjectBoardDaoImpl modifyBoard");
		log.info("전달받은 값 : "+map);
		return sqlSession.update(NS+"modifyBoard",map);
	}

	@Override
	public int deleteBoard(String seq) {
		log.info("ProjectBoardDaoImpl deleteBoard");
		log.info("전달받은 값 : "+seq);
		return sqlSession.delete(NS+"deleteBoard",seq);
	}

//	@Override
//	public int multidelete(String[] seqs) {
//		log.info("ProjectBoardDaoImpl multidelete");
//		log.info("전달받은 값 : "+Arrays.toString(seqs));
//		SqlSession session = manager.openSession(false);
//		log.info("@@@트랜잭션 시작@@@");
//		int row = 0;
//		try {
//			for (String s : seqs) {
//				row += session.delete(NS + "deleteBoard", s);
//			}
//			session.commit();
//		}catch(Exception e) {
//			session.rollback();
//			e.printStackTrace();
//		}
//		return 0;
//	}/

	@Override
	public int multideleteBoard(List<String> seqs) {
		log.info("ProjectBoardDaoImpl multideleteBoards");
		log.info("전달받은 값 : "+seqs);
		return sqlSession.delete(NS+"multideleteBoard",seqs);
	}
	/*
	 * @Override public int reply(ProjectBoardVo vo) {
	 * log.info("AnswerBoardDaoImpl reply"); log.info("전달받은 값 : "+vo); SqlSession
	 * session = manager.openSession(); int cnt = 0 ; try {
	 * cnt+=session.update(NS+"replyUpdate",vo);
	 * cnt+=session.insert(NS+"replyInsert",vo); session.commit(); } catch
	 * (Exception e) { session.rollback(); } return cnt; }
	 */
}
