package com.umc.spring.service.RestaurantService;

import com.umc.spring.domain.Restaurant;
import com.umc.spring.repository.restaurantRepository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

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
}
