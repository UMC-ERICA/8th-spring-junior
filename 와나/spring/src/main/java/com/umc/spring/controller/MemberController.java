package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.MemberConverter;
import com.umc.spring.domain.Member;
import com.umc.spring.service.memberService.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.spring.dto.requestDto.MemberRequestDto.*;
import static com.umc.spring.dto.responseDto.MemberResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberService;

    @PostMapping("/")
    public ApiResponse<JoinResultDto> join (@RequestBody @Valid JoinDto request) {
        Member member = memberService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDto(member));

    }


}
