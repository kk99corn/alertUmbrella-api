package com.kk99corn.alertUmbrella.service;

import com.kk99corn.alertUmbrella.domain.Member;
import com.kk99corn.alertUmbrella.domain.dto.MemberDTO;
import com.kk99corn.alertUmbrella.domain.vo.MemberVO;
import com.kk99corn.alertUmbrella.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public MemberVO findByMemberSeq(int memberSeq) {
		Member member = memberRepository.findByMemberSeq(memberSeq);
		MemberVO memberVO = null;
		if (member != null) {
			memberVO = MemberVO.builder()
					.id(member.getMemberId())
					.name(member.getMemberName())
					.build();
		}
		return memberVO;
	}

	public MemberVO findByMemberId(String memberId) {
		Member member = memberRepository.findByMemberId(memberId);
		MemberVO memberVO = null;
		if (member != null) {
			memberVO = MemberVO.builder()
					.id(member.getMemberId())
					.name(member.getMemberName())
					.build();
		}
		return memberVO;
	}

	public String findPasswordByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId).getMemberPassword();
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public MemberVO joinMember(MemberDTO memberDTO) {
		Member member = memberDTO.toEntity();
		Member saveMember = memberRepository.save(member);
		return MemberVO.builder()
				.id(saveMember.getMemberId())
				.name(saveMember.getMemberName())
				.build();
	}
}
