package com.ipl.middleware.repository;

import com.ipl.middleware.modal.ConfigModal;
import com.ipl.middleware.dto.ConfigDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends MongoRepository<ConfigModal, Long> {

    ConfigDTO findByKey(String key);
}
