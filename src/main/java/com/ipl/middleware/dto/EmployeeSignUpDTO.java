package com.ipl.middleware.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSignUpDTO {
    @NotNull(message = "name should not be null")
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotNull(message = "mobileNo should not be null")
    @NotEmpty(message = "mobile should not be empty")
    @Pattern(regexp = "[0-9]{10}", message = "mobile no should be valid")
    private String mobileNo;
    @NotNull(message = "email should not be null")
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be a valid email")
    private String emailId;
    private String Address;
    @NotNull(message = "role should not be null")
    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "SA|ADMIN|EDITOR|GUEST|IPL", message = "role should be a valid")
    private String role;
    @NotNull(message = "userId should not be null")
    @NotEmpty(message = "userId should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "mobile no should be valid")
    private String userName;
    @NotNull(message = "password should not be null")
    @NotEmpty(message = "password should not be empty")
    private String password;

}
