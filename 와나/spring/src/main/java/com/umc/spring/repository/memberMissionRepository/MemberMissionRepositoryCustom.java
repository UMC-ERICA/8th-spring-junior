package com.umc.spring.repository.memberMissionRepository;

import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findMissionByMemberIdAndStatus(Long memberId, MemberMissionStatus status);
}
