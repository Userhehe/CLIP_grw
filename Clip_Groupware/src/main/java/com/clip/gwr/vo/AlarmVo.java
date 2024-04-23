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
	private String alarm_seq;
	private String alarm_title;
	private String alarm_sender;
	private String alarm_recipient;
	private String alarm_check;
	private String alarm_key;
	private String alarm_set;
	private String alarm_date;
}
