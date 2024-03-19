package com.clip.gwr.vo;

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

public class ClientVo {

	private String	cli_id		;
	private String	cli_name	;
	private String	cli_contact	;
	private String	cli_address	;
	private String	cli_person	;
	private String	cli_note	;
}
