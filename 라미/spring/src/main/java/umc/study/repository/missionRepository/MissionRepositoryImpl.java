package umc.study.repository.missionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findAvailableMissionsByMemberRegion(Long memberId, int offset, int limit) {
        QMission m = QMission.mission;
        QStore s = QStore.store;
        QAddress a = QAddress.address;
        QMember mem = QMember.member;
        QMemberMission mm = QMemberMission.memberMission;

        // 서브쿼리 방식 대신 member.address를 직접 불러와 조인 필터링
        return queryFactory
                .selectFrom(m)
                .join(m.store, s).fetchJoin()
                .join(s.address, a).fetchJoin()
                .join(mem).on(mem.id.eq(memberId)) // 회원 조인
                .leftJoin(mm).on(mm.member.id.eq(mem.id).and(mm.mission.id.eq(m.id))) // 도전 여부 확인
                .where(
                        a.city.eq(mem.address),
                        mm.id.isNull()
                )
                .orderBy(m.createdAt.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }
}
