package umc.study.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Restaurant;
import umc.study.domain.Review;
import umc.study.domain.enums.ReviewRank;
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
                /*
                내가 에러 잡다가 이거 DTO에 없는데 넣으려고 해서 오류 나는 것 같아서 일단 하드코딩으로 박아뒀습니다!
                * 나중에 수정 해주세요!
                * */
                .rank(ReviewRank.R1)
                .build();

        Review saved = reviewRepository.save(review);

        return new ReviewResponseDTO.AddReviewResult(saved.getId(), "리뷰 등록 완료");
    }
}