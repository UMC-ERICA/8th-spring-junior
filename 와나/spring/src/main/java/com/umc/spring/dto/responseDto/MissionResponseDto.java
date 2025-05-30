package com.umc.spring.dto.responseDto;

import com.umc.spring.domain.enums.AccMethod;
import com.umc.spring.domain.enums.MemberMissionStatus;
import com.umc.spring.domain.enums.MissionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionCreateResponseDto {
        Long missionId;
        String certNum;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionStartResponseDto {
        Long memberMissionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionListResponseDto {
        List<MissionPreviewDto> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDto {
        String restaurantName;
        String content;
        MissionStatus status;
        Integer successPrice;
        Integer accPoint;
        LocalDateTime createdAt;
        LocalDate deadline;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionListResponseDto {
        List<MyMissionPreviewDto> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionPreviewDto {
        String restaurantName;
        String content;
        MemberMissionStatus status;
        Integer successPrice;
        Integer accPoint;
        LocalDateTime createdAt;
        LocalDate deadline;
    }
}
