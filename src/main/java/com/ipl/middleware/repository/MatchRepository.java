package com.ipl.middleware.repository;

import com.ipl.middleware.modal.MatchModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<MatchModal, Long> {
    MatchModal findByMatchId(String matchId);
}
