package com.umc.spring.repository.reviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.QReview;
import com.umc.spring.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private final QReview review = QReview.review;

    @Override
    public List<Review> findReviewsByRestaurantId(Long restaurantId) {
        return jpaQueryFactory
                .selectFrom(review)
                .where(
                        review.restaurant.id.eq(restaurantId)
                )
                .fetch()
                ;
    }
}
