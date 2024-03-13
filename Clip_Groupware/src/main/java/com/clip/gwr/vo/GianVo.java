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
public class GianVo {
	private String gian_seq;
	private String gian_gubun;
	private String gian_name;
	private String gian_modifier;
	private String gian_regdate;
	private String gian_html;
}
