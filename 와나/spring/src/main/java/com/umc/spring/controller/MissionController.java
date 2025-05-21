package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.MissionConverter;
import com.umc.spring.service.missionService.MissionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.umc.spring.dto.responseDto.MissionResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}/members")
    public ApiResponse<MissionStartResponseDto> startMission(@PathVariable Long missionId) {
        Long memberMissionId = missionCommandService.startMission(missionId);
        return ApiResponse.onSuccess(MissionConverter.toMissionStartResponseDto(memberMissionId));
    }
}
