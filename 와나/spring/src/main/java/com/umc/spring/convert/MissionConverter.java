package com.umc.spring.convert;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.enums.AccMethod;
import com.umc.spring.domain.enums.Gender;
import com.umc.spring.domain.mapping.MemberMission;
import com.umc.spring.dto.requestDto.MissionRequestDto;
import com.umc.spring.dto.responseDto.MissionResponseDto;
import com.umc.spring.dto.responseDto.ReviewResponseDto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.umc.spring.dto.requestDto.MissionRequestDto.*;
import static com.umc.spring.dto.responseDto.MissionResponseDto.*;

public class MissionConverter {

    public static Mission toMission(MissionCreateDto request, String num, Restaurant restaurant) {

        AccMethod method = null;

        System.out.println(request.getAccMethod());
        switch (request.getAccMethod()) {
            case 0:
                method = AccMethod.PRICE;
                break;
            case 1:
                method = AccMethod.PERCENT;
                break;
        }

        LocalDate deadline = LocalDate.of(request.getDeadlineY(), request.getDeadlineM(), request.getDeadlineD());
        return Mission.builder()
                .restaurant(restaurant)
                .content(request.getContent())
                .successPrice(request.getSuccessPrice())
                .accMethod(method)
                .accPoint(request.getAccPoint())
                .certifiedNum(num)
                .deadline(deadline)
                .build();
    }

    public static MissionCreateResponseDto toMissionCreateResponseDto(Mission mission) {
        return MissionCreateResponseDto.builder()
                .missionId(mission.getId())
                .certNum(mission.getCertifiedNum())
                .build();
    }

    public static MissionStartResponseDto toMissionStartResponseDto(Long memberMissionId) {
        return MissionStartResponseDto.builder()
                .memberMissionId(memberMissionId)
                .build();
    }

    public static MissionPreviewDto toMissionPreviewDto(Mission mission) {
        return MissionPreviewDto.builder()
                .content(mission.getContent())
                .status(mission.getStatus())
                .restaurantName(mission.getRestaurant().getRestName())
                .accPoint(mission.getAccPoint())
                .createdAt(mission.getCreatedAt())
                .deadline(mission.getDeadline())
                .successPrice(mission.getSuccessPrice())
                .build();
    }

    public static MissionListResponseDto toMissionListDto(Page<Mission> missionList) {
        List<MissionPreviewDto> missionDtoList = missionList.stream()
                .map(MissionConverter::toMissionPreviewDto).collect(Collectors.toList());


        return MissionListResponseDto.builder()
                .missionList(missionDtoList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .listSize(missionDtoList.size())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .build();
    }

    public static MyMissionPreviewDto toMyMissionPreviewDto(Mission mission, MemberMission memberMission) {
        return MyMissionPreviewDto.builder()
                .content(mission.getContent())
                .status(memberMission.getStatus())
                .restaurantName(mission.getRestaurant().getRestName())
                .accPoint(mission.getAccPoint())
                .createdAt(mission.getCreatedAt())
                .deadline(mission.getDeadline())
                .successPrice(mission.getSuccessPrice())
                .build();
    }

    public static MyMissionListResponseDto toMyMissionListDto(Page<MemberMission> memberMissionPage) {
        List<MyMissionPreviewDto> missionDtoList = memberMissionPage.stream()
                .map(mission -> toMyMissionPreviewDto(mission.getMission(), mission))
                .collect(Collectors.toList());

        // 수정
        return MyMissionListResponseDto.builder()
                .missionList(missionDtoList)
                .isFirst(memberMissionPage.isFirst())
                .isLast(memberMissionPage.isLast())
                .listSize(missionDtoList.size())
                .totalElements(memberMissionPage.getTotalElements())
                .totalPage(memberMissionPage.getTotalPages())
                .build();
    }


}
