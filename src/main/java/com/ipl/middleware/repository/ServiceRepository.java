package com.ipl.middleware.repository;

import com.ipl.middleware.modal.ServiceModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<ServiceModal, Long> {
    @Query("{ storeId: '?0' , '?1': { $exists : true } } ")
    ServiceModal findByStoreIdAndServiceCategory(String storeId, String productCategory);

    @Query("{ storeId: '?0' , '?1': '?2' } ")
    ServiceModal findByStoreIdAndServiceCategoryAndServiceName(String storeId, String productCategory, String productName);

    ServiceModal findByStoreId(String storeId);
}
