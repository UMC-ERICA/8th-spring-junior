package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.study.web.dto.ReviewDTO.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.AddReviewResult addReview(ReviewRequestDTO.AddReview request);
}