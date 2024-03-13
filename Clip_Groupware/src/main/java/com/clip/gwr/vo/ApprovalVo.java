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

	private String app_Seq;
	private String app_Title;
	private String app_Content;
	private String gian_Seq;
	private String app_Payline;
	private String app_Createdate;
	private String app_Draft;
	private String app_Strdate;
	private String app_Enddate;
	
//	private PaylineVo app_Payline;
}
