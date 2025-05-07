package com.umc.spring.service.reviewService;

import com.umc.spring.domain.Review;
import com.umc.spring.repository.reviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;


    @Override
    public List<Review> findReviewsByRestaurantId(Long restaurantId) {
        return reviewRepository.findReviewsByRestaurantId(restaurantId);
    }
}
