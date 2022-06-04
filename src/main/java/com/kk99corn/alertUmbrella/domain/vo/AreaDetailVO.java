package com.kk99corn.alertUmbrella.domain.vo;

import com.kk99corn.alertUmbrella.domain.Area;
import com.kk99corn.alertUmbrella.domain.AreaDetail;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AreaDetailVO {
	private int areaDetailSeq;
	private String areaDetailName;
	private int areaX;
	private int areaY;
	private int areaSeq;
	private Area area;

	public AreaDetail toEntity() {
		return AreaDetail.builder()
				.areaDetailSeq(areaDetailSeq)
				.areaDetailName(areaDetailName)
				.areaX(areaX)
				.areaY(areaY)
				.areaSeq(areaSeq)
				.area(area)
				.build();
	}
}
