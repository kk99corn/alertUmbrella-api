package com.kk99corn.alertUmbrella.DTO.member;

import com.kk99corn.alertUmbrella.domain.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
	private String id;
	private String name;
	private String password;

	public Member toEntity() {
		return Member.builder()
				.memberId(id)
				.memberName(name)
				.memberPassword(password)
				.build();
	}
}
