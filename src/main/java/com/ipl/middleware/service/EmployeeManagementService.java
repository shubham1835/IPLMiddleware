package com.ipl.middleware.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;
import com.ipl.middleware.dto.*;
import com.ipl.middleware.exception.ErrorMessageConstant;
import com.ipl.middleware.exception.ResponseEntityException;
import com.ipl.middleware.modal.EmployeeModal;
import com.ipl.middleware.repository.EmployeeRepository;
import com.ipl.middleware.utils.Util;
import de.taimos.totp.TOTP;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.ipl.middleware.exception.ErrorMessageConstant.INVALID_REQUEST;
import static com.ipl.middleware.exception.ErrorMessageConstant.USER_NOT_EXIST;

@Service
@Slf4j
public class EmployeeManagementService {

    @Autowired
    EmployeeRepository employeeRepository;

    public String employeeSignUp(EmployeeSignUpDTO employeeSignUpDTO) {
        String userId = employeeSignUpDTO.getUserName();
        String mobileNo = employeeSignUpDTO.getMobileNo();
        String EmailId = employeeSignUpDTO.getEmailId();
        Optional<EmployeeModal> employeeModalOptional = employeeRepository.findByUserNameOrMobileNoOrEmailId(userId, mobileNo, EmailId);
        if (employeeModalOptional.isPresent())
            throw new ResponseEntityException(ErrorMessageConstant.INVALID_USER);
        String secretKey = Util.generateSecretKey();
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeModal employeeModal = objectMapper.convertValue(employeeSignUpDTO, EmployeeModal.class);
        employeeModal.setFirstTime(true);
        employeeModal.setStatus("ACT");
        employeeModal.setSecretKey(secretKey);
        employeeModal.setUserName(userId.toLowerCase());
        employeeModal.setPassword(String.valueOf(Hashing.sha512().hashString(employeeSignUpDTO.getPassword(), StandardCharsets.UTF_8)));
        employeeModal.setSysDate(LocalDate.now().toString());
        employeeRepository.save(employeeModal);
        return Util.getGoogleAuthenticatorBarCode(secretKey, userId, "AV E-commerce");
    }

    public Object authenticateUser(UserLoginDTO userModal) {
        EmployeeModal employeeModal = employeeRepository.findByUserNameAndPassword(userModal.getUserName().toLowerCase(),String.valueOf(Hashing.sha512().hashString(userModal.getPassword(), StandardCharsets.UTF_8)));
        if (employeeModal == null)
            throw new ResponseEntityException(USER_NOT_EXIST);
        employeeModal.setLastLoginTime(LocalDate.now().toString());
        employeeModal.setTotalLogin(employeeModal.getTotalLogin() + 1);
        employeeRepository.save(employeeModal);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(employeeModal, EmployeeDTO.class);
    }

    public List<EmployeeDTO> employeeList(String userName) {
        validateUser(userName);
        List<EmployeeModal> employeeModalList = employeeRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(employeeModalList, new TypeReference<List<EmployeeDTO>>() {
        });
    }

    private void validateUser(String userName) {
        Optional<EmployeeModal> employeeModal = employeeRepository.findByUserNameAndRole(userName, "SA");
        if (!employeeModal.isPresent())
            throw new ResponseEntityException(INVALID_REQUEST);
    }

    public String generateQRString(UserQRDTO userQRDTO) {
        String userName = userQRDTO.getUserName();
        validateUser(userQRDTO.getMasterUserName());
        Optional<EmployeeModal> employeeModalOptional = employeeRepository.findByUserName(userName);
        EmployeeModal employeeModal = employeeModalOptional.orElseThrow(() -> new ResponseEntityException(INVALID_REQUEST));
        return Util.getGoogleAuthenticatorBarCode(employeeModal.getSecretKey(), userName, "AV E-commerce");
    }

    public Object authenticateUserWithOtp(UserLoginOTPDTO userLoginOTPDTO) {
        String userName = userLoginOTPDTO.getUserName();
        Optional<EmployeeModal> employeeModalOptional = employeeRepository.findByUserName(userName);
        EmployeeModal employeeModal = employeeModalOptional.orElseThrow(() -> new ResponseEntityException(ErrorMessageConstant.INVALID_USER));
        if (!validateTOTPCode(employeeModal.getSecretKey(), userLoginOTPDTO.getOtp())) {
            throw new ResponseEntityException(ErrorMessageConstant.INVALID_OTP);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(employeeModal, EmployeeDTO.class);
    }

    private boolean validateTOTPCode(String secretKey, String totp) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.validate(hexKey, totp);
    }
}
