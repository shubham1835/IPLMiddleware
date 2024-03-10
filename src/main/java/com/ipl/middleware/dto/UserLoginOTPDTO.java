package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserLoginOTPDTO {
    @NotNull(message = "userName should not be null")
    @NotEmpty(message = "userName should not be empty")
    private String userName;
    @NotNull(message = "otp should not be null")
    @NotEmpty(message = "otp should not be empty")
    @Pattern(regexp = "[0-9]{6}", message = "otp should be a valid")
    private String otp;
}
