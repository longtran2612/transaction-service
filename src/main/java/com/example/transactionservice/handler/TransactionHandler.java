package com.example.transactionservice.handler;

import com.example.transactionservice.base.BaseService;
import com.example.transactionservice.domain.dto.transaction.CreateTransactionRequest;
import com.example.transactionservice.domain.entity.Transaction;
import com.example.transactionservice.repository.TransactionRepository;
import com.example.transactionservice.service.TransactionService;
import com.example.transactionservice.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * 12:36 PM 02-Apr-23
 * Long Tran
 */
@Component
@RequiredArgsConstructor
public class TransactionHandler extends BaseService {

    private final TransactionService transactionService;

    public Mono<ServerResponse> getById(ServerRequest request) {
        return ServerResponse.ok().body(transactionService.getById(request.pathVariable("id")), Transaction.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(transactionService.getAll(), Transaction.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(CreateTransactionRequest.class)
                .flatMap(transaction -> ServerResponse.ok().body(transactionService.create(transaction), Transaction.class));
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return ServerResponse.ok().body(transactionService.delete(request.pathVariable("id")), Void.class);
    }
    public Mono<ServerResponse> getTotalAmount(ServerRequest request) {
        return ServerResponse.ok().body(transactionService.getTotalAmount(), BigDecimal.class);
    }
}
