package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.RestaurantRepository.RestaurantRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.study.web.dto.ReviewDTO.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponseDTO.AddReviewResult addReview(ReviewRequestDTO.AddReview request) {
        Member member = memberRepository.findAll().get(0); // 하드코딩된 멤버

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("해당 가게 없음"));

        Review review = Review.builder()
                .member(member)
                .restaurant(restaurant)
                .content(request.getContent())
//                .rating(request.getRating())
                .build();

        Review saved = reviewRepository.save(review);

        return new ReviewResponseDTO.AddReviewResult(saved.getId(), "리뷰 등록 완료");
    }
}