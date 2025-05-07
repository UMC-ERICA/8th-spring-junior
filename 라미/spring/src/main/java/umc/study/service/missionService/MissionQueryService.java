package umc.study.service.missionService;

import umc.study.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getAvailableMissions(Long memberId, int offset, int limit);
}

