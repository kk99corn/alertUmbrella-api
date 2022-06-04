package com.kk99corn.alertUmbrella.repository;

import com.kk99corn.alertUmbrella.domain.Area;
import com.kk99corn.alertUmbrella.domain.Member;

import java.util.List;

public interface AreaRepository {

	Area findByAreaSeq(int areaSeq);
	List<Area> findAll();
}
