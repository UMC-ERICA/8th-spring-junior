package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.RestaurantConverter;
import com.umc.spring.convert.ReviewConverter;
import com.umc.spring.domain.Review;
import com.umc.spring.dto.responseDto.ReviewResponseDto;
import com.umc.spring.service.reviewService.ReviewQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static com.umc.spring.dto.responseDto.ReviewResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    // 내가 작성한 리뷰 목록
    @GetMapping("/members/{memberId}")
    public ApiResponse<ReviewPreViewListDto> myReviews(@Valid @PathVariable Long memberId,
                                                       @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = reviewQueryService.getReviewListByMemberId(memberId, page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDto(reviewList));
    }

}
