package com.example.transactionservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 1:46 PM 02-Apr-23
 * Long Tran
 */
public class TransactionStatus {

    @AllArgsConstructor
   public enum Status {
        CREATE(1),
        CANCEL(2);

        @Getter
        private final int code;
    }

    public static String getName(int code){
        for (Status status : Status.values()) {
            if (status.getCode() == code) {
                return status.name();
            }
        }
        return null;
    }
}
