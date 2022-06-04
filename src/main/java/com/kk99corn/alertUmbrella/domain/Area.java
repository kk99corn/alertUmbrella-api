package com.kk99corn.alertUmbrella.domain;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int areaSeq;

	@NotNull
	private String areaName;

	@Builder
	public Area(int areaSeq, String areaName) {
		this.areaSeq = areaSeq;
		this.areaName = areaName;
	}
}
