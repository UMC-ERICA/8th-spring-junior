package umc.study.web.dto.MemberMissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.NotAlreadyChallenged;

public class MemberMissionRequestDTO {

    @Getter
    @NotAlreadyChallenged
    public static class JoinMission {
        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;
    }
}