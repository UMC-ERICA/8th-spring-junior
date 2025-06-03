package umc.study.service.memberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.mapping.MemberMission;

public interface MemberQueryService {
    void printMyPageInfo(Long memberId);

    Page<Review> getMyReviewList(Long memberId, Integer page);

    Page<MemberMission> getInProgressMissions(Long memberId, Integer page);
}
