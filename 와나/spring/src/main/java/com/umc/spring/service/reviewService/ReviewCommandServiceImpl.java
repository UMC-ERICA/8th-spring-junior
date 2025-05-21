package com.umc.spring.service.reviewService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.convert.ReviewConverter;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import com.umc.spring.dto.requestDto.ReviewRequestDto;
import com.umc.spring.repository.memberRepository.MemberRepository;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import com.umc.spring.repository.reviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.umc.spring.convert.ReviewConverter.*;
import static com.umc.spring.dto.requestDto.ReviewRequestDto.*;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review writeReview(ReviewCreateDto request, Long restId) {
        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        // 하드코딩
        Member member = memberRepository.findById(1L)
                        .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Review review = toReview(request, member, restaurant);

        return reviewRepository.save(review);
    }
}
