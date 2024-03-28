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
public class AnnualUseVo {

	private String annuse_seq         ;
	private String user_id            ;
	private String annuse_startdate   ;
	private String annuse_enddate     ;
	private int annuse_day            ;
	private String annuse_date        ;
}
