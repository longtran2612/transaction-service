package com.example.transactionservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 12:52 PM 02-Apr-23
 * Long Tran
 */
public class TransactionType {

    @AllArgsConstructor
    public enum Type {
        INCOME(1),
        EXPENSE(2);
        @Getter
        private final int code;
    }
    public static String getName(int code){
        for (Type type : Type.values()) {
            if (type.getCode() == code) {
                return type.name();
            }
        }
        return null;
    }
}
