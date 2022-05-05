package com.kk99corn.alertUmbrella.domain.vo;

import com.kk99corn.alertUmbrella.domain.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberVO {
	private String id;
	private String name;

	public Member toEntity() {
		return Member.builder()
				.memberId(id)
				.memberName(name)
				.build();
	}
}
