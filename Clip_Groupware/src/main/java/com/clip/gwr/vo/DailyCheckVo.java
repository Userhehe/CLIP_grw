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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DailyCheckVo {
	private String daily_seq;
	private String user_id;
	private String daily_intime;
	private String daily_outtime;
	private String daily_status;
	private String daily_modify;
	private String daily_reasonmodify;
	private String daily_regdate;
	
	private String user_name;
	private String positions_seq;
	private String positions_name;
	private String ranks_seq;
	private String ranks_name;
	private String dept_seq;
	private String dept_name;
}
