package umc.study.service.MemberMissionService;

import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMission> getMissionsByStatus(Long memberId, MissionStatus status);
}
