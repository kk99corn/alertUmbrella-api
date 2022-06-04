package com.kk99corn.alertUmbrella.domain.dto;

import com.kk99corn.alertUmbrella.domain.Area;
import com.kk99corn.alertUmbrella.domain.AreaDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AreaDetailDTO {
	private int areaDetailSeq;
	private String areaDetailName;
	private int areaX;
	private int areaY;
	private int areaSeq;

	public AreaDetail toEntity() {
		return AreaDetail.builder()
				.areaDetailSeq(areaDetailSeq)
				.areaDetailName(areaDetailName)
				.areaX(areaX)
				.areaY(areaY)
				.areaSeq(areaSeq)
				.build();
	}
}
