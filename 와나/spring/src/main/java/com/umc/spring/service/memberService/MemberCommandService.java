package com.umc.spring.service.memberService;

import com.umc.spring.domain.Member;
import com.umc.spring.dto.requestDto.MemberRequestDto;
import com.umc.spring.dto.responseDto.MemberResponseDto;

import static com.umc.spring.dto.requestDto.MemberRequestDto.*;
import static com.umc.spring.dto.responseDto.MemberResponseDto.*;

public interface MemberCommandService {

    Member joinMember(JoinDto request);

    LoginResultDto loginMember(LoginRequestDto request);
}
