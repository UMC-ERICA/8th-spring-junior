package com.umc.spring.service.RestaurantService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import com.umc.spring.repository.reviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findRestaurantsByNameAndScore(String name, Float score) {
        List<Restaurant> filteredStores = restaurantRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(restaurant -> System.out.println("Restaurant : " + restaurant));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        return reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }
}
