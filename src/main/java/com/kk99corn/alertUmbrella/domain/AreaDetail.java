package com.kk99corn.alertUmbrella.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "area_detail")
public class AreaDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int areaDetailSeq;

	private String areaDetailName;

	@NotNull
	private int areaX;

	@NotNull
	private int areaY;

	@NotNull
	private int areaSeq;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonManagedReference
	@JoinColumn(name = "areaSeq", insertable = false, updatable = false)
	private Area area;

	@Builder
	public AreaDetail(int areaDetailSeq, String areaDetailName, int areaX, int areaY, int areaSeq, Area area) {
		this.areaDetailSeq = areaDetailSeq;
		this.areaDetailName = areaDetailName;
		this.areaX = areaX;
		this.areaY = areaY;
		this.areaSeq = areaSeq;
		this.area = area;
	}
}
