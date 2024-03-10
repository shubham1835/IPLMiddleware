package com.ipl.middleware.repository;

import com.ipl.middleware.modal.UploadDocModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<UploadDocModal, Long> {

    UploadDocModal findByGstAndEntityType(String panNo, String entityType);
}
