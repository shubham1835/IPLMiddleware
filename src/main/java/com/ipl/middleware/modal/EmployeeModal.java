package com.ipl.middleware.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Document("user_master")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeModal {
    @Id
    private String id;
    private String name;
    private String mobileNo;
    private String emailId;
    private String Address;
    private String role;
    private String userName;
    private String password;
    private String secretKey;
    private boolean firstTime;
    private String sysDate;
    private String lastLoginTime;
    private long totalLogin;
    private long failureLoginAttempts;
    private String status;//ACT,BLK,IAC

}
