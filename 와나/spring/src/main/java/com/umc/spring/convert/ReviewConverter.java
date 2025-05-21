package com.umc.spring.convert;

import com.umc.spring.domain.Member;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import com.umc.spring.dto.requestDto.ReviewRequestDto;
import com.umc.spring.dto.responseDto.ReviewResponseDto;

import static com.umc.spring.dto.requestDto.ReviewRequestDto.*;
import static com.umc.spring.dto.responseDto.ReviewResponseDto.*;

public class ReviewConverter {

    public static Review toReview(ReviewCreateDto request, Member member, Restaurant restaurant) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .member(member)
                .restaurant(restaurant)
                .build();

    }

    public static ReviewCreateResponseDto toReviewCreateResponseDto(Review review) {
        return ReviewCreateResponseDto.builder()
                .reviewId(review.getId())
                .build();
    }
}
