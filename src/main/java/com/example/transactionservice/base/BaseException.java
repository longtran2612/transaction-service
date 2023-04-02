package com.example.transactionservice.base;

import com.example.transactionservice.utils.MessageSourceUtils;
import lombok.Getter;
import lombok.Setter;


/**
 * 9:38 AM 15-Sep-22
 * Long Tran
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    protected String errorCode;

    protected String message;

    public BaseException() {
    }

    public BaseException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.message = MessageSourceUtils.getMessage(errorCode, args);
    }
}
