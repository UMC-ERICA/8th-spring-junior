package com.umc.spring.dto.requestDto;

import com.umc.spring.domain.enums.AccMethod;
import lombok.Getter;

public class MissionRequestDto {

    @Getter
    public static class MissionCreateDto {
        String content;
        Integer successPrice;
        Integer accMethod;
        Integer accPoint;
        Integer deadlineY;
        Integer deadlineM;
        Integer deadlineD;
    }
}
