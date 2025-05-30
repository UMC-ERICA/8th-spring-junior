package com.umc.spring.service.RestaurantService;

import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);

    List<Restaurant> findRestaurantsByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long restaurantId, Integer page);
}
