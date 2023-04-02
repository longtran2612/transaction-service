package com.example.transactionservice.base;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * 12:10 PM 02-Apr-23
 * Long Tran
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Id
    private String id;

    private LocalDate createdDate;

    private LocalDate updatedDate;

    private String createdBy;

    private String updatedBy;
}
