package com.umc.spring.repository.missionRepository;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Region;
import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {

    List<Mission> findMissionsByRegionAndStatus(Region region);

}
