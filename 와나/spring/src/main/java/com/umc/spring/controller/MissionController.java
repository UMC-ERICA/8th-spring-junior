package com.umc.spring.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.MissionConverter;
import com.umc.spring.domain.Mission;
import com.umc.spring.domain.enums.MissionStatus;
import com.umc.spring.domain.mapping.MemberMission;
import com.umc.spring.service.missionService.MissionCommandService;
import com.umc.spring.service.missionService.MissionQueryService;
import com.umc.spring.validation.annotation.AlreadyStart;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static com.umc.spring.domain.mapping.QMemberMission.memberMission;
import static com.umc.spring.dto.responseDto.MissionResponseDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/{missionId}/members")
    public ApiResponse<MissionStartResponseDto> startMission(@PathVariable @Valid Long missionId) {
        Long memberMissionId = missionCommandService.startMission(missionId);
        return ApiResponse.onSuccess(MissionConverter.toMissionStartResponseDto(memberMissionId));
    }

    @GetMapping("/restaurants/{restId}")
    public ApiResponse<MissionListResponseDto> getMissionListOfRestaurant(@PathVariable Long restId,
                                                                      @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = missionQueryService.getMissionListByRestaurantId(restId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDto(missionList));
    }

    @GetMapping("/members/{memberId}")
    public ApiResponse<MissionListResponseDto> getMissionListOfMember(@PathVariable Long memberId,
                                                                      @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = missionQueryService.getMissionListByMemberId(memberId, page);
        return ApiResponse.onSuccess(MissionConverter.toMissionListDto(missionList));
    }

    // 로그인 기능 구현 안 되어서 일단 memberId를 받았다는 가정
    @PatchMapping("/{missionId}/complete")
    public ApiResponse<MyMissionListResponseDto> applyMissionComplete(@PathVariable Long missionId,
                                                                    @RequestParam(name = "page") Integer page,
                                                                    Long memberId) {
        Page<MemberMission> memberMissions = missionQueryService.updateMissionStatusByMissionId(missionId, memberId, page);
        return ApiResponse.onSuccess(MissionConverter.toMyMissionListDto(memberMissions));

    }

}
