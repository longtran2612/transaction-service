package com.example.transactionservice.exception;

import com.example.transactionservice.base.BaseException;

/**
 * 10:05 AM 07-Mar-23
 * Long Tran
 */
public class BusinessException extends BaseException {
    public BusinessException(String errorCode, Object... args) {
        super(errorCode, args);
    }

    public static BaseException build(String errorCode, String msgDetail) {
        BusinessException exp = new BusinessException(errorCode);
        exp.setMessage(msgDetail);
        return exp;
    }
}
