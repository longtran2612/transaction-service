package com.example.transactionservice.domain.entity;

import com.example.transactionservice.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * 11:53 AM 02-Apr-23
 * Long Tran
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction extends BaseEntity {
    private String name;
    private String description;
    private String status;
    private int statusCode;
    private String type;
    private int typeCode;
    private BigDecimal amount;
    private String necessaryLevel;
    private int necessaryLevelCode;
}
