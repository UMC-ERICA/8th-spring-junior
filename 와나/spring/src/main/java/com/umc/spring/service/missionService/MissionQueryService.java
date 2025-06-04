package com.umc.spring.service.missionService;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Region;
import com.umc.spring.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MissionQueryService {

    MemberMission findMemberMission(Long memberId, Long missionId);

    List<Mission> findMissionsByRegionAndStatus(Region region);

    Page<Mission> getMissionListByMemberId(Long memberId, Integer page);

    Page<Mission> getMissionListByRestaurantId(Long restId, Integer page);

    Page<MemberMission> updateMissionStatusByMissionId(Long missionId, Long memberId, Integer page);
}
