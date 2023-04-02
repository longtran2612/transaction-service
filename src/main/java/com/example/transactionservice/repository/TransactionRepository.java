package com.example.transactionservice.repository;

import com.example.transactionservice.domain.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * 12:35 PM 02-Apr-23
 * Long Tran
 */
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
