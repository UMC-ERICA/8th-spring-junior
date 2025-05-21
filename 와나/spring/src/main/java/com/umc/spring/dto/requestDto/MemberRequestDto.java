package com.umc.spring.dto.requestDto;

import com.umc.spring.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.List;

public class MemberRequestDto {

    @Getter
    public static class JoinDto {
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String addr;
        @ExistCategories
        List<Long> likeFoods;
    }
}
