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
public class NtcVo {
	
	private String ntc_seq    ;
	private String user_id    ;
	private String ntc_title  ;
	private String ntc_content;
	private String ntc_start  ;
	private String ntc_end    ;
	private String ntc_create ;
	private String ntc_delflag;

}
