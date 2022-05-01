package com.kk99corn.alertUmbrella.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int memberSeq;

	@NotNull
	private String memberId;

	@NotNull
	private String memberPassword;

	@NotNull
	@CreationTimestamp
	private Date inputDate;

	@Builder
	public Member(int memberSeq, String memberId, String memberPassword, Date inputDate) {
		this.memberSeq = memberSeq;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.inputDate = inputDate;
	}
}
