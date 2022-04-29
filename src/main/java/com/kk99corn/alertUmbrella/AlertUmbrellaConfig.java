package com.kk99corn.alertUmbrella;

import com.kk99corn.alertUmbrella.repository.MemberRepository;
import com.kk99corn.alertUmbrella.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlertUmbrellaConfig {

	private final MemberRepository memberRepository;

	@Autowired
	public AlertUmbrellaConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
}