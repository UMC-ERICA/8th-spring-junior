package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ReviewResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewIdResult {
        private Long reviewId;
    }
}
