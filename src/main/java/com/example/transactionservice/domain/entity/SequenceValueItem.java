package com.example.transactionservice.domain.entity;

import com.example.transactionservice.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 9:42 AM 02-Feb-23
 * Long Tran
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sequence_value_item")
public class SequenceValueItem extends BaseEntity implements Serializable {
    private int seqId;
}
