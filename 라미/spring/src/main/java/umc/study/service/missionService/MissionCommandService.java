package umc.study.service.missionService;

import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.MissionIdResult createMission(Long storeId, MissionRequestDTO.CreateMission request);
}
