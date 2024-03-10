package com.ipl.middleware.controller;

import com.ipl.middleware.dto.EmployeeSignUpDTO;
import com.ipl.middleware.dto.UserLoginDTO;
import com.ipl.middleware.dto.UserLoginOTPDTO;
import com.ipl.middleware.dto.UserQRDTO;
import com.ipl.middleware.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/app/v1/employee")
@Validated
@CrossOrigin
public class EmployeeManagementController {

    @Autowired
    EmployeeManagementService employeeManagementService;

    @PostMapping(value = "/signUp", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> merchantSignUp(@Valid @RequestBody EmployeeSignUpDTO employeeSignUpDTO) {
        String qrData = employeeManagementService.employeeSignUp(employeeSignUpDTO);
        return new ResponseEntity<>(qrData, HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> userLogin(@RequestBody UserLoginDTO userModal) {
        return new ResponseEntity<>(employeeManagementService.authenticateUser(userModal), HttpStatus.OK);
    }

    @PostMapping(value = "/otpLogin", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> userLogin(@RequestBody UserLoginOTPDTO userLoginOTPDTO) {
        return new ResponseEntity<>(employeeManagementService.authenticateUserWithOtp(userLoginOTPDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<?> employeeList(@RequestParam String userName) {
        return new ResponseEntity<>(employeeManagementService.employeeList(userName), HttpStatus.OK);
    }

    @PostMapping(value = "/qr", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> generateQRString(@RequestBody UserQRDTO userQRDTO) {
        return new ResponseEntity<>(employeeManagementService.generateQRString(userQRDTO), HttpStatus.OK);
    }
}
