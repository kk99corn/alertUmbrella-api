package com.kk99corn.alertUmbrella.repository;

import com.kk99corn.alertUmbrella.domain.Area;
import com.kk99corn.alertUmbrella.domain.AreaDetail;

import java.util.List;

public interface AreaDetailRepository {

	List<AreaDetail> findByAreaSeq(int areaSeq);
}
