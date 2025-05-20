package com.umc.spring.apiPayload.exception.handler;

import com.umc.spring.apiPayload.code.BaseErrorCode;
import com.umc.spring.apiPayload.exception.GeneralException;

public class TempHanlder extends GeneralException {
    public TempHanlder(BaseErrorCode code) {
        super(code);
    }

}
