package com.kk99corn.alertUmbrella.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int memberSeq;

	private String memberId;

	private String memberPassword;

	private Date inputDate;
}
