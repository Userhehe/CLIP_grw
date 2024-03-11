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
public class PaymentLineVo {

	private String plSeq;
	private String userId;
	private String plFirst;
	private String plSecond;
	private String plThird;
	private String plFscheck;
	private String plSecheck;
	private String plThcheck;
	private String plRefer;
	
}
