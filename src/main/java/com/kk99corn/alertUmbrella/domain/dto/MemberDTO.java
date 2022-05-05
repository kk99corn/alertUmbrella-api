package com.kk99corn.alertUmbrella.domain.dto;

import com.kk99corn.alertUmbrella.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
