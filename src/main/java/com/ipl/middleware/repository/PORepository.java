package com.ipl.middleware.repository;

import com.ipl.middleware.modal.POModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PORepository extends MongoRepository<POModal, Long> {
    POModal findTopByOrderBySequenceDesc();
}
