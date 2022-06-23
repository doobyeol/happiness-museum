package com.happiness.domain.common.exceptions;

import com.happiness.domain.common.constants.ResultCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException{
    private ResultCode resultCode;

    public BizException() {
        super();
        this.resultCode = ResultCode.FAIL;
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(ResultCode resultCode) {
        super();
        this.resultCode = resultCode;
    }

    public BizException(ResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }
}
