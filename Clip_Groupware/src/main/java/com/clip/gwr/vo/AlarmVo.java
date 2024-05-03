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
public class AlarmVo {
	private String alarm_seq  ;
	private String alarm_type ;
	private String alarm_title;
	private String alarm_time ;
	private String alarm_receiver;
	private String alarm_flag    ;
}
