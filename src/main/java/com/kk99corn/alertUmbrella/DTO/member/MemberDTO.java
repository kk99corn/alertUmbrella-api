package com.kk99corn.alertUmbrella.DTO.member;

import com.kk99corn.alertUmbrella.domain.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String id;
	private String password;
}
