package com.umc.spring.dto.requestDto;

import lombok.Getter;

public class ReviewRequestDto {

    @Getter
    public static class ReviewCreateDto {
        String content;
        Double score;
    }
}
