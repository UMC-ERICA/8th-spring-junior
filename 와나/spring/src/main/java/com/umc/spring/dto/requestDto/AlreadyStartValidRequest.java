package com.umc.spring.dto.requestDto;

import lombok.Getter;

import java.util.List;

@Getter
public class AlreadyStartValidRequest {

    private List<Long> missionIds;
    private Long memberId;

}
