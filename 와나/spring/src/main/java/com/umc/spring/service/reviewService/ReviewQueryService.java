package com.umc.spring.service.reviewService;

import com.umc.spring.domain.Review;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReviewQueryService {
    List<Review> findReviewsByRestaurantId(Long restId);

    Page<Review> getReviewListByMemberId(Long memberId, Integer page);
}
