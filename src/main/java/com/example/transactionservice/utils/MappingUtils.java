package com.example.transactionservice.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 8:46 AM 02-Nov-22
 * Long Tran
 */
public class MappingUtils {

    private static final ModelMapper modelMapper = new ModelMapper();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        modelMapper.getConfiguration().setDeepCopyEnabled(false);
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(com.fasterxml.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.setDefaultPropertyInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
    }


    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
    public static <D, T> List<D> mapListV2(Collection<T> entityList, Class<D> outCLass) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream()
                .map(entity -> mapObject(entity, outCLass))
                .collect(Collectors.toList());
    }
    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass, BiFunction<S, T, T> func) {
        return source
                .stream()
                .map(element -> {
                    T result = modelMapper.map(element, targetClass);
                    func.apply(element, result);
                    return result;
                })
                .collect(Collectors.toList());
    }
    public static <S, T> Set<T> mapSet(Set<S> source, Class<T> targetClass, BiFunction<S, T, T> func) {
        return source
                .stream()
                .map(element -> {
                    T result = modelMapper.map(element, targetClass);
                    func.apply(element, result);
                    return result;
                })
                .collect(Collectors.toSet());
    }

    public static <S, T> Set<T> mapSet(Set<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> {
                    return modelMapper.map(element, targetClass);
                })
                .collect(Collectors.toSet());
    }
    public static <D, T> Page<D> map(final Page<T> page, Class<D> outCLass) {
        if (page == null) {
            return null;
        }
        return page.map(objectEntity -> modelMapper.map(objectEntity, outCLass));
    }

    public static <D> D mapObject(Object source, Class<D> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public static <D> D mapObject(Object source, D des) {
//        BeanUtils.copyProperties(source,des);
        modelMapper.map(source, des);
        return des;
    }

    public static <T> T readValue(String request, Class<T> clazz) {
        try {
            return objectMapper.readValue(request, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static  Map<String,Object> convertObjectToMap(Object request) {
        return objectMapper.convertValue(request, new TypeReference<>() {});

    }



}
