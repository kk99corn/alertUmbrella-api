package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.DTO.member.MemberDTO;
import com.kk99corn.alertUmbrella.domain.Member;
import com.kk99corn.alertUmbrella.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member findByMemberSeq(int memberSeq) {
		return memberRepository.findByMemberSeq(memberSeq);
	}

	public Member findByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member joinMember(MemberDTO memberDTO) {
		Member member = memberDTO.toEntity();
		return memberRepository.save(member);
	}
}
