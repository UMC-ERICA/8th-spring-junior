package umc.study.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QRestaurant;
import umc.study.repository.MissionRepository.MissionRepositoryCustom;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findMissionByLocation(String location) {
        QMission mission = QMission.mission;
        QRestaurant restaurant = QRestaurant.restaurant;

        return queryFactory
                .selectFrom(mission)
                .join(mission.restaurant, restaurant).fetchJoin()
                .where(
                        restaurant.location.containsIgnoreCase(location),
                        mission.deadline.after(LocalDateTime.now())
                )
                .orderBy(mission.deadline.asc())
                .fetch();
    }
}
