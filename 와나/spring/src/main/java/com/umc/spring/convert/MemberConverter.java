package com.umc.spring.convert;

import com.umc.spring.domain.enums.Gender;
import com.umc.spring.dto.requestDto.MemberRequestDto;
import com.umc.spring.dto.responseDto.MemberResponseDto;
import com.umc.spring.domain.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
                .address(request.getAddr())
                .gender(gender)
                .birth(birth)
                .username(request.getName())
                .memberLikeFoods(new ArrayList<>()) // 선호 음식 말고 다른 리스트들은 초기화 안 해도 되나?
                .build();
    }
}
