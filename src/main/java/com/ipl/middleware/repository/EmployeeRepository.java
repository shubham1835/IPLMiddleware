package com.ipl.middleware.repository;

import com.ipl.middleware.modal.EmployeeModal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeModal, Long> {
    Optional<EmployeeModal> findByUserNameOrMobileNoOrEmailId(String userId, String mobileNo, String EmailId);

    EmployeeModal findByUserNameAndPassword(String userName, String shaHex);

    Optional<EmployeeModal> findByUserNameAndRole(String userName, String sa);

    Optional<EmployeeModal> findByUserName(String userName);
}
