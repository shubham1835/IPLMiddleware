package com.ipl.middleware.repository;

import com.ipl.middleware.modal.BiddingModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidRepository extends MongoRepository<BiddingModal, Long> {
    BiddingModal findByUserAndMatchId(String user, String matchId);
}
