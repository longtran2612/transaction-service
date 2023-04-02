package com.example.transactionservice.base;

import com.example.transactionservice.exception.BusinessException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 12:09 PM 02-Apr-23
 * Long Tran
 */
@Component
public class BaseService extends BaseObjectLoggable {

//    @Autowired
//    protected SequenceValueItemRepository sequenceValueItemRepository;

    @Autowired
    protected ReactiveMongoTemplate reactiveMongoTemplate;
    @Autowired
    protected   Validator validator;

    protected <T> void validateField(T dto) {
        var violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            logger.info("Violations: {}", violations);
            throw new BusinessException(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
        }
    }

    protected <T> void validateField(List<T> dtos) {
        dtos.forEach(this::validateField);
    }


}
