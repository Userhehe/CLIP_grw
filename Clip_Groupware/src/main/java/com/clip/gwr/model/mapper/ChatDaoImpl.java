package com.clip.gwr.model.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clip.gwr.vo.ChatVo;
import com.clip.gwr.model.mapper.ChatDaoImpl;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ChatDaoImpl implements IChatDao {

	@Autowired
	private SqlSessionTemplate template;
	private final String NS = "com.clip.grw.model.mapper.ChatDaoImpl.";

	@Override
	public int sendMessage(ChatVo vo) {
		log.info("ChatDaoImpl sendMessage DAO Access");
		return template.insert(NS + "sendMessage", vo);
	}

	@Override
	public List<ChatVo> selectAllMessage(ChatVo vo) {
		log.info("ChatDaoImpl selectAllMessage DAO Access");
		return template.selectList(NS + "selectAllMessage", vo);
	}

	@Override
	public int setReadMessage(ChatVo vo) {
		log.info("ChatDaoImpl setReadMessage DAO Access");
		return template.update(NS + "setReadMessage", vo);
	}

	@Override
	public int noReadList(ChatVo vo) {
		log.info("ChatDaoImpl noReadList DAO Access");
		return template.selectOne(NS + "noReadList", vo);
	}

	@Override
	public List<ChatVo> chatUserList(String ch_target) {
		log.info("ChatDaoImpl chatUserList DAO Access");
		return template.selectList(NS + "chatUserList", ch_target);
	}

}