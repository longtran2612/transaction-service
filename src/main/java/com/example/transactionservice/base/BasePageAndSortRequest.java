package com.example.transactionservice.base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 9:24 AM 15-Oct-22
 * Long Tran
 */
@Getter
@Setter
public class BasePageAndSortRequest extends BasePageRequest {
    private List<BaseSort> sort;
}
