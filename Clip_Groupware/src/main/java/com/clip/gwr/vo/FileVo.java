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
	private String file_seq;
	private String file_targetseq;
	private String file_targetobj;
	private String file_originname;
	private String file_storename;
	private int file_size;
	private String file_path;
	private String photo_seq;
	private String user_id;
}
