package com.example.transactionservice.base;

import lombok.Getter;
import lombok.Setter;

/**
 * 12:32 PM 26-Mar-23
 * Long Tran
 */
@Getter
@Setter
public class BaseSearchRequest extends BasePageAndSortRequest {
    private String keyword;
    private Boolean isPageAble = true;

}
