package com.umc.spring.convert;

import com.umc.spring.domain.Region;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.enums.Category;
import com.umc.spring.domain.enums.Gender;

import static com.umc.spring.dto.requestDto.RestaurantRequestDto.*;
import static com.umc.spring.dto.responseDto.RestaurantResponseDto.*;

public class RestaurantConverter {

    public static RestaurantCreateResponseDto toRestCreateResponse(Restaurant restaurant) {
        return RestaurantCreateResponseDto.builder()
                .restId(restaurant.getId())
                .build();
    }

    public static Restaurant toRestaurant(RestCreateDto request, Region region) {
        Category category = Category.fromCode(request.getCategory());
        return Restaurant.builder()
                .category(category)
                .region(region)
                .restName(request.getName())
                .build();

    }
}
