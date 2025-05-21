package com.umc.spring.convert;

import com.umc.spring.domain.Mission;
import com.umc.spring.domain.Restaurant;
import com.umc.spring.domain.enums.AccMethod;
import com.umc.spring.domain.enums.Gender;
import com.umc.spring.dto.requestDto.MissionRequestDto;
import com.umc.spring.dto.responseDto.MissionResponseDto;

import java.time.LocalDate;

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


}
