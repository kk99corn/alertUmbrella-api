package com.kk99corn.alertUmbrella.domain.dto;

import com.kk99corn.alertUmbrella.domain.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaDTO {
	private int areaSeq;
	private String areaName;

	public Area toEntity() {
		return Area.builder()
				.areaSeq(areaSeq)
				.areaName(areaName)
				.build();
	}
}
