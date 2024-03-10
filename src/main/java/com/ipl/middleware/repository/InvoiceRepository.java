package com.ipl.middleware.repository;


import com.ipl.middleware.modal.InvoiceModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<InvoiceModal, Long> {

    InvoiceModal findTopByOrderBySequenceDesc();
}
