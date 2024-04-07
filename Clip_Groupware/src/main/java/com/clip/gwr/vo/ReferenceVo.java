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
public class ReferenceVo {

	private String app_seq ;
	private String ref_user;
	private String ref_team;
	
	private String user_name;
	private String dept_name;
	
}
