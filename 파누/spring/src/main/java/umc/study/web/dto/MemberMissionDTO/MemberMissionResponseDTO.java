package umc.study.web.dto.MemberMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberMissionResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class JoinMissionResult {
        private Long memberMissionId;
        private String message;
    }
}
