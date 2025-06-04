package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.MemberConverter;
import com.umc.spring.domain.Member;
import com.umc.spring.dto.requestDto.MemberRequestDto;
import com.umc.spring.dto.responseDto.MemberResponseDto;
import com.umc.spring.service.memberService.MemberCommandService;
import com.umc.spring.service.memberService.MemberQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.umc.spring.dto.requestDto.MemberRequestDto.*;
import static com.umc.spring.dto.responseDto.MemberResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;

    private final MemberQueryService memberQueryService;

    @PostMapping("/join")
    public ApiResponse<JoinResultDto> join (@RequestBody @Valid JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDto(member));

    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API", description = "유저가 로그인하는 API입니다")
    public ApiResponse<LoginResultDto> login(@RequestBody @Valid LoginRequestDto request) {
        return ApiResponse.onSuccess(memberCommandService.loginMember(request));
    }

    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API", description = "유저가 내 정보를 조회하는 API"
    ,security = { @SecurityRequirement(name = "JWT TOKEN")})
    public ApiResponse<MemberInfoDto> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(memberQueryService.getMemberInfo(request));
    }

}
