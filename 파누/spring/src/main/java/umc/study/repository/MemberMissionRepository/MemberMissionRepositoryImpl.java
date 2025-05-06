package umc.study.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMission;
import umc.study.domain.QRestaurant;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMission> findByMemberAndStatus(Long memberId, MissionStatus status) {
        QMemberMission mm = QMemberMission.memberMission;
        QMission m = QMission.mission;
        QRestaurant r = QRestaurant.restaurant;

        return queryFactory
                .selectFrom(mm)
                .join(mm.mission, m).fetchJoin()
                .join(m.restaurant, r).fetchJoin()
                .where(
                        mm.member.id.eq(memberId),
                        mm.status.eq(status)
                )
                .orderBy(mm.createdAt.desc())
                .fetch();
    }
}
