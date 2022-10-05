package com.happiness.domain.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    OK("0000","ok"),
    FAIL("9999","Server Error"),
    INVALID_REFRESH_TOKEN("0001", "유효하지 않은 Refresh Token 입니다."),
    BAD_CREDENTIALS("0002", "ID 또는 비밀번호를 확인해주세요."),
    FAILED_SAVE("0003", "저장시 오류가 발생했습니다."),
    FAILED_DELETE("0004", "삭제시 오류가 발생했습니다."),
    INVALID_REQUESTER("0005", "잘못된 요청입니다."),
    INVALID_REQUEST("0006", "잘못된 요청입니다."),
    ;

    private String resultCode;
    private String resultMessage;

}
