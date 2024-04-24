package com.clip.gwr.model.service;

import java.util.List;

import com.clip.gwr.vo.ChatVo;


public interface IChatService {

	public int sendMessage(ChatVo vo);

	public List<ChatVo> selectAllMessage(ChatVo vo);

	public int setReadMessage(ChatVo vo);

	public int noReadList(ChatVo vo);

	public List<ChatVo> chatUserList(String ch_target);
}