package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserQRDTO {
    @NotNull(message = "masterUserName should not be null")
    @NotEmpty(message = "masterUserName should not be empty")
    private String masterUserName;
    @NotNull(message = "userName should not be null")
    @NotEmpty(message = "userName should not be empty")
    private String userName;
}
