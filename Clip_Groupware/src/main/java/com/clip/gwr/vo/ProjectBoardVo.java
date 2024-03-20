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
@AllArgsConstructor
@NoArgsConstructor

public class ProjectBoardVo {
//
	private String	pbo_seq		;
	private String	user_id		;
	private String	pbo_title	;
	private String	pbo_content	;
	private String	pbo_depth	;
	private String	pbo_ref		;
	private String	pbo_step	;
	private String	pbo_delflag	;
	private String	pbo_regdate	;
}
