package com.umc.spring.service.memberService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.config.security.jwt.JwtTokenProvider;
import com.umc.spring.convert.MemberConverter;
import com.umc.spring.convert.MemberLikeFoodConverter;
import com.umc.spring.domain.Food;
import com.umc.spring.domain.mapping.MemberLikeFood;
import com.umc.spring.dto.responseDto.MemberResponseDto;
import com.umc.spring.repository.foodRepository.FoodRepository;
import com.umc.spring.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.umc.spring.convert.MemberConverter.*;
import static com.umc.spring.dto.requestDto.MemberRequestDto.*;
import static com.umc.spring.dto.responseDto.MemberResponseDto.*;

import com.umc.spring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodRepository foodRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public Member joinMember(JoinDto request) {

        Member newMember = toMember(request);

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<Food> likeFoodList = request.getLikeFoods().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new ErrorHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberLikeFood> memberLikeFoodList = MemberLikeFoodConverter.toMemberListFoodList(likeFoodList);

        memberLikeFoodList.forEach(memberLikeFood -> memberLikeFood.setMember(newMember));

        return memberRepository.save(newMember);
    }

    @Override
    public LoginResultDto loginMember(LoginRequestDto request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new ErrorHandler(ErrorStatus.INVALID_PASSWORD);
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                member.getEmail(), null,
                Collections.singleton(() -> member.getRole().name()) // 싱글톤 이건 뭐지 왜하는거지
        );

        String accessToken = jwtTokenProvider.generateToken(authentication);
        return MemberConverter.toLoginResultDto(
                member.getId(),
                accessToken
        );
    }


}
