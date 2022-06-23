package com.happiness.interfaces.common.dto;

import com.happiness.domain.common.constants.ResultCode;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
public class ResponseDto<T> {
    private String resultCode;
    private String resultMessage;
    private T data;

    public static <R> ResponseDto<R> ok() {
        ResultCode resultCode = ResultCode.OK;
        ResponseDto dto = ResponseDto.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getResultMessage())
                .build();
        return dto;
    }

    public static <R> ResponseDto<R> ok(R data) {
        ResultCode resultCode = ResultCode.OK;
        ResponseDto dto = ResponseDto.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getResultMessage())
                .data(data)
                .build();
        return dto;
    }

    public static <R> ResponseDto<R> fail() {
        ResultCode resultCode = ResultCode.FAIL;
        ResponseDto dto = ResponseDto.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getResultMessage())
                .build();
        return dto;
    }

    public static <R> ResponseDto<R> fail(String errorMessage) {
        ResultCode resultCode = ResultCode.FAIL;
        ResponseDto dto = ResponseDto.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(errorMessage)
                .build();
        return dto;
    }


    public static <R> ResponseDto<R> fail(ResultCode resultCode) {
        ResponseDto dto = ResponseDto.builder()
                .resultCode(resultCode.getResultCode())
                .resultMessage(resultCode.getResultMessage())
                .build();
        return dto;
    }

}
