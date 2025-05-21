package com.umc.spring.dto.requestDto;

import com.umc.spring.domain.enums.Category;
import com.umc.spring.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.List;

public class RestaurantRequestDto {

    @Getter
    public static class RestCreateDto {
        String name;
        Integer category; // Food랑 Restaurant 테이블의 매핑테이블 만들어서 관리하는 게 나을 거 같기도 ..??
        Long regionId;
    }


}
