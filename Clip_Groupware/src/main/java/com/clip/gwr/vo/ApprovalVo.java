package com.clip.gwr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApprovalVo {

	private String app_seq;
	private String app_title;
	private String app_content;
	private String gian_seq;
	private String app_payline;
	private String app_createdate;
	private String app_draft;
	private String app_strdate;
	private String app_enddate;
	private String dept_seq;
	
	private String user_id;
	private String gian_name;
	
	private String pay_user;
	private String pay_sign;
	private String pay_num;
	private String pay_paydate;
	private String pay_rejectreason;

	private String ref_user;
	private String ref_team;

	private String rec_user;
	private String rec_team;
}
