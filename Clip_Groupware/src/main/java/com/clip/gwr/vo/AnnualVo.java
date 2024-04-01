package com.clip.gwr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnnualVo {        

	private String ann_seq   ;
	private String user_id   ;
	private int ann_day   ;
	private String ann_date  ;
	private int ann_leov  ;
	private int ann_useday;
	
	private String ranks_seq ;
	private String positions_seq;
	private String dept_seq ;
	private String user_name     ;
	private String positions_name ;
	private String ranks_name ;
	private String dept_name ;
	
}
