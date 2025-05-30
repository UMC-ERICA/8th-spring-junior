package com.umc.spring.service.memberService;

import com.umc.spring.domain.Member;
import com.umc.spring.dto.requestDto.MemberRequestDto;

import static com.umc.spring.dto.requestDto.MemberRequestDto.*;

public interface MemberCommandService {

    Member joinMember(JoinDto request);
}
