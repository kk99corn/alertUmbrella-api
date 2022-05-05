package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.DTO.member.MemberDTO;
import com.kk99corn.alertUmbrella.domain.Member;
import com.kk99corn.alertUmbrella.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberService memberService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	@DisplayName("회원 조회 - memberSeq")
	void findByMemberSeqTest() {
		//given
		int memberSeq = 1;
		//when
		Member member = memberRepository.findByMemberSeq(memberSeq);
		//then
		assertThat(member.getMemberId()).isEqualTo("admin");
	}

	@Test
	@DisplayName("회원 조회 - memberId")
	void findByMemberIdTest() {
		//given
		String memberId = "admin";
		//when
		Member member = memberRepository.findByMemberId(memberId);
		//then
		assertThat(member.getMemberId()).isEqualTo("admin");
	}

	@Test
	@DisplayName("회원 조회 - memberId & memberPassword")
	void findByMemberIdAndMemberPasswordTest() {
		//given
		String memberId = "admin";
		String memberPassword = "1234";

		//when
		Member member = memberRepository.findByMemberId(memberId);

		//then
		assertTrue(passwordEncoder.matches(memberPassword, member.getMemberPassword()));
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
		memberDTO.setName("testtest");
		memberDTO.setPassword(passwordEncoder.encode("1234"));

		System.out.println("memberDTO.getPassword() = " + memberDTO.getPassword());
		Member member = memberService.joinMember(memberDTO);

		assertThat(memberDTO.getId()).isEqualTo(member.getMemberId());
	}

	@Test
	@DisplayName("패스워드 암호화")
	void passwordEncoder() {
		//given
		String password = "1234";

		//when
		String encodedPassword = passwordEncoder.encode(password);

		//then
		assertThat(password).isNotEqualTo(encodedPassword);
		assertTrue(passwordEncoder.matches(password, encodedPassword));
	}
}
