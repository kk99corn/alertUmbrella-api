package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.domain.AreaDetail;
import com.kk99corn.alertUmbrella.domain.vo.AreaDetailVO;
import com.kk99corn.alertUmbrella.domain.vo.AreaVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AreaDetailServiceTest {

	@Autowired
	AreaDetailService areaDetailService;

	@Test
	@DisplayName("지역 조회")
	void findByAreaSeq() {
		//given
		int areaSeq = 9;
		//when
		List<AreaDetailVO> areaDetailVOList = areaDetailService.findByAreaSeq(areaSeq);
		//then
		assertThat(areaDetailVOList.size()).isEqualTo(43);
	}
}
