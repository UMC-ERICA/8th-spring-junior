package com.umc.spring.repository.reviewRepository;

import com.umc.spring.domain.Member;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    List<Review> findReviewsByMemberId(Long memberId);

    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
