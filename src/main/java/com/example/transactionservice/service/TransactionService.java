package com.example.transactionservice.service;

import com.example.transactionservice.base.BaseService;
import com.example.transactionservice.common.NecessaryLevel;
import com.example.transactionservice.common.TransactionStatus;
import com.example.transactionservice.common.TransactionType;
import com.example.transactionservice.domain.dto.transaction.CreateTransactionRequest;
import com.example.transactionservice.domain.entity.Transaction;
import com.example.transactionservice.repository.TransactionRepository;
import com.example.transactionservice.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 * 1:37 PM 02-Apr-23
 * Long Tran
 */
@Service
@RequiredArgsConstructor
public class TransactionService extends BaseService {

    private final TransactionRepository transactionRepository;

    public Mono<Transaction> getById(String id){
        return transactionRepository.findById(id);
    }
    public Flux<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Mono<Transaction> create(CreateTransactionRequest request){
        validateField(request);
        var transaction = MappingUtils.mapObject(request, Transaction.class);
        transaction.setCreatedDate(LocalDate.now());
//        transaction.setId(sequenceValueItemRepository.getSequence(Transaction.class));
        transaction.setNecessaryLevel(NecessaryLevel.getName(request.getNecessaryLevelCode()));
        transaction.setStatus(TransactionStatus.getName(request.getStatus()));
        transaction.setType(TransactionType.getName(request.getTypeCode()));
        return transactionRepository.save(transaction);
    }

    public Mono<Void> delete(String id){
       return transactionRepository.deleteById(id);
    }

//    public Flux<BigDecimal> getTotalTransaction(){
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.match(new Criteria()),
//                Aggregation.group().sum("amount").as("totalAmount")
//        );
////       return reactiveMongoTemplate.aggregate(aggregation, Transaction.class, BigDecimal.class);
//            return reactiveMongoTemplate.aggregate(aggregation, Transaction.class, Map.class).flatMap(map -> {
//                BigDecimal totalAmount = (BigDecimal) map.get("totalAmount");
//                return Mono.just(totalAmount);
//            });
//    }

    public Flux<Object> getTotalAmount(){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(new Criteria()),
                Aggregation.group().sum("amount").as("totalAmount")
        );
        return reactiveMongoTemplate.aggregate(aggregation, Transaction.class, Map.class).flatMap(map -> {
            var totalAmount = map.get("totalAmount");
            return Mono.just(totalAmount);
        });
    }




}
