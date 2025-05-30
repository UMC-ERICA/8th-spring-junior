package com.umc.spring.service.missionService;

import com.umc.spring.domain.Mission;
import com.umc.spring.dto.requestDto.MissionRequestDto;

import static com.umc.spring.dto.requestDto.MissionRequestDto.*;

public interface MissionCommandService {

    Mission createMission(MissionCreateDto request, Long restId);

    Long startMission(Long missionId);

}
