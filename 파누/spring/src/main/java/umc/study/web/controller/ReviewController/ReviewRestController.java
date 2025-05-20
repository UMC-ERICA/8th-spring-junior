package umc.study.web.controller.ReviewController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.study.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ApiResponse<ReviewResponseDTO.AddReviewResult> addReview(
            @RequestBody @Valid ReviewRequestDTO.AddReview request
    ) {
        return ApiResponse.onSuccess(reviewCommandService.addReview(request));
    }
}