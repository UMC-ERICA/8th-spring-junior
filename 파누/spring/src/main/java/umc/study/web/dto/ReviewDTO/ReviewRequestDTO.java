package umc.study.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistsRestaurant;

public class ReviewRequestDTO {

    @Getter
    public static class AddReview {
        @NotNull
        @ExistsRestaurant
        private Long restaurantId;

        @NotBlank
        private String content;

        @NotNull
        private Integer rating;
    }
}
