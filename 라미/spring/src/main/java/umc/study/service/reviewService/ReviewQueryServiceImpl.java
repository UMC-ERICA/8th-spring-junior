package umc.study.service.reviewService;

import umc.study.domain.Review;
import umc.study.repository.reviewRepository.ReviewRepository;

public class ReviewQueryServiceImpl implements ReviewQueryService {
    private ReviewRepository reviewRepository;

    @Override
    public Review writeReview(Review review) {
        return reviewRepository.save(review);
    }
}
