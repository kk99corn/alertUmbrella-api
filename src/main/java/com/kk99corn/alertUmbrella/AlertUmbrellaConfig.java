package com.kk99corn.alertUmbrella;

import com.kk99corn.alertUmbrella.repository.AreaRepository;
import com.kk99corn.alertUmbrella.repository.MemberRepository;
import com.kk99corn.alertUmbrella.service.AreaService;
import com.kk99corn.alertUmbrella.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertUmbrellaConfig {

	private final MemberRepository memberRepository;
	private final AreaRepository areaRepository;

	@Autowired
	public AlertUmbrellaConfig(MemberRepository memberRepository, AreaRepository areaRepository) {
		this.memberRepository = memberRepository;
		this.areaRepository = areaRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	@Bean
	public AreaService areaService() {
		return new AreaService(areaRepository);
	}
}