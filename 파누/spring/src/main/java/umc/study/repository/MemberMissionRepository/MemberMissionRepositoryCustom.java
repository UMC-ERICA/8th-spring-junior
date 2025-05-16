package umc.study.repository.MemberMissionRepository;

import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findByMemberAndStatus(Long memberId, MissionStatus status);
}
