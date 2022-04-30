package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.domain.Member;
import com.kk99corn.alertUmbrella.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberService memberService;

	@Test
	@DisplayName("회원 조회")
	void findByMemberSeqTest() {
		//given
		int memberSeq = 1;
		//when
		Member member = memberRepository.findByMemberSeq(memberSeq);
		//then
		assertThat(member.getMemberId()).isEqualTo("admin");
	}

	@Test
	@DisplayName("전체 회원 조회")
	void findAllTest() {
		List<Member> memberList = memberRepository.findAll();
		assertThat(memberList.size()).isEqualTo(1);
	}
}
