package umc.study.web.controller.MissionController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionDTO.MissionRequestDTO;
import umc.study.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequestMapping("/api/v1/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping
    public ApiResponse<MissionResponseDTO.AddMissionResult> addMission(
            @RequestBody @Valid MissionRequestDTO.AddMission request
    ) {
        return ApiResponse.onSuccess(missionCommandService.addMission(request));
    }
}