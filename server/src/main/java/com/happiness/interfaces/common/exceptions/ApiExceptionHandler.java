package com.happiness.interfaces.common.exceptions;

import com.happiness.domain.common.exceptions.BizException;
import com.happiness.interfaces.common.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
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

    @ExceptionHandler(Exception.class)
    public ResponseDto handleException(Exception e) {
        log.error("Exception occurred !",e);
        return ResponseDto.fail(e.getMessage());
    }
}
