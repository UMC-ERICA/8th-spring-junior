package com.umc.spring.convert;

import com.umc.spring.web.dto.TempResponse;

import static com.umc.spring.web.dto.TempResponse.*;

public class TempConverter {

    public static TempTestDto toTempTestDto() {
        return TempTestDto.builder()
                .testString("This is test")
                .build();
    }

    public static TempResponse.TempExceptionDto toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDto.builder()
                .flag(flag)
                .build();
    }
}
