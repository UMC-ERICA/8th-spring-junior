package umc.study.service.MissionService;


import umc.study.web.dto.MissionDTO.MissionRequestDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.AddMissionResult addMission(MissionRequestDTO.AddMission request);
}