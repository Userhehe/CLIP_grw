package com.clip.gwr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVo {

	private String an_seq    ;
	private String user_id   ;
	private String an_title  ;
	private String an_content;
	private String an_start  ;
	private String an_end    ;
	private String an_create ;
	private String an_delflag;
}
