package com.clip.gwr.vo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignsVo {
   
	private String signs_seq     ;
	private String user_id       ;
	private String signs_image   ;
	private String signs_regdate ;
	 
}
