package com.example.transactionservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 4:04 PM 17-Jan-23
 * Long Tran
 */
@Component
@Slf4j
public class GlobalHandleException implements ErrorWebExceptionHandler {


    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error("Error: {}", ex.getMessage());
        DataBufferFactory bufferFactory = exchange.getResponse().bufferFactory();
        var errorMessage =  bufferFactory.wrap(ex.getMessage().getBytes());
        if(errorMessage instanceof IllegalArgumentException){
           exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
           return exchange.getResponse().writeWith(Mono.just(errorMessage));
        }
        exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        return exchange.getResponse().writeWith(Mono.just(errorMessage));
    }
}
