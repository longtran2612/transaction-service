//package com.example.transactionservice.config;
//
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
///**
// * 3:15 PM 02-Apr-23
// * Long Tran
// */
//@EnableReactiveMongoRepositories
//public class MongoReactiveApplication  extends AbstractReactiveMongoConfiguration {
//    @Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create();
//    }
//
//    @NotNull
//    @Override
//    protected String getDatabaseName() {
//        return "transaction";
//    }
//}
