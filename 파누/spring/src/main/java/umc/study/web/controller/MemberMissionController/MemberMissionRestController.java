package umc.study.web.controller.MemberMissionController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.study.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

@RestController
@RequestMapping("/api/v1/member-missions")
@RequiredArgsConstructor
public class MemberMissionRestController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.JoinMissionResult> joinMission(
            @RequestBody @Valid MemberMissionRequestDTO.JoinMission request
    ) {
        return ApiResponse.onSuccess(memberMissionCommandService.joinMission(request));
    }
}
