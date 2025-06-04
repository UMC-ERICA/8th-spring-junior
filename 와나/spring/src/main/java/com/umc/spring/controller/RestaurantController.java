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
import com.umc.spring.service.RestaurantService.RestaurantQueryService;
import com.umc.spring.service.missionService.MissionCommandService;
import com.umc.spring.service.reviewService.ReviewCommandService;
import com.umc.spring.validation.annotation.ExistRestaurants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
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
@Validated
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;

    private final RestaurantQueryService restaurantQueryService;

    private final ReviewCommandService reviewCommandService;

    private final MissionCommandService missionCommandService;

    @PostMapping("/create")
    public ApiResponse<RestaurantCreateResponseDto> addRestaurant(@RequestBody @Valid RestCreateDto request) {
        Restaurant restaurant = restaurantCommandService.createRestaurant(request);
        return ApiResponse.onSuccess(toRestCreateResponse(restaurant));
    }

    @PostMapping("/{restId}/reviews")
    public ApiResponse<ReviewCreateResponseDto> writeReviewToRestaurant(@PathVariable @Valid Long restId,
                                                            @RequestBody @Valid ReviewCreateDto request) {
        Review review = reviewCommandService.writeReview(request, restId);
        return ApiResponse.onSuccess(toReviewCreateResponseDto(review));
    }

    @GetMapping("/{restId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewPreViewListDto> getReviewList(@PathVariable Long restId,
                                                           @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = restaurantQueryService.getReviewList(restId, page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDto(reviewList));
    }

    @PostMapping("/{restId}/missions")
    public ApiResponse<Long> addMissionToRestaurant(@PathVariable @Valid Long restId,
                                                    @RequestBody @Valid MissionCreateDto request) {
        Mission mission = missionCommandService.createMission(request, restId);
        return ApiResponse.onSuccess(mission.getId());
    }
}
