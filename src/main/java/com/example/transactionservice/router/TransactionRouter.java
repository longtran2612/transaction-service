package com.example.transactionservice.router;

import com.example.transactionservice.handler.TransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 2:14 PM 02-Apr-23
 * Long Tran
 */
@Configuration
public class TransactionRouter {

    @Bean
    public RouterFunction<ServerResponse> transactionRoute(TransactionHandler transactionHandler) {
        return route()
                .nest(path("/transactions"), builder -> builder
                        .GET("/{id}", transactionHandler::getById)
                        .GET("", transactionHandler::getAll)
                        .POST("", transactionHandler::create)
                        .DELETE("/{id}", transactionHandler::delete)
                        .GET("/total-amount", transactionHandler::getTotalAmount)
                )
                .build();
    }
}
