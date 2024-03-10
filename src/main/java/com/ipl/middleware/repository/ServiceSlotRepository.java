package com.ipl.middleware.repository;

import com.ipl.middleware.modal.SlotModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceSlotRepository extends MongoRepository<SlotModal, Long>  {
}
