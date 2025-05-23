package umc.study.service.reviewService;

import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.ReviewIdResult createReview(Long storeId, ReviewRequestDTO.CreateReview request);
}

