//package com.example.transactionservice.repository;
//
//import com.example.transactionservice.domain.entity.SequenceValueItem;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
///**
// * 9:40 AM 02-Feb-23
// * Long Tran
// */
//@Component
//@RequiredArgsConstructor
//public class SequenceValueItemRepository {
//    private final MongoTemplate mongoTemplate;
//
//    public  String getSequence(Class forClass) {
//        String sequenceName = forClass.getName();
//        SequenceValueItem sequenceValueItem = mongoTemplate.findById(sequenceName, SequenceValueItem.class);
//        if (null == sequenceValueItem) {
//            sequenceValueItem = new SequenceValueItem();
//            sequenceValueItem.setId(sequenceName);
//            sequenceValueItem.setSeqId(1);
//            sequenceValueItem.setCreatedDate(LocalDate.now());
//            mongoTemplate.save(sequenceValueItem);
//            return "1";
//        }
//        int sequenceId = sequenceValueItem.getSeqId() + 1;
//        sequenceValueItem.setSeqId(sequenceId);
//        sequenceValueItem.setUpdatedDate(LocalDate.now());
//        mongoTemplate.save(sequenceValueItem);
//        return String.valueOf(sequenceId);
//    }
//
//
//}
