package umc.study.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReview {
        @NotNull
        private Long restaurantId;

        @NotBlank
        private String content;

        @NotNull
        private Integer rating;
    }
}
