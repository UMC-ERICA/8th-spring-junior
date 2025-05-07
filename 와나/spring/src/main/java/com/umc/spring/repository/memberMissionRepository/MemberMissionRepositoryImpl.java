package com.umc.spring.repository.memberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.mapping.MemberMission;
import com.umc.spring.domain.mapping.QMemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<MemberMission> findMissionByMemberIdAndStatus(Long memberId, MemberMissionStatus status) {
        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(status)
                )
                .orderBy(memberMission.createdAt.desc())
                .fetch();
    }
}
