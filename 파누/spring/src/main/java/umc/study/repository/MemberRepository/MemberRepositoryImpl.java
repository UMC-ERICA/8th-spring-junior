package umc.study.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.QMember;
import umc.study.domain.QReview;
import umc.study.repository.MemberRepository.MemberRepositoryCustom;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Member findWithReviews(Long memberId) {
        QMember member = QMember.member;
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(member)
                .leftJoin(member.reviewList, review).fetchJoin()
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
