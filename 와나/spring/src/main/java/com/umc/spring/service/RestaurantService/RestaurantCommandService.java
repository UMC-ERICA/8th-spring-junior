package com.umc.spring.service.RestaurantService;

import com.umc.spring.domain.Restaurant;
import com.umc.spring.dto.requestDto.RestaurantRequestDto;

import static com.umc.spring.dto.requestDto.RestaurantRequestDto.*;

public interface RestaurantCommandService {

    Restaurant createRestaurant(RestCreateDto dto);
}
