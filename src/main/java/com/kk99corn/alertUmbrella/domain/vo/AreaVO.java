package com.kk99corn.alertUmbrella.domain.vo;

import com.kk99corn.alertUmbrella.domain.Area;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AreaVO {
	private int areaSeq;
	private String areaName;

	public Area toEntity() {
		return Area.builder()
				.areaSeq(areaSeq)
				.areaName(areaName)
				.build();
	}
}
