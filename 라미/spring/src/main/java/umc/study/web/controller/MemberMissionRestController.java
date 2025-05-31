package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.memerMissionService.MemberMissionCommandService;
import umc.study.web.dto.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{storeId}/missions/{missionId}/challenge")
    public ApiResponse<MemberMissionResponseDTO.ChallengeResult> challengeMission(
            @PathVariable("storeId") Long storeId,
            @PathVariable("missionId") Long missionId,
            @RequestBody @Valid MemberMissionRequestDTO.ChallengeRequest request
    ) {
        return ApiResponse.onSuccess(
                memberMissionCommandService.challengeMission(storeId, missionId, request)
        );
    }

}