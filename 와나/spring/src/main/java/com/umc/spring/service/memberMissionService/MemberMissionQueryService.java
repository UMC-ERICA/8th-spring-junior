package com.umc.spring.service.memberMissionService;

import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MemberMissionQueryService {
    List<MemberMission> findMissionsByStatus(Long memberId, MemberMissionStatus status);

}
