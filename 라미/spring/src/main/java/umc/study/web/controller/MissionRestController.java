package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.missionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.MissionIdResult> createMission(
            @PathVariable("storeId") Long storeId,
            @RequestBody @Valid MissionRequestDTO.CreateMission request
    ) {
        return ApiResponse.onSuccess(missionCommandService.createMission(storeId, request));
    }
}

