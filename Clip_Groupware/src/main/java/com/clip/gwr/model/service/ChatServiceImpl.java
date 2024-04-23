package com.clip.gwr.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.gwr.model.mapper.IChatDao;
import com.clip.gwr.vo.ChatVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatServiceImpl implements IChatService {

	@Autowired
	private IChatDao dao;

	@Override
	public int sendMessage(ChatVo vo) {
		log.info("ChatServiceImpl sendMessage Service 채팅 전송");
		return dao.sendMessage(vo);
	}

	@Override
	public List<ChatVo> selectAllMessage(ChatVo vo) {
		log.info("ChatServiceImpl selectAllMessage Service 대화목록");
		return dao.selectAllMessage(vo);
	}

	@Override
	public int setReadMessage(ChatVo vo) {
		log.info("ChatServiceImpl setReadMessage Service 읽음처리");
		return dao.setReadMessage(vo);
	}

	@Override
	public int noReadList(ChatVo vo) {
		log.info("ChatServiceImpl noReadList Service 안읽은 목록 수");
		return dao.noReadList(vo);
	}

	@Override
	public List<ChatVo> chatUserList(String ch_target) {
		log.info("ChatServiceImpl chatUserList Service 정렬을 위한 유저 목록 조회");
		return dao.chatUserList(ch_target);
	}

}