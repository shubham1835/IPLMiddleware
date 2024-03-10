package com.ipl.middleware.repository;

import com.ipl.middleware.modal.MerchantModal;
import com.ipl.middleware.dto.LoginDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends MongoRepository<MerchantModal, String> {
    MerchantModal findByUserName(String username);

    LoginDTO findByUserNameAndPassword(String username, String password);

    LoginDTO findByGstAndEntityType(String panNo, String merchant);

    List<LoginDTO> findByEntityTypeIn(String[] entityType);

    LoginDTO findByBusinessNameOrMobileNoAndEntityTypeOrEmailIdAndEntityType(String businessName, String mobileNo, String mer, String emailId, String merchant);
}
