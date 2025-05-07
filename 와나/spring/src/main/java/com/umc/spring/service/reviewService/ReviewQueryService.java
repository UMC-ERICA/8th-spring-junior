package com.umc.spring.service.reviewService;

import com.umc.spring.domain.Review;

import java.util.List;

public interface ReviewQueryService {
    List<Review> findReviewsByRestaurantId(Long restId);
}
