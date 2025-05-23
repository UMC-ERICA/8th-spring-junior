package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.domain.Store;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateMission request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.MissionIdResult toMissionIdResult(Mission mission) {
        return MissionResponseDTO.MissionIdResult.builder()
                .missionId(mission.getId())
                .build();
    }
}
