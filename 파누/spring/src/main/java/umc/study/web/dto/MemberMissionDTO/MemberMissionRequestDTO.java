package umc.study.web.dto.MemberMissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class JoinMission {
        @NotNull
        private Long missionId;
    }
}