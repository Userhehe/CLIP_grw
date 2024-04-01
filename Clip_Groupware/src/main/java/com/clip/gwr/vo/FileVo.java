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
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {
	private String fileName;
	
	private String file_seq; //파일 시퀀스
	private String file_targetseq; //기능테이블별 시퀀스코드 
	private String file_targetobj;//테이블 시퀀스 별 파일넘버
	private String file_originname; //파일 원본 이름
	private String file_storename;  //저장된 파일 이름
	private int file_size; //파일크기
	private byte[] file_ff; //파일
	private String file_path;
	private String photo_seq;
	private String user_id;
}
