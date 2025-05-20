package umc.study.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Restaurant;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantDTO.RestaurantResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponseDTO.AddRestaurantResult addRestaurant(RestaurantRequestDTO.AddRestaurant request) {
        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .location(request.getAddress())
                .build();

        Restaurant saved = restaurantRepository.save(restaurant);
        return new RestaurantResponseDTO.AddRestaurantResult(saved.getId(), saved.getName());
    }
}