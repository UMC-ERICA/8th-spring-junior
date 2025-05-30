package com.umc.spring.convert;

import com.umc.spring.domain.Region;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import com.umc.spring.domain.enums.Category;
import com.umc.spring.domain.enums.Gender;
import com.umc.spring.dto.requestDto.RestaurantRequestDto;
import com.umc.spring.dto.responseDto.RestaurantResponseDto;
import com.umc.spring.dto.responseDto.ReviewResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

import static com.umc.spring.dto.requestDto.RestaurantRequestDto.*;
import static com.umc.spring.dto.responseDto.RestaurantResponseDto.*;
import static com.umc.spring.dto.responseDto.ReviewResponseDto.*;

public class RestaurantConverter {

    public static RestaurantCreateResponseDto toRestCreateResponse(Restaurant restaurant) {
        return RestaurantCreateResponseDto.builder()
                .restId(restaurant.getId())
                .build();
    }

    public static Restaurant toRestaurant(RestCreateDto request, Region region) {
        Category category = Category.fromCode(request.getCategory());
        return Restaurant.builder()
                .category(category)
                .region(region)
                .restName(request.getRestName())
                .build();

    }

    public static ReviewPreViewDto reviewPreViewDto(Review review) {
        return ReviewPreViewDto.builder()
                .ownerNickname(review.getMember().getUsername())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .body(review.getContent())
                .build();
    }

    public static ReviewPreViewListDto reviewPreViewListDto(Page<Review> reviewList) {
        List<ReviewPreViewDto> reviewPreViewDtoList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDto).collect(Collectors.toList());

        return ReviewResponseDto.ReviewPreViewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDtoList.size())
                .reviewList(reviewPreViewDtoList)
                .build();
    }
}
