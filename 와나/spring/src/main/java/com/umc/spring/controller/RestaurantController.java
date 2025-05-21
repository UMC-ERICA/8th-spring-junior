package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.MemberConverter;
import com.umc.spring.convert.RestaurantConverter;
import com.umc.spring.convert.ReviewConverter;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import com.umc.spring.dto.requestDto.MemberRequestDto;
import com.umc.spring.dto.requestDto.MissionRequestDto;
import com.umc.spring.dto.requestDto.RestaurantRequestDto;
import com.umc.spring.dto.requestDto.ReviewRequestDto;
import com.umc.spring.dto.responseDto.MemberResponseDto;
import com.umc.spring.dto.responseDto.RestaurantResponseDto;
import com.umc.spring.dto.responseDto.ReviewResponseDto;
import com.umc.spring.service.RestaurantService.RestaurantCommandService;
import com.umc.spring.service.missionService.MissionCommandService;
import com.umc.spring.service.reviewService.ReviewCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.umc.spring.convert.RestaurantConverter.*;
import static com.umc.spring.convert.ReviewConverter.*;
import static com.umc.spring.dto.requestDto.MissionRequestDto.*;
import static com.umc.spring.dto.requestDto.RestaurantRequestDto.*;
import static com.umc.spring.dto.requestDto.ReviewRequestDto.*;
import static com.umc.spring.dto.responseDto.RestaurantResponseDto.*;
import static com.umc.spring.dto.responseDto.ReviewResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;

    private final ReviewCommandService reviewCommandService;

    private final MissionCommandService missionCommandService;

    @PostMapping("/create")
    public ApiResponse<RestaurantCreateResponseDto> addRestaurant(@RequestBody @Valid RestCreateDto request) {
        Restaurant restaurant = restaurantCommandService.createRestaurant(request);
        return ApiResponse.onSuccess(toRestCreateResponse(restaurant));
    }

    @PostMapping("/{restId}/reviews")
    public ApiResponse<ReviewCreateResponseDto> writeReviewToRestaurant(@PathVariable Long restId,
                                                            @RequestBody ReviewCreateDto request) {
        Review review = reviewCommandService.writeReview(request, restId);
        return ApiResponse.onSuccess(toReviewCreateResponseDto(review));
    }

    @PostMapping("/{restId}/missions")
    public ApiResponse<Long> addMissionToRestaurant(@PathVariable Long restId,
                                                    @RequestBody MissionCreateDto request) {
        Mission mission = missionCommandService.createMission(request, restId);
        return ApiResponse.onSuccess(mission.getId());
    }
}
