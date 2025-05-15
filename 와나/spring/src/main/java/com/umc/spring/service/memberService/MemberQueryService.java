package com.umc.spring.service.memberService;

import com.umc.spring.domain.Member;


public interface MemberQueryService {

    Member findMemberById(Long memberId);
}
