package com.ipl.middleware.repository;

import com.ipl.middleware.modal.GenerateOrderModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<GenerateOrderModal, Long> {

    boolean existsByOrderId(String orderId);
}
