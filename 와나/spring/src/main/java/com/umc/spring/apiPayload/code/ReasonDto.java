package com.umc.spring.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ReasonDto {

    private HttpStatus httpStatus;

    private final boolean isSuccess;

    private final String code;

    private final String message;

    public boolean getIsSuccess() {
        // is로 시작하는 필드는 따로 안 만들고 @getter로 하면 isSuccess가 게터메소드가 됨 -> 따로 설정
        return isSuccess;
    }
}
