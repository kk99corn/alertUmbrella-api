package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.domain.Area;
import com.kk99corn.alertUmbrella.domain.vo.AreaVO;
import com.kk99corn.alertUmbrella.repository.AreaRepository;

import java.util.ArrayList;
import java.util.List;

public class AreaService {
	private final AreaRepository areaRepository;

	public AreaService(AreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}

	public AreaVO findByAreaSeq(int areaSeq) {
		Area area = areaRepository.findByAreaSeq(areaSeq);
		AreaVO areaVO = null;
		if (area != null) {
			areaVO = AreaVO.builder()
					.areaSeq(area.getAreaSeq())
					.areaName(area.getAreaName())
					.build();
		}
		return areaVO;
	}

	public List<AreaVO> findAll() {
		List<Area> areaList = areaRepository.findAll();
		List<AreaVO> areaVOList = new ArrayList<>();
		for (Area area : areaList) {
			areaVOList.add(AreaVO.builder()
					.areaSeq(area.getAreaSeq())
					.areaName(area.getAreaName())
					.build());
		}

		return areaVOList;
	}
}
