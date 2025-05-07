package umc.study.repository.memberMissionRepository;

import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findMissionsByMemberId(Long memberId, int offset, int limit);
}

