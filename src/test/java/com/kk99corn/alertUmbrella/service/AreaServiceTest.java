package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.domain.vo.AreaVO;
import com.kk99corn.alertUmbrella.repository.AreaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AreaServiceTest {

	@Autowired
	AreaService areaService;

	@Test
	@DisplayName("지역 조회")
	void findByAreaSeq() {
		//given
		int areaSeq = 9;
		//when
		AreaVO areaVO = areaService.findByAreaSeq(areaSeq);
		//then
		assertThat(areaVO.getAreaName()).isEqualTo("경기도");
	}

	@Test
	@DisplayName("전체 지역 조회")
	void findByAll() {
		//given
		//when
		List<AreaVO> areaList = areaService.findAll();
		//then
		assertThat(areaList.size()).isEqualTo(18);
	}
}
