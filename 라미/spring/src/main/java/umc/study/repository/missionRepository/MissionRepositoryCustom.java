package umc.study.repository.missionRepository;

import umc.study.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findAvailableMissionsByMemberRegion(Long memberId, int offset, int limit);
}