package com.umc.spring.repository.reviewRepository;

import com.umc.spring.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByRestaurantId(Long restaurantId);
}
