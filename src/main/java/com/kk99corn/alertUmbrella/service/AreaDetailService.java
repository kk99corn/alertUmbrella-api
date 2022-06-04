package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.domain.AreaDetail;
import com.kk99corn.alertUmbrella.domain.vo.AreaDetailVO;
import com.kk99corn.alertUmbrella.repository.AreaDetailRepository;

import java.util.ArrayList;
import java.util.List;

public class AreaDetailService {
	private final AreaDetailRepository areaDetailRepository;

	public AreaDetailService(AreaDetailRepository areaDetailRepository) {
		this.areaDetailRepository = areaDetailRepository;
	}

	public List<AreaDetailVO> findByAreaSeq(int areaSeq) {
		List<AreaDetail> areaDetailList = areaDetailRepository.findByAreaSeq(areaSeq);
		List<AreaDetailVO> areaDetailVOList = new ArrayList<>();
		for (AreaDetail areaDetail : areaDetailList) {
			areaDetailVOList.add(AreaDetailVO.builder()
					.areaDetailSeq(areaDetail.getAreaDetailSeq())
					.areaDetailName(areaDetail.getAreaDetailName())
					.areaX(areaDetail.getAreaX())
					.areaY(areaDetail.getAreaY())
					.areaSeq(areaDetail.getAreaSeq())
					.area(areaDetail.getArea())
					.build());
		}

		return areaDetailVOList;
	}
}
