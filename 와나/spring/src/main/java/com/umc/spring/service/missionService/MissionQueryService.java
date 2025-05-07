package com.umc.spring.service.missionService;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Region;

import java.util.List;

public interface MissionQueryService {

    List<Mission> findMissionsByRegionAndStatus(Region region);
}
