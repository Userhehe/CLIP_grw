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

public class ProjectsVo {

	private String prj_id 			;
	private String cli_name 		;
	private String prj_name 		;
	private String prj_sdate		;
	private String prj_ddate		;
	private String prj_status		;
	private String prj_manager		;
	private String prj_progress		;
	private String user_id			;
}
