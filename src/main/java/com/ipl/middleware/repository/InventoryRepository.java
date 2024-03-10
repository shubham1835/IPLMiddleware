package com.ipl.middleware.repository;

import com.ipl.middleware.modal.InventoryModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<InventoryModal, Long> {
    @Query("{ storeId: '?0' , '?1': { $exists : true } } ")
    InventoryModal findByStoreIdAndProductCategory(String storeId, String productCategory);

    @Query("{ storeId: '?0' , '?1': '?2' } ")
    InventoryModal findByStoreIdAndProductCategoryAndProductName(String storeId, String productCategory, String productName);

    InventoryModal findByStoreId(String storeId);
}
