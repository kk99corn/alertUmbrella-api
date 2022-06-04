package com.kk99corn.alertUmbrella;

import com.kk99corn.alertUmbrella.repository.AreaDetailRepository;
import com.kk99corn.alertUmbrella.repository.AreaRepository;
import com.kk99corn.alertUmbrella.repository.MemberRepository;
import com.kk99corn.alertUmbrella.service.AreaDetailService;
import com.kk99corn.alertUmbrella.service.AreaService;
import com.kk99corn.alertUmbrella.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertUmbrellaConfig {

	private final MemberRepository memberRepository;
	private final AreaRepository areaRepository;
	private final AreaDetailRepository areaDetailRepository;

	@Autowired
	public AlertUmbrellaConfig(MemberRepository memberRepository,
							   AreaRepository areaRepository,
							   AreaDetailRepository areaDetailRepository) {
		this.memberRepository = memberRepository;
		this.areaRepository = areaRepository;
		this.areaDetailRepository = areaDetailRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	@Bean
	public AreaService areaService() {
		return new AreaService(areaRepository);
	}

	@Bean
	public AreaDetailService areaDetailService() {
		return new AreaDetailService(areaDetailRepository);
	}
}