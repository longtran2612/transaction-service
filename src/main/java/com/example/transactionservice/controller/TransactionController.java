package com.example.transactionservice.controller;

import com.example.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

/**
 * 3:40 PM 02-Apr-23
 * Long Tran
 */
@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping("/total-amount")
    public Flux<Object> getTotalAmount(){
        return transactionService.getTotalAmount();
    }

}
