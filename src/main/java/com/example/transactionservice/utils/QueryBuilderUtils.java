package com.example.transactionservice.utils;

import com.example.transactionservice.base.BaseSort;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 9:24 AM 15-Oct-22
 * Long Tran
 */
public class QueryBuilderUtils {

    public static void addDateFilter(Collection<Criteria> filterList, String fieldName, Date startDate, Date endDate) {
        if (startDate != null && endDate != null) {
            Criteria criteria = Criteria.where(fieldName).gte(startDate).lte(endDate);
            filterList.add(criteria);
        } else if (startDate != null) {
            Criteria criteria = Criteria.where(fieldName).gte(startDate);
            filterList.add(criteria);
        } else if (endDate != null) {
            Criteria criteria = Criteria.where(fieldName).lte(endDate);
            filterList.add(criteria);
        }
    }
    public static void addSingleRegexSearch(Collection<Criteria> filterList, String fieldName, String value) {
        if (!StringUtils.isEmpty(value)) {
            Criteria criteria = Criteria.where(fieldName).regex(value, "i");
            filterList.add(criteria);
        }
    }
    public static void addMultipleRegexSearch(Collection<Criteria> filterList,String value,String ...fieldNames) {
        if (Objects.nonNull(value) && Objects.nonNull(fieldNames)) {
          Arrays.stream(fieldNames).map(fieldName -> Criteria.where(fieldName).regex(value, "i")).forEach(filterList::add);
        }
    }

    public static void addSingleValueFilter(Collection<Criteria> filterList, String fieldName, Object value) {
        if (Objects.nonNull(value) && !value.toString().isEmpty()) {
            Criteria criteria = Criteria.where(fieldName).is(value);
            filterList.add(criteria);
        }
    }
    public static void addMultipleValuesFilter(Collection<Criteria> filterList, String fieldName, Collection<String> value) {
        if (!CollectionUtils.isEmpty(value)) {
            Criteria criteria = Criteria.where(fieldName).in(value);
            filterList.add(criteria);
        }
    }


    public static void addSingleValuesNinFilter(Collection<Criteria> filterList, String fieldName, Collection<String> value) {
        if (!CollectionUtils.isEmpty(value)) {
            Criteria criteria = Criteria.where(fieldName).nin(value);
            filterList.add(criteria);
        }
    }
    public static void addSingleValueNeFilter(Collection<Criteria> filterList, String fieldName, String value) {
//        if (StringUtils.nonNullOrEmptyString(value)) {
            Criteria criteria = Criteria.where(fieldName).ne(value);
            filterList.add(criteria);
//        }
    }

    public static void orOperator(Criteria criteria, Collection<Criteria> criteriaList) {
        if (!CollectionUtils.isEmpty(criteriaList)) {
            criteria.orOperator(criteriaList);
        }
    }
    public static void orOperator(Criteria criteria,Criteria ...criteriaList) {
        if (Objects.nonNull(criteriaList)) {
            criteria.orOperator(criteriaList);
        }
    }
    public static void andOperator(Criteria criteria, Collection<Criteria> filterList) {
        if (!CollectionUtils.isEmpty(filterList)) {
            criteria.andOperator(filterList);
        }
    }
    public static void andOperator(Criteria criteria,Criteria... filterList) {
        if (Objects.nonNull(filterList)) {
            criteria.andOperator(filterList);
        }
    }
    public static void addPageable(Query query, @NotNull Pageable pageable, @NotNull Boolean isPageAble) {
        if(isPageAble){
            query.with(pageable);
        }else {
            pageable = Pageable.unpaged();
        }
    }

    public static void withSort(Query query,List<BaseSort> baseSorts){
        if(!CollectionUtils.isEmpty(baseSorts)){
            query.with(SortUtils.convertToSort(baseSorts));
        }

    }
}
