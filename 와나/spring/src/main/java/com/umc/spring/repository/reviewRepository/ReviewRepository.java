package com.umc.spring.repository.reviewRepository;

import com.umc.spring.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    List<Review> findReviewsByMemberId(Long memberId);
}
