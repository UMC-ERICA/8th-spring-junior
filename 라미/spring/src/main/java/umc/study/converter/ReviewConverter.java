package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO.CreateReview dto, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .content(dto.getContent())
                .rating(dto.getRating())
                .build();
    }

    public static ReviewResponseDTO.ReviewIdResult toReviewIdResult(Review review) {
        return ReviewResponseDTO.ReviewIdResult.builder()
                .reviewId(review.getId())
                .build();
    }
}
