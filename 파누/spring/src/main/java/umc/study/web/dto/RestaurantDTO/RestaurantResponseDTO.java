package umc.study.web.dto.RestaurantDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class RestaurantResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class AddRestaurantResult {
        private Long id;
        private String name;
    }
}