package com.umc.spring.apiPayload.code;

import com.umc.spring.apiPayload.code.ErrorReasonDto;

public interface BaseErrorCode {

    ErrorReasonDto getReason();

    ErrorReasonDto getReasonHttpStatus();
}
