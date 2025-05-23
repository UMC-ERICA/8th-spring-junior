package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;

public class MemberMissionResponseDTO {
    @Getter
    @Builder
    public static class ChallengeResult {
        private Long memberMissionId;
        private MissionStatus status;
    }
}
