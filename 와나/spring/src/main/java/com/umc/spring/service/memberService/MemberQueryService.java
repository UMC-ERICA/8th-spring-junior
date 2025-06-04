package com.umc.spring.service.memberService;

import com.umc.spring.domain.Member;
import com.umc.spring.dto.responseDto.MemberResponseDto;
import jakarta.servlet.http.HttpServletRequest;

import static com.umc.spring.dto.responseDto.MemberResponseDto.*;


public interface MemberQueryService {

    Member findMemberById(Long memberId);

    MemberInfoDto getMemberInfo(HttpServletRequest request);
}
