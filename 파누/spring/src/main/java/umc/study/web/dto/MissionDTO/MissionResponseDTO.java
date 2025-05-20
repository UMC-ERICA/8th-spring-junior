package umc.study.web.dto.MissionDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MissionResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class AddMissionResult {
        private Long missionId;
        private String message;
    }
}