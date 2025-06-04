package com.umc.spring.convert;

import com.umc.spring.domain.Food;
import com.umc.spring.domain.enums.Gender;
import com.umc.spring.domain.mapping.MemberLikeFood;
import com.umc.spring.dto.requestDto.MemberRequestDto;
import com.umc.spring.dto.responseDto.MemberResponseDto;
import com.umc.spring.domain.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.umc.spring.dto.requestDto.MemberRequestDto.*;
import static com.umc.spring.dto.responseDto.MemberResponseDto.*;

public class MemberConverter {

    public static JoinResultDto toJoinResultDto(Member member) {
        return JoinResultDto.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build()
                ;
    }

    public static Member toMember(JoinDto request) {
        List<MemberLikeFood> likeFoods = new ArrayList<>();
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }


        LocalDate birth = LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDay());
        return Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddr())
                .gender(gender)
                .birth(birth)
                .username(request.getName())
                .memberLikeFoods(new ArrayList<>()) // 선호 음식 말고 다른 리스트들은 초기화 안 해도 되나?
                .role(request.getRole())
                .build();
    }

    public static LoginResultDto toLoginResultDto(Long memberId, String accessToken) {
        return LoginResultDto.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberInfoDto toMemberInfoDto(Member member) {
        return MemberInfoDto.builder()
                .name(member.getUsername())
                .email(member.getEmail())
                .gender(member.getGender().toString())
                .build();
    }
}
