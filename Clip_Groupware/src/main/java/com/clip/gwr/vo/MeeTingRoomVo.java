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
public class MeeTingRoomVo {
	private String me_room  ;
	private int me_attend;
}
