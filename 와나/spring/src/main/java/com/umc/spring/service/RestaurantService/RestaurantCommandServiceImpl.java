package com.umc.spring.service.RestaurantService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.convert.RestaurantConverter;
import com.umc.spring.domain.Region;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.enums.Category;
import com.umc.spring.dto.requestDto.RestaurantRequestDto;
import com.umc.spring.repository.RegionRepository;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.umc.spring.dto.requestDto.RestaurantRequestDto.*;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final RegionRepository regionRepository;

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(RestCreateDto dto) {
        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        Restaurant restaurant = RestaurantConverter.toRestaurant(dto, region);
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
        return saveRestaurant;


    }

}
