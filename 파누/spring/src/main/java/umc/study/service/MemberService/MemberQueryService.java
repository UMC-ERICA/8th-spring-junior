package umc.study.service.MemberService;

import umc.study.domain.Member;

public interface MemberQueryService {
    Member getMemberWithReviews(Long memberId);
}
