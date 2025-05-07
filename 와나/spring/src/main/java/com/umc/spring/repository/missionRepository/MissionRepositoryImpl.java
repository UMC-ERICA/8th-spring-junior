package com.umc.spring.repository.missionRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.spring.domain.*;
import com.umc.spring.domain.enums.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission mission = QMission.mission;

    private final QRegion region = QRegion.region;


    @Override
    public List<Mission> findMissionsByRegionAndStatus(Region restRegion) {
        QRestaurant restaurant = QRestaurant.restaurant;

        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.restaurant, restaurant).fetchJoin()
                .join(restaurant.region, region).fetchJoin()
                .where(
                        sameRegion(restRegion),
                        mission.status.eq(MissionStatus.PROGRESS)
                )
                .orderBy(mission.deadline.asc())
                .fetch();
    }

    private BooleanExpression sameRegion(Region restRegion) {
        return region.cityDo.eq(restRegion.getCityDo())
                .and(QRegion.region.siGunGu.eq(restRegion.getSiGunGu()))
                .and(QRegion.region.dong.eq(restRegion.getDong()));
    }
}
