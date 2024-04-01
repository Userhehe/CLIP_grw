package com.clip.gwr.vo;

import java.util.Map;

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
public class PaylineVo {

//	기안자
	private String writer;
//	결재라인
	private Map<String, Object> paymentLine;
//	결재라인승인
	private Map<String, Object> paymentOk;
//	참조자
	private Map<String, Object> reference;
	
	
	//JSON 형태로 진행할 때 사용
	
}
