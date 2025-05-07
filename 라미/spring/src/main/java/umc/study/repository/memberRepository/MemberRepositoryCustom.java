package umc.study.repository.memberRepository;

import umc.study.domain.Member;

public interface MemberRepositoryCustom {
    Member findMemberWithReviews(Long memberId);
}

