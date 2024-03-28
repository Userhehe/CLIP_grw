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

	private String user_id     ;
	private int annual_ct   ;
	private int annual_leov ;
	private int annual_use  ;
	private String user_name     ;
}
