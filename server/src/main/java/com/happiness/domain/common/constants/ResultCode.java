package com.happiness.domain.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    OK("0000","ok"),
    FAIL("9999","Server Error"),
    INVALID_REFRESH_TOKEN("0001", "유효하지 않은 Refresh Token 입니다.")
    ;

    private String resultCode;
    private String resultMessage;

}
