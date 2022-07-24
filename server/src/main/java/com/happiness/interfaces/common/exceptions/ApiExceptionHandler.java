package com.happiness.interfaces.common.exceptions;

import com.happiness.domain.common.constants.ResultCode;
import com.happiness.domain.common.exceptions.BizException;
import com.happiness.interfaces.common.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResponseDto handleBizException(BizException e) {
        log.error("BizException occurred !",e);
        return ResponseDto.fail(e.getResultCode());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseDto handleBadCredentialsException(BadCredentialsException e) {
        log.error("BadCredentialsException occurred !",e);
        return ResponseDto.fail(ResultCode.BAD_CREDENTIALS);
    }

    @ExceptionHandler(Exception.class)
    public ResponseDto handleException(Exception e) {
        log.error("Exception occurred !",e);
        return ResponseDto.fail(e.getMessage());
    }
}
