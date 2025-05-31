package umc.study.web.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class CreateReview {
        @NotNull
        private Long memberId;

        @NotBlank
        private String content;

        @Min(1)
        @Max(5)
        private Integer rating;

        private String title;
    }
}
