package umc.study.web.dto.RestaurantDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class AddRestaurant {
        @NotBlank
        private String name;

        @NotBlank
        private String address;

        @NotBlank
        private String category;
    }
}