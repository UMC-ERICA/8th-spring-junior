package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class CreateMission {
        @NotBlank
        private String title;

        @NotBlank
        private String content;
    }
}
