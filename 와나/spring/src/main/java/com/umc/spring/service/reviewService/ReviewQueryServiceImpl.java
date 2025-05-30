package com.umc.spring.service.reviewService;

import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.ErrorHandler;
import com.umc.spring.domain.Member;
import com.umc.spring.domain.Review;
import com.umc.spring.repository.memberRepository.MemberRepository;
import com.umc.spring.repository.reviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    @Override
    public List<Review> findReviewsByRestaurantId(Long restaurantId) {
        return reviewRepository.findReviewsByRestaurantId(restaurantId);
    }

    @Override
    public Page<Review> getReviewListByMemberId(Long memberId, Integer page) {
        Member member = memberRepository.findMemberById(memberId)
                .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (page <= 0) {
            throw new ErrorHandler(ErrorStatus.NEGATIVE_PAGE_NUMBER_REQUEST);
        }

        return reviewRepository.findAllByMember(member, PageRequest.of(page - 1, 10));
    }

}
