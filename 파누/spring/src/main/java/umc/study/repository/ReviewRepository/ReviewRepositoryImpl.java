package umc.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.QReview;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository.ReviewRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findReviewsByRestaurantId(Long restaurantId) {
        QReview review = QReview.review;
        QMember member = QMember.member;

        return queryFactory
                .selectFrom(review)
                .join(review.member, member).fetchJoin()
                .where(review.restaurant.id.eq(restaurantId))
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}
