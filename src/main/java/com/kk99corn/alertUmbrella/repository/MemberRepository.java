package com.kk99corn.alertUmbrella.repository;

import com.kk99corn.alertUmbrella.domain.Member;

import java.util.List;

public interface MemberRepository {

	//회원가입
	// Member joinMember(Member member);

	Member findByMemberSeq(int memberSeq);

	// List<Member> findAll();
}
