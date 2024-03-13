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

	private String pl_Seq;
	private String user_Id;
	private String pl_First;
	private String pl_Second;
	private String pl_Third;
	private String pl_Fscheck;
	private String pl_Secheck;
	private String pl_Thcheck;
	private String pl_Refer;
	
}
