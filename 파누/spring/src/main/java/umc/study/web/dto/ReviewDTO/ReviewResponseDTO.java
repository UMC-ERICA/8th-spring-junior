package umc.study.web.dto.ReviewDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReviewResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class AddReviewResult {
        private Long reviewId;
        private String message;
    }
}