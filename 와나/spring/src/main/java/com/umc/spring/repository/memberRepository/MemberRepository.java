package com.umc.spring.repository.memberRepository;

import com.umc.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberById(Long memberId);
}
