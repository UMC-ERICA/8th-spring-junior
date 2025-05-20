package com.umc.spring.web.controller;

import com.umc.spring.apiPayload.ApiResponse;
import com.umc.spring.convert.TempConverter;
import com.umc.spring.service.tempService.TempQueryService;
import com.umc.spring.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.umc.spring.web.dto.TempResponse.*;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempTestDto> testApi() {
        return ApiResponse.onSuccess(TempConverter.toTempTestDto());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDto> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.checkFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }

}
