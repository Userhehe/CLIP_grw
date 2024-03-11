package com.clip.gwr.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalVo {

	private String appSeq;
	private String appTitle;
	private String appContent;
	private String gianSeq;
	private String plSeq;
	private String appCreatedate;
	private String appDraft;
	private String appStrdate;
	private String appEnddate;
}
