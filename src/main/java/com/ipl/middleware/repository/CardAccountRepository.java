package com.ipl.middleware.repository;

import com.ipl.middleware.modal.CardAcctMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardAccountRepository extends MongoRepository<CardAcctMaster, Long> {
    CardAcctMaster findTopByOrderBySequenceDesc();
}
