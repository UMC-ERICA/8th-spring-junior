package com.umc.spring.repository.restaurantRepository;

import com.umc.spring.domain.Restaurant;

import java.util.List;

public interface RestaurantRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
