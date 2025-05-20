package umc.study.web.dto.MissionDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMission {
        @NotNull
        private Long restaurantId;

        @NotBlank
        private String description;

        @NotNull
        private Integer rewardPoint;

        @NotNull
        @Future
        private LocalDate startDate;

        @NotNull
        @Future
        private LocalDate endDate;
    }
}
