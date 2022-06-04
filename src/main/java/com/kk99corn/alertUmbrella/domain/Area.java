package com.kk99corn.alertUmbrella.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int areaSeq;

	@NotNull
	private String areaName;

	@OneToMany(mappedBy = "area")
	@JsonBackReference
	private List<AreaDetail> areaDetailList;

	@Builder
	public Area(int areaSeq, String areaName) {
		this.areaSeq = areaSeq;
		this.areaName = areaName;
	}
}
