package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.DTO.member.MemberDTO;
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
		assertThat(memberList.size()).isNotZero();
	}

	@Test
	@DisplayName("회원 가입")
	void joinMember() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("joinTest");
		memberDTO.setPassword("1234");

		Member member = memberService.joinMember(memberDTO);

		assertThat(memberDTO.getId()).isEqualTo(member.getMemberId());
	}
}
