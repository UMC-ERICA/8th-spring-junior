package com.umc.spring.apiPayload.exception.handler;

import com.umc.spring.apiPayload.code.BaseErrorCode;
import com.umc.spring.apiPayload.exception.GeneralException;

public class ErrorHandler extends GeneralException {
    public ErrorHandler (BaseErrorCode code) {
        super(code);
    }
}
