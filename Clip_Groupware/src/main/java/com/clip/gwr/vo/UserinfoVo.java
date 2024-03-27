package com.clip.gwr.vo;

import java.io.Serializable;

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
public class UserinfoVo  {
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_registnum;
	private String user_phonenum;
	private String user_email;
	private String user_birthday;
	private String user_address;
	private String ranks_seq;
	private String ranks_name;
	private String ranks_regdate;
	private String dept_seq;
	private String dept_name;
	private String dept_regdate;
	private String positions_seq;
	private String positions_name;
	private String positions_regdate;
	private String photo_seq;
	private String user_auth;
	private String user_status;
	private String user_certnum;
	private String user_regdate;
}
