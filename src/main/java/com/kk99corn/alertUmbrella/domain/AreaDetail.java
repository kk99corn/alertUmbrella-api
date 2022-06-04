package com.kk99corn.alertUmbrella.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@ToString
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

	@ManyToOne
	@JoinColumn(name = "areaSeq")
	private Area area;
}
