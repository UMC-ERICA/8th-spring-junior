package umc.study.repository.memberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.QMember;
import umc.study.domain.QReview;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Member findMemberWithReviews(Long memberId) {
        QMember m = QMember.member;
        QReview r = QReview.review;

        return queryFactory
                .selectFrom(m)
                .leftJoin(m.reviewList, r).fetchJoin()
                .where(m.id.eq(memberId))
                .fetchOne();
    }
}

