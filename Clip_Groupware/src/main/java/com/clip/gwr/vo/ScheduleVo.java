package com.clip.gwr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleVo {
	
	private String re_seq    ;
	private String user_id   ;
	private String re_title  ;
	private String re_content;
	private String re_start  ;
	private String re_end    ;
	private String re_create ;
	private String re_delflag;
	private int re_room   ;
	private String re_attend ;
	private String re_equip  ;

}
