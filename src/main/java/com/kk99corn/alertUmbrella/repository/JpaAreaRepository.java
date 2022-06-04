package com.kk99corn.alertUmbrella.repository;

import com.kk99corn.alertUmbrella.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAreaRepository extends JpaRepository<Area, Integer>, AreaRepository {

	Area findByAreaSeq(Integer integer);
	List<Area> findAll();
}
