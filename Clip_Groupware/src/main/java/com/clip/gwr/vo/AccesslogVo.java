package com.clip.gwr.vo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor 
public class AccesslogVo {
  
	private String alog_seq     ;
	private String alog_id      ;
	private String alog_ip      ;
	private String alog_url     ;
	private String alog_comment ;
	private String daily_regdate;
	 
}
