package com.clip.gwr.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatVo {
	private String chat_seq;
	private String chat_message;
	private String chat_sender;
	private String chat_recipient;
	private String chat_date;
	private String chat_check;
	
	private String sender_name;
	private String target_name;
	private byte[] sender_pic;
	private String sender_pic_str;
	
	private String user_email;
	private String user_name;
	private String dept_seq;
	private String ranks_seq;
}
