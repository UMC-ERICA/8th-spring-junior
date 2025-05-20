package umc.study.web.controller.RestaurantController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantDTO.RestaurantResponseDTO;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResult> addRestaurant(
            @RequestBody @Valid RestaurantRequestDTO.AddRestaurant request
    ) {
        return ApiResponse.onSuccess(restaurantCommandService.addRestaurant(request));
    }
}