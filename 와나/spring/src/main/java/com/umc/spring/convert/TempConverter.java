package com.umc.spring.convert;

import com.umc.spring.web.dto.TempResponse;

import static com.umc.spring.web.dto.TempResponse.*;

public class TempConverter {

    public static TempTestDto toTempTestDto() {
        return TempTestDto.builder()
                .testString("This is test")
                .build();
    }
}
