package com.umc.spring.web.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.TempConverter;
import com.umc.spring.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.spring.web.dto.TempResponse.*;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    @GetMapping("/test")
    public ApiResponse<TempTestDto> testApi() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDto());
    }
}
