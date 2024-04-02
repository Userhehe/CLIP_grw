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
public class RanksVo {
	
	  
	private String ranks_seq;
	private String ranks_name;
	private String ranks_regdate;
	private String user_id;
	private String user_name;

}
