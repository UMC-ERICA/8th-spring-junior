package com.umc.spring.apiPayload.code.status;

import com.umc.spring.apiPayload.code.BaseErrorCode;
import com.umc.spring.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 일반적인 응답
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON402", "금지된 요청입니다."),
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버에러, 관리자에게 문의 바랍니다."),

    // test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트중입니다."),

    // Member
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임을 입력해주세요"),

    //Restaurant
    RESTAURANT_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESTAURANT4001", "음식점을 찾을 수 없습니다."),

    // Mission
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "미션을 찾을 수 없습니다."),

    // Region
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001", "지역을 찾을 수 없습니다."),

    // Food
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOOD4001", "음식이 카테고리에 없습니다.")
    ;

    private final HttpStatus httpStatus;

    private final String code;

    private final String message;
    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
