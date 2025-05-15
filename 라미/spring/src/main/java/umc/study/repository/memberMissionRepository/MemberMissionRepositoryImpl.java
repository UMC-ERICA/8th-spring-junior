package umc.study.repository.memberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMission> findMissionsByMemberId(Long memberId, int offset, int limit) {
        QMemberMission mm = QMemberMission.memberMission;
        QMission m = QMission.mission;
        QStore s = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(mm.member.id.eq(memberId));
        builder.and(mm.status.in(MissionStatus.IN_PROGRESS, MissionStatus.COMPLETED));

        return queryFactory
                .selectFrom(mm)
                .join(mm.mission, m).fetchJoin()
                .join(m.store, s).fetchJoin()
                .where(builder)
                .orderBy(mm.createdAt.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}
