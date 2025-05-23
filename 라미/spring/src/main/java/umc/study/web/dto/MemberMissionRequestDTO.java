package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {
    @Getter
    public static class ChallengeRequest {
        @NotNull
        private Long memberId;
    }
}
