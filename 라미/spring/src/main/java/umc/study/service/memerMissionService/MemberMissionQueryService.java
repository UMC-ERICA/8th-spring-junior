package umc.study.service.memerMissionService;

import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMission> getMyMissionList(Long memberId, int offset, int limit);
}

