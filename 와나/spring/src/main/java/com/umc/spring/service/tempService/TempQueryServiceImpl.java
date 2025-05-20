package com.umc.spring.service.tempService;


import com.umc.spring.apiPayload.code.status.ErrorStatus;
import com.umc.spring.apiPayload.exception.handler.TempHanlder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHanlder(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
