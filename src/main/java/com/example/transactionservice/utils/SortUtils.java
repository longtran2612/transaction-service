package com.example.transactionservice.utils;

import com.example.transactionservice.base.BaseSort;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 9:17 PM 04-Mar-23
 * Long Tran
 */
public class SortUtils {

    public static Sort convertToSort(List<BaseSort> sorts){
        Sort sort = null;
        if (!CollectionUtils.isEmpty(sorts)) {
            for (BaseSort item : sorts) {
                if (!item.getAsc()) {
                    sort = (sort == null) ? Sort.by(item.getKey()).descending() : sort.and(Sort.by(item.getKey()).descending());
                } else {
                    sort = (sort == null) ? Sort.by(item.getKey()) : sort.and(Sort.by(item.getKey()));
                }
            }
        }
        return sort;
    }
}
