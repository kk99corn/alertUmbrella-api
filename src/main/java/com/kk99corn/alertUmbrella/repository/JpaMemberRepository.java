package com.kk99corn.alertUmbrella.repository;

import com.kk99corn.alertUmbrella.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JpaMemberRepository extends JpaRepository<Member, Integer>, MemberRepository {

	Member findByMemberSeq(Integer integer);

	List<Member> findAll();
}
