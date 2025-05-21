package com.umc.spring.service.reviewService;

import com.umc.spring.domain.Review;
import com.umc.spring.dto.requestDto.ReviewRequestDto;

import static com.umc.spring.dto.requestDto.ReviewRequestDto.*;

public interface ReviewCommandService {

    Review writeReview(ReviewCreateDto request, Long restId);
}
