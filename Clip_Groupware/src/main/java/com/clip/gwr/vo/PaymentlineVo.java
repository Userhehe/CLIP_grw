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
public class PaymentlineVo {

	private String app_seq;
	private String pay_user;
	private String pay_sign;
	private int pay_num;
	private String pay_asigndate;
	private String pay_rejectreason;
	
}
