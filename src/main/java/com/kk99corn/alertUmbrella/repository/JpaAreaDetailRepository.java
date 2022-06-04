package com.kk99corn.alertUmbrella.repository;

import com.kk99corn.alertUmbrella.domain.AreaDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAreaDetailRepository extends JpaRepository<AreaDetail, Integer>, AreaDetailRepository {

	List<AreaDetail> findByAreaSeq(Integer integer);
}
