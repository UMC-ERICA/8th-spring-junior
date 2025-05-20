package umc.study.service.RestaurantService;

import umc.study.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantDTO.RestaurantResponseDTO;

public interface RestaurantCommandService {
    RestaurantResponseDTO.AddRestaurantResult addRestaurant(RestaurantRequestDTO.AddRestaurant request);
}