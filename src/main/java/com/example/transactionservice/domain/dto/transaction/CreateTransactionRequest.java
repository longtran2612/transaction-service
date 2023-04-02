package com.example.transactionservice.domain.dto.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * 12:51 PM 02-Apr-23
 * Long Tran
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTransactionRequest {
    private String name;
    private String description;
    @Builder.Default
    private int status = 1;
    @Builder.Default
    private int typeCode = 1;
    private BigDecimal amount;
    @Builder.Default
    private int necessaryLevelCode = 1;

    private String createdBy;

}
