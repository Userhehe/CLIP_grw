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
public class ReservationVo {
	private String re_seq     ; //예약 번호
	private String user_id    ; //예약자 아이디
	private String re_title   ; //예약할 회의 제목
	private String re_content ; //예약할 회의 내용
	private String re_start   ; //예약할 회의실 시작 일시
	private String re_end     ; //예약할 회의실 종료 일시
	private String re_create  ; //예약일
	private String re_delflag ; //예약 취소 여부
	private String me_room    ; //예약할 회의실 번호
	private String re_attend  ; //회의 참석자 명단
	

	
	
	
}
