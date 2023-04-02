package com.example.transactionservice.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 9:24 AM 15-Oct-22
 * Long Tran
 */
@Getter
@Setter
public class BasePageRequest {
    private Integer pageNumber = 0;
    private Integer pageSize = 10;

}
