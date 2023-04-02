package com.example.transactionservice.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Objects;

/**
 * 8:46 AM 02-Nov-22
 * Long Tran
 */
public class UpdateBuilderUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.setDefaultPropertyInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
    }
    public static void addFieldUpdate(Map<String,Object> map, String fieldName, Object value) {
        if (Objects.nonNull(value) && !value.toString().isEmpty()) {
            map.put(fieldName, value);
        }
    }
    public static  Map<String,Object> convertToMapUpdate(Object request) {
        return objectMapper.convertValue(request, new TypeReference<>() {});

    }


}
