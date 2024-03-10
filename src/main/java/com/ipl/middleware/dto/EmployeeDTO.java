package com.ipl.middleware.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {

    private String name;
    private String mobileNo;
    private String emailId;
    private String Address;
    private String role;
    private String userName;

}
