package com.example.transactionservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 12:53 PM 02-Apr-23
 * Long Tran
 */
public class NecessaryLevel {
    @AllArgsConstructor
    public enum Level {
        LOW(1),
        MEDIUM(2),
        HIGH(3);
        @Getter
        private final int code;
    }

    public static String getName(int code){
        for (Level level : Level.values()) {
            if (level.getCode() == code) {
                return level.name();
            }
        }
        return null;
    }


}
