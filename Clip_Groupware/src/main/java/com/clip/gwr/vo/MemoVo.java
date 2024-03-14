package com.clip.gwr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoVo {

	private String prs_seq    ;
	private String user_id    ;
	private String prs_title  ;
	private String prs_content;
	private String prs_start  ;
	private String prs_end    ;
	private String prs_create ; 
}
