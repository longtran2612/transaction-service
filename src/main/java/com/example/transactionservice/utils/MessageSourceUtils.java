package com.example.transactionservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


/**
 * 9:38 AM 15-Sep-22
 * Long Tran
 */
@Component
public class MessageSourceUtils {

    private static MessageSource messageSource;
    private static final Locale localeVN = new Locale("vi", "VN");
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageSourceUtils.messageSource = messageSource;
    }

    public static  String getMessage(String key, Object... args) {
        try {
            return messageSource.getMessage(key, args, localeVN);
        } catch (Exception ex) {
            return key;
        }
    }

}
